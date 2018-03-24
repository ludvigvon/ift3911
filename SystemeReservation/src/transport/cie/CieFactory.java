package transport.cie;

public abstract class CieFactory {

	public CieTransport CreateCie(String name) {
		return FabricateCie(name);
	}

	protected abstract CieTransport FabricateCie(String name);

}
