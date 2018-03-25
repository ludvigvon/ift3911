package transport;

import java.util.Date;
import java.util.List;

public abstract class Itineraire {
	public String id;
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

	abstract protected String generateUniqueId();

}
