package transport;

import java.util.Date;
import java.util.List;

public abstract class ItineraireFactory {

	public Itineraire CreateItineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		return FabricateItineraire(arrets, transport, cie, depart, arrivee);
	}

	protected abstract Itineraire FabricateItineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee);
}
