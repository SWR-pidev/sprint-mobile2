/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swr.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.swr.entities.Event;
import com.swr.services.ServiceEvent;
import java.io.IOException;

/**
 *
 * @author Eya
 */
public class EventAllSForm extends BaseForm {

    public EventAllSForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public EventAllSForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {
        });

    }

    @Override
    protected boolean isCurrentEvents() {
        return true;
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Become a Sponsor");
         if(ServiceEvent.getInstance().getAllEventsS().isEmpty())
            {
                 addComponent(new Label("We have no events to sponsor for now"));
                 addComponent(new Label("Thank you ."));
            }
        for (Event e : ServiceEvent.getInstance().getAllEventsS()) {
           
            com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
            com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
            com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
            com.codename1.components.MultiButton gui_newYork = new com.codename1.components.MultiButton();
            com.codename1.components.MultiButton gui_newYork1 = new com.codename1.components.MultiButton();
            com.codename1.components.MultiButton gui_newYork2 = new com.codename1.components.MultiButton();
            com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
            addComponent(gui_Container_1);
            FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);
            gui_LA.setIconPosition(BorderLayout.EAST);

            FontImage.setMaterialIcon(gui_newYork1, FontImage.MATERIAL_ATTACH_MONEY);
            gui_newYork.setIconPosition(BorderLayout.WEST);

            FontImage.setMaterialIcon(gui_newYork, FontImage.MATERIAL_PEOPLE);
            gui_newYork1.setIconPosition(BorderLayout.WEST);

            FontImage.setMaterialIcon(gui_newYork2, FontImage.MATERIAL_DONE);
            gui_newYork2.setIconPosition(BorderLayout.WEST);

            EncodedImage placeHolder = null;
            try {
                placeHolder = EncodedImage.create("/load.png");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            String ul = "http://localhost/swr/web/uploads/" + e.getUrl_evt();
            Image img = URLImage.createToStorage(placeHolder, ul, ul, URLImage.RESIZE_SCALE);

            ScaleImageLabel sl = new ScaleImageLabel(img);
            sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
            gui_imageContainer1.add(BorderLayout.CENTER, sl);
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1);
            gui_Multi_Button_1.setPropertyValue("line1", e.getName());
            gui_Multi_Button_1.setPropertyValue("uiid1", "NameEvtLabel2");
            gui_Multi_Button_1.setUIID("Label");

            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_LA);
            gui_LA.setUIID("Label");
            gui_LA.setName("LA");
            gui_LA.setPropertyValue("line1", ServiceEvent.getInstance().GetDateDiff(e.getId_evt()) + " Days Left");
            gui_LA.setPropertyValue("line2", "in Tunis");
            gui_LA.setPropertyValue("uiid1", "DateEvt");
            gui_LA.setPropertyValue("uiid2", "RedLabelRight");
            gui_newYork.setUIID("Label");

            gui_newYork.setPropertyValue("line1", "" + e.getNbsponsor() + "");
            gui_newYork.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            gui_newYork1.setUIID("Label");
            gui_newYork1.setPropertyValue("line1", "" + e.getBudget() + "");
            gui_newYork1.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            gui_newYork2.setUIID("Label");
            if(e.getNbsponsor()==0){
                 gui_newYork2.setPropertyValue("line1", "0%");
            }
            else{
                 gui_newYork2.setPropertyValue("line1", "" + ServiceEvent.getInstance().GetRaised(e.getId_evt()) + "%");
            }
           
            gui_newYork2.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            addComponent(gui_imageContainer1);
            gui_imageContainer1.setName("imageContainer1");
            gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
            gui_Container_2.setName("Container_2");
            //gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_newYork);

            gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_1);
            Container ct = new Container(BoxLayout.xCenter());
            ct.add(gui_newYork).add(gui_newYork1).add(gui_newYork2);
            gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, ct);
            gui_Button_1.setText("");
            gui_Button_1.setUIID("Label");
            gui_Button_1.setName("Button_1");
            com.codename1.ui.FontImage.setMaterialIcon(gui_Button_1, "".charAt(0));
            gui_Container_2.setName("Container_2");

            addComponent(gui_separator1);
            gui_Button_1.addActionListener((ActionListener) (ActionEvent evt) -> {
                new EventSingleSForm(resourceObjectInstance, e.getId_evt()).show();
            });

        }
    }
}
