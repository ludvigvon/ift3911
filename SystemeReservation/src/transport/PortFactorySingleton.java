package transport;

public class PortFactorySingleton {
	private static PortFactorySingleton instance = null;

	protected PortFactorySingleton() {
	}

	public static PortFactorySingleton getInstance() {
		if (instance == null) {
			instance = new PortFactorySingleton();
		}
		return instance;
	}
}
