package admin.operations;

import gestion.ModelCommandWithResult;
import repository.Model;
import transport.Arret;
import transport.arret.Lieu;

public class CreateArretCommand extends ModelCommandWithResult<Arret> {

	String id;
	Lieu ville;
	
	public CreateArretCommand(Model model, Lieu ville) {
		super(model);
		this.ville = ville;		
	}

	@Override
	public void execute() {
		result = model.createArret(ville);
		id = result.getId();
	}

	@Override
	public void undo() {
		model.deleteArret(id);
	}

}
