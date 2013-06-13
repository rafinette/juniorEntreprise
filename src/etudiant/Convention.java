
package etudiant;

/**
 *
 * Autheurs Rafaèle BONDAZ Mathieu PETINOT
 */
public class Convention {
    
   String numConv;
   String dateConv;
   
   Convention () {}
   
   Convention (String n , String d) {
    n = this.numConv;
    d = this.dateConv;
   }
   
   Convention (String n) {
    n = this.numConv;
   }

    public String getNumConv() {
        return numConv;
    }

    public String getDateConv() {
        return dateConv;
    }

    public void setNumConv(String numConv) {
        this.numConv = numConv;
    }

    public void setDateConv(String dateConv) {
        this.dateConv = dateConv;
    }

    @Override
    public String toString() {
        return "Convention{" + "numConv=" + numConv + ", dateConv=" + dateConv + '}';
    }
   
    
   
   
    
}
