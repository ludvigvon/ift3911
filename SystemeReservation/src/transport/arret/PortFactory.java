package transport.arret;

public class PortFactory extends ArretFactory {
	private static PortFactory instance = null;

	protected PortFactory() {
	}

	public static PortFactory getInstance() {
		if (instance == null) {
			instance = new PortFactory();
		}
		return instance;
	}

	@Override
	public Arret FabricateArret(Lieu ville) {
		return new Port(ville);
	}

}
