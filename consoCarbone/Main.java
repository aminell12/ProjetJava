package consoCarbone;

import java.util.*;

import paquet.Utilisateur;


public class Main {

    public static void main (String [] args){
        /* 
        //Teste la classe Logement
        Logement amineAppart = new Logement(40, CE.A );
        System.out.println(amineAppart.toString());

        //Teste la classe Alimentation
        Alimentation amineAlim = new Alimentation(0.7,0.3);
        System.out.println(amineAlim.toString());

        //Teste la classe BienConso
        BienConso adelBienconso = new BienConso(3960);

        System.out.println(adelBienconso.toString());

        //Teste la classe Transport
        Transport adelTransport = new Transport(false);
        System.out.println(adelTransport.toString());

        Transport amineTransport = new Transport(true, Taille.P, 20000, 10, 276);
        System.out.println(amineTransport.toString());
        */

        ConsoCarbone logement= new Logement(140,CE.A);
		ConsoCarbone alim= new Alimentation(0.2,0.35);
		ConsoCarbone transport= new Transport(Taille.P,15000,5);
		ConsoCarbone bienconso = new BienConso(2000);
		ConsoCarbone services = new ServicesPublics();

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
		
		Collection<Transport> tr = new ArrayList<Transport> ();
		tr.add((Transport) transport);
		Collection<Logement> log = new ArrayList<Logement> ();
		log.add((Logement) logement);
		
		Utilisateur u= new Utilisateur((Alimentation) alim,(BienConso)bienconso,log,tr,(ServicesPublics)services);
		u.conseille();
		

    }
}
