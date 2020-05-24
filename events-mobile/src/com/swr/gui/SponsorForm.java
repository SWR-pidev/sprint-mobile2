/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swr.gui;

import com.codename1.capture.Capture;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ext.filechooser.FileChooser;
import com.codename1.io.File;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout.Constraint;
import com.swr.entities.Event;
import com.swr.entities.Sponsor;
import com.swr.entities.User;
import com.swr.services.ServiceEvent;

import java.io.IOException;
import java.io.InputStream;

//import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author Eya
 */
public class SponsorForm extends BaseForm {

    /**
     * ****** USER ID HERE *************
     */
    int idU = 152;
    User u = new User(idU, "eya", "eya");
    /**
     * ****** USER ID HERE *************
     */

    public int id;
    public int amountInt;
//    private FileUploader file;
    String fileUploaded;
    private String imgPath;
    Button logo = new Button();
    public com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    public SpanLabel sp = new SpanLabel();

    public SponsorForm(int ide) {
        this(com.codename1.ui.util.Resources.getGlobalResources(), ide);
        this.id = ide;
    }

    public SponsorForm(com.codename1.ui.util.Resources resourceObjectInstance, int ide) {
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
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {

        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Become a Sponsor");
        SpanLabel fileEmpty = new SpanLabel();
        SpanLabel AmountError = new SpanLabel();
        com.codename1.ui.Container gui_Container_6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
        com.codename1.ui.Container gui_Container_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));

        com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
        com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
        com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();

        com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
        com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
        com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();

        com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
        com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();

        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        /* gui_Container_1.addComponent(gui_Label_2);
        gui_Label_2.setUIID("CenterLabel");
        gui_Label_2.setText("                           \n \n \n \n \n \n");*/
        //gui_Label_2.setIcon(resourceObjectInstance.getImage("sponsor-01.png"));
        gui_Container_1.addComponent(gui_Container_6);
        gui_Container_1.addComponent(gui_imageContainer1);
        gui_Container_1.add(fileEmpty);
        fileEmpty.setUIID("CenterLabel");
        gui_Container_1.addComponent(gui_Component_Group_1);

        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Component_Group_1.addComponent(AmountError);
        AmountError.setUIID("CenterLabel");
        ((com.codename1.ui.layouts.BoxLayout) gui_Container_1.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        // ((com.codename1.ui.layouts.BoxLayout) gui_Container_1.getLayout()).setValign(com.codename1.ui.Component.CENTER);
        gui_Text_Field_2.setText("Amount");

        gui_Container_6.setUIID("GetStartedButton");

        ((com.codename1.ui.layouts.FlowLayout) gui_Container_6.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout) gui_Container_6.getLayout()).setValign(com.codename1.ui.Component.CENTER);
        gui_Container_6.addComponent(gui_Label_1);
        gui_Container_6.addComponent(gui_Button_1);
        gui_Button_1.setText("Upload Logo Here \n");
        gui_Button_1.setUIID("Label");
        gui_Button_1.setTextPosition(com.codename1.ui.Component.RIGHT);
        gui_Label_1.setUIID("GetStartedRedArrow");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Label_1, FontImage.MATERIAL_UPLOAD_FILE);

        CheckBox agree = new CheckBox();

        gui_Container_5.addComponent(agree);
        SpanLabel sp = new SpanLabel();
        sp.setText(" I declare on my word of honour that the information provided above is true and that I am aware that any incorrect statement may invalidate my application");
        gui_Container_5.addComponent(sp);
        sp.setUIID("Label");

        Button btn = new Button(" ");
        btn.setUIID("BunttonInvisiblepdf");
        agree.setOppositeSide(false);
        gui_Container_1.add(btn);
        gui_Container_1.add(gui_Container_5);
        Button btn2 = new Button(" ");
        btn2.setUIID("BunttonInvisiblepdf");
        gui_Container_1.add(btn2);
        gui_Container_1.add(gui_Button_2);
        gui_Button_2.setUIID("BunttonInvisiblepdf");

        agree.addPointerReleasedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!agree.isSelected()) {

                    gui_Button_2.setText("Submit");
                    gui_Button_2.setUIID("InboxNumber3");
                    revalidate();
                } else {
                    gui_Button_2.setText("");
                    gui_Button_2.setUIID("BunttonInvisiblepdf");
                    revalidate();
                }
            }
        });

        gui_Button_1.addPointerReleasedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                imgPath = Capture.capturePhoto();
                if (imgPath == null) {
                    fileEmpty.setText("No file was selected");
                    revalidate();
                } else {
                    fileEmpty.setText("  ");
                    System.out.println("hedha el path  " + imgPath);
                    String link = imgPath.toString();
                    int pod = link.indexOf("/", 2);
                    String img = link.substring(pod + 2, link.length());
                    System.out.println("img here " + img);
                    //FileUploader fu = new FileUploader("http://localhost/swr/web/");
                    try {
                       // fileUploaded = fu.upload(img);
                        EncodedImage placeHolder = null;
                        try {
                            placeHolder = EncodedImage.create("/load.png");
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        String ul = "http://localhost/swr/web/uploads/" + fileUploaded;
                        Image imgg = URLImage.createToStorage(placeHolder, ul, ul, URLImage.RESIZE_SCALE);

                        ScaleImageLabel sl = new ScaleImageLabel(imgg);
                        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FIT);
                        gui_imageContainer1.add(BorderLayout.CENTER, sl);
                        revalidate();
                    } catch (Exception ex) {
                    }

                }

            }
        });

        gui_Button_2.addPointerReleasedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                if (fileUploaded == null) {
                    fileEmpty.setText("Please select a logo");
                    revalidate();
                } else if (gui_Text_Field_2.getText().equals("Amount") || gui_Text_Field_2.getText().length() == 0) {
                    AmountError.setText("Please fill out the amount field");
                    revalidate();
                } else if (!checkAmount(gui_Text_Field_2.getText())) {
                    AmountError.setText("Please fill out the amount field with only numbers");
                    revalidate();
                } else if (ServiceEvent.getInstance().GetnbS(id) != 0 && amountInt > ServiceEvent.getInstance().GetStill(id)) {
                  
                        AmountError.setText("You're very generous but we cannot accept this much");
                        revalidate();
                   
                   
                } else if (ServiceEvent.getInstance().GetnbS(id) == 0 && amountInt > ServiceEvent.getInstance().GetBudget(id)) {
                   
                        AmountError.setText("You're very generous but we cannot accept this much");
                        revalidate();
                  
                }
                else {

                    Event e = new Event(id);
                    Sponsor s = new Sponsor(u, e, fileUploaded, amountInt);
                    ServiceEvent.getInstance().addSponsor(s);
                    new EventSingleSForm(id).show();

                    System.out.println("sponsoring now");
                }

            }
        });

    }

    public boolean checkAmount(String Amount) {
        if (Amount.length() == 0) {
            return false;
        }
        char[] chars = Amount.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        amountInt = Integer.parseInt(Amount);
        return true;
    }
}
