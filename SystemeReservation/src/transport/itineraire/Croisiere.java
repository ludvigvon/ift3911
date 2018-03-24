package transport.itineraire;

import java.util.Date;
import java.util.List;

import transport.arret.Arret;
import transport.cie.CieTransport;
import transport.moyen.MoyenTransport;

public class Croisiere extends Itineraire {

	public Croisiere(List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		super(arrets, transport, cie, depart, arrivee);
	}

	@Override
	protected String generateUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}

}
