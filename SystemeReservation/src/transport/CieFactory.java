package transport;

public abstract class CieFactory {

	public CieTransport CreateCie(String id, String name) {
		return FabricateCie(id, name);
	}

	protected abstract CieTransport FabricateCie(String id, String name);

}
