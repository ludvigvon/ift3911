package transport;

public class PortFactory extends ArretFactory {

	@Override
	public Arret FabricateArret(Lieu ville) {
		return new Port(ville);
	}

}
