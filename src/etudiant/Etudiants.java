package etudiant;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p0100081
 */
public class Etudiants {
    
    
    String num_etu;
    String password;
    String nom_etu;
    String prenom_etu;
    String adresse_etu;
    String num_secu;
    String date_naiss;

    public Etudiants(String login, String password) {
        this.num_etu = login;
        this.password = password;
    }
    public Etudiants (String login)
    {
      this.num_etu = login;
    }
    
    

    public String getLogin() {
        return num_etu;
    }

    public String getPassword() {
        return password;
    }
    
    public void setLogin(String login) {
        this.num_etu = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Etudiants{" + "num_etu=" + num_etu + ", password=" + password + ", nom_etu=" + nom_etu + ", prenom_etu=" + prenom_etu + ", adresse_etu=" + adresse_etu + ", num_secu=" + num_secu + ", date_naiss=" + date_naiss + '}';
    }
    
    
}
