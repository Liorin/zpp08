/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eeint.client.tabs;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.VerticalPanel;
import eeserver.persistence.eeProject;
import java.util.ArrayList;
import java.util.List;
import org.eeint.client.panels.MainPanel;
import org.eeint.client.MyConstants;

/**
 *
 * @author me2
 */
public class ProjectsInProgressTab extends VerticalPanel {

    static final MyConstants myConstants = (MyConstants) GWT.create(MyConstants.class);
    private MainPanel mp;

    public ProjectsInProgressTab(MainPanel mpanel) {
        mp = mpanel;
        setTitle(myConstants.projectsInProgress());

        Button sp = new Button("Szczegóły projektu");
        sp.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                mp.addTab(new ProjectDetailsTab(new eeProject()), true);
            }
        });
        add(sp);

  // --------  TABELKA ---------------------------------------------

   /* List<ColumnConfig> projects = new ArrayList<ColumnConfig>();
    ColumnConfig column = new ColumnConfig("name", myConstants.project(), 200);
    projects.add(column);

    column = new ColumnConfig("client", myConstants.client(), 200);
    projects.add(column);

    column = new ColumnConfig("startDate", myConstants.startDate(), 100);
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setDateTimeFormat(DateTimeFormat.getShortDateFormat());
    projects.add(column);

    column = new ColumnConfig("deadline", myConstants.deadline(), 100);
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setDateTimeFormat(DateTimeFormat.getShortDateFormat());
    projects.add(column);

     ListStore<eeProject> store = new ListStore<eeProject>();
     store.add(this.getCurrentProjects());

     ColumnModel cm = new ColumnModel(projects);

     ContentPanel cp = new ContentPanel();
     cp.setBodyBorder(false);
     cp.setHeading("Basic Grid");
     cp.setButtonAlign(HorizontalAlignment.CENTER);
     cp.setLayout(new FitLayout());
     cp.setSize(600, 300);

     Grid<eeProject> grid = new Grid<eeProject>(store, cm);
     grid.setStyleAttribute("borderTop", "none");
     grid.setAutoExpandColumn("name");
     grid.setBorders(true);
     cp.add(grid);

     add(cp);

}
      //---  ładowanie danych ---   
    private List<eeProject> getCurrentProjects() {
        List<eeProject> p = new ArrayList<eeProject>();

        p.add(new eeProject());
        p.add(new eeProject());
        return p;
    */
    }
}
