package service;

import gestion.operations.OperationsAdmin;
import repository.Model;
import repository.model.AvionModel;
import repository.model.CroisiereModel;
import repository.model.TrainModel;

public class SystemeReservation {

	private Model avionModel;
	private Model croisiereModel;
	private Model trainModel;
	
	private OperationsAdmin adminVols;
	private OperationsAdmin adminCroisieres;
	private OperationsAdmin adminTrains;
	
	public SystemeReservation() {
		avionModel = new AvionModel();
		croisiereModel = new CroisiereModel();
		trainModel = new TrainModel();
		
		adminVols = new OperationsAdmin(avionModel);
		adminCroisieres = new OperationsAdmin(croisiereModel);
		adminTrains = new OperationsAdmin(trainModel);
		
		
		
		
		
		avionModel.attach(adminVols);
		croisiereModel.attach(adminCroisieres);
		trainModel.attach(adminTrains);
	}
	
	
	
}
