
package etudiant;
/**
 *
 * Autheurs Rafaèle BONDAZ Mathieu PETINOT
 * 
 * 
 */
public class BddConnection {

java.sql.Connection conn;

public BddConnection(){
    
}
    
public void openConnection() throws java.sql.SQLException {
        
        String userid = "p0100081";   
        String password = "iut2012";  
        String URL = "jdbc:oracle:thin:@iuta.univ-lyon1.fr:1521:orcl";	
        java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        conn = java.sql.DriverManager.getConnection(URL, userid, password);

        if (conn == null) {
            System.out.println("Probleme de connection.");
            System.exit(1);
        }
    }

public void closeConnection() throws java.sql.SQLException {
        conn.close();// Fermeture de la connection
    }


}