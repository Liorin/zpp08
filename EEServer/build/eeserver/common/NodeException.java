/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.common;

/**
 *
 * @author maciek
 */
public class NodeException extends Exception {

    /**
     * Creates a new instance of <code>NodeException</code> without detail message.
     */
    public NodeException() {
    }


    /**
     * Constructs an instance of <code>NodeException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NodeException(String msg) {
        super(msg);
    }
}
