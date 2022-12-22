package consoCarbone;

/**  ServicesPublics est une classe fille de la classe ConsoCarbonne représentant le poste de consommation carbone induit par les services publics (justice, police, éducation, santé, ...).
 */
public final class ServicesPublics extends ConsoCarbone{  // Je déclare cette classe comme étant un singleton car on a besoin que d'un élément dans cette classe,
                                // l'empreinre carbone des français
                     
    /** EmpCarbFR represente l'empreinte carbonne d'un francais
     */
    private double EmpCarbFR;

    /* Constructeur de la classe ServicesPublics
     */
    public ServicesPublics(){
        EmpCarbFR = 1.5;
    }


    /** Getter de l'attribut EmpCarbFR
     * @return l'empreinte carbonne d'un français
     */
    public double getEmpCarbFR (){
        return this.EmpCarbFR;
    }
    
    @Override
    public String toString(){
    	return ("L'empreinte carbone des services publics (commune a tous les francais) est de "+EmpCarbFR+"tCO2.");
    }


}
