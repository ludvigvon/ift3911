package client.operations;

import repository.Model;
import repository.Observer;

public class OperationsClient implements Observer {

	private Model model;
	
	public OperationsClient(Model model) {
		this.model = model;
	}
	
	@Override
	public void update() {
		// TODO shared model has been modified. make necessary changes to synchronize view. 

	}

}
