/*
 * EagleEyeImpl.java
 *
 * Created on 18 listopad 2008, 21:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.me2.server;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.me2.client.EagleEye;

/**
 *
 * @author me2
 */
public class EagleEyeImpl extends RemoteServiceServlet implements
    EagleEye {

    public String myMethod(String s) {
        // Do something interesting with 's' here on the server.
        return "Server says:" + s;
    }
}
