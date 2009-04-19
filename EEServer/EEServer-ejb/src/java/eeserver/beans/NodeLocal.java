/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.beans;

import eeserver.common.NodeException;
import eeserver.persistence.*;
import java.sql.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maciek
 */
@Local
public interface NodeLocal {

    /**
     *
     * @param parent <- eeEntity, 
     * @param timelimit <- time limit of the freshly added node
     * @param type <- type of the node
     * @param taskType <- type of the task which is described by new node
     * @param currentStatus <- status of the created node
     * @param priority <- priority of the new node
     * @return new added eeNode
     * @throws eeserver.common.NodeException
     */
    eeNode addNode(eeEntity parent ,Date timelimit, int type, Integer taskType,
            Integer currentStatus, int priority) throws NodeException;

    /**
     * W zasadzie IMO usuwamy tylko
     * błędne node'y. Jeśli coś zostało zaraportowana
     * bądź mamy dzieci nie usuwamy
     *
     * @param node <- a node to delete
     * @return boolean value, meaning the result (node must be childless ;)
     * @throws eeserver.common.NodeException
     */
    Boolean removeNode(eeNode node) throws NodeException;
    Boolean removeNode(Long nodeId) throws NodeException;
    /**
     * 
     * @param node which subnodes are to be listed
     * @return list of subnodes for the given node
     */
    List<eeNode> listSubNodes(eeNode node);
    List<eeNode> listSubNodes(Long nodeId) throws NodeException;
    /**
     *
     * @param node
     * @param after
     * @see Well, well USE CASES :)
     * @throws eeserver.common.NodeException
     */
    void addDependencyAfter(eeNode node, eeNode after) throws NodeException;
    void addDependencyAfter(Long nodeID, Long afterNodeId) throws NodeException;

    /**
     *
     * @param node
     * @return List of nodes that should be completed before node
     * @throws eeserver.common.NodeException
     */
    List<eeNode> listDependenciesAfter(eeNode node) throws NodeException;
    List<eeNode> listDependenciesAfter(Long nodeId) throws NodeException;

    /**
     *
     * @param node
     * @return List of nodes that can be fully processed only after
     * completion of node
     * @throws eeserver.common.NodeException
     */
    List<eeNode> listDependenciesBefore(eeNode node) throws NodeException;
    List<eeNode> listDependenciesBefore(Long nodeId) throws NodeException;

    /**
     *
     * @param node
     * @param status
     */
    void changeStatus(eeNode node, Integer status);
    void changeStatus(Long nodeId, Integer status);

}
