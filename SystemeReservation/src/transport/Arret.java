package transport;

import transport.arret.Lieu;

public abstract class Arret {
	protected String id;
	public Lieu ville;

	public Arret(String id, Lieu ville) {
		this.id = id;
		this.ville = ville;
	}

	public String getId() {
		return id;
	}
}
