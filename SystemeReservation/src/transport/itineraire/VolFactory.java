package transport.itineraire;

import java.util.Date;
import java.util.List;

import transport.arret.Arret;
import transport.cie.CieTransport;
import transport.moyen.MoyenTransport;

public class VolFactory extends ItineraireFactory {

	@Override
	protected Itineraire FabricateItineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie,
			Date depart, Date arrivee) {
		return new Vol(arrets, transport, cie, depart, arrivee);
	}

}
