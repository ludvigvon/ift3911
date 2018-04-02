package admin.operations;

import java.util.Date;
import java.util.List;

import gestion.ModelCommandWithResult;
import repository.Model;
import transport.Arret;
import transport.CieTransport;
import transport.Itineraire;
import transport.MoyenTransport;

public class CreateItineraireCommand extends ModelCommandWithResult<Itineraire> {

	String id;
	List<Arret> arrets;
	MoyenTransport transport;
	CieTransport cie;
	Date depart;
	Date arrivee;

	public CreateItineraireCommand(Model model, String id, List<Arret> arrets, MoyenTransport transport,
			CieTransport cie, Date depart, Date arrivee) {
		super(model);
		this.id = id;
		this.arrets = arrets;
		this.transport = transport;
		this.cie = cie;
		this.depart = depart;
		this.arrivee = arrivee;
	}

	@Override
	public void execute() {
		result = model.createItineraire(id, arrets, transport, cie, depart, arrivee);
	}

	@Override
	public void undo() {
		model.deleteItineraire(id);
	}

}
