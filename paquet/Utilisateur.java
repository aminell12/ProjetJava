package consoCarbone.paquet;
import consoCarbone.*;


public class Utilisateur {
    private Alimentation alimentation;
    private BienConso bienConso;
    private Logement logement;
    private Transport transport;
    private ServicesPublics services;

    public Utilisateur (Alimentation alimentation,BienConso bienConso, Logement logement , Transport transport, ServicesPublics services){
        this.alimentation = alimentation;
        this.bienConso = bienConso;
        this.logement = logement;
        this.transport = transport;
        this.services = services;
    }

    //FAIRE GETTER ET SETTER DES ATTRIBUTS DE LA CLASSE

    public double calculerEmpreinte(){ // Calucle l'empreinte carbone totale d'un indiviu 
        return alimentation.getImpact()+ bienConso.getImpact() + logement.getImpact()+transport.getImpact()+services.getEmpCarbFR();
    };


    public void detaillerEmpreinte(){ //Détaille l'empreinte carbone d'un individu
        System.out.println("Alimentation : " + alimentation.getImpact() +"\nBiens consommés : " + bienConso.getImpact()+"\nLogement : " + logement.getImpact()+"\nTransport : " + transport.getImpact()+"\nServices Publics : " + services.getEmpCarbFR());
    };



    
}
