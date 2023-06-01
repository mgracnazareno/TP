/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP;

/**
 *
 * @author mgrac
 */
public abstract class Local {

    private int numero;
    private int etage;
    private int heureDebut;
    private int heureFin;
    protected boolean reservation;
   
    
    
    public Local(int numero, int etage, int heureDebut, int heureFin){
        this.numero = numero;
        this.etage = etage;
        this.heureDebut =heureDebut;
        this.heureFin=heureFin;
        
    }
    
    public Local(int numero, int etage){
        this.numero = numero;
        this.etage = etage;
    }
    public int getNumero(){
        return numero;
    }
    public int getEtage() {
        return etage;
    }
    public int getHeureDebut() {
        return heureDebut;
    }

    public int getHeureFin() {
        return heureFin;
    }
   
    public boolean getReservation() {
        return reservation;
    }
  
    @Override
    public String toString(){
        return "Local : " + getEtage() + "-"  + numero;
    }   
    
    public abstract boolean reserver(int heureD, int heureF);    
}
