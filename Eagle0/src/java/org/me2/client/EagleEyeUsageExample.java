/*
 * EagleEyeUsageExample.java
 *
 * Created on 18 listopad 2008, 21:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.me2.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Example class using the EagleEye service. 
 *
 * @author me2
 */
public class EagleEyeUsageExample extends VerticalPanel {
    
    private Label lblServerReply = new Label();
    private TextBox txtUserInput = new TextBox();
    private Button btnSend = new Button("Send_to_server");
    
    public EagleEyeUsageExample() {
        lblServerReply.setStyleName("Label");
        
        add(new Label("Input your text:"));
        add(txtUserInput);
        add(btnSend);

        
        // Create an asynchronous callback to handle the result.
        final AsyncCallback callback = new AsyncCallback() {
            public void onSuccess(Object result) {
                lblServerReply.setText((String)result); 
                add(lblServerReply);
            }
            
            public void onFailure(Throwable caught) {
                lblServerReply.setText("Communication failed");
                add(lblServerReply);
            }
        };
        
        // Listen for the button clicks
        btnSend.addClickListener(new ClickListener(){
            public void onClick(Widget w) {
                // Make remote call. Control flow will continue immediately and later
                // 'callback' will be invoked when the RPC completes.
                getService().myMethod(txtUserInput.getText(), callback);
            }
        });
    }
    
    public static EagleEyeAsync getService(){
        // Create the client proxy. Note that although you are creating the
        // service interface proper, you cast the result to the asynchronous
        // version of
        // the interface. The cast is always safe because the generated proxy
        // implements the asynchronous interface automatically.
        EagleEyeAsync service = (EagleEyeAsync) GWT.create(EagleEye.class);
        // Specify the URL at which our service implementation is running.
        // Note that the target URL must reside on the same domain and port from
        // which the host page was served.
        //
        ServiceDefTarget endpoint = (ServiceDefTarget) service;
        String moduleRelativeURL = GWT.getModuleBaseURL() + "eagleeye";
        endpoint.setServiceEntryPoint(moduleRelativeURL);
        return service;
    }
}
