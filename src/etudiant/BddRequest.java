
package etudiant;
import java.sql.*;
/*
 *
 * Autheurs Rafaèle BONDAZ Mathieu PETINOT
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
        query = "SELECT numetu FROM etudiants where numetu = " + login;
        ResultSet results;
        
        try{
       
            Statement stmt = b.conn.createStatement();
            results = stmt.executeQuery(query);
            results.next();
            int numEtu = results.getInt("numetu");
            results.close();
            stmt.close();
            b.closeConnection();
            if (numEtu > 0)
            {
               return true;
            } else 
            {
               return false;
            }
          
            
        }catch(Exception ex)
        {
            System.out.println("exception du a la requete dans etudiantExist");
            return false;
        }
        
       
           
        
        
         
       
     
    }

public boolean etudiantInEtudExist (int login, int idEtude) 
{
    BddConnection b= new BddConnection();
    
        try {
            b.openConnection();
        } catch (java.sql.SQLException se)
        {
            se.getMessage();  
        }
   
        
        
        try{
            String query;
            query = "SELECT dureeetude FROM etude where (numetu = " + login + " and  id_etude = " + idEtude + ")";
            ResultSet results;
            Statement stmt;
            stmt = b.conn.createStatement();
            results = stmt.executeQuery(query);
            results.next();
            int duree = results.getInt("dureeetude");
            results.close();
            stmt.close();
            b.closeConnection();
            
            if (duree > 0)
            {
               return true;
            } else 
            {
               return false;
            }
            
            
        }catch(Exception ex)
        {
            System.out.println("exception du a la requete dans etudiantInEtudExist");
            return false;
        }
                       
         
       
     
    }

public boolean conventionExist(int conv) 
{
    BddConnection b= new BddConnection();
    
        try {
            b.openConnection();
        } catch (java.sql.SQLException se)
        {
            se.getMessage();  
        }
   
        
        
        try{
            String query;
            query = "SELECT id_etude FROM etude where id_etude = " + conv;
            ResultSet results;
            java.sql.Statement stmt;
            stmt = b.conn.createStatement();
            results = stmt.executeQuery(query);
            results.next();
            int idEtude = results.getInt("id_etude");
            results.close();
            stmt.close();
            b.closeConnection();
            if (idEtude > 0)
            {
               return true;
            } else 
            {
               return false;
            }
            
        }catch(Exception ex)
        {
            System.out.println("exception du a la requete dans conventionExist");
            return false;
        }
        
         
        
    }

public void acompteInsertion(int login, int idEtude , double ddeacompte){

    BddConnection b= new BddConnection();
    
    try {
        b.openConnection();
    } catch (java.sql.SQLException se){
        se.getMessage();  
    }
    
    try{
        String query;
        // il faut récupérer le dernier numéro d 'acompte dans la Bdd
        //query = "SELECT IDENT_CURRENT(‘ACOMPTE’)";
        query = "SELECT MAX(NUMACOM) FROM ACOMPTE"; 
        Statement stmt = b.conn.createStatement();
        ResultSet results = stmt.executeQuery(query);
        results.next();
        int numac = results.getInt(1);
        numac++;
        results.close();
        stmt.close();
    
        query = "insert into acompte values ("+ numac + ", " + idEtude + ", " + login + ", " + ddeacompte + ", 'en attente' )";

        stmt = b.conn.createStatement();
        results = stmt.executeQuery(query);
        results.close();
        stmt.close();
        b.closeConnection();
    
    }catch(Exception ex){
        System.out.println("exception du a la requete dans acompteInsertion" + ex.getMessage());
    }
}


public boolean acompteParEtudiant (int login, int idEtude)
{ 
    try {
        boolean retour = true;
        BddConnection b =new BddConnection();
        b.openConnection();


        String query;
        query = "SELECT count (*) AS rowcount FROM acompte where (numetu = " + login + " and  id_etude = " + idEtude + ")";

       
        Statement stmt = b.conn.createStatement();
        ResultSet results = stmt.executeQuery(query);
        results.next();
        int count = results.getInt("rowcount") ;
        results.close() ;
        
        results.close();
        stmt.close();
        b.closeConnection();
        
        System.out.println("count vaut:" + count);

        if (count < 3)
            {
               retour = true;
            } else 
            {
               retour = false;
            }

        return retour; 
   } catch(Exception ex)
        {
                System.out.println("exception du a la requete dans acompteParEtudiant" + ex.getMessage());
        }  

return false;

}

public boolean pourcentageAcompteEtudiant (int login, int idEtude, double ddeAcompte)
{
    boolean retour=false;
    
    try {

        BddConnection b = new BddConnection();
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
        
        query = "SELECT dureeetude, prixJour FROM etude where (numetu = " + login + " and  id_etude = " + idEtude + ")";
        double salaire;
        stmt = b.conn.createStatement();
        results = stmt.executeQuery(query);
        results.next();
        int duree = results.getInt("dureeetude");
        double tarif = results.getDouble("prixjour");
        salaire = duree * tarif;
        results.close();
        stmt.close();
           
        b.closeConnection();
        Double pourcentage = (montantTotAcom + ddeAcompte)/salaire;
        System.out.println("pourcentage vaut:" + pourcentage);
        
        if(pourcentage <= 0.8){
            retour = true;
        }


        

    } catch(Exception ex)
        {
                System.out.println("exception du a la requete dans pourcentageAcompteEtudiant" + ex.getMessage());
        }  
    
    return retour;
}


}
