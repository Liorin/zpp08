/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.common;

/**
 *
 * @author maciek
 */
public class NoUserException extends Exception {

    /**
     * Creates a new instance of <code>NoUserException</code> without detail message.
     */
    public NoUserException() {
    }


    /**
     * Constructs an instance of <code>NoUserException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NoUserException(String msg) {
        super(msg);
    }
}
