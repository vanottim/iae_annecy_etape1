package org.iae.annecy.st1.etape1.model.produit;

import java.util.Iterator;

public class Client {
	
	String nom, prenom, codePromo, numClient;
	
		
	public Client( String numClient, String nom, String prenom, String codePromo) {
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
	public String getCodePromo() {
		return codePromo;
	}
	public void setCodePromo(String codePromo) {
		this.codePromo = codePromo;
	}
	public String getNumClient() {
		return numClient;
	}
	public void setNumClient(String numClient) {
		this.numClient = numClient;
	}
	
	public Client(){
		
	}
	
	public String affiche(){
		return "Num de client : "+ this.getNumClient() + " - Nom : " + this.getNom() +  " - Prenom : "+this.getPrenom() + "Code promotionnel : " + this.getCodePromo()+ "\n\n";
	}
	

	

}
