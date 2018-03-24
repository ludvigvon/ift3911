package transport.cie;

public class CieCroisiereFactorySingleton {
	private static CieCroisiereFactorySingleton instance = null;

	protected CieCroisiereFactorySingleton() {
	}

	public static CieCroisiereFactorySingleton getInstance() {
		if (instance == null) {
			instance = new CieCroisiereFactorySingleton();
		}
		return instance;
	}
}
