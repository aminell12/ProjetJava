package consoCarbone;
//import java.util.Scanner;

    public final class Alimentation extends ConsoCarbone {
        private double txBoeuf;
        private double txVege;

        public static final double c1 = 8;
        public static final double c2 = 1.6;
        public static final double c3 = 0.9;

        public Alimentation() {}
        
        public Alimentation( double txBoeuf, double txVege){ //Constructeur de la classe Alimentation
            super();
            this.txBoeuf = txBoeuf;
            this.txVege = txVege;
            impact = (c1*this.txBoeuf) + (c2*(1-this.txVege-this.txBoeuf))+c3*this.txVege;
        }

        //---Getters et Setters---
        public double getTxBoeuf(){ //Retourne le taux Boeuf
            return txBoeuf;
        }
        public void setTxboeuf ( double txBoeuf ){  //Initialise le taux d'un repas à base de Boeuf et vérifie la valeur
            if (0<txBoeuf && txBoeuf <1) {
                this.txBoeuf = txBoeuf;
                this.impact=c1*txBoeuf+c2*(1-txVege-txBoeuf)+c3*txVege;//Mise à jour de l'impact lorsque les taux changent
            }
            else {
                System.out.println("Erreur le taux doit être compris entre 0 et 1.");
            }
        }

        public double getTxVege(){ //Retourne le taux Végétarien
            return txVege;
        }
        public void setTxVege (double txVege){ //Initialise le taux d'un repas Végétarien et vérifie la valeur
            if (0<txVege && txVege <1) {
                this.txVege = txVege;
                this.impact=c1*txBoeuf+c2*(1-txVege-txBoeuf)+c3*txVege; //Mise à jour de l'impact lorsque les taux changent
            }
            else {
                System.out.println("Erreur le taux doit être compris entre 0 et 1.");
            }
        }
        //---fin Getters et Setters---  


        @Override
        public String toString(){
            return "Le taux de repas est de : " + (this.txBoeuf+this.txVege )+". L'impact energétique est de : "+ this.impact +" TCO2eq."; //faux affichage revoir cette partie
        }

        public static void francais(){//Méthode statique pour les francais
            System.out.println("Viandes et poisson : 1144 Kg/an. Produits laitiers et oeufs : 408 Kg/an. Autres : 538 Kg/an. Boisson : 263 Kg/an. Total : 2353 Kg/an");
        }
        
        public int compareTo(ConsoCarbone inst) {
     	   if (impact==inst.impact) return 0;
     	   if (impact<inst.impact) return -1;
     	   return 1;
         }



        /*
	 *       Méthode main propre à la classe Alimentation. Elle intéragit avec l'utilsateur pour récupérer ses données.
	 * 
	 * public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
        int nbboeuf;
        int nbvege;
        String s; 
        empcarbone();
        System.out.print("\n Vous etes sur le calculateur d'empreinte carbone \n"); 
        System.out.print("\n Nous allons calculer l'impact carbone de votre alimentation. Pour cela nous avons besoin de certaines informations sur votre alimentation \n");
        System.out.print("\n Q1 Combien de plats à base de boeuf mangez-vous par an? \n");
        s = scanner.next();
        while ((isNumEnt(s)==false) || ((int)Integer.valueOf(s)>365)) { 
        	System.out.println("La nombre entré n'est pas un nombre entier ou est supérieur au nombre de jours dans l'année. \n\nVeuillez entrer le nombre de repas à base de boeuf consommés par an.\n");
        	s=scanner.next();
        }
        nbboeuf=Integer.valueOf(s);
        System.out.print("\n Q2 Combien de plats à base d'aliments végétariens mangez-vous par an? \n");
        s = scanner.next();
        while ((!isNumEnt(s)) || (Integer.valueOf(s)>365)) {
        	System.out.print("La nombre entré n'est pas un nombre entier ou est supérieur au nombre de jours dans l'année. \n\nVeuillez entrer le nombre de repas à base d'aliments vegetariens consommés par an.\n");
        	s=scanner.next();
        }
        nbvege=Integer.valueOf(s);
        Alimentation alim = new Alimentation(nbboeuf/365., nbvege/365.);
    	System.out.print("\n Votre taux de consommation de boeuf est de "+alim.txBoeuf+" et celui d'aliments vegetariens est "+alim.txVege+". L'impact de votre alimentation est de "+ alim.impact+" TCO2eq.");
    	scanner.close();
    }*/
    }
