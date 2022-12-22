package consoCarbone;

public final class InvalidSizeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidSizeException() {
		super("\nLa taille entrée est incorrecte. Si la voiture référencée est grande, entrez G, si elle est petite, entrez P.");
	}

}
