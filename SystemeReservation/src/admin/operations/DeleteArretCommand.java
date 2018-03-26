package admin.operations;

import gestion.ModelCommand;
import repository.Model;
import transport.arret.Lieu;

public class DeleteArretCommand extends ModelCommand {

	String id;
	Lieu ville;

	public DeleteArretCommand(Model model, String id) {
		super(model);
		this.id = id;
	}

	@Override
	public void execute() {
		model.getArret(this.id).ifPresent(a -> this.ville = a.ville);
		model.deleteArret(id);
	}

	@Override
	public void undo() {
		if (ville != null)
			model.createArret(id, this.ville);
	}

}
