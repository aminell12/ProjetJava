package consoCarbone;


//j'ai enlevé l'abstraction psk j'en avais besoin pour la gestion d'erreur mais je trouverai quoi faire pour ne plus avoir d'erreurs (psk c'est vraiment le bordel quand c'est abstratit y 62 warnings ou erreurs)
public class ConsoCarbone implements Comparable<ConsoCarbone> {   // je déclare la classe Consocarbone en tant que classe abstaite car elle est étendue par plusieurs classes.
                                        //J'implémente l'interface comparable pour poiuvoir comparé l'impact carbone de deux instances différentes
    private final int ID;
    private static int cptID;
    protected double impact; //Attribut Impact commun à toutes les classes filles, il est donc placé dans la classe mère

    public ConsoCarbone(){//Constructeur de la classe ConsoCarbone
        cptID ++;
        ID = cptID;
    }

    //---Getters---
    public int getID(){
        return ID;
    }
    
    public double getImpact(){//Retourne la valeur de l'impact énergétique 
        return this.impact;
    }
    //---Fin Getters---

    //Teste si l'élément entré par l'utilisateur est un entier
    static public boolean isNumEnt(String s) {
		String digits="0123456789";
		for (int i=0; i<s.length();i++) {
			if (digits.indexOf(s.charAt(i))==-1) return false;
		}
		return true;
	}

    //Teste si l'élément entré par l'utilisateur est un flottant  
    static public boolean isNumFloat(String s) {
    	String digits="0123456789";
    	int nbvirgule=0;
		for (int i=0; i<s.length();i++) {
			if (s.charAt(i)=='.') {
				if (nbvirgule==0) nbvirgule++;
				else return false;
			}
			else 
			if (digits.indexOf(s.charAt(i))==-1) return false;
		}
		return true;
	}

    public int compareTo(ConsoCarbone inst){
  	   if (impact==inst.impact) return 0;
  	   if (impact<inst.impact) return -1;
  	   return 1;
      };
    

}
