/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eeint.client.tabs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.eeint.client.MyConstants;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.ListLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import eeserver.persistence.eeProject;
import eeserver.persistence.eeUser;
import java.util.ArrayList;
import java.util.List;
import org.eeint.client.EEService;
import org.eeint.client.EEServiceAsync;

/**
 *
 * @author me2
 */
public class TeamTab extends VerticalPanel {

    static final MyConstants myConstants = (MyConstants) GWT.create(MyConstants.class);
    private EEServiceAsync service = null;

    public TeamTab() {
        setTitle(myConstants.team());
        service = getService();

        final AsyncCallback callback = new AsyncCallback() {

            public void onSuccess(Object result) {
            }

            public void onFailure(Throwable caught) {
            }
        };
        //getService().getProjects(callback);
    }

    /** server accessor for rpc calls */
    private EEServiceAsync getService() {
        if (service == null) {
            service = (EEServiceAsync) GWT.create(EEService.class);
            ServiceDefTarget endpoint = (ServiceDefTarget) service;
            String moduleRelativeURL = GWT.getModuleBaseURL() + "eeservice";
            endpoint.setServiceEntryPoint(moduleRelativeURL);
        }
        return service;
    }
}