package consoCarbone;

import java.util.*;


import GestionUtil.*;


public class Main {
	//Méthode pour le menu intéractif
	private static void MenuInteractif(){

		System.out.println("Bienvenu dans le menu interactif du Projet Empreinte Carbone.");

		//Bloc pour attendre quelques secondes
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nous allons vous poser quelques questions concernant votre quotidien.");
		
		creeUtilisateur();

	}
	//Méthode pour créer un utilisateur 
	private static Utilisateur creeUtilisateur(){
		boolean succes = false;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Quel est votre Nom ?");

		String nom = scanner.nextLine();

		System.out.println("Quel est votre Prénom");

		String Prenom = scanner.nextLine();

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
		int nblog = scanner.nextInt();
		//Collection de logements de l'utilisateurs
		Collection <Logement> logs = new ArrayList<Logement>();
		for (int i = 0; i< nblog; i++){
			//Recupère la superficie du logement de l'utilisateur
			System.out.println("Quel est la superficie de votre logement n° "+ i +"? (en m2)");
			int superficie = 0;
			succes = false;
			while (!succes) {
				try {
					superficie = scanner.nextInt();
					succes=true;
				}
				catch (NumberFormatException e) {
					System.out.println("\nLa valeur entrée n'est pas un nombre entier. Veuillez entrer la superficie de votre logement.");
				}
			}

			//Recupère la classe énergétique de l'individu
			System.out.println("Quelle est la classe energetique de votre logement ? (choix : A,B,C,D,E,F,G) ");
			CE ce = null;
			succes = false;
			while (!succes) {
				try {
					ce = CE.valueOf(scanner.next());
					if (!Arrays.asList("A","B","C","D","E","F","G").contains(scanner.next())) {
						throw new InvalidCEException();
					}
					succes = true;
				}
				catch (InvalidCEException e) {
					System.out.println(e.getMessage());
	       		} 
			}
			Logement log = new Logement(superficie,ce);
			logs.add(log);
		}

		//Récupre le mode de transport de l'utilisateur
		System.out.println("Possedez-vous un ou plusieurs véhicules ? (T/F)");
		boolean reponse;
		String s = "";
		succes = false;
		while (!succes) {
        	try {
        		s = scanner.next();
        		if (!Arrays.asList("T","F").contains(s)) {
        			throw new InvalidBooleanException();
        		}
        		succes=true;
        	}
        	catch (InvalidBooleanException e) {
        		System.out.println(e.getMessage());
        	} 
     	}
     	if (s == "T") reponse=true;
     	else reponse = false;
		if (!reponse) {
			Collection <Transport> transports = new ArrayList<Transport>();
			Transport trans = new Transport(false);
			transports.add(trans);
		}
		

		System.out.println("Combien de véhicules possedez-vous ?");
		int nbtrans = scanner.nextInt();
		//Collection de logements de l'utilisateurs
		Collection <Transport> transports = new ArrayList<Transport>();
		for (int i = 0; i< nbtrans; i++){
			//Recupère la Taille du vehicule de l'utilisateur
			System.out.println("Quel est la taille de votre voiture n° "+ i +"? (P/G)");
			Taille taille = null;
			succes = false;
			while (!succes) {
				try {
					taille = Taille.valueOf(scanner.next());
				   if (!Arrays.asList("G","P").contains(scanner.next())) {
					   throw new InvalidSizeException();
				   }
				   succes=true;
			   	}
				catch (InvalidSizeException e) {
				   System.out.println(e.getMessage());
			   } 
		   }
			
			//Recupère le kilometrage du vehicule
			System.out.println("Quelle est le kilometrage de votre véhicule n° "+ i +"?");
			int kilometre = 0;
			succes = false;
			while (!succes) {
				try {
					kilometre = scanner.nextInt();
					succes=true;
				}
				catch (NumberFormatException e) {
					System.out.println("La valeur entrée n'est pas un nombre entier. Veuillez entrer la superficie de votre logement.");
				}
			}
			//Récupère l'amortissement du véhicule
			System.out.println("Quelle est l'amortissement de votre véhicule n° "+ i +"?");
			int amortissement = 0;
			succes = false;
			while (!succes) {
				try {
					kilometre = scanner.nextInt();
					succes=true;
				}
				catch (NumberFormatException e) {
					System.out.println("La valeur entrée n'est pas un nombre entier. Veuillez entrer la superficie de votre logement.");
				}
			}

			Transport trans = new Transport(taille,kilometre,amortissement);
			transports.add(trans);
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

		System.out.println("Quel est le taux de consommation de Boeuf ?");
		double txvege = 0, txboeuf = 0;
		succes = false;
		while (!succes) {
        	try {
        		txboeuf = scanner.nextFloat();
        		if(txboeuf>1 || txboeuf<0)
					try {
						throw new InvalidRateException();
					} catch (InvalidRateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		succes=true;
        	}
        	catch (NumberFormatException e) {
        		System.out.println("Taux invalide. Les taux de consommation doivent être entre 0 et 1.");
        	}
        }

		System.out.println("Quel est le taux de consommation de Vege ?");
		succes = false;
		while (!succes) {
        	try {
        		txvege = scanner.nextFloat();
        		if(txvege>1 || txvege<0)
					try {
						throw new InvalidRateException();
					} catch (InvalidRateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		succes=true;
        	}
        	catch (NumberFormatException e) {
        		System.out.println("Taux invalide. Les taux de consommation doivent être entre 0 et 1.");
        	}
        }

		//Récupère la consommation des biens de l'individu
		System.out.println("Quel est le montant de vos biens de consommations ?");
		double montant = 0;
		succes = false;
		while(!succes){
			try{
				montant = scanner.nextDouble();
				succes = true;
			}
			catch(NumberFormatException e){
				System.out.println("Taux invalide. Les taux de consommation doivent être entre 0 et 1.");
			}
		}
		Utilisateur u = new Utilisateur(new Alimentation(txboeuf,txvege), new BienConso(montant), logs, transports, new ServicesPublics(), nom, Prenom);
		scanner.close();
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
		System.out.println(pop.DetaillePopulation());

		pop.DecisionMairie();

		MenuInteractif();

		 */
		MenuInteractif();

    }
}
