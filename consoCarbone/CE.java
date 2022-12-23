package consoCarbone;

/**CE est une énumération avec 7 instances nommées {A, B, C, D, E, F, G} représentant les différentes classes énergétiques possibles d’un logement.
 */
public enum CE {
    A(0.005),
    B(0.01),
    C(0.02),
    D(0.035),
    E(0.055),
    F(0.08),
    G(0.1);

	/** alpha est un coéfficient multiplicatif dépendant de la classe énergétique du logement selon la correspondance
	 */
    private final double alpha;

    /** constructeur de CE
     * @param alpha est un coéfficient multiplicatif dépendant de la classe énergétique du logement selon la correspondance
     */
    private CE (double alpha){
        this.alpha = alpha;
    }
    /** getter de l'attribut alpha de la classe CE
     * @return l'attribut alpha
     */
    public double getCE(){
        return alpha;
    }

}
