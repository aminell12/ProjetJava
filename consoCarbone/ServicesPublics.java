package consoCarbone;

public class ServicesPublics extends ConsoCarbone{  // Je déclare cette classe comme étant un singleton car on a besoin que d'un élément dans cette classe,
                                // l'empreinre carbone des français
                                //REVOIR CETTE CLASSE PARCE QUE TRES FLOU CE QUE J'AI FAIT
                                // FAUT-IL CREER PLUSIEURS INSTANCES POUR CHAQUE SERVICE PUBLIC (Justice, police,éducation) et chaque poste c'est 1,5?? => du coup changer le design pattern parce plus singleton
    private static ServicesPublics instance;
    private double EmpCarbFR;

    public ServicesPublics(){ // Constructeur de la classe ServicesPublics
        EmpCarbFR = 1.5;
    }

    public static ServicesPublics getInstance (double EmpCarbFR ){ //Méthode qui renvoie l'unique instance de la classe ServicesPublics
        if (instance == null){ 
            instance = new ServicesPublics();
        }
        return instance;
    }
    
    
    public double getEmpCarbFR (){ // Retourne l'empreinte carbonne d'un français
        return this.EmpCarbFR;
    }
    
}

