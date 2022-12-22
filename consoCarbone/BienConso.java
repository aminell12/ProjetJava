package consoCarbone;


/** BienConso est une classe fille de la classe ConsoCarbonne qui permet le calcul de l'impacte du au dépenses
*/
public final class BienConso extends ConsoCarbone{
	/** montant représente le montant des dépenses annuelles de l'utilisateur.rice.
	 */
    private double montant;



    /** Constructeur de la classe BienConso
     * @param montant le montant des dépenses annuelles de l'utilisateur.rice.
     */
    public BienConso(double montant){
        super();
        this.montant = montant;
        impact = this.montant/1750;
    }

    /** Getter de l'attribut montant
     * @return le montant des dépenses annuelles de l'utilisateur.rice.

     */
    public double getMontant(){
        return this.montant;
    }

    /** Setter de l'attribut montant avec mise à jour de l'impact
     * @param montant le montant des dépenses annuelles de l'utilisateur.rice.
     */
    public void setMontant (double montant){
        this.montant = montant;
        impact = this.montant/1750;
    }


    @Override
    /** Méthode qui permet de retourner les attributs de la classe BienConso en chaines de caractères.
     * @return le montant des dépenses annuelles de l'utilisateur.rice et son impact
     */
    public String toString(){
        return "Le montant de la consommation des biens est de : " + montant + ". Son impact est de " + impact+"tCO2eq.";
    }

    /** Méthode statique détaillant sur la console l’empreinte carbone moyenne d’un.e français.e vis-à-vis de ses dépenses.
     */
    public static void francais(){
        System.out.println("Achat et usages internet et technologies : 1180 Kg/an. Autres biens et services : 682 Kg/an. Habillement : 763 Kg/an. Total : 2625 Kg/an");
    }


}
