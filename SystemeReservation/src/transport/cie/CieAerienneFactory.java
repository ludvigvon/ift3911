package transport.cie;

public class CieAerienneFactory extends CieFactory {

	@Override
	protected CieTransport FabricateCie(String name) {
		return new CieAerienne(name);
	}

}
