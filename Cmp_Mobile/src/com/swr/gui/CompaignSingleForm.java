/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swr.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
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
import com.codename1.ui.util.Resources;
import com.swr.entities.Compaign;
import com.swr.entities.Donation;
import com.swr.services.ServiceCompaign;
import java.io.IOException;

/**
 *
 * @author Monta
 */
public class CompaignSingleForm extends BaseForm {

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
    public int id;

    public CompaignSingleForm(int ids) {
        this(com.codename1.ui.util.Resources.getGlobalResources(), ids);
        int id;
    }

    public CompaignSingleForm(com.codename1.ui.util.Resources resourceObjectInstance, int ids) {
        this.id = ids;
        initGuiBuilderComponents(resourceObjectInstance);
         Style st = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK_IOS, st);
        getToolbar().addCommandToLeftBar("", icon, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                 new CompaignAllForm().showBack();
            }
            
        });
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
        for (Compaign c : ServiceCompaign.getInstance().getSignleCompaign(id)) {
            System.out.println("Cmp == " + c.getNamecmp());
            System.out.println("url == " + c.getUrl());

            com.codename1.ui.Container c3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));

            c3 = ForCmps(resourceObjectInstance, c.getNamecmp(), c.getUrl(), c.getTrgt(), c.getRaised(), c.getNbdon(), c.getDesc(),c.getStillneeded());

            addComponent(c3);
        }
        
        addComponent(gui_Container_1_3);
        System.out.println("id === " + id);

    }

    public Container ForCmps(com.codename1.ui.util.Resources resourceObjectInstance, String name, String url, Double target, Double raised, int nb, String des,Double Still) {
        com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_7 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_8 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_9 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_10 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_11 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_12 = new com.codename1.ui.Label();
        com.codename1.ui.Container gui_Container_3_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
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

        gui_Label_5.setText("  " + name);
        gui_Label_5.setName("Label_5");
        gui_Label_5.setUIID("namecmp");
        com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
        com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_1);
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Label_5);
        gui_Container_3_3.addComponent(gui_Container_2);
        SpanLabel sp = new SpanLabel();
        sp.setText(des);
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, sp);

        Container ct = new Container(BoxLayout.xCenter());
        Container ct2 = new Container(BoxLayout.yCenter());
        Container ct3 = new Container(BoxLayout.yCenter());
        Container ct4 = new Container(BoxLayout.yCenter());
        Container cts = new Container(BoxLayout.yCenter());
        Container ct5 = new Container(BoxLayout.yCenter());
       
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
        s.setMaxValue(rai.intValue());
        s.setMinValue(0);
        Double sed = new Double(raised);
        s.setProgress(sed.intValue());
        cts.add(s);
        ct.add(ct2).add(ct3).add(ct4);
        cts1.add(cts).add(ct).add(ct5);
        
      String[] sugg =new String[10] ;

int size = Display.getInstance().convertToPixels(7);
        
        int i=0;
        for (String c : ServiceCompaign.getInstance().getProps(id)) {
         
             sugg[i]=c;
             i++;
         }
        
        MultiButton b = new MultiButton("This Might Help...");
        b.setUIID("CalendarHourSelected");
b.addActionListener(e -> {
    Dialog d = new Dialog();
    d.setLayout(BoxLayout.y());
    d.getContentPane().setScrollableY(true);
    for(int iter = 0 ; iter < sugg.length ; iter++) {
        MultiButton mb = new MultiButton(sugg[iter]);
        mb.setUIID("SlightlySmallerFontLabelLeft");
        
        d.add(mb);
        mb.addActionListener(ee -> {
            b.setTextLine1(mb.getTextLine1());
            b.setTextLine2(mb.getTextLine2());
            b.setIcon(mb.getIcon());
            d.dispose();
            b.revalidate();
        });
    }
    d.showPopupDialog(b);
});
        
        
        
        Label l1=new Label("Recent Donations"); 
        l1.setUIID("namecmp");
         cts1.add(l1).add(recent()).add(b);
         
      /*   Button btn1=new Button("Check Stats");
        btn1.setUIID("InboxNumber4");
        
        btn1.addActionListener((ActionListener) (ActionEvent evt) -> {
            
      
        });
        cts1.add(btn1);*/
        Button btn=new Button("Give Donation");
        btn.setUIID("InboxNumber4");
        
        btn.addActionListener((ActionListener) (ActionEvent evt) -> {
            
             new DonateForm(resourceObjectInstance, id,123,target,Still).show();
        });
        Button btn1=new Button("Play a Game");
        btn1.setUIID("InboxNumber4");
        
        btn1.addActionListener((ActionListener) (ActionEvent evt) -> {
            
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
                browser.animate();
                browser.setURL("http://localhost/swr-web/web/app_dev.php/cmp/PlayMobileGame/"+id);
                browser.animate();
                
                fm_brw.addComponent(BorderLayout.CENTER, browser);
                fm_brw.show();
            
            
            
            
        });
        cts1.add(btn).add(btn1);
       
        gui_Container_3_3.addComponent(cts1);

        return gui_Container_3_3;
    }
    
    public Container recent(){
    Container rec=new Container(BoxLayout.x());
    rec.setScrollableX(true);
    for (Donation d : ServiceCompaign.getInstance().getDons(id)) {
 
        if (d.getAnnonym()==1)
        {
       // new ImageViewer(theme.getImage("bassem.jpg"))
        Container cwestlfor=new Container(BoxLayout.y());           
        EncodedImage placeHolder = null;
        try {
            placeHolder = EncodedImage.create("/noname.png");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String ul = "http://localhost/swr-mobile/noname.png";
        Image img = URLImage.createToStorage(placeHolder, ul, ul, URLImage.RESIZE_SCALE);
        Label label1 = new Label(img);
       // cwestlfor.addComponent(label1);
        int w = img.getWidth();
        int h = img.getHeight();
        
        Image maskImage = Image.createImage(w, h);
        Graphics g = maskImage.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0x000000);
        g.fillRect(0, 0, w, h);
        g.setColor(0xffffff);
        g.fillArc(0, 0, w, h, 0, 360);
        Label label2 = new Label(maskImage);
       // cwestlfor.addComponent(label2);
         Object mask = maskImage.createMask();
        
        Image maskedImage = img.applyMask(mask);
   
        Label label3 = new Label(maskedImage.scaledWidth(Math.round(Display.getInstance().getDisplayWidth() / 6)));
        cwestlfor.addComponent(label3);
        rec.add(cwestlfor);
        }
        else { 
        Container cwestlfor=new Container(BoxLayout.y());           
        EncodedImage placeHolder = null;
        try {
            placeHolder = EncodedImage.create("/load.png");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String ul = "http://localhost/swr/web/uploads/" + d.getPrenom();
        Image img = URLImage.createToStorage(placeHolder, ul, ul, URLImage.RESIZE_SCALE);
        Label label1 = new Label(img);
       // cwestlfor.addComponent(label1);
        int w = img.getWidth();
        int h = img.getHeight();
        
        Image maskImage = Image.createImage(w, h);
        Graphics g = maskImage.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0x000000);
        g.fillRect(0, 0, w, h);
        g.setColor(0xffffff);
        g.fillArc(0, 0, w, h, 0, 360);
        Label label2 = new Label(maskImage);
       // cwestlfor.addComponent(label2);
         Object mask = maskImage.createMask();
        
        Image maskedImage = img.applyMask(mask);
   
        Label label3 = new Label(maskedImage.scaledWidth(Math.round(Display.getInstance().getDisplayWidth() / 6)));
        cwestlfor.addComponent(label3);
        rec.add(cwestlfor);
    }
    }
    
    Container cwestlfor=new Container(BoxLayout.y());           
        EncodedImage placeHolder = null;
        try {
            placeHolder = EncodedImage.create("/plus.png");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String ul = "http://localhost/swr-mobile/plus.png";
        Image img = URLImage.createToStorage(placeHolder, ul, ul, URLImage.RESIZE_SCALE);
        Label label1 = new Label(img);
       // cwestlfor.addComponent(label1);
        int w = img.getWidth();
        int h = img.getHeight();
        
        Image maskImage = Image.createImage(w, h);
        Graphics g = maskImage.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0x000000);
        g.fillRect(0, 0, w, h);
        g.setColor(0xffffff);
        g.fillArc(0, 0, w, h, 0, 360);
        Label label2 = new Label(maskImage);
       // cwestlfor.addComponent(label2);
         Object mask = maskImage.createMask();
        
        Image maskedImage = img.applyMask(mask);
   
        Label label3 = new Label(maskedImage.scaledWidth(Math.round(Display.getInstance().getDisplayWidth() / 6)));
        
        label3.addPointerReleasedListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            
           new RecentForm(id).show();
        }
        });
        cwestlfor.addComponent(label3);
       
        rec.add(cwestlfor);
    return rec;
    }
}
