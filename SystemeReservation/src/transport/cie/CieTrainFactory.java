package transport.cie;

public class CieTrainFactory extends CieFactory {

	@Override
	protected CieTransport FabricateCie(String name) {
		return new CieTrain(name);
	}

}
