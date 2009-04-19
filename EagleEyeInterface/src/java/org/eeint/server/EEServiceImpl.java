/*
 * EEServiceImpl.java
 *
 * Created on 11 styczeń 2009, 15:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.eeint.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eeserver.common.LoginException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eeint.client.EEService;
import eeserver.beans.*;
import eeserver.persistence.eeProject;
import eeserver.persistence.eeUser;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author me2
 */
public class EEServiceImpl extends RemoteServiceServlet implements EEService {

    @EJB
    private UserLocal User;

    @EJB
    private ProjectLocal eeProject;

    public String logIn(String login, String password) throws LoginException {
        if (login == null) {
            login = "";
        }
        if (password == null) {
            password = "";
        }
        return User.login(login, password);

    }

    public List<eeProject> getProjects() {

        return eeProject.listProjects(true);

    }

}