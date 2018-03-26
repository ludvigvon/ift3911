package transport.itineraire;

import java.util.Date;
import java.util.List;

import transport.Arret;
import transport.CieTransport;
import transport.Itineraire;
import transport.MoyenTransport;

public class Trajet extends Itineraire {

	public Trajet(String id, List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		super(id, arrets, transport, cie, depart, arrivee);
	}

}
