package consoCarbone;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


class TestTransport extends ConsoCarbone {
	
	private ConsoCarbone transport;
	
	@BeforeEach
	public void initElem() {
		transport= new Transport(Taille.P,15000,5);
	}
	
	@AfterEach
	public void deleteElem() {
		transport=null;
	}
	
	
	@Test
	void isTaille_PorG_returnBool() {
		boolean output= Transport.isTaille("P");
		assertEquals(true,output);
	}
	
	@Test
	void isTaille_notPnorG_returnBool() {
		boolean output= Transport.isTaille("Q");
		assertEquals(false,output);
	}
}
