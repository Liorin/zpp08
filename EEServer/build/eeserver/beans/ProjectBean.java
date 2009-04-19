/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.beans;

import eeserver.common.NoSuchProjectException;
import java.util.List;
import javax.ejb.*;
import javax.persistence.*;
import eeserver.persistence.*;
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

    public List<eeProject> listProjects() {
        List<eeProject> res = em.createNamedQuery("findAllProjects").getResultList();
        return res;
    }

    public eeProject addProject(eeAccount acc) {
        eeProject proj = new eeProject();
        em.refresh(acc);
        proj.setAccount(acc);
        em.persist(proj);
        return proj;
    }

    public void removeProject(eeProject project) throws NoSuchProjectException {
        try{
            em.refresh(project);
            /**
             * Jesli refresh ne zadziala
             * trzeba bedzie robi
             * em.find(eeProject.class,project.getId())
             */
            em.remove(project);
        }
        catch(IllegalArgumentException iae) {
            // Not an entity :)
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")

    
}
