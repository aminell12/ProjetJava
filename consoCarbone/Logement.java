package consoCarbone;
import java.util.Arrays;
import java.util.List;
//import java.util.Scanner;

public class Logement extends ConsoCarbone {
    private int superficie;
    private CE classeE;

    public Logement (){}
    
    public Logement (int superficie, CE classE){ //Constructeur de la classe Logement
        super();
        this.superficie = superficie;
        this.classeE = classE;
        impact = this.classeE.getCE() * this.superficie;
    }

    //---Getters et Setters--- 
    public int getSuperficie(){ //Retourne la sperfécie d'un logement
        return superficie;
    }
    public void setSuperficie (int superficie){ // Initialise la superficie d'un logement
        this.superficie = superficie;
    }

    public CE getCE(){ // Retourne la classe énergétique d'un logement
        return classeE;
    }
    public void setCE (CE classeE){ // Initialise la CE d'un logement
        this.classeE = classeE;
    }
    //---Fin Getters et Setters---  

    @Override
    public String toString(){
        return "Le logement a une superficie de : " + superficie + " m2, la une classe energétique est de type : " + classeE + ". Son impact énergetique est de: " + impact + " TCO2eq.";
    }
    
    public static void français(){ //Méthode statique pour les francais
        System.out.println("Énergie et utilités : 1696 Kg/an. Construction et gros entretien : 675 Kg/an. Équipement des logements : 335 Kg/an. Total : 2706 Kg/an");
    }

    //Teste si l'utilisateur entre la bonne empreinte carbone
    static public boolean isCE(String s) {
		List<String> ce=Arrays.asList("A","B","C","D","E","F","G");
		return ce.contains(s);
	}


    /*
    *       Méthode main propre à la classe Logement. Elle intéragit avec l'utilsateur pour récupérer ses données.
    * 
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
        int superficie;
        String s; 
        empcarbone();
        System.out.print("\n Vous êtes sur le calculateur d'empreinte carbone \n"); 
        System.out.print("\n Nous allons calculer l'impact carbone de votre logement. Pour cela nous avons besoin de certaines informations sur votre domicile \n");
        System.out.print("\n Q1 Quelle est la superficie de votre logement ? (en m2) \n");
        s = scanner.next();
        while (!isNumEnt(s)) { 
        	System.out.println("La superficie entrée n'est pas un nombre entier. \n\nVeuillez entrer la superficie de votre logement (en m2).");
        	s=scanner.next();
        }
        superficie=Integer.valueOf(s);
        System.out.print("\n Q2 Quelle est la classe energetique de votre logement ? (choix : A,B,C,D,E,F,G) \n");
        s = scanner.next();
        while (!isCE(s)) {
        	System.out.print("Cette classe energetique n'existe pas.\n\n Veuillez entrer la classe energetique de votre logement (A,B,C,D,E,F,G).");
        	s=scanner.next();
        }
        Logement logement = new Logement(superficie, CE.valueOf(s));
    	System.out.print("\n L'impact de votre logement de "+logement.superficie+" m2 et de classe energetique "+logement.ce+" est de "+ logement.impact+" TCO2eq.");
        scanner.close();
    }*/
}