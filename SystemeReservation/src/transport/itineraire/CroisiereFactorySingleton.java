package transport.itineraire;

public class CroisiereFactorySingleton {
	private static CroisiereFactorySingleton instance = null;

	protected CroisiereFactorySingleton() {
	}

	public static CroisiereFactorySingleton getInstance() {
		if (instance == null) {
			instance = new CroisiereFactorySingleton();
		}
		return instance;
	}
}
