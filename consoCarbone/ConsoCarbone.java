package consoCarbone;


/** la classe ConsoCarbone est une classe abstraite du package consoCarbone qui est la classe mère de plusieurs classes.
 */
public abstract class ConsoCarbone implements Comparable<ConsoCarbone> {   // je déclare la classe Consocarbone en tant que classe abstaite car elle est étendue par plusieurs classes.
                                        //J'implémente l'interface comparable pour poiuvoir comparé l'impact carbone de deux instances différentes
    /** id correspond à un identifiant unique attribué à l’instance.
     */
	private final int ID;
	/** compteur d'identifiants
	 */
    private static int cptID;
    /** consommation carbone
     */
    protected double impact; //Attribut Impact commun à toutes les classes filles, il est donc placé dans la classe mère

    /** Constructeur de la classe ConsoCarbone
     */
    public ConsoCarbone(){
        cptID ++;
        ID = cptID;
    }

    /** Getter de l'attribut id
     * @return un identifiant unique attribué à l’instance
     */
    public int getID(){
        return ID;
    }

    /** getter de l'attribut impact
     * @return la valeur de l'impact énergétique
     */
    public double getImpact(){
        return this.impact;
    }


    /**compare l'impacte issu de la classe consocarbone avec l'un des éléments du package consocarbone
     */
    public int compareTo(ConsoCarbone inst){
  	   if (impact==inst.impact) return 0;
  	   if (impact<inst.impact) return -1;
  	   return 1;
      };


}
