package consoCarbone;

import java.util.Arrays;
import java.util.List;

public class Transport extends ConsoCarbone{
    private boolean possede;
    private Taille taille;
    private int kilomAnnee;
    private int amortissement;
    
    public Transport(boolean possede){
    	this.possede = possede;
    	impact = 0;
    }

    public Transport (Taille taille, int kilomAnnee, int amortissement){ //Constructeut de la classe Transport
        super();
        possede=true;
        this.taille = taille;
        this.kilomAnnee = kilomAnnee;
        this.amortissement = amortissement;
        impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
    }
    
    
    
    //---Getters et Setters--- 
    public boolean getPossede(){//Retourne si l'individu possede une voiture ou non
        return possede;
    }
    public void setPossede(boolean possede){ //Initialise le boolean possede
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

    public int getKilomAnnee(){// Retourne le nombre de kilometre par annee
        return this.kilomAnnee;
    }
    public void setKilomAnnee(int kilomAnnee){//Initialise le nombre de kilometre parcourrue par annee
        this.kilomAnnee = kilomAnnee;
        impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
    }

    public int getAmortissement(){//Retourne la duree de vie d'un vehicule
        return this.amortissement;
    }
    public void setAmortissement(int amortissement){//Initialise la duree de vie d'un vehicule
        this.amortissement = amortissement;
        impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
    }
    //---Fin Getters et Setters---   

    public String toString(){
        if (this.possede){
            return "L'individu possede une voiture. Sa taille est "+ taille+". Elle a roule " + kilomAnnee+ " par an. Elle possede un amortissement de " + amortissement+ ". Lors de sa fabrication elle a emis " + taille.getEmission()+". Son impact est de " + impact+"."; 
        }
        else {
            return "L'individu ne possede pas de voiture";
        }
    }

    
    public static void francais(){//Methode statique pour les francais
        System.out.println("Voiture : 1972 Kg/an. Avion : 480 Kg/an. Fret et messagerie : 383 Kg/an. Train et bus : 85 Kg/an. Total : 2920 Kg/an");
    }

    //Test d'erreur dans le cas où l'utilisateur entre une taille erronee
    static public boolean isTaille(String s) {
		List<String> T=Arrays.asList("P","G");
		return T.contains(s);
	}

}
