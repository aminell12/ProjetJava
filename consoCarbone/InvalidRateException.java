package consoCarbone;

public final class InvalidRateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidRateException() {
		super("\nTaux invalide. Les taux de consommation doivent être entre 0 et 1.");
	}

}
