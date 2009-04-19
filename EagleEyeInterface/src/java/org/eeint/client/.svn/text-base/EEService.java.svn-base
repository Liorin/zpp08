/*
 * EEService.java
 *
 * Created on 11 styczeń 2009, 15:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.eeint.client;

import com.google.gwt.user.client.rpc.RemoteService;
import eeserver.common.LoginException;
import eeserver.persistence.eeProject;
import eeserver.persistence.eeUser;
import java.util.List;

/**
 *
 * @author me2
 */
public interface EEService extends RemoteService {
    public List<eeProject> getProjects();
    public String logIn(String value, String value0) throws  LoginException;
}
