package consoCarbone;

public class InvalidCEException extends Exception{

	
	public InvalidCEException() {
		super("\nCE invalide. Les CE existants sont A,B,C,D,E,F et G.");
	}

}
