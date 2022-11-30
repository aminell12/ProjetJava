package paquet;
import java.util.*;

import consoCarbone.*;


public class Utilisateur {
    private Alimentation alimentation;
    private BienConso bienConso;
    private Collection<Logement> logements;
    private Collection<Transport> transports;
    private ServicesPublics services;

    public Utilisateur (Alimentation alimentation,BienConso bienConso, Collection<Logement> logements , Collection <Transport> transports, ServicesPublics services){
        this.alimentation = alimentation;
        this.bienConso = bienConso;
        this.logements = logements;
        this.transports = transports;
        this.services = services;
    }

    //FAIRE GETTER ET SETTER DES ATTRIBUTS DE LA CLASSE
    //faire setter avec les attributs de chaque chaque classes? 
   

    public Alimentation getAlimentation() {
		return alimentation;
	}

	public BienConso getBienConso() {
		return bienConso;
	}

	public Collection<Logement> getLogement() {
		return logements;
	}

	public Collection<Transport> getTransport() {
		return transports;
	}

	public ServicesPublics getServices() {
		return services;
	}

	public void setAlimentation(Alimentation alimentation) {
		this.alimentation = alimentation;
	}

	public void setBienConso(BienConso bienConso) {
		this.bienConso = bienConso;
	}

	public void setLogement(Collection<Logement> logements) {
		this.logements = logements;
	}

	public void setTransport(Collection<Transport> transports) {
		this.transports = transports;
	}

	public void setServices(ServicesPublics services) {
		this.services = services;
	}

	
    public double calculerEmpreinte(){ // Calucle l'empreinte carbone totale d'un indiviu 
    	double impact=alimentation.getImpact()+ bienConso.getImpact()+services.getEmpCarbFR();
    	for (Logement log : logements) {
    		impact+=log.getImpact();
    	}
    	for (Transport tr :  transports) {
    		impact+=tr.getImpact();
    	}
    	
        return impact;
    };
    
	public void detaillerEmpreinte(){ //Détaille l'empreinte carbone d'un individu
		double impactLog = 0,impactTr=0;
    	for (Logement log : logements) {
    		impactLog+=log.getImpact();
    	}
    	for (Transport tr :  transports) {
    		impactTr+=tr.getImpact();
    	}
		System.out.println("Alimentation : " + alimentation.getImpact() +"TCO2eq\nBiens consommés : " + bienConso.getImpact()+"TCO2eq\nLogement : " + impactLog + "TCO2eq\nTransport : " + impactTr + "TCO2eq\nServices Publics : " + services.getEmpCarbFR() + "TCO2eq.");
    };
    
    
    
    
}
