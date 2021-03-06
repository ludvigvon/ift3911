package transport.cie;

import transport.CieFactory;
import transport.CieTransport;

public class CieAerienneFactory extends CieFactory {

	private static CieAerienneFactory instance = null;

	protected CieAerienneFactory() {
	}

	public static CieAerienneFactory getInstance() {
		if (instance == null) {
			instance = new CieAerienneFactory();
		}
		return instance;
	}

	@Override
	protected CieTransport FabricateCie(String id,String name) {
		return new CieAerienne(id, name);
	}

}
