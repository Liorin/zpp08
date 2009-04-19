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
package org.eeint.client.panels;

import org.eeint.client.*;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

/**
 * The top panel, which contains the 'welcome' message and various links.
 */
public class TopPanel extends LayoutContainer {

    public void login(String login) {
        usernameInfo.setHTML(myConstants.youAreLoggedAs() + " <i>" + login + "</i>. ");
    }

    Button signOutButton = new Button(myConstants.logOut());
    HTML usernameInfo = new HTML();
    FlexTable wrapper = new FlexTable();
    FlexTable languageSelection = new FlexTable();
    FlexTable sessionInfo = new FlexTable();
    static final MyConstants myConstants = (MyConstants) GWT.create(MyConstants.class);

    public TopPanel() {
        usernameInfo.setStyleName("sessionInfo");

        sessionInfo.setWidget(0, 0, usernameInfo);
        sessionInfo.setWidget(0, 1, signOutButton);

        signOutButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                Cookies.removeCookie("user");
                MainEntryPoint.get().logout();
            }
        });

        Button enBtn = new Button();
        enBtn.setIconStyle("enIcon");
        Button plBtn = new Button();
        plBtn.setIconStyle("plIcon");
        Button esBtn = new Button();
        esBtn.setIconStyle("esIcon");
        Button deBtn = new Button();
        deBtn.setIconStyle("deIcon");

        enBtn.addSelectionListener(new SelectionListener<ButtonEvent>() {

            public native void componentSelected(ButtonEvent ce) /*-{
            var currLocation = $wnd.location.toString().split("?");
            var currLocale = "?locale=en"; $wnd.location.href = currLocation[0] + currLocale;
            $wnd.location.replace(currLocation[0] + currLocale);
            }-*/;
        });

        plBtn.addSelectionListener(new SelectionListener<ButtonEvent>() {

            public native void componentSelected(ButtonEvent ce) /*-{
            var currLocation = $wnd.location.toString().split("?");
            var currLocale = "?locale=pl"; $wnd.location.href = currLocation[0] + currLocale;
            $wnd.location.replace(currLocation[0] + currLocale); }-*/;
        });

        esBtn.addSelectionListener(new SelectionListener<ButtonEvent>() {

            public native void componentSelected(ButtonEvent ce) /*-{
            var currLocation = $wnd.location.toString().split("?");
            var currLocale = "?locale=es"; $wnd.location.href = currLocation[0] + currLocale;
            $wnd.location.replace(currLocation[0] + currLocale);
            }-*/;
        });

        deBtn.addSelectionListener(new SelectionListener<ButtonEvent>() {

            public native void componentSelected(ButtonEvent ce) /*-{
            var currLocation = $wnd.location.toString().split("?");
            var currLocale = "?locale=de"; $wnd.location.href = currLocation[0] + currLocale;
            $wnd.location.replace(currLocation[0] + currLocale);
            }-*/;
        });

        languageSelection.setCellSpacing(4);
        languageSelection.setWidget(0, 0, enBtn);
        languageSelection.setWidget(0, 1, plBtn);
        languageSelection.setWidget(0, 2, deBtn);
        languageSelection.setWidget(0, 3, esBtn);

        wrapper.setWidget(1, 0, sessionInfo);
        wrapper.setWidget(0, 0, languageSelection);
        wrapper.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_TOP);
        wrapper.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_BOTTOM);
        wrapper.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_RIGHT);
        wrapper.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
        wrapper.setWidth("100%");
        wrapper.setHeight("60px");
        wrapper.setCellPadding(5);

        this.add(wrapper);
        setStyleName("topPanel");
        setHeight(60);
    }
}