package transport;

import transport.arret.Lieu;

public abstract class Arret {
	protected String id;
	public Lieu ville;

	public Arret(Lieu ville) {
		this.ville = ville;
		this.id = generateUniqueId();
	}	
	
	protected abstract String generateUniqueId();
}

