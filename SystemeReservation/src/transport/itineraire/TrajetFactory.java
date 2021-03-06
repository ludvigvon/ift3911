package transport.itineraire;

import java.util.Date;
import java.util.List;

import transport.Arret;
import transport.CieTransport;
import transport.Itineraire;
import transport.ItineraireFactory;
import transport.MoyenTransport;

public class TrajetFactory extends ItineraireFactory {

	private static TrajetFactory instance = null;

	protected TrajetFactory() {
	}

	public static TrajetFactory getInstance() {
		if (instance == null) {
			instance = new TrajetFactory();
		}
		return instance;
	}

	@Override
	protected Itineraire FabricateItineraire(String id, List<Arret> arrets, MoyenTransport transport, CieTransport cie,
			Date depart, Date arrivee) {
		return new Trajet(id, arrets, transport, cie, depart, arrivee);
	}

}
