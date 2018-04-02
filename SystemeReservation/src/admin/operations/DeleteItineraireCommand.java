package admin.operations;

import gestion.ModelCommand;
import repository.Model;

public class DeleteItineraireCommand extends ModelCommand {

	String id;
	
	public DeleteItineraireCommand(Model model, String id) {
		super(model);
		this.id = id;
	}

	@Override
	public void execute() {
		model.deleteItineraire(id);
	}

	@Override
	public void undo() {
		// TODO copy values of itineraire before delete and re-create here
	}

}
