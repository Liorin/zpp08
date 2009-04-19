/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eeint.client.tabs;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.eeint.client.MyConstants;

/**
 *
 * @author me2
 */
public class ProfileTab extends VerticalPanel {

    static final MyConstants myConstants = (MyConstants) GWT.create(MyConstants.class);

    public ProfileTab() {
        setTitle(myConstants.profile());

        final Dialog changePassWindow = new Dialog();
        changePassWindow.setBodyBorder(false);
        changePassWindow.setButtons(Dialog.OKCANCEL);
        changePassWindow.setClosable(false);
        changePassWindow.setHeading(myConstants.changePass());
        changePassWindow.setWidth(300);
        changePassWindow.setHeight(170);
        changePassWindow.cancelText = myConstants.cancel();
        changePassWindow.setHideOnButtonClick(true);

        changePassWindow.setLayout(new FitLayout());

        FormPanel panel = new FormPanel();
        panel.setBorders(false);
        panel.setBodyBorder(false);
        panel.setLabelWidth(140);
        panel.setPadding(5);
        panel.setHeaderVisible(false);


        TextField<String> oldPass = new TextField<String>();
        oldPass.setFieldLabel(myConstants.oldPass());
        oldPass.setAllowBlank(false);

        TextField<String> newPass1 = new TextField<String>();
        newPass1.setFieldLabel(myConstants.newPass1());
        newPass1.setAllowBlank(false);

        TextField<String> newPass2 = new TextField<String>();
        newPass2.setFieldLabel(myConstants.newPass2());
        newPass2.setAllowBlank(false);

        panel.add(oldPass, new FormData("100%"));
        panel.add(newPass1, new FormData("100%"));
        panel.add(newPass2, new FormData("100%"));

        Button OKbutton = changePassWindow.getButtonById(Dialog.OK);
        OKbutton.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
            }
        });


        changePassWindow.add(panel);

        Button changePassButton = new Button(myConstants.changePass());
        changePassButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                changePassWindow.show();
            }
        });
        add(changePassButton);
    }
}


