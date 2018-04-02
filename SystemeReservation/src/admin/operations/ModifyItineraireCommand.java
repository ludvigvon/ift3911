package admin.operations;

import java.util.Date;
import java.util.List;

import gestion.ModelCommand;
import repository.Model;
import transport.Arret;
import transport.CieTransport;
import transport.MoyenTransport;

public class ModifyItineraireCommand extends ModelCommand {

	String id;
	List<Arret> arrets; 
	MoyenTransport transport; 
	CieTransport cie; 
	Date depart;
	Date arrivee;
	
	public ModifyItineraireCommand(Model model, String id, List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart,
			Date arrivee) {
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
		model.modifyItineraire(id, arrets, transport, cie, depart, arrivee);
	}

	@Override
	public void undo() {		
		// TODO: save old values before modify and restore on undo with 2nd call to model.modifyItineraire	
	}

}
