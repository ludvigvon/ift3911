package transport.cie;

public class CieTrainFactorySingleton {
	private static CieTrainFactorySingleton instance = null;

	protected CieTrainFactorySingleton() {
	}

	public static CieTrainFactorySingleton getInstance() {
		if (instance == null) {
			instance = new CieTrainFactorySingleton();
		}
		return instance;
	}
}
