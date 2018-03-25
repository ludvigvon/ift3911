package gestion;

import repository.Model;
import transport.arret.Lieu;

public class ModifyArretCommand extends ModelCommand {

	String id;
	Lieu oldVille, newVille;
	
	public ModifyArretCommand(Model model, String id, Lieu ville) {
		super(model);
		this.id = id;
		this.newVille = ville;
	}

	@Override
	public void execute() {
		model.modifyArret(id, newVille);
	}

	@Override
	public void undo() {
		model.modifyArret(id, oldVille);
	}

}
