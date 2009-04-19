/*
 * Copyright 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.eeint.client;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * Class capable of creating a login panel and handling its usage.
 */
public class LoginScreen extends LayoutContainer {

    private Button logInButton = new Button("Zaloguj");
    private TextField<String> password = new TextField<String>();
    private TextField<String> login = new TextField<String>();
    private FormPanel logInForm = new FormPanel();

    public LoginScreen() {

        setLayout(new CenterLayout());

        /* form settings */
        logInForm.setWidth(350);
        logInForm.setAutoHeight(true);
        logInForm.setHeading("Logowanie");
        logInForm.setFrame(true);

        logInForm.add(login);
        logInForm.add(password);
        logInForm.addButton(logInButton);

        /* login text input settings */
        login.setFieldLabel("Login");
        login.setAutoValidate(true);
        login.setValidator(new Validator() {

            public String validate(Field field, String value) {
                if (!(value.matches("([a-zA-Z0-9])*"))) {
                    return "Login zawiera niedozwolone znaki";
                }
                if ((value.length() < 3)) {
                    return "Zbyt krótki login";
                }
                return null;
            }
        });

        /* password text input settings */
        password.setFieldLabel("Hasło");
        password.setPassword(true);
        password.addKeyListener(new KeyListener() {
            @Override
            public void componentKeyPress(ComponentEvent event) {
                if(event.getKeyCode()==13) authenticateUser();
            }
        });

        /* button settings */
        logInButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                authenticateUser();
            }
        });

        /* component settings */
        add(logInForm);
        setWidth("100%");
        setHeight("100%");
    }

    /** connects to server and tries to log in. Handles exceptions */
    private void authenticateUser() {

        /* local correctness validation */
        if (!logInForm.isValid()) {
            MessageBox.info("Porażka", "Błąd logowania", null);
            return;
        }

        final AsyncCallback callback = new AsyncCallback() {

            public void onSuccess(Object result) {
                MessageBox.info("Brawo", "Sukces logowania. klucz: " + (String) result, null);
                MainEntryPoint.get().login(login.getValue());
                Info.display("Powitanie", "Witaj, {0}", login.getValue());
            }

            public void onFailure(Throwable caught) {
                MessageBox.info("Błąd połączenia", caught.getMessage(), null);
            }
        };
        getService().logIn(login.getValue(), password.getValue(), callback);
    }

    /** server accessor for rpc calls */
    public static EEServiceAsync getService() {
        EEServiceAsync service = (EEServiceAsync) GWT.create(EEService.class);
        ServiceDefTarget endpoint = (ServiceDefTarget) service;
        String moduleRelativeURL = GWT.getModuleBaseURL() + "eeservice";
        endpoint.setServiceEntryPoint(moduleRelativeURL);
        return service;
    }
}