/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.common;

/**
 *
 * @author maciek
 */
public class LoginException extends Exception {

    /**
     * Creates a new instance of <code>LoginException</code> without detail message.
     */
    public LoginException() {
        
    }


    /**
     * Constructs an instance of <code>LoginException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public LoginException(String msg) {
        super(msg);
    }
}
