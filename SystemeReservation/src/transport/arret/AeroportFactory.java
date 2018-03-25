package transport.arret;

import transport.Arret;
import transport.ArretFactory;

public class AeroportFactory extends ArretFactory {

	private static AeroportFactory instance = null;

	protected AeroportFactory() {
	}

	public static AeroportFactory getInstance() {
		if (instance == null) {
			instance = new AeroportFactory();
		}
		return instance;
	}
	
	@Override
	public Arret FabricateArret(Lieu ville) {
		return new Aeroport(ville); 
	}

}
