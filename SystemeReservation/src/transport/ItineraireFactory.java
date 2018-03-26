package transport;

import java.util.Date;
import java.util.List;

public abstract class ItineraireFactory {

	public Itineraire CreateItineraire(String id, List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		return FabricateItineraire(id, arrets, transport, cie, depart, arrivee);
	}

	protected abstract Itineraire FabricateItineraire(String id, List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee);
}
