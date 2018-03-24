package transport.cie;

public abstract class CieTransport {
	protected String Id;
	public String Name;

	public CieTransport(String name) {
		Id = generateUniqueId();
		Name = name;
	}

	abstract protected String generateUniqueId();
}
