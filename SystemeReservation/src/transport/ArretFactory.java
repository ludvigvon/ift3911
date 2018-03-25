package transport;

import transport.arret.Lieu;

public abstract class ArretFactory {

	public Arret CreateArret(Lieu ville) {
		return FabricateArret(ville);
	}

	protected abstract Arret FabricateArret(Lieu ville); 
}
