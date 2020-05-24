/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swr.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.ParseException;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.swr.services.ServiceEvent;

/**
 *
 * @author Eya
 */
public class EventSpaceForm extends BaseForm {

    public EventSpaceForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();

    public EventSpaceForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {
        });
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Event Space");
        addComponent(gui_Container_1);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);

        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
        Label bg = new Label(resourceObjectInstance.getImage("event_bg.jpg"), "CenterLabel");
        gui_Container_3.addComponent(bg);
        Label gui_Label_3 = new Label();
        gui_Label_3.setText("Would you like to ? ");
        gui_Label_3.setName("Label_3");
        gui_Label_3.setUIID("BoldLabel");
        gui_Container_3.addComponent(gui_Label_3);
        gui_Button_2.setText(" Become a Sponsor");
        gui_Button_2.setName("Button_2");
        gui_Button_2.setUIID("InboxNumber4");
        gui_Container_3.addComponent(gui_Button_2);
        // gui_Button_2.setIcon(resourceObjectInstance.getImage("donate1.png"));
        gui_Button_3.setText(" Attend an Event");
        gui_Button_3.setName("Button_2");
        gui_Button_3.setUIID("InboxNumber3");
        gui_Container_3.addComponent(gui_Button_3);
        // gui_Button_3.setIcon(resourceObjectInstance.getImage("event-01.png"));
    }

    @Override
    protected boolean isCurrentEvents() {
        return true;
    }

    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_3.addActionListener(callback);
        gui_Button_2.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {

        private com.codename1.ui.Component cmp;

        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if (sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if (sourceComponent == gui_Button_3) {

                onButton_3ActionEvent(ev);

            }
            if (sourceComponent == gui_Button_2) {

                onButton_2ActionEvent(ev);

            }
        }

        public void dataChanged(int type, int index) {
        }
    }

    public void onButton_3ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new EventAllPForm().show();
    }

    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new EventAllSForm().show();
    }
}
