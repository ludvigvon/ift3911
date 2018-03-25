package gestion;

import repository.Model;

public abstract class ModelCommand implements Command {

	protected Model model;

	public ModelCommand(Model model) {
		this.model = model;
	}
	
	
}
