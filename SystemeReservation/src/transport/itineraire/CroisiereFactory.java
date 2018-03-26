package transport.itineraire;

import java.util.Date;
import java.util.List;

import transport.Arret;
import transport.CieTransport;
import transport.Itineraire;
import transport.ItineraireFactory;
import transport.MoyenTransport;

public class CroisiereFactory extends ItineraireFactory {

	private static CroisiereFactory instance = null;

	protected CroisiereFactory() {
	}

	public static CroisiereFactory getInstance() {
		if (instance == null) {
			instance = new CroisiereFactory();
		}
		return instance;
	}

	@Override
	protected Itineraire FabricateItineraire(String id, List<Arret> arrets, MoyenTransport transport, CieTransport cie,
			Date depart, Date arrivee) {
		return new Croisiere(id, arrets, transport, cie, depart, arrivee);
	}

}
