package consoCarbone;

/** Alimentation est une classe fille de la classe ConsoCarbonne qui permet le calcul de l'impacte du à l'alimentation grace à des informations sur les repas
 */
    public final class Alimentation extends ConsoCarbone {
    	/*txBoeuf: le taux de repas à base de boeuf
    	 */
        private double txBoeuf;
        /*txVege  represente le taux de repas vegetariens
         */
        private double txVege;

        /** constante facteur de l'attribut txBoeuf pour le calcul de l'impacte.
         */
        public static final double c1 = 8;
        /** constante facteur des repas à base de Volaille pour le calcul de l'impacte.
         */
        public static final double c2 = 1.6;
        /** constante facteur de l'attribut txVege pour le calcul de l'impacte.
         */
        public static final double c3 = 0.9;


       /** Constructeur de la classe Alimentation
        * @param txBoeuf represente le taux de repas à base de viande de boeuf
        * @param txVege  represente le taux de repas vegetariens
        */
        public Alimentation( double txBoeuf, double txVege){ //Constructeur de la classe Alimentation
            super();
            this.txBoeuf = txBoeuf;
            this.txVege = txVege;
            impact = (c1*this.txBoeuf) + (c2*(1-this.txVege-this.txBoeuf))+c3*this.txVege;
        }

        
        
        
        //---Getters et Setters---
        
        /** getter de l'attribut txBoeuf de la classe Alimentation
         * @return txBoeuf: le taux de repas à base de boeuf
         */
        public double getTxBoeuf(){ //Retourne le taux Boeuf
            return txBoeuf;
        }
        /** setter de l'attribut txBoeuf de la classe Alimentation et verifie si le taux est correcte.
         * @param txBoeuf le taux de repas à base de boeuf
         */

        public void setTxboeuf ( double txBoeuf ){
            if (0<txBoeuf && txBoeuf <1) {
                this.txBoeuf = txBoeuf;
                this.impact=c1*txBoeuf+c2*(1-txVege-txBoeuf)+c3*txVege;
            }
            else {
                System.out.println("Erreur le taux doit être compris entre 0 et 1.");
            }
        }
        /**
        * getter de l'attribut txVege de la classe Alimentation
        * @return txVege: le taux de repas végétariens
        */
        public double getTxVege(){
            return txVege;
        }



        /**
         * setter de l'attribut txVege de la classe Alimentation et vérifie si le taux est correcte.
         * @param txVege le taux de repas végetariens
         */
        public void setTxVege (double txVege){
            if (0<txVege && txVege <1) {
                this.txVege = txVege;
                this.impact=c1*txBoeuf+c2*(1-txVege-txBoeuf)+c3*txVege;
            }
            else {
                System.out.println("Erreur le taux doit être compris entre 0 et 1.");
            }
        }
        
        //---Fin Guetters et Setter 

        
        
        
        /** Méthode qui permet de retourner les attributs de la classe Alimentation en chaines de caractères.
         * @return les informations sur Alimentations comme le taux de repas vegétariens, à base de boeuf ou de volaille ou encore leur impacte.
         */
        @Override
        public String toString(){
            return "Le taux de repas à base de Boeuf est de : " + this.txBoeuf+ ", le taux de repas vegetariens est de : "+ this.txVege + " et le taux de repas à base de volaille est de:  " + (1-this.txVege-this.txBoeuf) +". L'impact energétique est de : "+ this.impact +" TCO2eq.";
        }

        /**Méthode statique deétaillant sur la console l’empreinte carbone moyenne d’un.e français.e vis-à-vis de son Alimentation.
         */
        public static void francais(){//Méthode statique pour les francais
            System.out.println("Viandes et poisson : 1144 Kg/an. Produits laitiers et oeufs : 408 Kg/an. Autres : 538 Kg/an. Boisson : 263 Kg/an. Total : 2353 Kg/an");
        }
    }
