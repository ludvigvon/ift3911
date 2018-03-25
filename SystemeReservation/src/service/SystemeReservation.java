package service;

import gestion.OperationsAdmin;
import repository.AvionModel;
import repository.CroisiereModel;
import repository.Model;
import repository.TrainModel;

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
