package transport.itineraire;

public class TrajetFactorySingleton {
	private static TrajetFactorySingleton instance = null;

	protected TrajetFactorySingleton() {
	}

	public static TrajetFactorySingleton getInstance() {
		if (instance == null) {
			instance = new TrajetFactorySingleton();
		}
		return instance;
	}
}
