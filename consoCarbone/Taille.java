package consoCarbone;

/** Taille est une enumeration de la classe ConsoCarbone pour connaitre l'emission de CO2 pour la production d'une voiture selon sa taille.
 */
public enum Taille {
	/** P represente l'emission pour la production d'une petite voiture
	 */
    P(4.2),
    /** G represente l'emission pour la production d'une grande voiture
	 */
    G(19);
	/** emission représente en tCO2eq l'emission pour la production d'une voiture donnée
	 */
    private double emission;

	/** Constructeur de la classe Taille
	 * @param emission représente en tCO2eq l'emission pour la production d'une voiture donnée
	 */
    private Taille (double emission){
        this.emission = emission;

    }
    /** Getter de l'attribut emission
     * @return l'emission en tCO2eq pour la production d'une voiture
     */
    public double getEmission(){
        return emission;
    }

}
