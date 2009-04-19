/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eeint.client.tabs;

import com.extjs.gxt.ui.client.widget.DatePicker;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.eeint.client.MyConstants;

/**
 *
 * @author me2
 */
public class HomeTab extends VerticalPanel {

    static final MyConstants myConstants = (MyConstants) GWT.create(MyConstants.class);

    public HomeTab() {
        setTitle(myConstants.home());
        DatePicker dp = new DatePicker();
        
        add(dp);
    }
}
