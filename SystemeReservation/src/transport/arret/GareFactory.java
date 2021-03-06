package transport.arret;

import transport.Arret;
import transport.ArretFactory;

public class GareFactory extends ArretFactory {

	private static GareFactory instance = null;

	protected GareFactory() {
	}

	public static GareFactory getInstance() {
		if (instance == null) {
			instance = new GareFactory();
		}
		return instance;
	}
	
	@Override
	public Arret FabricateArret(String id, Lieu ville) {
		return new Gare(id, ville);
	}

}
