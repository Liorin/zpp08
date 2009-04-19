
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eeserver.beans;

import eeserver.common.*;

import eeserver.persistence.*;

import java.util.List;
import java.util.Random;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;



/**
 *
 * @author maciek
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class UserBean implements UserLocal {

    @javax.persistence.PersistenceContext(unitName = "EEServer-ejbPU")
    private EntityManager em;

    private Boolean validate(String s) {
        /*TODO*/
        if (s.contains("fuck")) {
            return false;
        }
        return true;
    }

    private Long lookupIdOnSession(Integer session) {
        return new Long(0);
    }


    public eeUser addUser(String name, String surname, String login, String password, String email, String nip, String adress, eeAccount account)
            throws UserException {
        if (!validate(name)) {
            throw new UserException("wrong param: name");
        }
        if (!validate(surname)) {
            throw new UserException("wrong param: surname");
        }
        if (!validate(login)) {
            throw new UserException("wrong param: login");
        }
        if (!validate(password)) {
            throw new UserException("wrong param: password");
        }
        if (!validate(nip)) {
            throw new UserException("wrong param: nip");
        }
        if (!validate(email)) {
            throw new UserException("wrong param: email");
        }
        if (!validate(adress)) {
            throw new UserException("wrong param: adress");
        }

        if (!em.createNamedQuery("findUserByLogin").setParameter("login", login).getResultList().isEmpty()) {
            throw new UserException(login);
        }

        return new eeUser(name, surname, login, email, adress, nip, MD5Calc.compute(password), account);
    }

    /**
     * No troszkie jes to zaburaczone ;)
     */  
    public eeSession login(String login, String password) throws  LoginException {
        eeUser u = null;
        if (!validate(login)) {
            throw new LoginException("login");
        }
        if (!validate(password)) {
            throw new LoginException("password");
        }

        try {
            u = (eeUser) em.createNamedQuery("findUserByLogin").setParameter("name", login).getSingleResult();
            if(!u.getPassword().equals(MD5Calc.compute(password)))
                throw new LoginException("wrong_password");
        } catch(NoResultException nre) {
            throw new LoginException("no_user " + nre.getMessage());
        }
        if(u == null) {
             throw new LoginException("no_user null");
        }
        Integer ident = new Integer((new Random()).nextInt());
        return new eeSession(u,ident);
    }

    public Boolean changePassword(String newPassword, String oldPassword) {

        
        return false;
    }

    public eeAccount addAccount(eeUser user) {
        eeAccount acc = new eeAccount();
        acc.setOwner(user);
        em.persist(acc);
        user.setAccount(acc);
        em.flush();
        return acc;
    }
    

}


   