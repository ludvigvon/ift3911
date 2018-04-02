package admin.operations;

import gestion.ModelCommand;
import repository.Model;

public class DeleteCieCommand extends ModelCommand {

	String id;
	String name;
	
	public DeleteCieCommand(Model model, String id) {
		super(model);
		this.id = id;
	}

	@Override
	public void execute() {
		model.getCie(id).ifPresent(a -> this.name = a.name);
		model.deleteArret(id);
	}

	@Override
	public void undo() {
		if (name != null)
			model.createCie(id, name);
	}

}
