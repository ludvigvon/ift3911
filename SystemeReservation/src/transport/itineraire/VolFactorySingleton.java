package transport.itineraire;

public class VolFactorySingleton {
	private static VolFactorySingleton instance = null;

	protected VolFactorySingleton() {
	}

	public static VolFactorySingleton getInstance() {
		if (instance == null) {
			instance = new VolFactorySingleton();
		}
		return instance;
	}
}
