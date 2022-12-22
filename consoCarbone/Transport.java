package consoCarbone;



/** Transport est une classe fille de la classe ConsoCarbonne qui permet le calcul de l'impacte du au transport grace à des informations sur les véhicules.
 */
public final class Transport extends ConsoCarbone{
	/* boolean indiquant si l'utilisateur posséde une voiture.
	 */
    private boolean possede;
    /* la taille du véhicule grace à l'enumeration Taille.
     */
    private Taille taille;
    /* Nombre de kilomètres parcourus par an.
     */
    private int kilomAnnee;
    /*
     * durée de conservation du véhicule.
     */
    private int amortissement;

    public Transport(boolean possede){
    	this.possede = possede;
    	impact = 0;
    }

    /** Constructeut de la classe Transport
     * @param taille la taille du vehicule
     * @param kilomAnnee Nombre de kilomètres parcourus par an
     * @param amortissement durée de conservation du véhicule.
     */
    public Transport (Taille taille, int kilomAnnee, int amortissement){
        super();
        possede=true;
        this.taille = taille;
        this.kilomAnnee = kilomAnnee;
        this.amortissement = amortissement;
        impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
    }


    
    
    //---Getters et Setters--- 
    
    
    /** getter de l'attribut possede
     * @return  si l'individu possede une voiture ou non
     */
    public boolean getPossede(){
        return possede;
    }

    /** setter de l'attribut possede
     * @param possede si l'individu possede une voiture ou non
     */
    public void setPossede(boolean possede){
        if (!(this.possede = possede)) {
        	taille=null;
        	kilomAnnee=0;
        	amortissement=0;
        	impact=0;
        }
    }

    /** getter de l'attribut taille
     * @return taille la taille du vehicule
     */
    public Taille getTaille(){
        return this.taille;
    }

    /** setter de l'attribut taille
     * @param taille la taille du vehicule
     */
    public void setTaille( Taille taille){//Initialise la taille de la voiture
        this.taille = taille;
        impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
    }

    /** getter de l'attribut kilomAnnee
     * @return kilomAnnee nombre de kilomètres parcourus par an
     */
    public int getKilomAnnee(){
        return this.kilomAnnee;
    }

    /** setter de l'attribut kilomAnnee
     * @param kilomAnnee nombre de kilomètres parcourus par an
     */
    public void setKilomAnnee(int kilomAnnee){//Initialise le nombre de kilometre parcourrue par annee
        this.kilomAnnee = kilomAnnee;
        impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
    }

    /** getter de l'attribut amortissement
     * @return amortissement, durée de conservation du véhicule.
     */
    public int getAmortissement(){
        return this.amortissement;
    }

    /** setter de l'attribut amortissement
     * @param amortissement durée de conservation du véhicule.
     */
    public void setAmortissement(int amortissement){//Initialise la duree de vie d'un vehicule
        this.amortissement = amortissement;
        impact = kilomAnnee*1.93*0.0001+ (this.taille.getEmission()/amortissement);
    }
    
    //---Fin Getters et Setters---   

    @Override
    public String toString(){
        if (this.possede){
            return "L'individu possede une voiture. Sa taille est "+ taille+". Elle a roule " + kilomAnnee+ " par an. Elle possede un amortissement de " + amortissement+ ". Lors de sa fabrication elle a emis " + taille.getEmission()+". Son impact est de " + impact+"tCO2eq."; 
        }
        else {
            return "L'individu ne possede pas de voiture";
        }
    }

    
    public static void francais(){//Methode statique pour les francais
        System.out.println("Voiture : 1972 Kg/an. Avion : 480 Kg/an. Fret et messagerie : 383 Kg/an. Train et bus : 85 Kg/an. Total : 2920 Kg/an");
    }

    

}

