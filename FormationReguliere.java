/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP;

/**
 *
 * @author mgrac
 */
public class FormationReguliere extends Local {
    private String session;
    Department dept;
    
    public FormationReguliere(int numero, int etage, int heureDebut, int heureFin, String session, Department dept){
        super(numero, etage, heureDebut, heureFin);
        this.session = session;
        this.dept = dept;
    }
    
    public FormationReguliere(int numero, int etage, String session, Department dept){
        super(numero, etage);
        this.session = session;
        this.dept = dept;
    }
    
    public String getSession() {
        return session;
    }
    public Department getDept(){
        return dept;
    }

    
        @Override
        public boolean reserver(int heureDebut, int heureFin) {
            Department dept = getDept();
            if ((heureDebut >= 8 && heureFin <=23) && dept.getNom().equals("Informatique")){
                reservation = true;
                return true;  
            }else if((heureDebut >= 8 && heureFin <= 18) || (dept.getNom().equals("Science Humaine") || dept.getNom().equals("Sciences Nature"))){
                reservation = true;
                return true;
            }else if( heureDebut == 12 && heureFin == 13){
                //System.out.println("Local doit libre ces heures!");
                return false;
            }else{
                return false;
            }
        }
    
    @Override
    public String toString(){
        String reserveStatus = reservation ? "Oui" : "Non";
        return super.toString() +"\nReserve: " + reserveStatus + " \nFormation reguliere: (session " + getSession() + ")\n"  + getDept();
    }
}
