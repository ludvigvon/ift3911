package repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import transport.Arret;
import transport.ArretFactory;
import transport.CieFactory;
import transport.CieTransport;
import transport.Itineraire;
import transport.ItineraireFactory;
import transport.MoyenTransport;
import transport.arret.Lieu;

public abstract class Model implements Subject {

	private List<Observer> observers = new ArrayList<Observer>();

	private List<Arret> arrets = new ArrayList<Arret>();
	private List<CieTransport> compagnies = new ArrayList<CieTransport>();
	private List<Itineraire> itineraires = new ArrayList<Itineraire>();

	protected ArretFactory arretFactory;
	protected CieFactory cieFactory;
	protected ItineraireFactory itineraireFactory;

	public Arret createArret(Lieu ville) {
		Arret arret = arretFactory.CreateArret(ville);
		arrets.add(arret);

		notifyObservers();

		return arret;
	}

	public void modifyArret(String id, Lieu ville) {
		Optional<Arret> arret = arrets.stream().filter(a -> a.getId().equals(id)).findFirst();
			
		arret.ifPresent(a -> a.ville = ville);
		
		notifyObservers();
	};

	public void deleteArret(String id) {
		Optional<Arret> arret = arrets.stream().filter(a -> a.getId().equals(id)).findFirst();
		
		arret.ifPresent(a -> arrets.remove(a));
		
		notifyObservers();
	};

	public CieTransport createCie(String name) {
		CieTransport cie = cieFactory.CreateCie(name);
		compagnies.add(cie);

		notifyObservers();

		return cie;
	}

	public void modifyCie(String name) {
		notifyObservers();
	};

	public void deleteCie(String id) {
		notifyObservers();
	};

	public Itineraire createItineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		Itineraire itineraire = itineraireFactory.CreateItineraire(arrets, transport, cie, depart, arrivee);
		itineraires.add(itineraire);
		
		notifyObservers();
		
		return itineraire;
	}

	public void modifyItineraire(List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		notifyObservers();
	};

	public void deleteItineraire(String id) {
		notifyObservers();
	};

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer o : this.observers)
			o.update();
	}

}
