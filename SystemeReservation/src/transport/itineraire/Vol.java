package transport.itineraire;

import java.util.Date;
import java.util.List;

import transport.Arret;
import transport.CieTransport;
import transport.Itineraire;
import transport.MoyenTransport;

public class Vol extends Itineraire {

	public Vol(List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		super(arrets, transport, cie, depart, arrivee);
	}

	@Override
	protected String generateUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}

}
