/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eeint.client;

import org.eeint.client.panels.MainPanel;
import org.eeint.client.panels.TopPanel;
import org.eeint.client.panels.LeftPanel;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;

/**
 *
 * @author me2
 */
public class OwnerScreen extends LayoutContainer {

    public TopPanel topPanel = new TopPanel();
    public MainPanel mainPanel = new MainPanel();
    private LeftPanel leftPanel = new LeftPanel(mainPanel);

    public OwnerScreen() {
        setLayout(new BorderLayout());

        /* top panel settings */
        LayoutContainer north = new LayoutContainer();
        BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH, 60);
        northData.setSplit(false);
        northData.setCollapsible(false);
        northData.setFloatable(false);
        northData.setHideCollapseTool(false);
        northData.setMargins(new Margins(5, 5, 0, 5));
        north.add(topPanel);

        /* left panel settings */
        BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, 200, 100, 300);
        westData.setMargins(new Margins(5, 5, 5, 5));
        westData.setCollapsible(true);

        /* main panel settings */
        BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
        centerData.setMargins(new Margins(5, 5, 5, 0));
        ContentPanel center = new ContentPanel();
        center.setHeaderVisible(false);
        center.setScrollMode(Scroll.AUTOX);
        center.add(mainPanel);
        center.setScrollMode(Scroll.AUTO);

        /* bottom panel settings */
        ContentPanel south = new ContentPanel();
        BorderLayoutData southData = new BorderLayoutData(LayoutRegion.SOUTH, 100);
        southData.setSplit(true);
        southData.setCollapsible(true);
        southData.setFloatable(true);
        southData.setMargins(new Margins(0, 5, 5, 5));

        add(north, northData);
        add(leftPanel.get(), westData);
        add(center, centerData);
        add(south, southData);

        setHeight("100%");
        setWidth("100%");
    }
}
