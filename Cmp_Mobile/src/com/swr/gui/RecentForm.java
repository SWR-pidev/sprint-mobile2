/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.swr.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.swr.entities.Donation;
import com.swr.services.ServiceCompaign;
import java.io.IOException;

/**
 * GUI builder created Form
 *
 * @author shai
 */


public class RecentForm extends BaseForm {
public int id;
    public RecentForm(int id) {
        this(com.codename1.ui.util.Resources.getGlobalResources(), id);
    }
    
    public RecentForm(com.codename1.ui.util.Resources resourceObjectInstance,int id) {
       this.id=id;
        initGuiBuilderComponents(resourceObjectInstance);
       
    }

//-- DON'T EDIT BELOW THIS LINE!!!
  


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
     

        
             Style st = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK_IOS, st);
        getToolbar().addCommandToLeftBar("", icon, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                 new CompaignSingleForm(id).showBack();
            }
            
        });
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        
      
        
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Recent Donation");
         for (Donation d : ServiceCompaign.getInstance().getDons(id)) {
                  String ul;
        
        com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
      com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
     com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
     com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
     com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.components.MultiButton gui_null_1_1_1 = new com.codename1.components.MultiButton();
     com.codename1.components.MultiButton gui_newYork = new com.codename1.components.MultiButton();
     com.codename1.ui.Container gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
     com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
     com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();
         gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
             FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_ATTACH_MONEY);
        gui_LA.setIconPosition(BorderLayout.EAST);
        
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setGrowByContent(false);
        gui_Text_Area_1.setEditable(false);
        
        
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_LA);
        gui_Multi_Button_1.setUIID("Label");
        gui_Multi_Button_1.setName("Multi_Button_1");
        
        EncodedImage placeHolder = null;
        try {
            placeHolder = EncodedImage.create("/load.png");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        if (d.getAnnonym()==1){
            ul = "http://localhost/swr/web/uploads/" + d.getPrenom();
        } else {
              ul = "http://localhost/swr-mobile/noname.png";
        }
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
   
      
        
        
        gui_Multi_Button_1.setIcon(maskedImage.scaledWidth(Math.round(Display.getInstance().getDisplayWidth() / 6)));  // img user 
       if(d.getAnnonym()==1)
       { gui_Multi_Button_1.setPropertyValue("line1", d.getNom());
       }
         else{gui_Multi_Button_1.setPropertyValue("line1","Annonymous") ;}// namee user 
        gui_Multi_Button_1.setPropertyValue("uiid1", "Label");

        gui_LA.setUIID("Label");
        gui_LA.setName("LA");
        gui_LA.setPropertyValue("line1", ""+d.getGiven());  // given 

        gui_LA.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
       
        addComponent(gui_imageContainer1);
        gui_imageContainer1.setName("imageContainer1");
        gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
        gui_Container_2.setName("Container_2");
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_1);
        gui_Text_Area_1.setText(d.getMes());
        gui_Text_Area_1.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_1.setName("Text_Area_1");
     
     
        gui_Container_2.setName("Container_2");
        addComponent(gui_separator1);
               addComponent(gui_Label_1_1_1);
        
      
        gui_separator1.setUIID("Separator");
        gui_separator1.setName("separator1");
        gui_null_1_1.setName("null_1_1");
       
        gui_Label_1_1_1.setUIID("Separator");
        gui_Label_1_1_1.setName("Label_1_1_1");
    }// </editor-fold>
    
    }

//-- DON'T EDIT ABOVE THIS LINE!!!

    @Override
    protected boolean isCurrentTrending() {
        return true;
    }
}
