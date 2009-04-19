/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eeserver.beans;

import eeserver.common.NodeException;
import eeserver.persistence.*;
import java.sql.Date;
import java.util.Calendar;
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
            eeNode node;
            eeEntity par = null;
            if(parent != null) {
                par = em.merge(parent);
                node = new eeNode(par, priority, timelimit, type, taskType, currentStatus);
            } else {
                node = new eeNode(parent, priority, timelimit, type, taskType, currentStatus);
            }
            em.persist(node);
            if(par != null) {
                par.getChild().add(node);
            }
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

    public Boolean removeNode(eeNode nodee) throws NodeException {
        try {
            eeNode node = em.merge(nodee);
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
            em.flush();
        } catch (IllegalArgumentException iae) {
            return false;
        }
        return true;
    }

    public Boolean removeNode(Long nodeID) throws NodeException {
        eeNode node = em.find(eeNode.class, nodeID);

        return (node == null ? false : removeNode(node));
    }

    public List<eeNode> listSubNodes(eeNode node) {
        node = em.merge(node);
        return node.getChild();
    }

    public List<eeNode> listSubNodes(Long nodeId) throws NodeException {
        eeNode node = em.find (eeNode.class, nodeId);
        if (node == null) {
            throw new NodeException("No node with given ID!");
        }
        return node.getChild();
    }

    public void addDependencyAfter(eeNode node, eeNode after) throws NodeException {
        after = em.merge(after);
        node = em.merge(node);
        after.getComesBefore().add(node);
        node.getComesAfter().add(after);
        em.flush();
    }

    public void addDependencyAfter(Long nodeID, Long afterNodeId) throws NodeException {
        eeNode node = em.find(eeNode.class, nodeID);
        eeNode after = em.find(eeNode.class, afterNodeId);
        if (node == null || after == null) {
            throw new NodeException("There is no node with given id!");
        }
        addDependencyAfter(node, after);
    }

    public List<eeNode> listDependenciesAfter(eeNode node) throws NodeException {
        node = em.merge(node);
        return node.getComeAfter();
    }

    public List<eeNode> listDependenciesAfter(Long nodeId) throws NodeException {
        eeNode node = em.find(eeNode.class, nodeId);
        if (node == null) {
            throw new NodeException("No node with given ID!");
        }
        return node.getComesAfter();
    }

    public List<eeNode> listDependenciesBefore(eeNode node) throws NodeException {
        node = em.merge(node);
        return node.getComesBefore();
    }
    
    public List<eeNode> listDependenciesBefore(Long nodeId) throws NodeException {
        eeNode node = em.find(eeNode.class, nodeId);
        if (node == null) {
            throw new NodeException("No node with given ID!");
        }
        return node.getComesBefore();
    }

    public void changeStatus(eeNode node, Integer status) {
        Calendar cal = Calendar.getInstance();
        node = em.merge(node);
        eeStatusHistory statusHistory = new eeStatusHistory();
        statusHistory.setDate(new Date(cal.getTimeInMillis()));
        statusHistory.setStatus(node.getCurrentStatus());
        statusHistory.setNode(node);
        em.persist(statusHistory);
        node.getStatusHistory().add(statusHistory);
        node.setCurrentStatus(status);
        em.flush();
    }

    

    public void changeStatus(Long nodeId, Integer status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
}