package gestion;

import java.util.Date;
import java.util.List;

import repository.Model;
import repository.Observer;
import transport.Arret;
import transport.CieTransport;
import transport.Itineraire;
import transport.MoyenTransport;
import transport.arret.Lieu;

public class OperationsAdmin implements Observer {

	private Command cmd;
	private Model model;
		
	public OperationsAdmin(Model model) {
		this.model = model;
	}

	@SuppressWarnings("unchecked")
	public Arret createArret(Lieu ville) {
		cmd = new CreateArretCommand(model, ville);
		cmd.execute();
		return ((ModelCommandWithResult<Arret>)cmd).getResult();
	}

	public void modifyArret(String id, Lieu ville) {
		cmd = new ModifyArretCommand(model, id, ville);
		cmd.execute();
	}
	
	public void deleteArret(String id) {
		model.deleteArret(id);
	}
	
	public CieTransport createCie(String name) {
		return model.createCie(name);
	}
	
	public void modifyCie(String name) {
		model.modifyCie(name);
	}
	
	public void deleteCie(String id) {
		model.deleteCie(id);
	}
	
	public Itineraire createItineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		return model.createItineraire(arrets, transport, cie, depart, arrivee);
	}
	
	public void modifyItineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		model.modifyItineraire(arrets, transport, cie, depart, arrivee);
	}
	
	public void deleteItineraire(String id) {
		model.deleteItineraire(id);
	}
	
	public void undo() {
		if (cmd != null)
			cmd.undo();
		cmd = null;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
