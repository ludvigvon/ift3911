package transport.itineraire;

import java.util.Date;
import java.util.List;

import transport.arret.Arret;
import transport.cie.CieTransport;
import transport.moyen.MoyenTransport;

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
	protected Itineraire FabricateItineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie,
			Date depart, Date arrivee) {
		return new Croisiere(arrets, transport, cie, depart, arrivee);
	}

}
