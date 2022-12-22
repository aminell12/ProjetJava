package consoCarbone;

public final class InvalidCEException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCEException() {
		super("\nCE invalide. Les CE existants sont A,B,C,D,E,F et G.");
	}
}
