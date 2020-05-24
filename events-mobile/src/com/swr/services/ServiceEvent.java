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
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.swr.entities.Event;
import com.swr.entities.Sponsor;
import com.swr.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Eya
 */
public class ServiceEvent {

    public ArrayList<Event> events;
    public ArrayList<String> logos;
    public int par;
    public int par2;
    public int par3;
    public int par4;
    public String date;
    public String time;
    public int dateDiff;

    public static ServiceEvent instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceEvent() {
        req = new ConnectionRequest();
    }

    public static ServiceEvent getInstance() {
        if (instance == null) {
            instance = new ServiceEvent();
        }
        return instance;
    }

    public ArrayList<Event> parseTasks(String jsonText) {
        try {
            events = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
             */
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
             */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Event e = new Event();
                float id = Float.parseFloat(obj.get("idEvt").toString());
                e.setId_evt((int) id);
                e.setDetails(obj.get("detailsEvt").toString());
                e.setLocation(obj.get("locationEvt").toString());
                e.setOrganizator(obj.get("organizatorEvt").toString());
                e.setUrl_evt(obj.get("urlEvt").toString());
                e.setNbparticipant((int) Float.parseFloat(obj.get("nbparticipantEvt").toString()));
                e.setNbsponsor((int) Float.parseFloat(obj.get("nbsponsorEvt").toString()));
                e.setNbviews((int) Float.parseFloat(obj.get("nbviewsEvt").toString()));
                e.setState_evt((int) Float.parseFloat(obj.get("stateEvt").toString()));
                e.setStillneeded_evt((double) Float.parseFloat(obj.get("stillneededEvt").toString()));
                /* e.setDate_evt((Date) obj.get("dateEvt"));
                e.setTime_evt((TimeZone) obj.get("timeEvt"));*/
                e.setBudget((double) Float.parseFloat(obj.get("budgetEvt").toString()));
                e.setName(obj.get("nameEvt").toString());
                //Ajouter la tâche extraite de la réponse Json à la liste
                events.add(e);
            }

        } catch (IOException ex) {

        }
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        return events;
    }

    public ArrayList<String> parseLogos(String jsonText) {
        try {
            logos = new ArrayList<>();
            JSONParser j = new JSONParser();

            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {

                String e = new String();

                e = obj.get("logo").toString();

                logos.add(e);
            }

        } catch (IOException ex) {

        }

        return logos;
    }

    public ArrayList<Event> getAllEvents() {
        String url = Statics.BASE_URL + "/evt/mobileEvt/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return events;
    }

    public ArrayList<Event> getSingleEventP(int id) {
        String url = Statics.BASE_URL + "/evt/mobileEvt/singleP/" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return events;
    }

    public int AddP(int id, int idU) {

        String url = Statics.BASE_URL + "/evt/mobileEvt/addP/" + id + "/" + idU;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                par = Integer.parseInt(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return par;
    }

    public int CheckP(int id, int idU) {

        String url = Statics.BASE_URL + "/evt/mobileEvt/checkP/" + id + "/" + idU;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                par2 = Integer.parseInt(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return par2;
    }

    public int DeleteP(int id, int idU) {

        String url = Statics.BASE_URL + "/evt/mobileEvt/deleteP/" + id + "/" + idU;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                par3 = Integer.parseInt(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return par3;
    }

    public int GetnbP(int id) {

        String url = Statics.BASE_URL + "/evt/mobileEvt/getnbP/" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                par3 = Integer.parseInt(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return par3;
    }

    public ArrayList<String> getLogos(int id) {
        String url = Statics.BASE_URL + "/evt/mobileEvt/getLogoS/" + id;
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

    public String getDate(int id) {
        String url = Statics.BASE_URL + "/evt/mobileEvt/getDate/" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                date = new String(req.getResponseData());
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return date;
    }

    public String getTime(int id) {
        String url = Statics.BASE_URL + "/evt/mobileEvt/getTime/" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                time = new String(req.getResponseData());
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return time;
    }

    public int GetDateDiff(int id) {

        String url = Statics.BASE_URL + "/evt/mobileEvt/getDateDiff/" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                dateDiff = Integer.parseInt(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return dateDiff;
    }

    public ArrayList<Event> getAllEventsS() {
        String url = Statics.BASE_URL + "/evt/mobileEvt/allS";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return events;
    }

    public int GetRaised(int id) {

        String url = Statics.BASE_URL + "/evt/mobileEvt/raised/" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                par3 = Integer.parseInt(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return par3;
    }

    public int GetStill(int id) {

        String url = Statics.BASE_URL + "/evt/mobileEvt/still/" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                par3 = Integer.parseInt(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return par3;
    }

    public int GetnbS(int id) {

        String url = Statics.BASE_URL + "/evt/mobileEvt/nbs/" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                par2 = Integer.parseInt(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return par2;
    }

    public int GetBudget(int id) {

        String url = Statics.BASE_URL + "/evt/mobileEvt/budget/" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                par = Integer.parseInt(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return par;
    }

    public boolean addSponsor(Sponsor s) {
        String url = Statics.BASE_URL + "/evt/mobileEvt/sponsor/" + s.getE().getId_evt() + "/" + s.getU().getIdu() + "/" + s.getGiven() + "/" + s.getLogo();
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean updateState(int id) {
        String url = Statics.BASE_URL + "/evt/mobileEvt/update/" + id;
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
}
