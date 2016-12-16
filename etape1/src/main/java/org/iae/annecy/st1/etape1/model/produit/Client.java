package org.iae.annecy.st1.etape1.model.produit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class Client implements Serializable {
	
	private String nom, prenom, numClient;
	private int codePromo;
	private Commande commandeEnCours;
	private double reduction = 0;
	private HistoriqueCommandes historiqueCommandes; 
	
	
	public HistoriqueCommandes getHistoriqueCommandes() {
		return historiqueCommandes;
	}
	public void setHistoriqueCommandes(HistoriqueCommandes historiqueCommandes) {
		this.historiqueCommandes = historiqueCommandes;
		historiqueCommandes.setClient(this);
	}
	
	public void ajouterCommandeHistorique(Commande c){
		this.historiqueCommandes.ajouterCommande(c);
	}
	
	public double getReduction() {
		return reduction;
	}
	public void setReduction(double reduction) {
		this.reduction = reduction;
	}
	public Commande getCommande() {
		return commandeEnCours;
	}
	public void setCommande(Commande commande) {
		this.commandeEnCours = commande;
		commande.setAcheteur(this);
	}

	public Client(){
		
	}
	public Client(String numClient, String nom, String prenom, int codePromo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.codePromo = codePromo;
		this.numClient = numClient;
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getCodePromo() {
		return codePromo;
	}
	public void setCodePromo(int codePromo) {
		this.codePromo = codePromo;
	}
	public String getNumClient() {
		return numClient;
	}
	public void setNumClient(String numClient) {
		this.numClient = numClient;
	}
	

	
	public String affiche(){
		return "Num de client : "+ this.getNumClient() + " - Nom : " + this.getNom() +  " - Prenom : "+this.getPrenom() + "- Code promotionnel : " + this.getCodePromo()+ "\n\n";
	}
	
	public String affiche2(){
		return "Num de client : "+ this.getNumClient() + " - Nom : " + this.getNom() +  " - Prenom : "+this.getPrenom() +" \n";
	}
	
	public void attribuerReduction(int codePromo){
		if(codePromo == 10)
			this.setReduction(0.1);
		else if(codePromo == 25)
			this.setReduction(0.25);
		else if(codePromo == 50)
			this.setReduction(0.50);
	}

	

}
