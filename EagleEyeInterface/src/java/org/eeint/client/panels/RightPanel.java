/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eeint.client.panels;

import org.eeint.client.*;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.tree.Tree;
import com.extjs.gxt.ui.client.widget.tree.TreeItem;

/**
 *
 * @author me2
 */
public class RightPanel extends ContentPanel {

    ContentPanel singleton = null;
    OwnerScreen lm;

    public RightPanel(OwnerScreen l) {
        lm = l;
    }

    public ContentPanel get() {
        if (singleton != null) {
            return singleton;
        } else {
            singleton = this;

            setBodyBorder(false);
            setHeading("Menu");
            setLayout(new AccordionLayout());

            ContentPanel home = new ContentPanel();
            home.setHeading("Pokaż w drzewie projektu");
            home.setBorders(false);
            add(home);

            ContentPanel e = new ContentPanel();
            e.setHeading("Edycja");
            e.setBorders(false);
            add(e);

            ContentPanel o = new ContentPanel();
            o.setHeading("Oszacowania / Terminy / Historia");
            o.setBorders(false);
            add(o);

            return this;
        }
    }
}
