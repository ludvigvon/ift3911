package transport;

public class GareFactorySingleton {
	private static GareFactorySingleton instance = null;

	protected GareFactorySingleton() {
	}

	public static GareFactorySingleton getInstance() {
		if (instance == null) {
			instance = new GareFactorySingleton();
		}
		return instance;
	}
}
