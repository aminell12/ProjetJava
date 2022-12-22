package consoCarbone;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TestConsoCarbone extends ConsoCarbone{
	private ConsoCarbone alim;
	private ConsoCarbone transport;
	private ConsoCarbone bienconso;
	private ConsoCarbone logement;
	private ConsoCarbone services;

	
	@BeforeEach
	public void initElem() {
		logement= new Logement(140,CE.A);
		alim= new Alimentation(0.2,0.35);
		transport= new Transport(Taille.P,15000,5);
		bienconso = new BienConso(2000);
		services= new ServicesPublics();
	}
	
	@AfterEach
	public void deleteElem() {
		logement=null;
		alim=null;
		transport=null;
		bienconso=null;
		services=null;
	}
	
	
	@Test
	void compareTo_MemePoste_returnInt() { //methode test qui compare un impact avec lui meme pour verifier la valuer de retour de compareTo
		int output= alim.compareTo(alim);
		assertEquals(0,output);
	}
	
	
	@Test
	void compareTo_DeuxPoste_returnInt() { //methode test qui compare un impact avec lui meme pour verifier la valuer de retour de compareTo
		int output= alim.compareTo(transport);
		assertEquals(-1,output);
	}
	
	@Test
	public void isNumFloat_word_returnBool() {
		boolean output= isNumFloat("hello");
		assertEquals(false,output);
	}
	
	
	@Test
	public void isNumFloat_float_returnBool() {
		boolean output= isNumFloat("12.3");
		assertEquals(true,output);
	}
	
	@Test
	public void isNumEnt_Int_returnBool() {
		boolean output= isNumEnt("123");
		assertEquals(true,output);
	}
	
	@Test
	public void isNumEnt_NotInt_returnBool() {
		boolean output= isNumEnt("12 hfk 3");
		assertEquals(false,output);
	}
}

