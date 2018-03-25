package transport.cie;

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
	protected CieTransport FabricateCie(String name) {
		return new CieAerienne(name);
	}

}
