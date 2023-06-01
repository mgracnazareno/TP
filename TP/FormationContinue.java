/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP;

/**
 *
 * @author mgrac
 */
public class FormationContinue extends Local {
    private int etape;
    
    public FormationContinue(int numero, int etage, int debut, int fin,  int etape){
        super(numero, etage, debut, fin);
        this.etape = etape;
    }
    
    public FormationContinue(int numero, int etage, int etape){
        super(numero, etage);
        this.etape = etape;
    }

    public int getEtape() {
        return etape;
    }
    
    public void setEtape(int etape) {
        this.etape = etape;
    }
    
    @Override
    public String toString(){
        String reserveStatus = reservation ? "Oui" : "Non";
        return super.toString() +"\nReserve: " + reserveStatus +"\nFormation Continue (etape " + getEtape() + ")";
    }

     @Override
    public boolean reserver(int heureD, int heureF) {
        if (heureD >= 18 && heureF <= 23) {
            this.reservation = true;
            return true;
        } else {
            this.reservation = false;    
            return false; 
        } 
   
    }
    
   
}
