/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swr.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.swr.entities.Compaign;
import com.swr.entities.Donation;
import com.swr.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceCompaign {

    public ArrayList<Compaign> cmps;
    public ArrayList<Donation> dons;
    public ArrayList<String> logos;
    public static ServiceCompaign instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    public Integer don;
    private ServiceCompaign() {
         req = new ConnectionRequest();
    }

    public static ServiceCompaign getInstance() {
        if (instance == null) {
            instance = new ServiceCompaign();
        }
        return instance;
    }



    public ArrayList<Compaign> parseTasks(String jsonText){
        try {
          cmps=new ArrayList<>();
            JSONParser j = new JSONParser();
          
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
             
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                 Compaign c = new Compaign();
                  float nb = Float.parseFloat(obj.get("nbdon").toString());
                float id = Float.parseFloat(obj.get("idCmp").toString());
             c.setId_cmp((int)id);
             c.setNbdon((int)nb);
             c.setRaised(((double)Double.parseDouble(obj.get("raised").toString())));
             c.setTrgt(((double)Double.parseDouble(obj.get("target").toString())));
             c.setStillneeded(((double)Double.parseDouble(obj.get("stillneeded").toString())));
             c.setNamecmp(obj.get("nameCmp").toString());
             c.setDesc(obj.get("descrip").toString());
             c.setUrl(obj.get("urlimg").toString());
                //Ajouter la tâche extraite de la réponse Json à la liste
                cmps.add(c);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return cmps;
    }
    
    public ArrayList<Compaign> getAllCompaign(){
        String url = Statics.BASE_URL+"/cmp/Mobilecmp/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cmps = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return cmps;
    }
     public ArrayList<Compaign> getSignleCompaign(int id){
         
        String url = Statics.BASE_URL+"/cmp/MobilecmpLearn_More/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cmps = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return cmps;
    }
     
      public void Donate(int id,int idu,int given,int a,int f,int m,String ms){
         
        String url = Statics.BASE_URL+"/cmp/MobileDonate_More/"+id+"/"+idu+"/"+given+"/"+a+"/"+f+"/"+m+"/"+ms;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                don=Integer.parseInt(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    }
       public ArrayList<String> parseLogos(String jsonText) {
        try {
            logos = new ArrayList<>();
            JSONParser j = new JSONParser();

            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {

                String e = new String();

                e = obj.get("detail").toString();

                logos.add(e);
            }

        } catch (IOException ex) {

        }

        return logos;
    }
    public ArrayList<String> getProps(int id){
         
        String url = Statics.BASE_URL+"/cmp/MobilePropcmp/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                logos = parseLogos(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return logos;
    } 
    
    
    
    
    public ArrayList<Donation> parseDons(String jsonText) {
        try {
            dons = new ArrayList<>();
            JSONParser j = new JSONParser();

            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {

                 float id = Float.parseFloat(obj.get("annonym").toString());
                 Donation d=new Donation();
                d.setMes(obj.get("message").toString());
                d.setNom((obj.get("username").toString()));
                d.setPrenom((obj.get("image").toString()));
                d.setGiven((((double)Double.parseDouble(obj.get("given").toString()))));
                d.setAnnonym((int)id);
                dons.add(d);
            }

        } catch (IOException ex) {

        }

        return dons;
    }
        public ArrayList<Donation> getDons(int id){
         
        String url = Statics.BASE_URL+"/cmp/MobilRecent/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                dons = parseDons(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return dons;
    } 
}
