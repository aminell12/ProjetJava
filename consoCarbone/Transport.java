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
            this.impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
        }
        else{
            this.impact = 0;
        }   
    }

    //---Getters et Setters--- 
    public boolean getPossede(){//Retourne si l'individu possède une voiture ou non
        return this.possede;
    }
    public void getPossede(boolean possede){ //Initialise le boolean possede
        this.possede = possede;
    }

    public Taille getTaille(){//Retourne la taille de la voiture 
        return this.taille;
    }
    public void setTaille( Taille taille){//Initialise la taille de la voiture
        this.taille = taille;
    }

    public int getKilomAnnee(){// Retourne le nombre de kilomètre par année
        return this.kilomAnnee;
    }
    public void setKilomAnnee(int kilomAnnee){//Initialise le nombre de kilomètre parcourrue par année
        this.kilomAnnee = kilomAnnee;
    }

    public int getAmortissement(){//Retourne la durée de vie d'un véhicule
        return this.amortissement;
    }
    public void setAmortissement(int amortissement){//Initialise la durée de vie d'un véhicule
        this.amortissement = amortissement;
    }
    //---Fin Getters et Setters---   

    public String toString(){
        if (this.possede){
            return "L'individu possède une voiture. Sa taille est "+ this.taille+". Elle a roulé " + this.kilomAnnee+ " par an. Elle possède un amortissement de " + this.amortissement+ ". Lors de sa fabrication elle a émis " + this.taille.getEmission()+". Son impact est de " + this.impact+"."; 
        }
        else {
            return "L'individu ne possède pas de voiture";
        }
    }

    
    public static void français(){//Méthode statique pour les français
        System.out.println("Voiture : 1972 Kg/an. Avion : 480 Kg/an. Fret et messagerie : 383 Kg/an. Train et bus : 85 Kg/an. Total : 2920 Kg/an");
    }

    //Teste d'erreur dans le cas où l'utilisateur entre une taille erronée
    static public boolean isTaille(String s) {
		List<String> T=Arrays.asList("P","G");
		return T.contains(s);
	}

}
