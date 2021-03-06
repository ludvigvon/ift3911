package transport.cie;

import transport.CieFactory;
import transport.CieTransport;

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
	protected CieTransport FabricateCie(String id,String name) {
		return new CieCroisiere(id, name);
	}

}
