package consoCarbone;

public final class InvalidRateException extends Exception{

	public InvalidRateException() {
		super("\nTaux invalide. Les taux de consommation doivent être entre 0 et 1.");
	}

}
