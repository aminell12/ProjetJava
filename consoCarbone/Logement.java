package consoCarbone;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class Logement extends ConsoCarbone {
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
        return "Le logement a une superficie de : " + superficie + " m2, la une classe energetique est de type : " + classeE + ". Son impact energetique est de: " + impact + " TCO2eq.";
    }
    
    public static void francais(){ //Méthode statique pour les francais
        System.out.println("Energie et utilites : 1696 Kg/an. Construction et gros entretien : 675 Kg/an. Equipement des logements : 335 Kg/an. Total : 2706 Kg/an");
    }

    //Teste si l'utilisateur entre la bonne empreinte carbone
    static public boolean isCE(String s) {
		List<String> ce=Arrays.asList("A","B","C","D","E","F","G");
		return ce.contains(s);
	}
    
  /*  public int compareTo(ConsoCarbone inst) {
 	   if (impact==inst.impact) return 0;
 	   if (impact<inst.impact) return -1;
 	   return 1;
     }*/


    
    //       Méthode main propre à la classe Logement. Elle intéragit avec l'utilsateur pour récupérer ses données.
    
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
        int superficie;
        String s=""; 
        boolean succes=false;
        francais();
        System.out.print("\n Vous êtes sur le calculateur d'empreinte carbone \n"); 
        System.out.print("\n Nous allons calculer l'impact carbone de votre logement. Pour cela nous avons besoin de certaines informations sur votre domicile \n");
        System.out.print("\n Q1 Quelle est la superficie de votre logement ? (en m2) \n");
        while (!succes) {
        	try {
        		s = scanner.next();
        		superficie=Integer.parseInt(s);
        		succes=true;
        	}
        	catch (NumberFormatException e) {
        		System.out.println("\nLa valeur entrée n'est pas un nombre entier. Veuillez entrer la superficie de votre logement.");
        	}
        }
        superficie=Integer.parseInt(s);
        System.out.print("\n Q2 Quelle est la classe energetique de votre logement ? (choix : A,B,C,D,E,F,G) \n");
        succes=false;
        while (!succes) {
        	try {
        		s = scanner.next();
        		if (!Arrays.asList("A","B","C","D","E","F","G").contains(s)) {
        			throw new InvalidCEException();
        		}
        		succes=true;
        	}
        	catch (InvalidCEException e) {
        		System.out.println(e.getMessage());
;        	} 
        }
        Logement logement = new Logement(superficie, CE.valueOf(s));
    	System.out.print("\n L'impact de votre logement de "+logement.superficie+" m2 et de classe energetique "+logement.classeE+" est de "+ logement.impact+" TCO2eq.");
        scanner.close();
    
	}
}



/*

//pour test tous les nombres entiers
succes=false; //si la varibale a été utilisée auparavant et est true
while (!succes) {
try {
	s = scanner.next();
	superficie=Integer.parseInt(s);
	succes=true;
}
catch (NumberFormatException e) {
	System.out.println("\nLa valeur entrée n'est pas un nombre entier. Veuillez entrer la superficie de votre logement.");
}
}



//pour les taux de vege/viandes etc
succes=false; //si la varibale a été utilisée auparavant et est true
while (!succes) {
        	try {
        		s = scanner.next();
        		taux=Double.parseDouble(s); //parametre a changer en fonction du cas 
        		if(taux>1 || taux<0) throw new InvalidRateException();
        		succes=true;
        	}
        	catch (NumberFormatException e) {
        		System.out.println("\nLa valeur entrée n'est pas un nombre. Veuillez entrer ....");
        	}
        	
        }
 
 
 
 //pour la taille des voitures 
     succes=false; //si la varibale a été utilisée auparavant et est true
     while (!succes) {
        	try {
        		s = scanner.next();
        		if (!Arrays.asList("G","P").contains(s)) {
        			throw new InvalidSizeException();
        		}
        		succes=true;
        	}
        	catch (InvalidSizeException e) {
        		System.out.println(e.getMessage());
        	} 
        }
 

//pour la propriété d'une voiture
 
     succes=false; //si la varibale a été utilisée auparavant et est true
     while (!succes) {
        	try {
        		s = scanner.next();
        		if (!Arrays.asList("T","F").contains(s)) {
        			throw new InvalidBooleanException();
        		}
        		succes=true;
        	}
        	catch (InvalidSizeException e) {
        		System.out.println(e.getMessage());
        	} 
     }
     if (s=="T") possede=true;
     else possede=false;
        
  */
