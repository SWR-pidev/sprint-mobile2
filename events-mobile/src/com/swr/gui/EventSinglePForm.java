/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swr.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
import com.codename1.l10n.ParseException;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.swr.entities.Event;
import com.swr.entities.User;
import com.swr.services.ServiceEvent;
import java.io.IOException;

/**
 *
 * @author Eya
 */
public class EventSinglePForm extends BaseForm {

    public int id;

    public EventSinglePForm(int ide) {
        this(com.codename1.ui.util.Resources.getGlobalResources(), ide);
        this.id = ide;
    }

    public EventSinglePForm(com.codename1.ui.util.Resources resourceObjectInstance, int ide) {
        this.id = ide;
        initGuiBuilderComponents(resourceObjectInstance);

        Style st = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK_IOS, st);
        getToolbar().addCommandToLeftBar("", icon, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                new EventAllPForm().showBack();

            }

        });

        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {
        });
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Attend An Event");
        for (Event e : ServiceEvent.getInstance().getSingleEventP(id)) {
            com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            com.codename1.ui.Container gui_Container_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            com.codename1.ui.Container gui_Container_6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());

            com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
            com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
            com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
            com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
            com.codename1.components.MultiButton date = new com.codename1.components.MultiButton();
            com.codename1.components.MultiButton time = new com.codename1.components.MultiButton();
            com.codename1.components.MultiButton people = new com.codename1.components.MultiButton();
            com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();

            com.codename1.components.MultiButton location = new com.codename1.components.MultiButton();
            com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());

            addComponent(gui_imageContainer1);

            FontImage.setMaterialIcon(date, FontImage.MATERIAL_CALENDAR_TODAY);
            date.setIconPosition(BorderLayout.WEST);
            FontImage.setMaterialIcon(time, FontImage.MATERIAL_TIMER);
            time.setIconPosition(BorderLayout.WEST);
            FontImage.setMaterialIcon(people, FontImage.MATERIAL_PEOPLE);
            people.setIconPosition(BorderLayout.WEST);
            FontImage.setMaterialIcon(location, FontImage.MATERIAL_LOCATION_ON);
            location.setIconPosition(BorderLayout.WEST);

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

            gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_1);

            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Multi_Button_1);
            gui_Multi_Button_1.setPropertyValue("line1", e.getName());
            gui_Multi_Button_1.setPropertyValue("uiid1", "NameEvtLabel2");
            gui_Multi_Button_1.setUIID("Label");

            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
            SpanLabel sp = new SpanLabel();
            gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, sp);
            sp.setText(e.getDetails());
            sp.setUIID("SlightlySmallerFontLabelLeft");
            gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_3);

            Container ct = new Container(BoxLayout.xCenter());
            gui_Container_3.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, ct);
            gui_Container_3.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_4);
            date.setUIID("Label");
            date.setPropertyValue("line1", ServiceEvent.getInstance().getDate(id));
            date.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            time.setUIID("Label");
            time.setPropertyValue("line1", ServiceEvent.getInstance().getTime(id));
            time.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            people.setUIID("Label");
            people.setPropertyValue("line1", "" + e.getNbparticipant() + "");
            people.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            ct.add(date).add(time).add(people);
            location.setUIID("Label");
            location.setPropertyValue("line1", e.getLocation());
            location.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            gui_Container_4.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, location);
            gui_Container_4.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_5);
            Label lb = new Label();
            lb.setText("  Sponsored By \n");
            lb.setUIID("RedLabel2");
            Container ct1 = new Container(BoxLayout.y());
            Container ct2 = new Container(BoxLayout.xCenter());
            for (String logo : ServiceEvent.getInstance().getLogos(id)) {
                EncodedImage placeHolder2 = null;
                try {
                    placeHolder2 = EncodedImage.create("/load.png");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                String ull = "http://localhost/swr/web/uploads/" + logo;
                Image img2 = URLImage.createToStorage(placeHolder2, ull, ull, URLImage.RESIZE_SCALE);
                Label logoImg = new Label();
                logoImg.setUIID("RedLabel2");
                logoImg.setIcon(img2.scaledWidth(Math.round(Display.getInstance().getDisplayWidth() / 7)));
                ct2.add(logoImg);
            }
            ct1.add(lb).add(ct2);
            gui_Container_5.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, ct1);

            gui_Container_5.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_6);
            /**
             * *************************** ID USER NEEDED
             * ***************************
             */
            if (ServiceEvent.getInstance().CheckP(id, 5) == 1) {
                gui_Button_1.setText("Participate");
                gui_Button_2.setText(" ");
                gui_Button_2.setUIID("BunttonInvisiblepdf");
            } /**
             * *************************** ID USER NEEDED
             * ***************************
             */
            else {
                gui_Button_1.setText("Cancel Participation");
                gui_Button_2.setText("Show Invitation");
                gui_Button_2.setUIID("InboxNumber4");
            }
            gui_Button_1.setName("Button_2");
            gui_Button_1.setUIID("InboxNumber3");

            gui_Button_1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (gui_Button_1.getText().equals("Participate")) {
                        ServiceEvent.getInstance().AddP(id, 5);
                        gui_Button_1.setText("Cancel Participation");
                        gui_Button_2.setText("Show Invitation");
                        gui_Button_2.setUIID("InboxNumber4");

                        people.setPropertyValue("line1", "" + ServiceEvent.getInstance().GetnbP(id) + "");
                    } else if (gui_Button_1.getText().equals("Cancel Participation")) {
                        ServiceEvent.getInstance().DeleteP(id, 5);
                        gui_Button_1.setText("Participate");
                        gui_Button_2.setText(" ");
                        gui_Button_2.setUIID("BunttonInvisiblepdf");
                        people.setPropertyValue("line1", "" + ServiceEvent.getInstance().GetnbP(id) + "");
                    }
                }
            });

            gui_Button_2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    FileSystemStorage fs = FileSystemStorage.getInstance();
                    String fileName = fs.getAppHomePath() + "pdf-sample.pdf";

                    Util.downloadUrlToFile("http://localhost/swr-web/web/app_dev.php/evt/mobileEvt/invit/" + id + "/" + 63, fileName, true);

                    Display.getInstance().execute(fileName);

                }

            });

            gui_Container_6.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Button_1);
            gui_Container_6.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_2);
        }

    }

    @Override
    protected boolean isCurrentEvents() {
        return true;
    }
}
