package gestion;

import java.util.Date;
import java.util.List;

import repository.Model;
import repository.Observer;
import transport.Arret;
import transport.CieTransport;
import transport.Itineraire;
import transport.MoyenTransport;
import transport.arret.Lieu;

public class OperationsAdmin implements Observer {

	private Model model;
		
	public OperationsAdmin(Model model) {
		this.model = model;
	}

	public Arret createArret(Lieu ville) {
		return model.createArret(ville);
	}

	public void modifyArret(Lieu ville) {
		model.modifyArret(ville);
	}
	
	public void deleteArret(String id) {
		model.deleteArret(id);
	}
	
	public CieTransport createCie(String name) {
		return model.createCie(name);
	}
	
	public void modifyCie(String name) {
		model.modifyCie(name);
	}
	
	public void deleteCie(String id) {
		model.deleteCie(id);
	}
	
	public Itineraire createItineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		return model.createItineraire(arrets, transport, cie, depart, arrivee);
	}
	
	public void modifyItineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		model.modifyItineraire(arrets, transport, cie, depart, arrivee);
	}
	
	public void deleteItineraire(String id) {
		model.deleteItineraire(id);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
