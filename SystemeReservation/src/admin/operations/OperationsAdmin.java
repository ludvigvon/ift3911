package admin.operations;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import gestion.Command;
import gestion.ModelCommandWithResult;
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
	public Arret createArret(String id, Lieu ville) {
		cmd = new CreateArretCommand(model, id, ville);
		cmd.execute();
		return ((ModelCommandWithResult<Arret>) cmd).getResult();
	}

	public void modifyArret(String id, Lieu ville) {
		cmd = new ModifyArretCommand(model, id, ville);
		cmd.execute();
	}

	public void deleteArret(String id) {
		cmd = new DeleteArretCommand(model, id);
		cmd.execute();
	}

	public Arret getArret(String id) {
		Optional<Arret> arret = model.getArret(id);
		
		if (arret.isPresent())
			return arret.get();
		else
			return null;
	}
	
	public CieTransport createCie(String id, String name) {
		return model.createCie(id, name);
	}

	public void modifyCie(String id, String name) {
		model.modifyCie(id, name);
	}

	public void deleteCie(String id) {
		model.deleteCie(id);
	}

	public CieTransport getCie(String id) {
		Optional<CieTransport> cie = model.getCie(id);
		
		if (cie.isPresent())
			return cie.get();
		else
			return null;
	}
	
	public MoyenTransport getMoyenTransport(String cie, String modele) {
		return model.getMoyenTransport(cie, modele);
	}
	
	public Itineraire createItineraire(String id, List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart,
			Date arrivee) {
		return model.createItineraire(id, arrets, transport, cie, depart, arrivee);
	}

	public void modifyItineraire(String id, List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart,
			Date arrivee) {
		model.modifyItineraire(id, arrets, transport, cie, depart, arrivee);
	}

	public void deleteItineraire(String id) {
		model.deleteItineraire(id);
	}

	public void consulterItineraires(String cieName) {
		List<Itineraire> itineraires = model.getItineraires(cieName);
		for (Itineraire i : itineraires) {
			i.accept(new ConsultationAdminVisitor());
		}		
	}
	
	public void undo() {
		if (cmd != null)
			cmd.undo();
		cmd = null;
	}

	@Override
	public void update() {
		// TODO shared model has been modified. make necessary changes to synchronize view. 

	}

}
