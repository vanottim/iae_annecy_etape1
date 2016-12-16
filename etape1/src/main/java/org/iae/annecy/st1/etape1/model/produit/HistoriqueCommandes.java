package org.iae.annecy.st1.etape1.model.produit;

import java.util.ArrayList;

public class HistoriqueCommandes {
	
	public ArrayList<Commande> commandes = new ArrayList<Commande>();
	public Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ArrayList<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(ArrayList<Commande> commandes) {
		this.commandes = commandes;
	}

	public HistoriqueCommandes(){
	}
	
	public void ajouterCommande(Commande co){
		this.getCommandes().add(co);
		
	}
	
	public String afficherCommandes(){
		String chaine = "";
		for(Commande c : commandes){
			chaine = chaine + c.affiche2();
		}
		
		return chaine;
	}
	
	public String afficherProduitsAchetés(){
		String chaine = "";
		for(Commande c : commandes){
			chaine = chaine + c.affiche2();
		}
		return chaine;
		
	}
	
	
}
