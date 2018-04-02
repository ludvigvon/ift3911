package admin.operations;

import gestion.ModelCommand;
import repository.Model;

public class ModifyCieCommand extends ModelCommand {

	String id;
	String name, oldname;
	
	public ModifyCieCommand(Model model, String id, String name) {
		super(model);
		this.id = id;
		this.name = name;
	}

	@Override
	public void execute() {
		model.modifyCie(id, name);
	}

	@Override
	public void undo() {
		model.modifyCie(id, oldname);
	}

}
