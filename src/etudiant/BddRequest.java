/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etudiant;
import java.sql.*;
/*
 *
 * @author RAFINETTE
 */
public class BddRequest {
  
  
BddRequest () {}
    

public boolean etudiantExist (String login) 
{
    BddConnection b= new BddConnection();
    
        try {
        b.openConnection();
        } catch (java.sql.SQLException se)
        {
        se.getMessage();  
        }
   
        String query;
        query = "SELECT numetu FROM etudiants where numetu as login;";
        ResultSet results;
        
        try{
       
        Statement stmt = b.conn.createStatement();
        results = stmt.executeQuery(query);
        results.close();
        stmt.close();
        
        }catch(Exception ex)
        {
            System.out.println("exception du a la requete");
        }
        
        try {
        b.closeConnection();
        } catch (java.sql.SQLException se)
        {
        se.getMessage();  
        }
        
         return true;
       
     
    }

public boolean etudiantInEtudExist (int login) 
{
    //Etudiants e = new Etudiants(login);
    BddConnection b= new BddConnection();
    Etude et = new Etude ();
    
        try {
        b.openConnection();
        } catch (java.sql.SQLException se)
        {
        se.getMessage();  
        }
   
        String query;
        query = "SELECT numetu FROM etude where numetu = " + login;
        ResultSet results;
        
        try{
        Statement stmt;
        stmt = b.conn.createStatement();
        results = stmt.executeQuery(query);
        results.close();
        stmt.close();
        }catch(Exception ex)
        {
            System.out.println("exception du a la requete");
        }
        
        
        
        try {
        b.closeConnection();
        } catch (java.sql.SQLException se)
        {
        se.getMessage();  
        }
        
         return true;
       
     
    }

public boolean ConventionExist(int conv) 
{
    //Convention c = new Convention(conv);
    BddConnection b= new BddConnection();
    
        try {
        b.openConnection();
        } catch (java.sql.SQLException se)
        {
        se.getMessage();  
        }
   
        String query;
        
        query = "SELECT id_etude FROM etude where id_etude = " + conv;
        ResultSet results;
        
        try{
        java.sql.Statement stmt;
        stmt = b.conn.createStatement();
        results = stmt.executeQuery(query);
        results.close();
        stmt.close();
        }catch(Exception ex)
        {
            System.out.println("exception du a la requete");
        }
        
        try {
        b.closeConnection();
        } catch (java.sql.SQLException se)
        {
        se.getMessage();  
        }
        
         return true;
        
    }

public void acompteInsertion(){
    
}


public boolean acompteParEtudiant (int login, int idEtude)
{
    boolean retour = true;
    
    try {

        BddConnection b =new BddConnection();
        b.openConnection();


        String query;
        query = "SELECT count (*) AS rowcount FROM acompte where (numetu = " + login + " and  id_etude = " + idEtude + ")";

        /*
        rs = stm.executeQuery("SELECT count(*) AS nbLignes FROM contact ");
        int nbLignes=0;
        rs.next();
        nbLignes = rs.getInt("nbLignes");

        * ou

        Statement s = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery
        ("SELECT * FROM employee WHERE id_emp LIKE '1%'");
        r.last();
        int count = r.getRow();

        */    
        
       
        Statement stmt = b.conn.createStatement();
        ResultSet results = stmt.executeQuery(query);
        results.next();
        int count = results.getInt("rowcount") ;
        results.close() ;
        
        
        //results.next();
        
        //count = count + results.getRow(); 
       
        //********PROBLEME DE REQUETE*************
        

        results.close();
        stmt.close();
        b.closeConnection();
        
        

        if (count < 3)
            {
               retour = true;
            } else 
            {
               retour = false;
            }

   } catch(Exception ex)
        {
                System.out.println("exception du a la requete" + ex.getMessage());
        }  
  
return retour; 

}

public boolean pourcentageAcompteEtudiant (String login, int idEtude, double ddeAcompte)
{
    boolean retour=false;
    
    try {

        BddConnection b =new BddConnection();
        b.openConnection();


        String query;
        
        query = "SELECT montantacom FROM acompte where (numetu = " + login + " and  id_etude = " + idEtude + ")";
        double montantTotAcom = 0;
        Statement stmt = b.conn.createStatement();
        ResultSet results = stmt.executeQuery(query);
        while (results.next()){                
            montantTotAcom += results.getDouble(1);      
        }
        results.close();
        stmt.close();
        
        query = "SELECT dureeetude, prixJour FROM etude where (numetu = " + login + " and  idetude = " + idEtude + ")";
        double salaire;
        stmt = b.conn.createStatement();
        results = stmt.executeQuery(query);
        results.last();
        int duree = results.getInt("dureeetude");
        double tarif = results.getDouble("prixjour");
        salaire = duree * tarif;
        results.close();
        stmt.close();
           
        b.closeConnection();
        
        if(((montantTotAcom + ddeAcompte)/salaire) <= 0.8){
            retour = true;
        }


        

    } catch(Exception ex)
        {
                System.out.println("exception du a la requete" + ex.getMessage());
        }  
    
    return retour;
}


}
