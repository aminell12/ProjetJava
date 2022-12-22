package consoCarbone;

public final class InvalidRateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidRateException() {
		super("\nTaux invalides. Les taux de consommation doivent être entre 0 et 1 et doivent avoir une somme inférieure à 1.");
	}

}
