package transport.cie;

public class CieTrainFactory extends CieFactory {

	private static CieTrainFactory instance = null;

	protected CieTrainFactory() {
	}

	public static CieTrainFactory getInstance() {
		if (instance == null) {
			instance = new CieTrainFactory();
		}
		return instance;
	}
	
	@Override
	protected CieTransport FabricateCie(String name) {
		return new CieTrain(name);
	}

}
