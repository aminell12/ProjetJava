package paquet;

public class InvalidSizeException extends Exception {

	public InvalidSizeException() {
		super("\nLa taille entrée est incorrecte. Si la voiture référencée est grande, entrez G, si elle est petite, entrez P.");
	}

}
