package transport.arret;

public class AeroportFactory extends ArretFactory {

	@Override
	public Arret FabricateArret(Lieu ville) {
		return new Aeroport(ville); 
	}

}
