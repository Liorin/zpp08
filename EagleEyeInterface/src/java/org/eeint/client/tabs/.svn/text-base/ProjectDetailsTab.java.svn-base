/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eeint.client.tabs;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.VerticalPanel;
import eeserver.persistence.eeProject;

/**
 *
 * @author me2
 */
public class ProjectDetailsTab extends VerticalPanel {

    VerticalPanel vp;

    ProjectDetailsTab(eeProject project) {
        setTitle("Szczegóły projektu blabla");

        vp = new VerticalPanel();
        vp.setSpacing(10);

        FormPanel simple = new FormPanel();
        simple.setHeading("Raportuj pracę");
        simple.setFrame(true);
        simple.setWidth(360);

        simple.addText("<b>Projekt:</b> Zespołowy Projekt Programistyczny 2009");
        simple.addText("<b>IMPLEMENTACJA INTERFEJSU</b> <br/><br/>");

        DateField date = new DateField();
        date.setFieldLabel("Data");
        simple.add(date);

        TextField<String> firstName = new TextField<String>();
        firstName.setFieldLabel("Liczba godzin");
        firstName.setAllowBlank(false);
        simple.add(firstName);

        simple.setButtonAlign(HorizontalAlignment.CENTER);
        simple.addButton(new Button("Raportuj"));
        simple.addButton(new Button("Anuluj"));

        /* -------------------- drugie okienko -------------------------- */

        final Window window = new Window();
        window.setSize(500, 300);
        window.setPlain(true);
        window.setHeading("Nowe podzadanie");
        //window.setLayout(new FitLayout());

        FormPanel newNode = new FormPanel();
        newNode.setHeading("Nowe podzadanie");
        newNode.setFrame(true);
        newNode.setWidth(360);

        TextField<String> newNodeName = new TextField<String>();
        newNodeName.setFieldLabel("Nazwa");
        newNodeName.setAllowBlank(false);
        newNode.add(newNodeName);

        TextField<String> newNodeDesc = new TextArea();
        newNodeDesc.setFieldLabel("Opis");
        newNode.add(newNodeDesc);

        ComboBox combo = new ComboBox();
        combo.setFieldLabel("Osoba odpowiedzialna");
        combo.setTriggerAction(TriggerAction.ALL);
        newNode.add(combo);

        newNode.setButtonAlign(HorizontalAlignment.CENTER);
        newNode.addButton(new Button("Utwórz"));
        newNode.addButton(new Button("Anuluj"));

        vp.add(simple);
        vp.add(newNode);
        add(vp);
    }
}