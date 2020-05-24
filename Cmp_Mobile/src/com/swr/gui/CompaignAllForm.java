/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swr.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.swr.entities.Compaign;
import com.swr.services.ServiceCompaign;
import java.io.IOException;

/**
 *
 * @author Monta
 */
public class CompaignAllForm extends BaseForm {

    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();

    private com.codename1.ui.Container gui_Container_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2_1 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_1 = new com.codename1.ui.TextArea();

    private com.codename1.ui.Container gui_Container_1_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2_2 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_2 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Container gui_Container_1_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_3_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2_3 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_3 = new com.codename1.ui.TextArea();

    private com.codename1.ui.Container gui_Container_1_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2_4 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_4 = new com.codename1.ui.TextArea();
public String mail;
    public CompaignAllForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public CompaignAllForm(com.codename1.ui.util.Resources resourceObjectInstance ) {
     
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {
        });
    }

    @Override
    protected boolean isCurrentCmps() {
        return true;
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Campaings");
        addComponent(gui_Container_1);

        SpanLabel sp = new SpanLabel();
        sp.setText(ServiceCompaign.getInstance().getAllCompaign().toString());

        // addComponent(sp);
        for (Compaign c : ServiceCompaign.getInstance().getAllCompaign()) {
            System.out.println("Cmp == " + c.getNamecmp());
            System.out.println("url == " + c.getUrl());

            com.codename1.ui.Container c3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
            if (c.getTrgt() != c.getRaised()) {
                c3 = ForCmps(resourceObjectInstance, c.getNamecmp(), c.getUrl(), c.getTrgt(), c.getRaised(), c.getNbdon(), c.getId_cmp());

                addComponent(c3);
            }
        }
        addComponent(gui_Container_1_3);
        this.getToolbar().addCommandToOverflowMenu("Check Stats", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Form fm_brw = new Form();
                   Style st = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK_IOS, st);
        fm_brw.getToolbar().addCommandToLeftBar("", icon, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                 new CompaignAllForm().showBack();
            }
            
        });
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {
        });
                fm_brw.setLayout(new BorderLayout());

                BrowserComponent browser = new BrowserComponent();
                browser.setURL("http://localhost/swr-web/web/app_dev.php/cmp/Mobilestatcmp");

                fm_brw.addComponent(BorderLayout.CENTER, browser);
                fm_brw.show();
            }
        });

    }

    public Container ForCmps(com.codename1.ui.util.Resources resourceObjectInstance, String name, String url, Double target, Double raised, int nb, int id) {
        com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_7 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_8 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_9 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_10 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_11 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_12 = new com.codename1.ui.Label();
        com.codename1.ui.Container gui_Container_3_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        gui_Label_5.setText("  " + name);
        gui_Label_5.setName("Label_5");
        gui_Label_5.setUIID("namecmp");
        com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
        com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_1);
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Label_5);

        gui_Container_3_3.addComponent(gui_Container_2);
        gui_Button_1.setText("");
        gui_Button_1.setUIID("Label");
        gui_Button_1.setName("Button_1");
        gui_Button_1.setIcon(resourceObjectInstance.getImage("next.png"));

        gui_Button_1.addActionListener((ActionListener) (ActionEvent evt) -> {
            new CompaignSingleForm(resourceObjectInstance, id).show();

        });

        EncodedImage placeHolder = null;
        try {
            placeHolder = EncodedImage.create("/load.png");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String ul = "http://localhost/swr/web/uploads/" + url;
        Image img = URLImage.createToStorage(placeHolder, ul, ul, URLImage.RESIZE_SCALE);
        com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer1.add(BorderLayout.CENTER, sl);

        gui_Container_3_3.addComponent(gui_imageContainer1);
        Container ct = new Container(BoxLayout.xCenter());
        Container ct2 = new Container(BoxLayout.yCenter());
        Container ct3 = new Container(BoxLayout.yCenter());
        Container ct4 = new Container(BoxLayout.yCenter());
        Container cts = new Container(BoxLayout.yCenter());
        Container cts1 = new Container(BoxLayout.yCenter());
        gui_Label_7.setText("" + nb);
        gui_Label_7.setName("Label_7");
        gui_Label_7.setUIID("CenterLabelCmp");
        gui_Label_8.setText(" Donors");
        FontImage.setMaterialIcon(gui_Label_8, FontImage.MATERIAL_PEOPLE);
        FontImage.setMaterialIcon(gui_Label_10, FontImage.MATERIAL_ATTACH_MONEY);
        FontImage.setMaterialIcon(gui_Label_12, FontImage.MATERIAL_ATTACH_MONEY);

        gui_Label_8.setName("Label_8");
        gui_Label_8.setUIID("CenterLabelCmp");
        ct2.add(gui_Label_7).add(gui_Label_8);
        gui_Label_9.setText(raised + "$");
        gui_Label_9.setName("Label_9");
        gui_Label_9.setUIID("CenterLabelCmp");
        gui_Label_10.setText("Raised");
        gui_Label_10.setName("Label_10");
        gui_Label_10.setUIID("CenterLabelCmp");
        ct3.add(gui_Label_9).add(gui_Label_10);
        gui_Label_11.setText(target + "$");
        gui_Label_11.setName("Label_10");
        gui_Label_11.setUIID("CenterLabelCmp");
        gui_Label_12.setText("Goal");
        gui_Label_12.setName("Label_12");
        gui_Label_12.setUIID("CenterLabelCmp");
        ct4.add(gui_Label_11).add(gui_Label_12);
        Slider s = new Slider();
        s.setUIID("Slider");
        Double rai = new Double(target);
        Double sed = new Double(raised);
        s.setProgress(sed.intValue());
        s.setMaxValue(rai.intValue());
        s.setMinValue(0);
     
        System.out.println("Raised Should be" + sed.intValue());
          System.out.println("Max Value should be" + rai.intValue());

        cts.add(s);
        ct.add(ct2).add(ct3).add(ct4);
        cts1.add(cts).add(ct);
        gui_Container_3_3.addComponent(cts1);
        return gui_Container_3_3;
    }
}
