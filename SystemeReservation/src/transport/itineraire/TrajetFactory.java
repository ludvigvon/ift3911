package transport.itineraire;

import java.util.Date;
import java.util.List;

import transport.arret.Arret;
import transport.cie.CieTransport;
import transport.moyen.MoyenTransport;

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
	protected Itineraire FabricateItineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie,
			Date depart, Date arrivee) {
		return new Trajet(arrets, transport, cie, depart, arrivee);
	}

}
