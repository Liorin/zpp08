/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eeint.client.panels;

import org.eeint.client.*;
import com.extjs.gxt.ui.client.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TreeEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.tree.Tree;
import com.extjs.gxt.ui.client.widget.tree.TreeItem;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import org.eeint.client.tabs.*;


/**
 *
 * @author me2
 */
public class LeftPanel extends ContentPanel {

    static final MyConstants myConstants = (MyConstants) GWT.create(MyConstants.class);
    ContentPanel singleton = null;
    MainPanel mainPanel;

    public LeftPanel(MainPanel l) {
        mainPanel = l;
    }

    public ContentPanel get() {
        if (singleton != null) {
            return singleton;
        } else {
            singleton = this;

            setBodyBorder(false);
            setHeading(myConstants.menu());
            setLayout(new AccordionLayout());

            ContentPanel all = new ContentPanel();
            all.setHeaderVisible(false);
            all.setBorders(false);
            all.add(getMenuTree());
            add(all);

            return this;
        }
    }

    private Widget getMenuTree() {
        final Tree tree = new Tree();
        TreeItem root = tree.getRootItem();

        /* HOME */
        TreeItem home = newItem(myConstants.home(), "icon-home");
        root.add(home);

        /* MY EAGLE EYE:
         *  PROFILE
         *  MESSAGES    */
        TreeItem myEagleEye = newItem(myConstants.myEagleEye(), "icon-accordion");
        root.add(myEagleEye);
        TreeItem profile = newItem(myConstants.profile(), "icon-contact");
        TreeItem messages = newItem(myConstants.messages(), "icon-email");
        myEagleEye.add(profile);
        myEagleEye.add(messages);

        /* PROJECTS:
         *  IN PROGRESS
         *  CLOSED  */
        TreeItem projects = newItem(myConstants.projects(), "icon-album");
        root.add(projects);
        TreeItem projectsInProgress = newItem(myConstants.projectsInProgress(), "icon-projectsInProgress");
        TreeItem projectsClosed = newItem(myConstants.projectsClosed(), "icon-projectsClosed");
        projects.add(projectsInProgress);
        projects.add(projectsClosed);

        /* TEAM */
        TreeItem team = newItem(myConstants.team(), "user");
        root.add(team);

        /* OWNER:
         *  COMPANY PROFILE
         *  INVITES
         *  CLIENTS */
        TreeItem owner = newItem(myConstants.owner(), "user-suit");
        root.add(owner);
        TreeItem companyProfile = newItem(myConstants.companyProfile(), "icon-contact");
        TreeItem invites = newItem(myConstants.invites(), "user-add");
        TreeItem clients = newItem(myConstants.clients(), "icon-client");
        owner.add(companyProfile);
        owner.add(invites);
        owner.add(clients);

        tree.addListener(Events.OnClick, new Listener<TreeEvent>() {

            public void handleEvent(TreeEvent te) {
                TreeItem item = te.tree.getSelectedItem();
                if (item != null) {
                    if (item.getText().equals(myConstants.home())) {
                        mainPanel.addTab(new HomeTab(), true);
                    } else if (item.getText().equals(myConstants.profile())) {
                        mainPanel.addTab(new ProfileTab(), true);
                    } else if (item.getText().equals(myConstants.messages())) {
                        mainPanel.addTab(new MessagesTab(), true);
                    } else if (item.getText().equals(myConstants.projectsInProgress())) {
                        mainPanel.addTab(new ProjectsInProgressTab(mainPanel), true);
                    } else if (item.getText().equals(myConstants.projectsClosed())) {
                        mainPanel.addTab(new ProjectsClosedTab(), true);
                    } else if (item.getText().equals(myConstants.team())) {
                        mainPanel.addTab(new TeamTab(), true);
                    } else if (item.getText().equals(myConstants.companyProfile())) {
                        mainPanel.addTab(new CompanyProfileTab(), true);
                    } else if (item.getText().equals(myConstants.invites())) {
                        mainPanel.addTab(new InvitesTab(), true);
                    } else if (item.getText().equals(myConstants.clients())) {
                        mainPanel.addTab(new ClientsTab(), true);
                    }
                }
            }
        });

        return tree;
    }

    private TreeItem newItem(String text, String iconStyle) {
        TreeItem item = new TreeItem(text);
        item.setIconStyle(iconStyle);
        return item;
    }
}
