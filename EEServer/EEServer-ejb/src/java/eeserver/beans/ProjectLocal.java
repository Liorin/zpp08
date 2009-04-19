/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.beans;

import eeserver.common.ProjectException;
import eeserver.common.UserException;
import eeserver.persistence.*;
import java.util.*;
import javax.ejb.Local;

/**
 * This is interface that describes bean responsible for project, functionalities and node management.
 * @author maciek
 */
@Local
public interface ProjectLocal {
    public eeProject addProject(eeAccount acc);
    public void removeProject(eeProject project) throws ProjectException;
    public List<eeProject> listProjects(Boolean withSuspended);
    eeProject addProject(eeAccount account, String name, String descr);
    public List<eeProject> listUserProjects(eeUser user);
    public List<eeProject> listUserProjects(String login) throws UserException;
}
