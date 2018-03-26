package transport.arret;

import transport.Arret;
import transport.ArretFactory;

public class PortFactory extends ArretFactory {
	private static PortFactory instance = null;

	protected PortFactory() {
	}

	public static PortFactory getInstance() {
		if (instance == null) {
			instance = new PortFactory();
		}
		return instance;
	}

	@Override
	public Arret FabricateArret(String id, Lieu ville) {
		return new Port(id, ville);
	}

}
