package consoCarbone;

public final class InvalidBooleanException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidBooleanException() {
		super("\nRéponse invalide. Si vous possédez une voiture entrez Oui, sinon entrez Non.");
	}

}
