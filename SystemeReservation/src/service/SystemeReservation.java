package service;

import admin.operations.OperationsAdmin;
import client.operations.OperationsClient;
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
	
	private OperationsClient clientVols;
	private OperationsClient clientCroisieres;
	private OperationsClient clientTrains;
	
	public SystemeReservation() {
		avionModel = new AvionModel();
		croisiereModel = new CroisiereModel();
		trainModel = new TrainModel();
		
		adminVols = new OperationsAdmin(avionModel);
		adminCroisieres = new OperationsAdmin(croisiereModel);
		adminTrains = new OperationsAdmin(trainModel);
				
		clientVols = new OperationsClient(avionModel);
		clientCroisieres = new OperationsClient(croisiereModel);
		clientTrains = new OperationsClient(trainModel);
		
		avionModel.attach(adminVols);
		croisiereModel.attach(adminCroisieres);
		trainModel.attach(adminTrains);
		
		avionModel.attach(clientVols);
		croisiereModel.attach(clientCroisieres);
		trainModel.attach(clientTrains);
	}
	
	public OperationsAdmin getAdminVols() {
		return adminVols;
	}

	public OperationsAdmin getAdminCroisieres() {
		return adminCroisieres;
	}

	public OperationsAdmin getAdminTrains() {
		return adminTrains;
	}

	public OperationsClient getClientVols() {
		return clientVols;
	}

	public OperationsClient getClientCroisieres() {
		return clientCroisieres;
	}

	public OperationsClient getClientTrains() {
		return clientTrains;
	}

	
}
