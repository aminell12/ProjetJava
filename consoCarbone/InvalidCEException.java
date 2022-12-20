package consoCarbone;

public final class InvalidCEException extends Exception{
	public InvalidCEException() {
		super("\nCE invalide. Les CE existants sont A,B,C,D,E,F et G.");
	}
}
