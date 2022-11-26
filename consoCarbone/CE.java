package consoCarbone;

public enum CE {   
    // Initialisation des classes énergétiques pour chaque classe    
    A(0.005),
    B(0.01), 
    C(0.02), 
    D(0.035),
    E(0.055),
    F(0.08),
    G(0.1); 

    private final double alpha; 

    private CE (double alpha){
        this.alpha = alpha;
    }
    public double getCE(){ //Initialise la classe énergétique
        return alpha;
    }
    
}
