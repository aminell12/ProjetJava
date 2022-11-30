package consoCarbone;

public enum Taille {
    P(4.2),
    G(19);

    private double emission;

    private Taille (double emission){
        this.emission = emission;
    }
    //---Getter---
    public double getEmission(){
        return emission;
    }
    
}
