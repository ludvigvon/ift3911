package transport;

public class AeroportFactorySingleton {
	private static AeroportFactorySingleton instance = null;

	protected AeroportFactorySingleton() {}

	public static AeroportFactorySingleton getInstance() {
		if (instance == null) {
			instance = new AeroportFactorySingleton();
		}
		return instance;
	}
}
