package paquet;
import java.util.*;
//import org.javatuples.*;

import consoCarbone.*;


public class Utilisateur {
    private Alimentation alimentation;
    private BienConso bienConso;
    private Collection<Logement> logements;
    private Collection<Transport> transports;
    private ServicesPublics services;

    public Utilisateur (Alimentation alimentation,BienConso bienConso, Collection<Logement> logements , Collection <Transport> transports, ServicesPublics services){//Constructeur de la classe Utilisateur
        this.alimentation = alimentation;
        this.bienConso = bienConso;
        this.logements = logements;
        this.transports = transports;
        this.services = services;
    }

    

   //---Getters et Setters--- 

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

	//---Fin Getters et Setters---

	
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
    
    public void conseille() {
    	SortedMap<Double,String> conso= new TreeMap<Double,String>();
    	conso.put(alimentation.getImpact(),"alimentation");
    	conso.put(bienConso.getImpact(),"bienconso");
    	conso.put(services.getEmpCarbFR(),"Service");
    	double impactLog = 0,impactTr=0;
    	for (Logement log : logements) {
    		impactLog+=log.getImpact();
    	}
    	for (Transport tr :  transports) {
    		impactTr+=tr.getImpact();
    	}
    	conso.put(impactLog,"logement");
    	conso.put(impactTr,"transport");
    	Double max= conso.lastKey();
    	System.out.println("La classe avec l'impact le plus elevé est "+conso.get(max));
        
    	Set<Double> keys = conso.keySet();
        for (Double key : keys) {
        	System.out.println("\nVotre consommation au poste "+conso.get(key)+" est de "+key+" tCO2eq.");
        	
        	if ((conso.get(key) == "transport")&&(key>=1.972)) {
        		System.out.println("C'est supérieur à la moyenne française.\nPriviligiez l'utilisation de transports en communs ou non polluants (velo,trotinette éléctrique,etc...).");
        	}
        	if ((conso.get(key) == "logement")&&(key>=2.706)) {
        		System.out.println("C'est supérieur à la moyenne française.\nLimitez la consommation d'énergie et prenez soin d'éteindre vos appareils éléctroménagers s'ils ne sont pas utilisés.");
        	}
        	if ((conso.get(key) == "bienconso")&&(key>=2.625)) {
        		System.out.println("C'est supérieur à la moyenne française.\nPriviligiez l'achat de vêtements en seconde main et le reconditionnement des appreils éléctroniques.");
        	}
        	if ((conso.get(key) == "alimentation")&&(key>=2.353)) {
        		System.out.println("C'est supérieur à la moyenne française.\nFavorisez la consommation d'aliments végétariens.");
        	}
        	//L'impact des services publics est commun à tous les francais, on ne peut donc pas donner de conseils sur cette classe.
        	
        }
    }
    
    
    
    
}
