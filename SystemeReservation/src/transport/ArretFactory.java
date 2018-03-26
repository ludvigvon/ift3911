package transport;

import transport.arret.Lieu;

public abstract class ArretFactory {

	public Arret CreateArret(String id, Lieu ville) {
		return FabricateArret(id, ville);
	}

	protected abstract Arret FabricateArret(String id, Lieu ville); 
}
