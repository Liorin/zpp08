/*
 * MainEntryPoint.java
 *
 * Created on 18 listopad 2008, 21:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.me2.client;

import com.google.gwt.core.client.EntryPoint;  
import com.google.gwt.user.client.Timer;  
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.RootPanel;  
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.EventObject;  
import com.gwtext.client.util.Format;  
import com.gwtext.client.widgets.*;  
import com.gwtext.client.widgets.event.ButtonListenerAdapter;  
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.layout.TableLayout;  
/**
 *
 * @author me2
 */
public class MainEntryPoint implements EntryPoint {

    /** Creates a new instance of MainEntryPoint */
    public MainEntryPoint() {
    }

    /** 
        The entry point method, called automatically by loading a module
        that declares an implementing class as an entry-point
    */
    public void onModuleLoad() {
        
        final Label label = new Label("Hello, GWT!!!");
        final Button button = new Button("Click me!");
        
        Button button1 = new Button("Show Me", new ButtonListenerAdapter() {  
            @Override
             public void onClick(Button button, EventObject e)
             {  
                 MessageBox.confirm("Confirm", "Are you sure you want to do that?",  
                        new MessageBox.ConfirmCallback() {  
                            public void execute(String btnID) {  
                                 System.out.println("Button Click : " +  
                                         Format.format("You clicked the {0} button", btnID));  
                            }
                 });
              }  
        });  

        label.setStyleName("Label");
        
        RootPanel.get().add(new EagleEyeUsageExample());
        RootPanel.get().add(button1);
        RootPanel.get().add(label);
    }

}
