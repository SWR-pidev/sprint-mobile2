/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swr.gui;

import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Effects;
import com.codename1.ui.util.UITimer;
import com.swr.entities.Event;
import com.swr.entities.Sponsor;
import com.swr.services.ServiceEvent;

import java.util.Date;

/**
 *
 * @author Eya
 */
public class ConfirmSponsorForm extends com.codename1.ui.Form {
 public int id;
  int expy =0;
    int expm=0;
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.components.InfiniteProgress gui_Infinite_Progress_1 = new com.codename1.components.InfiniteProgress();
    private com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();

    public ConfirmSponsorForm(int ide) {
        this(com.codename1.ui.util.Resources.getGlobalResources(), ide);
         this.id = ide;
    }

    public ConfirmSponsorForm(com.codename1.ui.util.Resources resourceObjectInstance, int ide) {
this.id = ide;
        initGuiBuilderComponents(resourceObjectInstance);
        Style st = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK_IOS, st);
        getToolbar().addCommandToLeftBar("", icon, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                new EventAllSForm().showBack();

            }

        });
         getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {
        });

        //UITimer.timer(40000, false, this, () -> new EventAllSForm(resourceObjectInstance).show());
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {

        com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
        com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField("","Card Number");
        com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField("","Exp Year");
        com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField("","Exp Month");
        com.codename1.ui.TextField gui_Text_Field_4 = new com.codename1.ui.TextField("","CVC");
        com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
com.codename1.ui.Label errorCard = new com.codename1.ui.Label();

        com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
  com.codename1.ui.Container gui_Container_6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
  
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Become a Sponsor");
        ((com.codename1.ui.layouts.BorderLayout) getLayout()).setCenterBehavior(com.codename1.ui.layouts.BorderLayout.CENTER_BEHAVIOR_CENTER);
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setName("Container_1");
        Button btnA = new Button("  ");
        Button btnB = new Button("  ");
      

        gui_Label_2.setUIID("Padding2");
        gui_Label_2.setText("Payment Infos");
         gui_Container_1.addComponent(gui_Label_2);
           gui_Container_1.addComponent(btnA);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
      

        gui_Component_Group_1.addComponent(gui_Text_Field_1);
       
        gui_Component_Group_1.addComponent(gui_Text_Field_3);
         
        gui_Component_Group_1.addComponent(gui_Text_Field_4);
        
        ((com.codename1.ui.layouts.BoxLayout) gui_Container_1.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        //((com.codename1.ui.layouts.BoxLayout) gui_Container_1.getLayout()).setValign(com.codename1.ui.Component.CENTER);
    
        // gui_Container_1.addComponent(btnA);

        btnA.setUIID("BunttonInvisiblepdf");
        btnB.setUIID("BunttonInvisiblepdf");
        
          gui_Container_6.setUIID("GetStartedButton");

        ((com.codename1.ui.layouts.FlowLayout) gui_Container_6.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout) gui_Container_6.getLayout()).setValign(com.codename1.ui.Component.CENTER);
        gui_Container_6.addComponent(gui_Label_1);
        gui_Container_6.addComponent(errorCard);
        
        gui_Label_1.setUIID("GetStartedRedArrow");
       
        
        
        
         gui_Container_1.addComponent(gui_Container_6);
         gui_Container_1.addComponent(btnB);
        gui_Container_1.addComponent(gui_Button_2);

        gui_Button_2.setText("Next");
        gui_Button_2.setUIID("InboxNumber3");
        
        gui_Button_2.addPointerReleasedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                 if (!checkCardNumber(gui_Text_Field_2.getText())) {
                    errorCard.setText("Please fill out the Card number field");
                     com.codename1.ui.FontImage.setMaterialIcon(gui_Label_1, FontImage.MATERIAL_WARNING);
                    revalidate();
                }  else if (!checkExpYear(gui_Text_Field_1.getText())) {
                    errorCard.setText("Please fill out the exp Year field");
                     com.codename1.ui.FontImage.setMaterialIcon(gui_Label_1, FontImage.MATERIAL_WARNING);
                    revalidate();
                } else if (expy < 2021 || expy > 2050) {
                    errorCard.setText("please fill out a valid year");
                     com.codename1.ui.FontImage.setMaterialIcon(gui_Label_1, FontImage.MATERIAL_WARNING);
                    revalidate();
                }
                else if (!checkExpMonth(gui_Text_Field_3.getText())) {
                    errorCard.setText("Please fill out the exp Month field");
                     com.codename1.ui.FontImage.setMaterialIcon(gui_Label_1, FontImage.MATERIAL_WARNING);
                    revalidate();
                }else if (expm > 12 || expm == 00) {
                    errorCard.setText("please fill out a valid month");
                     com.codename1.ui.FontImage.setMaterialIcon(gui_Label_1, FontImage.MATERIAL_WARNING);
                    revalidate();
                }
                else if (!checkCvc(gui_Text_Field_4.getText())) {
                    errorCard.setText("Please fill out the CVC field");
                     com.codename1.ui.FontImage.setMaterialIcon(gui_Label_1, FontImage.MATERIAL_WARNING);
                    revalidate();
                }
                else { 
                    
                    new SponsorForm(resourceObjectInstance, id).show();
                    
                    
                    System.out.println("sponsoring now");
               }
            }
        });

 
    }// </editor-fold>

  
    
     public boolean checkCardNumber(String cardn)
    {
        /* if(cardn.isEmpty() || cardn.length()!=16 || !cardn.matches(".*[^0-9].*"))
        {
            
                return false;
        }*/
        if (cardn.length()!=16){return false;}
         char[] chars = cardn.toCharArray();
        for (char c : chars) {
        if(!Character.isDigit(c)) {
        return false;
        } }
     return true;
    }
       public boolean checkExpYear(String exy)
    {
         if (exy.length()!=4){return false;}
         char[] chars = exy.toCharArray();
        for (char c : chars) {
        if(!Character.isDigit(c)) {
        return false;
        } }
        expy = Integer.parseInt(exy);
         return true;
    }
         public boolean checkExpMonth(String exm)
    {
           if (exm.length()!=2){return false;}
         char[] chars = exm.toCharArray();
        for (char c : chars) {
        if(!Character.isDigit(c)) {
        return false;
        } }
        expm = Integer.parseInt(exm);
         return true;
    }
         
public boolean checkCvc(String cvcc)
    {
          if (cvcc.length()!=3){return false;}
         char[] chars = cvcc.toCharArray();
        for (char c : chars) {
        if(!Character.isDigit(c)) {
        return false;
        } }
          return true;
    }
}
