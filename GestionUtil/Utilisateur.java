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
	public Utilisateur(){
		try{
			BufferedReader reader = new BufferedReader (new FileReader(new File("EmpreinteCarbone.txt")));
			String line = reader.readLine();
			while(line!=null){
				line = reader.readLine();
				System.out.println(line);

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

	public void setImpactUt(double impact){
		impactUt = impact;
	}

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
