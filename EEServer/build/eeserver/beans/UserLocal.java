/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.beans;

import eeserver.common.*;
import eeserver.persistence.*;
import javax.ejb.Local;

/**
 *
 * @author maciek
 */
@Local
public interface UserLocal {

    eeUser addUser(String name, String surname,String login,String password)
            throws WrongParamException, UserException;

    public String login(String login, String password) throws WrongParamException, LoginException  ;

    public String helloAdamLeniu();
    
}
