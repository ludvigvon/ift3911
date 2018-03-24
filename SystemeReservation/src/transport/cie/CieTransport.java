package transport.cie;

public abstract class CieTransport {
	protected String id;
	public String name;

	public CieTransport(String name) {
		this.id = generateUniqueId();
		this.id = name;
	}

	abstract protected String generateUniqueId();
}
