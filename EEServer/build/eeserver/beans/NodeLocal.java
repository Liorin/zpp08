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

    eeNode addNode(eeEntity project,Date timelimit, int type, Integer taskType,
            Integer currentStatus, int priority) throws NodeException;

    /**
     * W zasadzie IMO usuwamy tylko
     * błędne node'y. Jeśli coś zostało zaraportowana
     * bądź mamy dzieci nie usuwamy
     *
     * @param node
     * @return
     * @throws eeserver.common.NodeException
     */
    Boolean removeNode(eeNode node) throws NodeException;

    List<eeNode> listSubNodes(eeNode node);
}
