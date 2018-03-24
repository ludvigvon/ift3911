package transport.cie;

public class CieCroisiereFactory extends CieFactory {

	@Override
	protected CieTransport FabricateCie(String name) {
		return new CieCroisiere(name);
	}

}
