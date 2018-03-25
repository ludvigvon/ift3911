package gestion;

import repository.Model;

public abstract class ModelCommandWithResult<T> extends ModelCommand {

	public ModelCommandWithResult(Model model) {
		super(model);
	}

	protected T result;

	public T getResult() {
		return result;
	}

}
