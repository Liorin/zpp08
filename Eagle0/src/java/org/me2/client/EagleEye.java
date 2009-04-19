/*
 * EagleEye.java
 *
 * Created on 18 listopad 2008, 21:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.me2.client;
import com.google.gwt.user.client.rpc.RemoteService;

/**
 *
 * @author me2
 */
public interface EagleEye extends RemoteService{
    public String myMethod(String s);
}
