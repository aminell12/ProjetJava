package TestJUnit;
import consoCarbone.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TestLogement extends ConsoCarbone{
    private ConsoCarbone logement;

    @BeforeEach
    public void initElem() {
		logement= new Logement(50,CE.B);
	}
    
    @AfterEach
	public void deleteElem() {
		logement=null;
	}

    @Test
    //teste si la méthode getSuperficie renvoie la bonne superficie  
    public void getSuperficie_Superficie_returnInt(){
        int output = ((Logement) logement).getSuperficie();
        assertEquals(50, output);
    }

    @Test
    //teste si la méthode getCE renvoie la bonne classe enérgétique   
    public void getCE_CE_returnCE(){
        CE output = ((Logement) logement).getCE();
        assertEquals(CE.B, output);
    }

    @Test
    //teste si la méthode isCE renvoie bien true quand l'utilisateur entre une bonne CE 
    public void isCE_CE_returnBoolean(){
        boolean output = Logement.isCE("A");
        assertEquals(true, output);
    }

    @Test
    //teste si la méthode isCE renvoie bien false quand l'utilisateur entre une mauvaise CE
    public void isCE_notCE_returnBoolean(){
        boolean output = Logement.isCE("K");
        assertEquals(false, output);
    }


}

