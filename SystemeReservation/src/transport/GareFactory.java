package transport;

public class GareFactory extends ArretFactory {

	@Override
	public Arret FabricateArret(Lieu ville) {
		return new Gare(ville);
	}

}
