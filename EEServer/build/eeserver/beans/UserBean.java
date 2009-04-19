/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eeserver.beans;

import eeserver.common.*;
import eeserver.persistence.eeUser;
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
        if (s.contains("fuck")) {
            return false;
        }
        return true;
    }

    @Override
    public eeUser addUser(String name, String surname, String login, String password)
            throws WrongParamException, UserException {
        if (!validate(name)) {
            throw new WrongParamException("name");
        }
        if (!validate(surname)) {
            throw new WrongParamException("surname");
        }
        if (!validate(login)) {
            throw new WrongParamException("login");
        }
        if (!validate(password)) {
            throw new WrongParamException("password");
        }

        if (!em.createNamedQuery("findUserByLogin").setParameter("login", login).getResultList().isEmpty()) {
            throw new UserException(login);
        }

        return new eeUser();
    }

    /**
     * No troszkie jes to zaburaczone ;)
     */
    public String login(String login, String password) throws WrongParamException, LoginException {

        if (!validate(login)) {
            throw new WrongParamException("login");
        }
        if (!validate(password)) {
            throw new WrongParamException("password");
        }

        try {
            eeUser u = (eeUser) em.createNamedQuery("findUserByLogin").setParameter("name", login).getSingleResult();
            if(!u.getPassword().equals(MD5Calc.compute(password)))
                throw new LoginException("wrong_password");
        } catch(NoResultException nre) {
            throw new LoginException("no_user");
        }
        Integer ident = new Integer((new Random()).nextInt());
        return ident.toString();
    }

    public String helloAdamLeniu() {
        return "Hello, Adam :)";
    }
}
