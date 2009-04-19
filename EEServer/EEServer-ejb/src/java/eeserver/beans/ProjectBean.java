/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.beans;

import eeserver.common.ProjectException;
import eeserver.common.UserException;
import java.util.List;
import javax.ejb.*;
import javax.persistence.*;
import eeserver.persistence.*;
import java.util.ArrayList;
/**
 *
 * @author maciek
 */
@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class ProjectBean implements ProjectLocal {
    @javax.persistence.PersistenceContext(unitName="EEServer-ejbPU")
    private EntityManager em ;

    private Boolean validate(String s) {
            return true;
    }

    public List<eeProject> listProjects(Boolean withSuspended) {
        String query = (withSuspended) ? "findAllProjects" : "findAllNotSuspended";
        List<eeProject> res = em.createNamedQuery(query).getResultList();
        List<eeProject> ret = new ArrayList<eeProject>();
        for(eeProject proj : res) {
            ret.add(new eeProject(proj));
        }
        return ret;
    }

    public eeProject addProject(eeAccount acc) {
        acc = em.merge(acc);
        eeProject proj = new eeProject(acc);
        em.persist(proj);
        return proj;
    }

    public eeProject addProject(eeAccount acc, String name, String descr) {
        acc = em.merge(acc);
        eeProject proj = new eeProject(acc,name,descr);
        em.persist(proj);
        return proj;
    }


    public void removeProject(eeProject project) throws ProjectException {
        try{
            project = em.merge(project);
            /**
             * Jesli refresh ne zadziala
             * trzeba bedzie robi
             * em.find(eeProject.class,project.getId())
             */
            if(!project.getChild().isEmpty()) {
                throw new ProjectException("Have some children");
            }
            em.remove(project);
        }
        catch(IllegalArgumentException iae) {
            // Not an entity :)
        }
    }

    public List<eeProject> listUserProjects(eeUser user) {
        List<eeProject> projectList = new ArrayList<eeProject>();
        
        return projectList;
    }

    public List<eeProject> listUserProjects(String login) throws UserException {
        eeUser user;
        try {
            user = (eeUser) em.createNamedQuery("findUserByLogin")
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException nre) {
            throw new UserException("There is no user with given login");
        }
        
        return this.listUserProjects(user);
    }


}
