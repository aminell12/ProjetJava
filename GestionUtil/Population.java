package GestionUtil;
import java.util.*;
import consoCarbone.*;

public final class Population extends Utilisateur {

    private Collection <Utilisateur> population;

    

    //Impact de la population
    private double impactPop;
    private double impactBienconsoPop;
    private double impactLogementPop;
    private double impactTransportPop;
    private double impactAlimentationPop;

    //Impact moyen de la population
    private double impactMoyPop;
    private double impactLogementMoy;
    private double impactBienconsoMoy;
    private double impactTransportMoy;
    private double impactAlimentationMoy;

    public Population(Collection <Utilisateur> population) {
        super(alimentation, bienConso, logements, transports, services,nom, prenom);
        this.population = population;
        for (Utilisateur ut : population){
            impactPop += ut.getImpactUt();
            impactBienconsoPop += Utilisateur.bienConso.getImpact();
            impactAlimentationPop += Utilisateur.alimentation.getImpact();
            for (Logement log : Utilisateur.logements){
                impactLogementPop += log.getImpact();
            
            }
            for (Transport tr : Utilisateur.transports){
                impactLogementPop += tr.getImpact();
            }
        }
        impactMoyPop = impactPop/population.size();
        impactLogementMoy = impactLogementPop/population.size();
        impactBienconsoMoy = impactBienconsoPop/population.size();
        impactTransportMoy = impactTransportPop/population.size();
        impactAlimentationMoy = impactAlimentationPop/population.size();

    }

    //---Getters et Setters--- 

    public Collection <Utilisateur> getpopulation(){
        return population;
    }

    public void setpopulation(Collection <Utilisateur> population) {
		this.population = population;
	}

    public double getImpactLogementPop(){
        return impactLogementPop;
    }

    public double getImpactAlimentationPop(){
        return impactAlimentationPop;
    }

    public double getImpactTransportPop(){
        return impactTransportPop;
    }

    public double getImpactBienconsoPop(){
        return impactBienconsoPop;
    }

    public double getImpactMoy(){
        return impactMoyPop;
    }

    public double getImpactLogementMoy(){
        return impactLogementMoy;
    }

    public double getImpactAlimentationMoy(){
        return impactAlimentationMoy;
    }

    public double getImpactTransportMoy(){
        return impactTransportMoy;
    }

    public double getImpactBienconsoMoy(){
        return impactBienconsoMoy;
    }

	//---Fin Getters et Setters---


    //Methode qui va permettre de detailler, calucler et conseiller sur l'empreinte carbone de chaque individu de la poupulation
    public void DetaillePopulation(){
        for (Utilisateur ut : population){
            System.out.println("\n\n----------------Fiche récapitulative de " + ut.getNom() +" "+ ut.getPrenom() + ":----------------\n" );
            ut.detaillerEmpreinte();
            System.out.println("\n\n");
            ut.conseille();
        }
        System.out.println("\n\nL'Empreinte Carbone totale de la population est de " + impactPop +" TCO2eq.\nLa moyenne de la population cette année  est de " +impactMoyPop);
    }

    public void DecisionMairie(){
        System.out.println("\n\n----------------Rapport du Maire:----------------\n" );
        if ((impactTransportMoy>ITransport)) {
            System.out.println("Au vu des derniers relevés sur l'Empreinte Carbone de la population, une nouvelle taxe concernant les propriétaires de voiture sera mise en place afin de compenser l'augmentation de l'EC.\n L'utilsation des transports est fortement recommendée, nous mettrons en place de nouveaux projets afin de palier cette augmentation.");
        }
        if ((impactLogementMoy>ILogement)) {
            System.out.println("Au vu des derniers relevés sur l'Empreinte Carbone de la population, une nouvelle taxe habitation sera mise en place afin de compenser l'augmentation de l'EC.\n L'utilsation d'appreil avec un faible niveau de consommation est fortement recommendée dans les logement.");
        }
        if ((impactBienconsoMoy>IBienconso)) {
            System.out.println("Au vu des derniers relevés sur l'Empreinte Carbone de la population, nous recommondons fortement aux habitants d'éviter la surconsommation, d'éviter les achats inutiles et de priviligier le reconditionnement, la seconde main...");
        }
        if (impactAlimentationMoy>IAlimentation) {
            System.out.println("Au vu des derniers relevés sur l'Empreinte Carbone de la population, favoriser la consommation de plats végétariens...");
        }  
    }
}
