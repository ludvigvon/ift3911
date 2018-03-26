package transport;

public abstract class CieTransport {
	protected String id;
	public String name;

	public CieTransport(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
}
