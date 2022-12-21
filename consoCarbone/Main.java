package consoCarbone;

import java.util.*;
import GestionUtil.*;


public class Main {
	//Méthode pour le menu intéractif
	private static void MenuInteractif(){
		Scanner scanner = new Scanner(System.in);
		String entreeUt = "";
		boolean succes = false;
		Utilisateur util;

		System.out.println("Bienvenue dans le menu interactif du Projet Empreinte Carbone.");

		//Bloc pour attendre quelques secondes
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Ce projet consiste à recceuillir des informations auprès de nos utilisateurs afin d'analyser l'Empreinte Carbone de notre population.");

		//Bloc pour attendre quelques secondes
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Vous avez le choix entre lire un fichier contenant vos informations ou bien entrer les données vous même.");

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
			System.out.println("						!!!Attention !!!\nVeuillez bien prendre en compte le format de fichier texte mis à disposition dans le dossier ReadMe. Une quelconque erreur de mise en page ou autre pourrait affecter la suite du programme.");
			
			//Bloc pour attendre quelques secondes
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
			System.out.println("Quel est nom du fichier texte à lire ?");
			succes = false;
			String nomFic = scanner.next();

			Utilisateur utilisateur = new Utilisateur(nomFic);
			//Affiche l'empreinte carbone de l'individu du fichier et le conseille
			utilisateur.detaillerEmpreinte();
			System.out.println("\n\n");
			utilisateur.conseille();

			System.out.println("\n\n");
			System.out.println("Pour l'instant nous ne pouvons traiter qu'un fichier texte à la fois. Dans une prochaine mise à jour nous pourrons à partir de plusieurs fichier texte créer une population afin de calculer et conseiller le niveau de l'Empreinte Carbone de celle-ci.");
		}
		else {
			System.out.println("Vous devez entrer au minimum deux individus. Combien d'utilisateurs voulez-vous entrer ? (minimum 2)");
			int nbUtilisateur = 0;
			succes = false;
			while(!succes){
				try{
					entreeUt = scanner.next();
					nbUtilisateur = Integer.parseInt(entreeUt);
					if(nbUtilisateur<2) throw new NumberFormatException();
					succes = true;
				}
				catch(NumberFormatException e){
					System.out.println("Attention ! Vous devez entrer un nombre entier supérieur ou égal à 2.");

				}
			}
			Collection<Utilisateur> utilisateurs = new ArrayList<Utilisateur> ();

			//for (int i = 0; i<nbUtilisateur; i++){
				//System.out.println("Bonjour utilisateur numéro "+ (j+1) +". Nous allons vous poser quelques questions concernant votre quotidien.");
				creeUtilisateurs(scanner,utilisateurs,nbUtilisateur);
				//util=creeUtilisateur(scanner,utilisateurs);
				//utilisateurs.add(util);
			//	scanner.reset();
			//}

			System.out.println("Nous avons bien enregistré vos informations. Nous procédons au calcul...");

			//Bloc pour attendre quelques secondes
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Population population = new Population(utilisateurs);
			population.DetaillePopulation();
			population.DecisionMairie();
			scanner.close();
		}

	}

	//Méthode pour créer un utilisateur 
	private static void creeUtilisateurs(Scanner scanner,Collection<Utilisateur> utilisateurs,  int nbUtil){
		boolean succes = false;
		String entreeUt = "";
		String nom,Prenom;
		
		int nblog = 0;
		Collection <Logement> logs = new ArrayList<Logement>();
		int superficie = 0;
		Logement log;
		
		int nbtrans = 0;
		Collection <Transport> transports = new ArrayList<Transport>();
		Transport trans;
		int kilometre = 0;
		int amortissement = 0;
		
		double txvege = 0, txboeuf = 0;
		double montant = 0;
		

		
		for (int i = 0; i<nbUtil; i++){
			System.out.println("Bonjour utilisateur numéro "+ (i+1) +". Nous allons vous poser quelques questions concernant votre quotidien.");
			System.out.println("Quel est votre Nom ?");

			nom = scanner.next();

			System.out.println("Quel est votre Prénom");

			Prenom = scanner.next();
			System.out.println("Rentrons un peu plus dans le vif du sujet.");
		
			//Bloc pour attendre quelques secondes
			try {
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}

			//Recupère les logements de l'indiviu
			System.out.println("Combien de logements possedez-vous ?");
		
			succes = false;
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
		
			for (int j = 0; j< nblog; j++){
				//Recupère la superficie du logement de l'utilisateur
				System.out.println("Quel est la superficie de votre logement n° "+ (j+1) +"? (en m2)");
			
				succes = false;
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
				System.out.println("Quelle est la classe energetique de votre logement n° "+ (j+1) +"? (choix : A,B,C,D,E,F,G) ");
				succes = false;
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
				log = new Logement(superficie,CE.valueOf(entreeUt));
				logs.add(log);
			}

			//Récupre le mode de transport de l'utilisateur
			System.out.println("Possedez-vous un (ou plusieurs) véhicule(s) ? (Oui/Non)");
		
			
			succes = false;
			while (!succes) {
				try {
					entreeUt = scanner.next();
					if (!Arrays.asList("Oui","Non").contains(entreeUt)) {
						throw new InvalidBooleanException();
					}
					succes=true;
				}
				catch (InvalidBooleanException e) {
					System.out.println(e.getMessage());
				} 
			}
			if (entreeUt.equals("Non")) {
				trans = new Transport(false);
				transports.add(trans);
			}
			else { 
				//Récupere le nombre de voitures
				System.out.println("Combien de véhicules possedez-vous ?");
					
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

				//Collection de transports de l'utilisateurs
			
				for (int j = 0; j< nbtrans; j++){
					//Recupère la Taille du vehicule de l'utilisateur
					System.out.println("Quel est la taille de votre voiture n° "+ (j+1) +"? (P/G)");
					Taille taille = null;
					succes = false;
					while (!succes) {
						try {
							entreeUt = scanner.next();
							if (!Arrays.asList("G","P").contains(entreeUt)) {
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
					System.out.println("Quelle est le kilometrage de votre véhicule n° "+ (j+1) +"?");
				
					succes = false;
					while (!succes) {
						try {
							entreeUt = scanner.next();
							kilometre = Integer.parseInt(entreeUt);
							succes=true;
						}	
						catch (NumberFormatException e) {
							System.out.println("La valeur entrée n'est pas un nombre entier. Veuillez entrer le kilometrage par année du véhicule n°"+ (j+1) +".");
						}
					}
					//Récupère l'amortissement du véhicule
					System.out.println("Quelle est l'amortissement de votre véhicule n° "+ (j+1) +"?");
				
					succes = false;
					while (!succes) {
						try {
							entreeUt = scanner.next();
							amortissement = Integer.parseInt(entreeUt);
							succes=true;
						}	
						catch (NumberFormatException e) {
							System.out.println("La valeur entrée n'est pas un nombre entier. Veuillez entrer l'amortissement du véhicule n°"+ (j+1) +".");
						}
					}

					trans = new Transport(taille,kilometre,amortissement);
					transports.add(trans);
				
				}
			}

			//Bloc pour attendre quelques secondes
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		//Récupère alimentation de l'utilisateur
		System.out.println("Passons à votre alimentation maintement.");

		//Bloc pour attendre quelques secondes
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Récupère le taux Boeuf
		System.out.println("Quel est le taux de consommation de Boeuf ?");
		
		succes = false;
		while (!succes) {
        	try {
        		entreeUt = scanner.next();
        		txboeuf=Double.parseDouble(entreeUt); 
        		if(txboeuf>1 || txboeuf<0) throw new InvalidRateException();
        		succes = true;
        	}
        	catch (NumberFormatException e) {
        		System.out.println("\nLa valeur entrée n'est pas un nombre à décimal. Veuillez entrez le taux de consommation de boeuf.");
        	}
        	catch(InvalidRateException e) {
        		System.out.println(e.getMessage());
        	}
        }
		//Récupère le taux Vege
		System.out.println("Quel est le taux de consommation de Vege ?");
		succes = false;
		while (!succes) {
        	try {
        		entreeUt = scanner.next();
        		txvege = Double.parseDouble(entreeUt);  
        		if(txvege>1 || txvege<0) throw new InvalidRateException();
        		succes = true;
        	}
        	catch (NumberFormatException e) {
        		System.out.println("\nLa valeur entrée n'est pas un nombre à décimal. Veuillez entrez le taux de consommation de vegetarien"+ ".");
        	}
        	catch(InvalidRateException e) {
        		System.out.println(e.getMessage());
        	}
        }

		//Récupère la consommation des biens de l'individu
		System.out.println("Quel est le montant de vos biens de consommations ?");
		
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
		
		utilisateurs.add(null);
		((ArrayList<Utilisateur>) utilisateurs).set(i,new Utilisateur(new Alimentation(txboeuf,txvege), new BienConso(montant), logs, transports, new ServicesPublics(), nom, Prenom));
		
		//return u;
		}
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
