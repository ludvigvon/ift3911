package transport.cie;

public class CieAerienneFactorySingleton {
	private static CieAerienneFactorySingleton instance = null;

	protected CieAerienneFactorySingleton() {
	}

	public static CieAerienneFactorySingleton getInstance() {
		if (instance == null) {
			instance = new CieAerienneFactorySingleton();
		}
		return instance;
	}
}
