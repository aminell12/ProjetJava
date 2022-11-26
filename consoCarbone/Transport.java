package consoCarbone;

import java.util.Arrays;
import java.util.List;

public class Transport extends ConsoCarbone{
    private boolean possede;
    private Taille taille;
    private int kilomAnnee;
    private int amortissement;
    
    public Transport(boolean b){}

    public Transport (boolean possede, Taille taille, int kilomAnnee, int amortissement){ //Constructeut de la classe Transport
        super();
        this.possede = possede;
        this.taille = taille;
        this.kilomAnnee = kilomAnnee;
        this.amortissement = amortissement;
        if (this.possede){
            impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
        }
        else{
            impact = 0;
        }   
    }
    
//    public Transport (boolean possede, Taille taille, int kilomAnnee, int amortissement){ //Constructeut de la classe Transport
//        super();
//        this.possede = possede; 
//        if (this.possede) {
//        	this.taille = taille;
//        	this.kilomAnnee = kilomAnnee;
//        	this.amortissement = amortissement;
//          impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
//        }
//    }
// 											voir cette partie avec le grp psk qst de logique
    
    
    //---Getters et Setters--- 
    public boolean getPossede(){//Retourne si l'individu possède une voiture ou non
        return possede;
    }
    public void getPossede(boolean possede){ //Initialise le boolean possede
        if (!(this.possede = possede)) {
        	taille=null;
        	kilomAnnee=0;
        	amortissement=0;
        	impact=0;
        }
    }

    public Taille getTaille(){//Retourne la taille de la voiture 
        return this.taille;
    }
    public void setTaille( Taille taille){//Initialise la taille de la voiture
        this.taille = taille;
        impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
    }

    public int getKilomAnnee(){// Retourne le nombre de kilomètre par année
        return this.kilomAnnee;
    }
    public void setKilomAnnee(int kilomAnnee){//Initialise le nombre de kilomètre parcourrue par année
        this.kilomAnnee = kilomAnnee;
        impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
    }

    public int getAmortissement(){//Retourne la durée de vie d'un véhicule
        return this.amortissement;
    }
    public void setAmortissement(int amortissement){//Initialise la durée de vie d'un véhicule
        this.amortissement = amortissement;
        impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
    }
    //---Fin Getters et Setters---   

    public String toString(){
        if (this.possede){
            return "L'individu possède une voiture. Sa taille est "+ taille+". Elle a roulé " + kilomAnnee+ " par an. Elle possède un amortissement de " + amortissement+ ". Lors de sa fabrication elle a émis " + taille.getEmission()+". Son impact est de " + impact+"."; 
        }
        else {
            return "L'individu ne possède pas de voiture";
        }
    }

    
    public static void français(){//Méthode statique pour les français
        System.out.println("Voiture : 1972 Kg/an. Avion : 480 Kg/an. Fret et messagerie : 383 Kg/an. Train et bus : 85 Kg/an. Total : 2920 Kg/an");
    }

    //Test d'erreur dans le cas où l'utilisateur entre une taille erronée
    static public boolean isTaille(String s) {
		List<String> T=Arrays.asList("P","G");
		return T.contains(s);
	}

}
