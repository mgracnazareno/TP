
package TP;

/**
 *
 * @author mgrac
 */
public class Department {
    private String nom;
    
    public Department(){};
    public Department(String nom){
        this.nom = nom;
    }
    
    public String getNom() {
        return nom;
    }

    @Override
    public String toString(){
        return "Department " + getNom();
    }
   
    
}
