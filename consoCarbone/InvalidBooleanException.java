package consoCarbone;

public class InvalidBooleanException extends Exception{

	public InvalidBooleanException() {
		super("\nRéponse invalide. Si vous possédez une voiture entrez T, sinon entrez F.");
	}

}
