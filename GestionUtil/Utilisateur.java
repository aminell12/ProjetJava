package GestionUtil;
import java.io.*;
import java.nio.Buffer;
import java.util.*;
import consoCarbone.*;


public class Utilisateur {
	//Constante moyenne de l'impact eneretique français
	public static final double ITransport =  1.972;
	public static final double IBienconso = 2.625;
	public static final double ILogement = 2.706 ;
	public static final double IAlimentation = 2.353;


	//Changement des types des attributs car la classe utilisateur a une classe fille population
    protected static Alimentation alimentation; 
    protected static BienConso bienConso;
    protected static Collection<Logement> logements;
    protected static Collection<Transport> transports;
    protected static ServicesPublics services;

	private double impactUt; //Impact total d'un individu

	//Identité de l'individu
	protected static String nom;
	protected static String prenom;


	//Constructeur de la classe 
    public Utilisateur (Alimentation alimentation,BienConso bienConso, Collection<Logement> logements , Collection <Transport> transports, ServicesPublics services, String nom, String prenom){//Constructeur de la classe Utilisateur
		Utilisateur.alimentation = alimentation;
        Utilisateur.bienConso = bienConso;
        Utilisateur.logements = logements;
        Utilisateur.transports = transports;
        Utilisateur.services = services;
		Utilisateur.nom = nom;
		Utilisateur.prenom = prenom;

		//Impact carbone d'un individu 
		impactUt = alimentation.getImpact()+ bienConso.getImpact()+services.getEmpCarbFR();
    	for (Logement log : logements) {
    		impactUt+=log.getImpact();
    	}
    	for (Transport tr :  transports) {
    		impactUt+=tr.getImpact();
    	}
    }
    
	//Constructeur qui prend un ficher en flux d'entrée
	public  Utilisateur(String entreeUtilisateur){
		try{
			//Initialisation du buffer afin de lire le fichier texte
			BufferedReader reader = new BufferedReader (new FileReader(new File(entreeUtilisateur)));
			String line = "";
			int superficie = 0;
			CE ce;
			Taille taille = null;
			int kilom = 0;
			int amortissement = 0;
			double txboeuf = 0;
			double txvege = 0;
			Utilisateur.logements = new ArrayList<Logement>();
			Utilisateur.transports = new ArrayList<Transport>();


			//Boucle while pour lire ligne par ligne le fichier texte
			while(line!=null){
				line = reader.readLine();
				if (line == null) break;
				
				//Recupère le nom et prénom de l'individu dans le fichier
				if (line.contains("Nom")){
					String [] elemline = line.split(":");
					Utilisateur.nom = elemline[1];
				}
				if (line.contains("Prénom")){
					String [] elemline = line.split(":");
					Utilisateur.prenom = elemline[1];
				}
				//récupère la superficie et la classe énergetique s'il a un logement 
				if (line.contains("Superficie") || line.contains("Classe énergétique")){
					if (line.contains("Superficie")){
						String [] elemline = line.split(":");
						superficie = Integer.parseInt(elemline[1]);
					}
					if(line.contains ("Classe énergétique")){
						String [] elemline = line.split(":");
						ce = CE.valueOf(elemline[1]);
						Utilisateur.logements.add(new Logement(superficie,ce));
					}
				}
				//Récupère la Taille, le kilométrage et l'amortissement du véhicule s'il en a. Initialise les services
				if((line.contains("Taille")) || (line.contains("Kilométrage")) || (line.contains("Amortissement"))){
					if (line.contains("Taille")){
						String [] elemline = line.split(":");
						taille = Taille.valueOf(elemline[1]);
					}
					if(line.contains ("Kilométrage")){
						String [] elemline = line.split(":");
						kilom = Integer.parseInt(elemline[1]);
					}
					if (line.contains("Amortissement")){
						String [] elemline = line.split(":");
						amortissement = Integer.parseInt(elemline[1]);
						Utilisateur.transports.add(new Transport(taille, kilom, amortissement));
					}
				}
				//Récupère le montant et initialise les services
				if(line.contains("Montant")){
					String [] elemline = line.split(":");
					double montant = Double.parseDouble(elemline[1]);
					Utilisateur.bienConso = new BienConso(montant);
				}
				//Récupère et initialise Services publiques
				if (line.contains("Empreinte carbone française ")){
					Utilisateur.services = new ServicesPublics();
				}
				//Récupère et initialise Alimentation
				if (line.contains("Taux Boeuf") || line.contains("Taux Végé")){
					if(line.contains("Taux Boeuf")){
						String [] elemline = line.split(":");
						txboeuf = Double.parseDouble(elemline[1]);
					}
					if (line.contains("Taux Végé")){
						String [] elemline = line.split(":");
						txvege = Double.parseDouble(elemline[1]);
						Utilisateur.alimentation = new Alimentation(txboeuf,txvege);
					}
				}
			}
			reader.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace() ; 
		}
		catch(IOException e){
			e.printStackTrace() ;
		}

	}


   //---Getters et Setters--- 

   public String getNom(){
	return Utilisateur.nom;
   }

   public String getPrenom(){
	return Utilisateur.prenom;
   }

	public double getImpactUt(){
		return impactUt;
	}

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

	//On suppose qu'on ne peut pas changer le nom et prenom d'un individu donc pas besoin de setter pour leurs attributs

	public void setAlimentation(Alimentation alimentation) {
		Utilisateur.alimentation = alimentation;
	}

	public void setBienConso(BienConso bienConso) {
		Utilisateur.bienConso = bienConso;
	}

	public void setLogement(Collection<Logement> logements) {
		Utilisateur.logements = logements;
	}

	public void setTransport(Collection<Transport> transports) {
		Utilisateur.transports = transports;
	}

	public void setServices(ServicesPublics services) {
		Utilisateur.services = services;
	}

	//---Fin Getters et Setters---


	public void detaillerEmpreinte(){ //Détaille l'empreinte carbone d'un individu
		double impactLog = 0,impactTr=0;
    	for (Logement log : logements) {
    		impactLog+=log.getImpact();
    	}
    	for (Transport tr :  transports) {
    		impactTr+=tr.getImpact();
    	}
		System.out.println("\n\n----------------Fiche récapitulative de " + Utilisateur.nom +" "+ Utilisateur.prenom + ":----------------\n" );
		System.out.println("Alimentation : " + alimentation.getImpact() +" TCO2eq\nBiens consommés : " + bienConso.getImpact()+" TCO2eq\nLogement : " + impactLog + " TCO2eq\nTransport : " + impactTr + " TCO2eq\nServices Publics : " + services.getEmpCarbFR() + " TCO2eq.");
    }
    
    public void conseille() { //Conseille sur la consommation d'un individu
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

    	System.out.println("\nLa classe avec l'impact le plus elevé est "+conso.get(max));
        
    	Set<Double> keys = conso.keySet();
        for (Double key : keys) {
        	System.out.println("\n\nVotre consommation au poste "+ conso.get(key) +" est de "+ key +" TCO2eq.");
        	
        	if ((conso.get(key) == "transport")&&(key>ITransport)) {
        		System.out.println("C'est supérieur à la moyenne française. Priviligiez l'utilisation de transports en communs ou non polluants (velo,trotinette éléctrique,etc...).");
        	}
        	if ((conso.get(key) == "logement")&&(key>ILogement)) {
        		System.out.println("C'est supérieur à la moyenne française. Limitez la consommation d'énergie et prenez soin d'éteindre vos appareils éléctroménagers s'ils ne sont pas utilisés.");
        	}
        	if ((conso.get(key) == "bienconso")&&(key>IBienconso)) {
        		System.out.println("C'est supérieur à la moyenne française. Priviligiez l'achat de vêtements en seconde main et le reconditionnement des appreils éléctroniques.");
        	}
        	if ((conso.get(key) == "alimentation")&&(key>IAlimentation)) {
        		System.out.println("C'est supérieur à la moyenne française. Favorisez la consommation d'aliments végétariens.");
        	}
        	//L'impact des services publics est commun à tous les français, on ne peut donc pas donner de conseils sur cette classe.
        	
        }
    }
    
}
