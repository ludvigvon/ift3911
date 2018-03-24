package transport.cie;

public abstract class CieTransport {
	protected String id;
	public String name;

	public CieTransport(String name) {
		this.name = name;
		this.id = generateUniqueId();
	}

	abstract protected String generateUniqueId();
}
