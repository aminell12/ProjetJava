package consoCarbone;

public final class InvalidBooleanException extends Exception{

	public InvalidBooleanException() {
		super("\nRéponse invalide. Si vous possédez une voiture entrez Oui, sinon entrez Non.");
	}

}
