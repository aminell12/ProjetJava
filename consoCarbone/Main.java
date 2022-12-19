package consoCarbone;

import java.util.*;

import GestionUtil.*;


public class Main {

    public static void main (String [] args){
        
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

    }
}
