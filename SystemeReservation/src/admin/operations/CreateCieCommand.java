package admin.operations;

import gestion.ModelCommandWithResult;
import repository.Model;
import transport.CieTransport;

public class CreateCieCommand extends ModelCommandWithResult<CieTransport> {

	String id;
	String name;
	
	public CreateCieCommand(Model model, String id, String name) {
		super(model);
		this.id = id;
		this.name = name;
	}

	@Override
	public void execute() {
		result = model.createCie(id, name);
	}

	@Override
	public void undo() {
		model.deleteCie(id);
	}

}
