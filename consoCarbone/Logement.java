package consoCarbone;
import java.util.Arrays;
import java.util.List;

/** Logement est une classe fille de la classe ConsoCarbonne qui permet le calcul de l'impacte energetique en fonction de son logement.
 */
public final class Logement extends ConsoCarbone {
	/** superficie représente la superficie du logement
	 */
    private int superficie;
    /** classeE représente la classe énergétique du logement
     */
    private CE classeE;

    /**Constructeur de la classe Logement
     * @param superficie représente la superficie du logement
     * @param classE représente la classe énergétique du logement
     */
    public Logement (int superficie, CE classE){
        super();
        this.superficie = superficie;
        this.classeE = classE;
        impact = this.classeE.getCE() * this.superficie;
    }

    //---Getters et Setters--- 
    /** getter de l'attribut superficie de la classe Logement
     * @return superficie: la superficie du logement
     */
    public int getSuperficie(){
        return superficie;
    }

    /** setter de l'attribut superficie de la classe Logement
     * @param superficie la superficie du logement
     */

    public void setSuperficie (int superficie){
        this.superficie = superficie;
    }

    /**getter de l'attribut classeE
     * @return classeE la classe énergétique du logement
     */
    public CE getCE(){
        return classeE;
    }

    /** setter de l'attribut classeE de la classe Logement
     * @param classeE la classe énergétique du logement
     */
    public void setCE (CE classeE){
        this.classeE = classeE;
    }
    
    //---Fin Getters et Setters---  


    /** Méthode qui permet de retourner les attributs de la classe Logement en chaines de caractères.
     * @return la superficie du logement sa classe énergétique et son impacte.
     */
    @Override
    public String toString(){
        return "Le logement a une superficie de : " + superficie + " m2, la une classe energetique est de type : " + classeE + ". Son impact energetique est de: " + impact + " TCO2eq.";
    }

    /**Méthode statique détaillant sur la console l’empreinte carbone moyenne d’un.e français.e vis-à-vis de son Logement.
     */
    public static void francais(){
        System.out.println("Energie et utilites : 1696 Kg/an. Construction et gros entretien : 675 Kg/an. Equipement des logements : 335 Kg/an. Total : 2706 Kg/an");
    }

    /**Teste si l'utilisateur entre la bonne empreinte carbone
     * @param s  la classe énergétique d’un logement.
     * @return true si cette classe energétique existe, sinon false.
     */
    static public boolean isCE(String s) {
		List<String> ce=Arrays.asList("A","B","C","D","E","F","G");
		return ce.contains(s);
	}

}
