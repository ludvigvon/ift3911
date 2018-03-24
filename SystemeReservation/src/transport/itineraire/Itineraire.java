package transport.itineraire;

import java.util.List;

import transport.arret.Arret;
import transport.moyen.MoyenTransport;

public abstract class Itineraire {
	public List<Arret> arrets;
	public MoyenTransport transport;
}
