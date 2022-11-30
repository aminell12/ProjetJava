package consoCarbone;

public class BienConso extends ConsoCarbone{
    private double montant;


    public BienConso(){}

    public BienConso(double montant){ //Constructeur de la classe BienConso
        super();
        this.montant = montant;
        impact = this.montant/1750;
    }

    //---Getters et Setters---   
    public double getMontant(){ //Retourne le montant
        return this.montant;
    }
    public void setMontant (double montant){ //Initialise le montant
        this.montant = montant;
        impact = this.montant/1750; // Mise à jour de l'impact lorsque le montant change
    } 
    //---Fin Getters et Setters---  

    @Override
    public String toString(){
        return "Le montant de la consommation des biens est de : " + montant + ". Son impact est de " + impact+".";
    }
    
    public static void francais(){//Méthode statique pour les francsais
        System.out.println("Achat et usages internet et technologies : 1180 Kg/an. Autres biens et services : 682 Kg/an. Habillement : 763 Kg/an. Total : 2625 Kg/an");
    }
}
