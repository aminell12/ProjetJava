package TestJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import consoCarbone.*;


class TestAlimentation extends ConsoCarbone {
	
	private ConsoCarbone alimentaion;
	
	@BeforeEach
	public void initElem() {
		alimentaion= new Alimentation(0.7,0.3);
	}
	
	@AfterEach
	public void deleteElem() {
		alimentaion=null;
	}
	
	
	@Test
	//teste si la méthode getTxBoeuf renvoie le bon taux  
	void getTxboeuf_txBoeuf_returndouble() {
		double output= ((Alimentation )alimentaion).getTxBoeuf();
		assertEquals(0.7,output);
	}
	
	@Test
	//teste si la méthode getTxVege renvoie le bon taux
	void getTxboeuf_txvege_returndouble() {
		double output= ((Alimentation )alimentaion).getTxVege();
		assertEquals(0.3,output);
	}
}
