package org.iae.annecy.st1.etape1.model.produit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Annuaire implements Serializable {
	
	public ArrayList<Client> clients = new ArrayList<Client>();

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public Annuaire(ArrayList<Client> clients) {
		super();
		this.clients = clients;
	}
	
	public String affiche(){
		String chaine = "";
		for(Client c : clients){
			chaine = chaine + c.affiche();
		}
		
		return chaine;
	}
	
	public String affiche2(){
		String chaine = "";
		for(Client c : clients){
			chaine = chaine + c.affiche2();
		}
		
		return chaine;
	}
	
	public void ajouterClient(Client c){
		clients.add(c);
	}
	
	public Annuaire(){
		
	}
	
	public Client rechercherClient(String numClient){
		Iterator<Client> it = this.getClients().iterator();
		//Client monClient = new Client();
		while(it.hasNext()){
			Client current = it.next();
			if(current.getNumClient().equals(numClient)){
				return current;
			}
			
		}
		
		return null;
	}
	
	public boolean numExiste(String num) {
		boolean bool = false;
		for (Client c : clients) {
			if (num.equals(c.getNumClient()))
				bool = true;

		}
		return bool;
	}
	
	


}
