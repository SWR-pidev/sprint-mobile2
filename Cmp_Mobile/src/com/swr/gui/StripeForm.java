/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swr.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.Switch;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.TextSelection;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import com.swr.entities.Compaign;
import com.swr.services.ServiceCompaign;
import java.io.IOException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author Monta
 */
public class StripeForm extends BaseForm {

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
    private com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
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
    public int idu;
    public Double still;
    int given;
    int a;
    int f;
    int m;
    int expm = 0;
    int expy = 0;
    TextField cn = new TextField(null, "Card Number", 16, TextArea.NUMERIC);
    TextField ex = new TextField(null, "Expiraion Month", 2, TextArea.NUMERIC);
    TextField ey = new TextField(null, "Expiraion Year", 4, TextArea.NUMERIC);
    TextField cvc = new TextField(null, "Enter Cvc", 3, TextArea.NUMERIC);
    SpanLabel sp1 = new SpanLabel("","SmallThinLabel");
    SpanLabel sp2 = new SpanLabel("","SmallThinLabel");
    SpanLabel sp3 = new SpanLabel("","SmallThinLabel");
    SpanLabel sp4 = new SpanLabel("","SmallThinLabel");

    public StripeForm(int ids, int idu, int given) {
        this(com.codename1.ui.util.Resources.getGlobalResources(), ids, idu, given);
        int id;

    }

    public StripeForm(com.codename1.ui.util.Resources resourceObjectInstance, int ids, int idus, int given) {
        this.id = ids;
        this.idu = idu;

        this.given = given;
        initGuiBuilderComponents(resourceObjectInstance);
        Style st = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK_IOS, st);
        getToolbar().addCommandToLeftBar("", icon, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new CompaignAllForm(com.codename1.ui.util.Resources.getGlobalResources()).showBack();
            }

        });
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {
        });

    }

    @Override
    protected boolean isCurrentCmps() {
        return true;
    }

    public boolean checkExpYear(String exy) {
        if (exy.length() != 4) {
            return false;
        }
        char[] chars = exy.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        expy = Integer.parseInt(exy);
        return true;
    }

    public boolean checkExpMonth(String exm) {
        if (exm.length() != 2) {
            return false;
        }
        char[] chars = exm.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        expm = Integer.parseInt(exm);
        return true;
    }

    public boolean checkCvc(String cvcc) {
        if (cvcc.length() != 3) {
            return false;
        }
        char[] chars = cvcc.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean StripePayment(String cn, String em, String ey, String cvc, int d) throws StripeException, IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //add stripe key
        Stripe.apiKey = "sk_test_Y0jQ7oWwtJt7b1c1xHJaN4Kg00OReUT5ee";

        //change customer id
        Customer newCustomer = Customer.retrieve("cus_GmTdcLIX8mMjCZ");
        //ExternalAccountCollection allCardDetails = newCustomer.getSources();

        Map< String, Object> cardParam = new HashMap< String, Object>();
        cardParam.put("number", cn);
        cardParam.put("exp_month", em);
        cardParam.put("exp_year", ey);
        cardParam.put("cvc", cvc);

        Map< String, Object> tokenParam = new HashMap< String, Object>();
        tokenParam.put("card", cardParam);

        Token token = Token.create(tokenParam);
        Boolean cardIsNotExist = true;

        Map< String, Object> source = new HashMap< String, Object>();
        source.put("source", token.getId());

        newCustomer.getSources().create(source);
        System.out.println("card created");

        System.out.println(gson.toJson(newCustomer));

        Map<String, Object> params = new HashMap<>();
        params.put("amount", d * 100);
        params.put("currency", "usd");
        params.put("customer", "cus_GmTdcLIX8mMjCZ");

        Charge charge = Charge.create(params);
        System.out.println(charge);

        return true;
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Final Step");
        addComponent(gui_Container_1);
        Container c1 = new Container(BoxLayout.yCenter());
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, c1);

        Label amount = new Label(" Pay With Stripe ");
        amount.setUIID("SLabel");
        c1.add(amount);
        // addComponent(sp);
        /*   gui_Label_6.setIcon(resourceObjectInstance.getImage("business (1).png"));
          gui_Label_6.setUIID("DLabel");
       c1.addComponent(gui_Label_6);
       Slider s=new Slider();
       s.setMaxValue(still.intValue());
       s.setMinValue(0);

        s.setProgress(5); // el init value 
        s.setIncrements(1);
        s.setEditable(true);

 s.addDataChangedListener(new DataChangedListener() {

                     @Override
                     public void dataChanged(int type, int index) {
                      amount.setText(s.getProgress()+" $"); //badalna fel label
                     }
                 });

         */

        Container ct = new Container(BoxLayout.yCenter());
        ct.add(cn).add(sp1).add(ex).add(sp2).add(ey).add(sp3).add(cvc).add(sp4);
        add(ct);
        Container ctsw = new Container(BoxLayout.x());
        Container ctsw1 = new Container(BoxLayout.x());
        Container ctsw2 = new Container(BoxLayout.x());
        Switch sw = new Switch(); //thoto fi container wahdo 
        Switch sw1 = new Switch();
        Switch sw2 = new Switch();
        ctsw.add(new Label("Annomymous       ")).add(sw);
        add(ctsw);

        sw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                if (sw.isOn()) // theni value
                {
                    a = 1;
                } else {
                    a = 0;
                }
            }
        });

        ctsw1.add(new Label("Monthly Reminder  ")).add(sw1);
        sw1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                if (sw1.isOn()) // theni value
                {
                    m = 1;
                } else {
                    m = 0;
                }
            }
        });
        add(ctsw1);
        ctsw2.add(new Label("Fund Us          ")).add(sw2);
        sw1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                if (sw1.isOn()) // theni value
                {
                    f = 1;
                } else {
                    f = 0;
                }
            }
        });
        add(ctsw2);
        com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
        gui_Text_Area_2.setGrowByContent(true);
        gui_Text_Area_2.setEditable(true);
        gui_Text_Area_2.setText("You Can Leave a Message Here  ...");
        gui_Text_Area_2.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_2.setName("Text_Area_2");
        addComponent(gui_Text_Area_2);
        Button btn = new Button("Donate Now");
        btn.setUIID("InboxNumber4");

        btn.addActionListener((ActionListener) (ActionEvent evt) -> {
            String ch = gui_Text_Area_2.getText();

            if (ch.equals("You Can Leave a Message Here  ...") || ch.length() == 0) {
                ch = "Donated from our mobile app ";
            }
            if (!checkCardNumber(cn.getText())) {
                sp1.setText("Please fill out the Card number field with only numbers");

                revalidate();
            } else if (!checkExpMonth(ex.getText())) {
                sp2.setText("Please fill out the exp Month field");
                sp1.setText(" ");
                revalidate();
            } else if (expm > 12 || expm == 00) {
                sp2.setText("please fill out a valid month");
                sp1.setText(" ");
                revalidate();
            } else if (!checkExpYear(ey.getText())) {
                sp3.setText("Please fill out the exp Year field");
                sp1.setText(" ");
                sp2.setText(" ");
                revalidate();
            } else if (expy < 2021 || expy > 2050) {
                sp3.setText("please fill out a valid year");
                sp1.setText(" ");
                sp2.setText(" ");
                revalidate();
            } else if (!checkCvc(cvc.getText())) {
                sp4.setText("Please fill out the CVC field");
                sp1.setText(" ");
                sp2.setText(" ");
                sp3.setText(" ");
                revalidate();
            } else {
                try {
                    //   ServiceCompaign.getInstance().Donate(id, idu, given, id, id, id);
                    // apple Stripe honi

                    boolean StripePayment = StripePayment(cn.getText(), ex.getText(), ey.getText(), cvc.getText(), given);
                } catch (StripeException ex) {

                } catch (IOException ex) {
                }
                // id user
                ServiceCompaign.getInstance().Donate(id, 123, given, a, f, m, ch);
                new ConfirmeForm(resourceObjectInstance, 123).show();
            }

        });

        add(btn);

        //gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, btn);
    }

    public boolean checkCardNumber(String cardn) {
        /* if(cardn.isEmpty() || cardn.length()!=16 || !cardn.matches(".*[^0-9].*"))
        {
            
                return false;
        }*/
        if (cardn.length() != 16) {
            return false;
        }
        char[] chars = cardn.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
