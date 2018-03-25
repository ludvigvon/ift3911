package transport.arret;

public class GareFactory extends ArretFactory {

	private static GareFactory instance = null;

	protected GareFactory() {
	}

	public static GareFactory getInstance() {
		if (instance == null) {
			instance = new GareFactory();
		}
		return instance;
	}
	
	@Override
	public Arret FabricateArret(Lieu ville) {
		return new Gare(ville);
	}

}
