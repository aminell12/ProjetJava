package consoCarbone;

public final class InvalidBooleanException extends Exception{

	public InvalidBooleanException() {
		super("\nRéponse invalide. Si vous possédez une voiture entrez 1, sinon entrez 0.");
	}

}
