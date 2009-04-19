/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eeint.client.panels;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
/**
 *
 * @author me2
 */
public class MainPanel extends LayoutContainer {

    class ExclusiveTabPanel extends TabPanel {

        HashMap<String, TabItem> map = new HashMap<String, TabItem>();

        @Override
        public boolean add(TabItem item) {
            boolean added = super.add(item);
            if (added) {
                map.put(item.getText(), item);
            }
            return added;
        }

        @Override
        public boolean remove(TabItem item) {
            boolean removed = super.remove(item);
            if (removed) {
                map.remove(item.getText());
            }
            return removed;
        }

        public void remove(String title) throws Exception {
            if (contains(title)) {
                remove(map.get(title));
            } else {
                throw new Exception("no_tab");
            }
        }

        public void setSelection(String title) {
            this.setSelection(map.get(title));
        }

        public boolean contains(String title) {
            return map.containsKey(title);
        }
    }
    private ExclusiveTabPanel tabPanel;

    public MainPanel() {

        setScrollMode(Scroll.AUTO);
        tabPanel = new ExclusiveTabPanel();

        tabPanel.setHeight("100%");
        tabPanel.setAnimScroll(true);
        tabPanel.setTabScroll(true);

        add(tabPanel);
    }

    public void addTab(Widget widget, Boolean closeable) {

        if (tabPanel.contains(widget.getTitle())) {
            /* tab already exists */
            tabPanel.setSelection(widget.getTitle());
            Info.display("Zakładka już istnieje", widget.getTitle());
        } else {
            Info.display("Nowa zakładka", widget.getTitle());
            /* we need to add new tab */
            TabItem newTab = new TabItem();

            newTab.setText(widget.getTitle());
            newTab.setClosable(closeable);
            newTab.add(widget);
            newTab.addStyleName("pad-text");

            tabPanel.add(newTab);
            tabPanel.setSelection(newTab);
        }
    }

    public void removeTab(String tabTitle) {
        try {
            tabPanel.remove(tabTitle);
            Info.display("Zamknięto zakładkę", tabTitle);
        } catch (Exception ex) {
            Info.display("blad!", ex.getMessage());
        }
    }
}

