/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eeserver.beans;

import eeserver.common.NodeException;
import eeserver.persistence.*;
import java.sql.Date;
import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;

/**
 *
 * @author maciek
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class NodeBean implements NodeLocal {

    @javax.persistence.PersistenceContext(unitName = "EEServer-ejbPU")
    private EntityManager em;

    public eeNode addNode(eeEntity parent, Date timelimit, int type, Integer taskType,
            Integer currentStatus, int priority) throws NodeException{
        try {
            em.refresh(parent);
            eeNode node = new eeNode(parent, priority, timelimit, type, taskType, currentStatus);
            em.persist(node);
            /**creator.getNodes().add(node);
            em.persist(creator);
            if(proj != null) {
                proj.getNodes().add(node);
                em.persist(proj);
            } */
            return node;
        } catch (IllegalArgumentException iae) {
            throw new NodeException("wrong param");
        }
    }

    public Boolean removeNode(eeNode node) throws NodeException {
        try {
            em.refresh(node);
            if (!node.getComesBefore().isEmpty()) {
                throw new NodeException("Some subnodes exist");
            }
            if (!node.getReports().isEmpty()) {
                throw new NodeException("Some information laready reported");
            }
            if(node.getProject() != null)
            {
                node.getProject().removeNode(node);
            }
            em.remove(node);
        } catch (IllegalArgumentException iae) {
            return false;
        }
        return true;
    }

    public List<eeNode> listSubNodes(eeNode node) {
        return null;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
}
