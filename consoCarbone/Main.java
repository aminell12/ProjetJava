package consoCarbone;

import java.util.*;
import GestionUtil.*;


public class Main {
	//Méthode pour le menu intéractif
	private static void MenuInteractif(){
		Scanner scanner = new Scanner(System.in);
		String entreeUt = "";
		boolean succes = false;

		System.out.println("Bienvenu dans le menu interactif du Projet Empreinte Carbone.");

		//Bloc pour attendre quelques secondes
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Ce projet consiste à recceuillir des informations auprès de nos utilisateurs afin d'analyser l'Empreinte Carbone de notre population.");

		//Bloc pour attendre quelques secondes
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Vous avez le choix entre lire un fichier contenant vos informations ou bien entre les données vous même.");

		System.out.println("Voulez-vous lire un fichier ? Entrer 1 pour lire un fichier, 0 sinon.");
		boolean lirefichier = false;
		int test;
		succes = false;
		while(!succes){
			try {
        		entreeUt = scanner.next();
        		if (!Arrays.asList("1","0").contains(entreeUt)) {
        			throw new InvalidBooleanException();
        		}
				test = Integer.parseInt(entreeUt);
				if (test == 1) lirefichier = true;
				else lirefichier = false;
        		succes = true;
        	}
        	catch (InvalidBooleanException e) {
        		System.out.println(e.getMessage());
        	} 
		}

		
		if (lirefichier){
			Utilisateur utilisateur = new Utilisateur();


		}
		else {
			System.out.println("Vous devez entrer au minimum deux individus. Combien d'utilisateurs voulez-vous entrer ? (minimum 2)");
			int nbUtilisateur = 0;
			succes = false;
			while(!succes){
				try{
					entreeUt = scanner.next();
					nbUtilisateur = Integer.parseInt(entreeUt);
					//if(nbUtilisateur<2) 
					succes = true;
				}
				catch(NumberFormatException e){
					System.out.println("Attention ! Vous devez entrer un nombre entier supérieur ou égal à 2.");

				}
			}
			Collection<Utilisateur> utilisateurs = new ArrayList<Utilisateur> ();
			for (int i = 0; i<nbUtilisateur; i++){
				System.out.println("Bonjour utilisateur numéro "+ (i+1) +". Nous allons vous poser quelques questions concernant votre quotidien.");
				utilisateurs.add(creeUtilisateur(scanner));
			}
			System.out.println("Nous avons bien enregistré vos informations. Nous procédons au calcul...");

			//Bloc pour attendre quelques secondes
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Population population = new Population(utilisateurs);
			population.DetaillePopulation();
			population.DecisionMairie();
			scanner.close();
		}

	}

	//Méthode pour créer un utilisateur 
	private static Utilisateur creeUtilisateur(Scanner scanner){
		boolean succes = false;
		String entreeUt = "";


		System.out.println("Quel est votre Nom ?");

		String nom = scanner.next();

		System.out.println("Quel est votre Prénom");

		String Prenom = scanner.next();

		System.out.println("Rentrons un peu plus dans le vif du sujet.");
		
		//Bloc pour attendre quelques secondes
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Recupère les logements de l'indiviu
		System.out.println("Combien de logements possedez-vous ?");
		int nblog = 0;
		succes = false;
			entreeUt = "";
			while (!succes) {
				try {
					entreeUt = scanner.next();
					nblog = Integer.parseInt(entreeUt);
					succes=true;
				}
				catch (NumberFormatException e) {
					System.out.println("La valeur entrée n'est pas un nombre entier. Veuillez entrer un entier.");
				}
			}

		//Collection de logements de l'utilisateurs
		Collection <Logement> logs = new ArrayList<Logement>();
		for (int i = 0; i< nblog; i++){
			//Recupère la superficie du logement de l'utilisateur
			System.out.println("Quel est la superficie de votre logement n° "+ (i+1) +"? (en m2)");
			int superficie = 0;
			succes = false;
			entreeUt = "";
			while (!succes) {
				try {
					entreeUt = scanner.next();
					superficie = Integer.parseInt(entreeUt);
					succes=true;
				}
				catch (NumberFormatException e) {
					System.out.println("\nLa valeur entrée n'est pas un nombre entier. Veuillez entrer la superficie de votre logement.");
				}
			}

			//Recupère la classe énergétique de l'individu
			System.out.println("Quelle est la classe energetique de votre logement n° "+ (i+1) +"? (choix : A,B,C,D,E,F,G) ");
			succes = false;
			entreeUt = "";
			while (!succes) {
				try {
					entreeUt = scanner.next();
					if (!Arrays.asList("A","B","C","D","E","F","G").contains(entreeUt)) {
						throw new InvalidCEException();
					}
					succes = true;
				}
				catch (InvalidCEException e) {
					System.out.println(e.getMessage());
	       		} 
			}
			Logement log = new Logement(superficie,CE.valueOf(entreeUt));
			logs.add(log);
		}

		//Récupre le mode de transport de l'utilisateur
		System.out.println("Possedez-vous un ou plusieurs véhicules ? (1/0)");
		Collection <Transport> transports = new ArrayList<Transport>();
		boolean reponse;
		succes = false;
		int test = 0;
		entreeUt = "";
		while (!succes) {
        	try {
        		entreeUt = scanner.next();
        		if (!Arrays.asList("1","0").contains(entreeUt)) {
        			throw new InvalidBooleanException();
        		}
				test = Integer.parseInt(entreeUt);
        		succes=true;
        	}
        	catch (InvalidBooleanException e) {
        		System.out.println(e.getMessage());
        	} 
     	}
     	if (test == 1) reponse = true;
		else reponse = false;
		if (reponse == false) {
			
			Transport trans = new Transport(false);
			transports.add(trans);
		}
		else{ 
			//Récupere le nombre de
			System.out.println("Combien de véhicules possedez-vous ?");
			int nbtrans = 0;
			entreeUt = "";
			succes = false;
			while (!succes) {
				try {

					entreeUt = scanner.next();
					nbtrans = Integer.parseInt(entreeUt);
					succes=true;
				}
				catch (NumberFormatException e) {
					System.out.println("La valeur entrée n'est pas un nombre entier. Veuillez recommencer.");
				}
			} 

			//Collection de logements de l'utilisateurs
			
			for (int i = 0; i< nbtrans; i++){
				//Recupère la Taille du vehicule de l'utilisateur
				System.out.println("Quel est la taille de votre voiture n° "+ (i+1) +"? (P/G)");
				Taille taille = null;
				entreeUt = "";
				succes = false;
				while (!succes) {
					try {
						entreeUt = scanner.next();
					if (!Arrays.asList("G","P").contains(scanner.next())) {
						throw new InvalidSizeException();
					}
					taille = Taille.valueOf(entreeUt);
					succes=true;
					}
					catch (InvalidSizeException e) {
					System.out.println(e.getMessage());
				} 
			}
				
				//Recupère le kilometrage du vehicule
				System.out.println("Quelle est le kilometrage de votre véhicule n° "+ (i+1) +"?");
				int kilometre = 0;
				succes = false;
				while (!succes) {
					try {
						entreeUt = scanner.next();
						kilometre = Integer.parseInt(entreeUt);
						succes=true;
					}
					catch (NumberFormatException e) {
						System.out.println("La valeur entrée n'est pas un nombre entier. Veuillez entrer la superficie de votre logement.");
					}
				}
				//Récupère l'amortissement du véhicule
				System.out.println("Quelle est l'amortissement de votre véhicule n° "+ (i+1) +"?");
				int amortissement = 0;
				succes = false;
				while (!succes) {
					try {
						entreeUt = scanner.next();
						amortissement = Integer.parseInt(entreeUt);
						succes=true;
					}
					catch (NumberFormatException e) {
						System.out.println("La valeur entrée n'est pas un nombre entier. Veuillez entrer la superficie de votre logement.");
					}
				}

				Transport trans = new Transport(taille,kilometre,amortissement);
				transports.add(trans);
			}
		}

		//Bloc pour attendre quelques secondes
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Récupère alimentation de l'utilisateur
		System.out.println("Passons à votre alimentation maintement.");

		//Bloc pour attendre quelques secondes
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Récupère le taux Boeuf
		System.out.println("Quel est le taux de consommation de Boeuf ?");
		double txvege = 0, txboeuf = 0;
		succes = false;
		entreeUt = "";
		while (!succes) {
        	try {
        		entreeUt = scanner.next();
        		txboeuf=Double.parseDouble(entreeUt); 
        		if(txboeuf>1 || txboeuf<0)
					try {
						throw new InvalidRateException();
					} catch (InvalidRateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		succes = true;
        	}
        	catch (NumberFormatException e) {
        		System.out.println("Taux invalide. Les taux de consommation doivent être entre 0 et 1.");
        	}
        }
		//Récupère le taux Vege
		System.out.println("Quel est le taux de consommation de Vege ?");
		succes = false;
		entreeUt = "";
		while (!succes) {
        	try {
        		entreeUt = scanner.next();
        		txvege = Double.parseDouble(entreeUt);  
        		if(txvege>1 || txvege<0)
					try {
						throw new InvalidRateException();
					} catch (InvalidRateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		succes = true;
        	}
        	catch (NumberFormatException e) {
        		System.out.println("Taux invalide. Les taux de consommation doivent être entre 0 et 1.");
        	}
        }

		//Récupère la consommation des biens de l'individu
		System.out.println("Quel est le montant de vos biens de consommations ?");
		double montant = 0;
		entreeUt = "";
		succes = false;
		while(!succes){
			try{
				entreeUt = scanner.next();
				montant = Double.parseDouble(entreeUt);
				succes = true;
			}
			catch(NumberFormatException e){
				System.out.println("Montant invalide. Le montant de la consommation de vos biens doit étre un double");
			}
		}
		Utilisateur u = new Utilisateur(new Alimentation(txboeuf,txvege), new BienConso(montant), logs, transports, new ServicesPublics(), nom, Prenom);
		return u;
	}

	
    public static void main (String [] args){
        /* 
        ConsoCarbone logement= new Logement(140,CE.A);
		ConsoCarbone alim= new Alimentation(0.2,0.35);
		ConsoCarbone transport= new Transport(Taille.P,15000,5);
		ConsoCarbone bienconso = new BienConso(2000);
		ConsoCarbone services = new ServicesPublics();

		/* 										TESTE DES DIFFÉRENTES CLASSES

        System.out.println("              ----EMPREINTE CARBONE DU LOGEMENT----");
		Logement.francais();
		System.out.println();
		System.out.println(logement.toString());
		System.out.println("\n\n");

        System.out.println("              ----EMPREINTE CARBONE DE L'ALIMENTATION----");
		Alimentation.francais();
		System.out.println();
		System.out.println(alim.toString());
		System.out.println("\n\n");
		
		System.out.println("              ----EMPREINTE CARBONE DES TRANSPORTS----");
		Transport.francais();
		System.out.println();
		System.out.println(transport.toString());
		System.out.println("\n\n");
		
		System.out.println("              ----EMPREINTE CARBONE DES BIENS CONSOMÉS----");
		BienConso.francais();
		System.out.println();
		System.out.println(bienconso.toString());
		*/
/* 

		Collection<Transport> tr = new ArrayList<Transport> ();
		tr.add((Transport) transport);
		Collection<Logement> log = new ArrayList<Logement> ();
		log.add((Logement) logement);

		Utilisateur u = new Utilisateur((Alimentation) alim,(BienConso)bienconso,log,tr,(ServicesPublics)services, "Lallali", "Amine");
		//Utilisation de la classe Population
		Collection<Utilisateur> utilisateurs = new ArrayList<Utilisateur> ();
		utilisateurs.add((Utilisateur ) u);

		Population pop = new Population(utilisateurs);
		pop.DetaillePopulation();

		pop.DecisionMairie();

		MenuInteractif();

		 */
		MenuInteractif();

    }
}
