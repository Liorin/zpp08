package org.eeint.client;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.TreeBuilder;
import com.extjs.gxt.ui.client.widget.DataList;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ProgressBar;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.tree.Tree;
import com.extjs.gxt.ui.client.widget.tree.TreeItem;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;

/**
 * @author me2
 */
public class Projects {

    private ListBox allProjectsNames = new ListBox(true);
    private List<String> allProjectsList;
    private Button showProjectDetailsButton = new Button("Pokaż szczegóły projektu");
    private Button deleteProjectButton = new Button("Usuń wybrany projekt");
    private Button addNewProjectButton = new Button("Dodaj nowy Projekt");
    private TextBox newPNameTextBox = new TextBox();
    private TextArea newPDescTextArea = new TextArea();

    public Projects() {
        addNewProjectButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {

                final AsyncCallback callback = new AsyncCallback() {

                    public void onSuccess(Object result) {

                        Info.display("Sukces", "Dodałeś nowy projekt");
                    }

                    public void onFailure(Throwable caught) {
                        Window.alert("aaa nie dodano projektu!");
                    }
                };
//                getService().addProject(newPNameTextBox.getText(), newPDescTextArea.getText(), callback);
            }
        });

        showProjectDetailsButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                //MainEntryPoint.get().showProjectDetails(getProjectDetailsPanel(getSelectedProject()));
            }
        });

        deleteProjectButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                final String removedProject = getSelectedProject();

                final AsyncCallback callback = new AsyncCallback() {

                    public void onSuccess(Object result) {
                        Info.display("Sukces", "Usunąłeś projekt");

                    }

                    public void onFailure(Throwable caught) {
                        Window.alert("aaa nie usunieto projektu!");
                    }
                };

//                getService().removeProject(removedProject, callback);
            }
        });

    }

    private void addProject(String project) {
        allProjectsNames.addItem(project);
        allProjectsList.add(project);
    }

    private void removeProject(String project) {
        allProjectsList.remove(project);
        allProjectsNames.removeItem(getProjectIndexInNames(project));
        try {
    //        MainEntryPoint.get().ownerScreen.mainPanel.removeTab("Szczegóły projektu " + project);
        } catch (Exception ex) {
            Info.display(Projects.class.getName(), ex.getMessage());
        }
    }

    public TreeModel getTreeModel() {
        BaseTreeModel<TreeModel> root = new BaseTreeModel<TreeModel>();
        TreeItem f1 = new TreeItem("Funkcjonalność 1");
        TreeItem f2 = new TreeItem("Funkcjonalność 2");
        TreeItem f3 = new TreeItem("Funkcjonalność 3");
//        root.add(f1);
//        root.add(f2);
        //       root.add(f3);

        TreeItem n1 = new TreeItem("Zadanie 1");
        TreeItem n2 = new TreeItem("Zadanie 2");
        TreeItem n3 = new TreeItem("Zadanie 3");
        TreeItem n4 = new TreeItem("Zadanie 4");
        f1.add(n1);
        f1.add(n2);
        f1.add(n3);
        f1.add(n4);

        TreeItem i1 = new TreeItem("Projekt");
        TreeItem i2 = new TreeItem("Testy");
        TreeItem i3 = new TreeItem("Implementacja");
        n1.add(i1);
        n1.add(i2);
        n1.add(i3);

        return root;
    }

    public class ContextMenuTreeExample extends LayoutContainer {

        private int count = 1;
        private TreeModel tm = getTreeModel();

        private ContextMenuTreeExample(String project) {
        }

        @Override
        protected void onRender(Element parent, int pos) {
            super.onRender((com.google.gwt.user.client.Element) parent, pos);

            final Tree tree = new Tree();
            tree.setSelectionMode(SelectionMode.MULTI);
            tree.getStyle().setLeafIconStyle("icon-music");

            // quick way to build tree from Model instances.  
            TreeBuilder.buildTree(tree, tm);

            Menu contextMenu = new Menu();
            contextMenu.setWidth(130);

            MenuItem detale = new MenuItem();
            detale.setText("Szczegóły");
            detale.setIconStyle("icon-accordion");
            detale.addSelectionListener(new SelectionListener<MenuEvent>() {

                public void componentSelected(MenuEvent ce) {
                    TreeItem item = (TreeItem) tree.getSelectionModel().getSelectedItem();
  //                  MainEntryPoint.get().ownerScreen.mainPanel.addTab(getNodeDetailsPanel(), true);
                }
            });
            contextMenu.add(detale);

            MenuItem insert = new MenuItem();
            insert.setText("Insert Item");
            insert.setIconStyle("icon-add");
            insert.addSelectionListener(new SelectionListener<MenuEvent>() {

                public void componentSelected(MenuEvent ce) {
                    TreeItem item = (TreeItem) tree.getSelectionModel().getSelectedItem();
                    if (item != null) {
                        TreeItem newItem = new TreeItem();
                        newItem.setText("Add Child " + count++);
                        item.add(newItem);
                        item.setExpanded(true);
                    }
                }
            });
            contextMenu.add(insert);

            MenuItem remove = new MenuItem();
            remove.setText("Remove Selected");
            remove.setIconStyle("icon-delete");
            remove.addSelectionListener(new SelectionListener<MenuEvent>() {

                public void componentSelected(MenuEvent ce) {
                    TreeItem item = (TreeItem) tree.getSelectionModel().getSelectedItem();
                    if (item != null) {
                        item.getParentItem().remove(item);
                    }
                }
            });
            contextMenu.add(remove);

            tree.setContextMenu(contextMenu);

            setLayout(new FlowLayout(8));
            add(tree);
        }
    }

    private String getSelectedProjectName() {
        return allProjectsNames.getItemText(allProjectsNames.getSelectedIndex());
    }

    private int getProjectIndexInNames(String project) {
        String pname = project;
        int ind = 0;
        for (int i = 0; i < allProjectsNames.getItemCount(); i++) {
            if (allProjectsNames.getItemText(i).equals(pname)) {
                ind = i;
                break;
            }
        }
        return ind;
    }

    private String getSelectedProject() {
        int ind = 0;
        String pname = getSelectedProjectName();
        for (int i = 0; i < allProjectsList.size(); i++) {
            if (allProjectsList.get(i).equals(pname)) {
                ind = i;
                break;
            }
        }
        return allProjectsList.get(ind);
    }

    public VerticalPanel getAddProjectPanel() {
        FlexTable newProjectTable = new FlexTable();
        VerticalPanel newProjectPanel = new VerticalPanel();

        newProjectPanel.setTitle("Dodawanie projektu");

        newProjectTable.clear();
        newProjectTable.setCellSpacing(6);
        FlexCellFormatter cellFormatter = newProjectTable.getFlexCellFormatter();
        newProjectTable.setHTML(0, 0, "<b>Tworzenie nowego projektu</b>");

        cellFormatter.setColSpan(0, 0, 2);
        cellFormatter.setColSpan(3, 0, 2);
        cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
        cellFormatter.setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_CENTER);

        newProjectTable.setHTML(1, 0, "Nazwa:");
        newProjectTable.setWidget(1, 1, newPNameTextBox);
        newProjectTable.setHTML(2, 0, "Opis:");
        newProjectTable.setWidget(2, 1, newPDescTextArea);
        newProjectTable.setWidget(3, 0, addNewProjectButton);

        newProjectPanel.add(newProjectTable);

        return newProjectPanel;
    }

    public VerticalPanel getAllProjectsPanel() {
        VerticalPanel allProjectsPanel = new VerticalPanel();

        allProjectsPanel.setTitle("Wszystkie projekty");
        allProjectsPanel.clear();
        allProjectsPanel.setSpacing(5);
        allProjectsNames.setWidth("80px");
        allProjectsNames.clear();
        allProjectsNames.addItem("Chwilowo brak projektów");
        //     allProjectsPanel.add(new HTML("<b>Lista wszystkich projektów</b>"));
        allProjectsPanel.add(allProjectsNames);
        allProjectsPanel.add(showProjectDetailsButton);
        allProjectsPanel.add(deleteProjectButton);


        // Create an asynchronous callback to handle the result.
        final AsyncCallback callback = new AsyncCallback() {

            public void onSuccess(Object result) {
                allProjectsList = (List<String>) result;
                allProjectsNames.clear();
                for (int i = 0; i < allProjectsList.size(); i++) {
                    allProjectsNames.addItem(allProjectsList.get(i));
                }
            }

            public void onFailure(Throwable caught) {
                Window.alert("aaa nie ma listy projektów!");
            }
        };

        //    getService().getProjectsList(callback);

        return allProjectsPanel;
    }

    //argumentem tego musi być chyba eeObject ? //on musi mieć metode getName
    public Widget getProjectDetailsPanel(String project) {
        VerticalPanel projectDetailsPanel = new VerticalPanel();
        VerticalPanel projectDetailTopPanel = new VerticalPanel();
        VerticalPanel projectDetailBottomPanel = new VerticalPanel();
        String projectName = project;

        projectDetailsPanel.setTitle("Szczegóły projektu " + projectName);

        FlexTable projectDetailTable = new FlexTable();
        projectDetailsPanel.add(projectDetailTopPanel);
        projectDetailsPanel.add(projectDetailBottomPanel);
        final ContextMenuTreeExample dynamicTree = new ContextMenuTreeExample(project);

        projectDetailTable.clear();
        projectDetailTable.setCellSpacing(6);
        FlexCellFormatter cellFormatter = projectDetailTable.getFlexCellFormatter();
        projectDetailTable.setHTML(0, 0, "<b>Szczegółowe dane projektu</b>");

        cellFormatter.setColSpan(0, 0, 2);
        cellFormatter.setColSpan(4, 0, 2);
        cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
        cellFormatter.setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_LEFT);
        cellFormatter.setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_CENTER);

        projectDetailTable.setHTML(1, 0, "Nazwa:");
        projectDetailTable.setHTML(1, 1, project);
        projectDetailTable.setHTML(2, 0, "Opis:");
        projectDetailTable.setHTML(2, 1, project);

        ProgressBar bar = new ProgressBar();
        bar.reset();
        bar.setWidth(200);
        bar.updateProgress(0.76, "in progress");

        projectDetailTable.setHTML(3, 0, "Stopień ukończenia:");
        projectDetailTable.setWidget(3, 1, bar);
        projectDetailTable.setWidget(4, 0, dynamicTree);

        projectDetailTopPanel.add(projectDetailTable);
        return projectDetailsPanel;
    }

    public static EEServiceAsync getService() {
        EEServiceAsync service = (EEServiceAsync) GWT.create(EEService.class);
        ServiceDefTarget endpoint = (ServiceDefTarget) service;
        String moduleRelativeURL = GWT.getModuleBaseURL() + "eeservice";
        endpoint.setServiceEntryPoint(moduleRelativeURL);
        return service;
    }

    private VerticalPanel getNodeDetailsPanel() {
        VerticalPanel nodeDetailsPanel = new VerticalPanel();
        nodeDetailsPanel.setTitle("Szczegóły węzła");
        FlexTable nodeDetailsTable = new FlexTable();

        nodeDetailsTable.clear();
        nodeDetailsTable.setCellSpacing(6);
        FlexCellFormatter cellFormatter = nodeDetailsTable.getFlexCellFormatter();
        nodeDetailsTable.setHTML(0, 0, "<b>Szczegółowe dane węzła</b>");

        cellFormatter.setColSpan(0, 0, 3);
        cellFormatter.setColSpan(1, 1, 2);
        cellFormatter.setColSpan(2, 1, 2);
        cellFormatter.setColSpan(4, 1, 2);
        cellFormatter.setColSpan(5, 1, 2);
        cellFormatter.setColSpan(6, 1, 2);
        cellFormatter.setColSpan(7, 1, 2);

        cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

        nodeDetailsTable.setHTML(1, 0, "Projekt:");
        nodeDetailsTable.setHTML(1, 1, "Projekt 1");

        nodeDetailsTable.setHTML(2, 0, "Nazwa:");
        nodeDetailsTable.setHTML(2, 1, "Funkcjonalność 1");

        ProgressBar bar = new ProgressBar();
        bar.reset();
        bar.updateProgress(0.9, "in progress");
        bar.setWidth(200);
        nodeDetailsTable.setHTML(3, 0, "Stopień ukończenia:");
        nodeDetailsTable.setWidget(3, 1, bar);
        nodeDetailsTable.setWidget(3, 2, new HTML("1%"));

        nodeDetailsTable.setHTML(4, 0, "Opis:");
        nodeDetailsTable.setHTML(4, 1, "Lorem Ipsum is simply dummy text of the printing a");


        nodeDetailsTable.setHTML(5, 0, "Data rozpoczęcia:");
        nodeDetailsTable.setHTML(5, 1, "12.02.2009");

        nodeDetailsTable.setHTML(6, 0, "Deadline:");
        nodeDetailsTable.setHTML(6, 1, "22.03.2009 (pozostało 5 dni)");


        DataList dt = new DataList();
        dt.add("Johny Doe");
        dt.add("Betty Jones");

        nodeDetailsTable.setHTML(7, 0, "Pracownicy:");
        nodeDetailsTable.setWidget(7, 1, dt);


        nodeDetailsPanel.add(nodeDetailsTable);
        return nodeDetailsPanel;
    }
}

