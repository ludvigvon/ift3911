package transport.cie;

public class CieCroisiereFactory extends CieFactory {

	private static CieCroisiereFactory instance = null;

	protected CieCroisiereFactory() {
	}

	public static CieCroisiereFactory getInstance() {
		if (instance == null) {
			instance = new CieCroisiereFactory();
		}
		return instance;
	}
	
	@Override
	protected CieTransport FabricateCie(String name) {
		return new CieCroisiere(name);
	}

}
