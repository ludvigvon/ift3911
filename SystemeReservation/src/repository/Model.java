package repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	protected List<Arret> arrets = new ArrayList<Arret>();
	protected List<CieTransport> compagnies = new ArrayList<CieTransport>();
	protected List<Itineraire> itineraires = new ArrayList<Itineraire>();

	protected ArretFactory arretFactory;
	protected CieFactory cieFactory;
	protected ItineraireFactory itineraireFactory;

	
	
	public Model() {
		loadModel();
	}

	protected abstract void loadModel();
	
	public Optional<Arret> getArret(String id){
		return arrets.stream().filter(a -> a.getId().equals(id)).findFirst();
	}
	
	public Arret createArret(String id, Lieu ville) {
		Arret arret = arretFactory.CreateArret(id, ville);
		arrets.add(arret);

		notifyObservers();

		return arret;
	}

	public void modifyArret(String id, Lieu ville) {
		getArret(id).ifPresent(a -> a.ville = ville);
		
		notifyObservers();
	};

	public void deleteArret(String id) {
		getArret(id).ifPresent(a -> arrets.remove(a));
		
		notifyObservers();
	};

	public CieTransport createCie(String id, String name) {
		CieTransport cie = cieFactory.CreateCie(id, name);
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

	public Optional<Itineraire> getItineraire(String id){
		return itineraires.stream().filter(a -> a.getId().equals(id)).findFirst();
	}
	
	public List<Itineraire> getItineraires(String cieName){
		return itineraires.stream().filter(a -> a.cie.name == cieName).collect(Collectors.toList());
	}
	
	public Itineraire createItineraire(String id, List<Arret> arrets, MoyenTransport transport, CieTransport cie, Date depart, Date arrivee) {
		Itineraire itineraire = itineraireFactory.CreateItineraire(id, arrets, transport, cie, depart, arrivee);
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
