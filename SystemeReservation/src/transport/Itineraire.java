package transport;

import java.util.Date;
import java.util.List;

import gestion.ItineraireVisitable;
import gestion.ItineraireVisitor;

public abstract class Itineraire implements ItineraireVisitable {
	private String id;
	public List<Arret> arrets;
	public MoyenTransport transport;
	public CieTransport cie;
	public Date depart;
	public Date arrivee;

	public Itineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		this.id = generateUniqueId();
		this.arrets = arrets;
		this.transport = transport;
		this.cie = cie;
		this.depart = depart;
		this.arrivee = arrivee;
	}

	public String getId() {
		return this.id;
	}
	
	abstract protected String generateUniqueId();

	@Override
	public void accept(ItineraireVisitor visitor) {
		visitor.visit(this);
	}

}
