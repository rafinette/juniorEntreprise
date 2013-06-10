/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etudiant;

/**
 *
 * @author x9004882
 */
public class Etude {
  
    String nom_etude;
    int duree_etude;
    String fin_prevue;
    Double prix_jour;

    public String getNom_etude() {
        return nom_etude;
    }

    public int getDuree_etude() {
        return duree_etude;
    }

    public String getFin_prevue() {
        return fin_prevue;
    }

    public Double getPrix_jour() {
        return prix_jour;
    }

    public void setNom_etude(String nom_etude) {
        this.nom_etude = nom_etude;
    }

    public void setDuree_etude(int duree_etude) {
        this.duree_etude = duree_etude;
    }

    public void setFin_prevue(String fin_prevue) {
        this.fin_prevue = fin_prevue;
    }

    public void setPrix_jour(Double prix_jour) {
        this.prix_jour = prix_jour;
    }

   public void calc_charge_travail() {
       
   }

  
}
