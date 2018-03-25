package transport.itineraire;

import java.util.Date;
import java.util.List;

import transport.Arret;
import transport.CieTransport;
import transport.Itineraire;
import transport.ItineraireFactory;
import transport.MoyenTransport;

public class VolFactory extends ItineraireFactory {

	private static VolFactory instance = null;

	protected VolFactory() {
	}

	public static VolFactory getInstance() {
		if (instance == null) {
			instance = new VolFactory();
		}
		return instance;
	}

	@Override
	protected Itineraire FabricateItineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie,
			Date depart, Date arrivee) {
		return new Vol(arrets, transport, cie, depart, arrivee);
	}

}
