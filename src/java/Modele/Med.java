/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author sio
 */
public class Med implements Comparable <Med>{

    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String spe;
    private String id;
    private String dep;

    public Med(String nom, String prenom, String adresse, String tel, String spe, String id, String dep) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.spe = spe;
        this.id = id;
        this.dep=dep;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getSpe() {
        return this.spe;
    }

    public String getTel() {
        return this.tel;
    }
    public String getDep() {
        return this.dep;
    }

    @Override
    
    public int compareTo(Med m) {
      if(nom.compareTo(m.nom)==0) {
          if(prenom.compareTo(m.prenom)==0){
           return id.compareTo (m.id);
          }
          else{
            return prenom.compareTo(m.prenom); 
          }
      } 
      else{
         return nom.compareTo(m.nom);
      }
      
    }


}
