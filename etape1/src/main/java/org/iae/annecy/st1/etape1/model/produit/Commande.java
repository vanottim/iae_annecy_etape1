package org.iae.annecy.st1.etape1.model.produit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.iae.annecy.st1.tools.ConsoleHelper;

import java.util.Set;

public class Commande implements Serializable {
	
	private ArrayList<Produit> produits = new ArrayList<Produit>();
	private String etat = "";
	private double montantTotal=0;
	private Client acheteur;
	
	
	public Client getAcheteur() {
		return acheteur;
	}


	public void setAcheteur(Client acheteur) {
		this.acheteur = acheteur;
	}


	public ArrayList<Produit> getProduits() {
		return produits;
	}


	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}

	public void ajouterProduit (Produit p1, int qte){
		
		this.getProduits().add(p1);
		p1.setQteCommandee(qte);
	}

	public double getMontantTotal() {
		return montantTotal;
	}


	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}
	
	
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	

	

	public String affiche(){
		
		String chaine = "";
		
		for(Produit p : produits){
			
			chaine = chaine + p.afficheAcQte();
		}
		
		return chaine;
	}
	
public String affiche2(){
		
		String chaine = "";
		
		for(Produit p : produits){
			
			chaine = chaine + p.affiche3();
		}
		
		return chaine;
	}
	
	

	public void validerPanier(){
		this.etat = "Envoyee";
		ConsoleHelper.display("Bravo ! Le panier vient de passer à l'état de commande ! Elle sera expédiée dans 3 jours :)\n");
		//this.getAcheteur().getHistoriqueCommandes().ajouterCommande(this);
	}
	
	public double montantTotal(){
		double prix = 0;
		for(Produit p : produits){
			prix = prix + p.getPrix();
		}
		return prix;
	}
	
	public double calculeMontantFinal(){
		double mt = 0;
		for(Produit p : produits){
			mt = mt + p.calculeMontant();
		}
		return mt;
		
	}
	
	public boolean estPresent(String ref) {
		boolean bool = false;
		for (Produit p : acheteur.getCommande().getProduits()) {
			if (ref.equals(p.getRef()));
				bool = true;

		}
		return bool;
	}
	
	public Produit rechercherProduit(String ref) {
		Iterator<Produit> it = this.getProduits().iterator();
		while (it.hasNext()) {
			Produit current = it.next();
			if (current.getRef().equals(ref)) {
				return current;
			}

		}

		return null;
	}

	
	public Commande(){
		
		this.etat="En cours";
		
	}
	
	public double calculeMontantFinalReduction(Client c){
		double mt=0;
		if(c.getReduction()==0)
			mt = c.getCommande().calculeMontantFinal();
		else 
			mt = (c.getCommande().calculeMontantFinal())*(1 - c.getReduction());
		return mt;
	}
	
	public double arrondir(double nombre,double nbApVirg)
	{
		return(double)((int)(nombre * Math.pow(10,nbApVirg) + .5)) / Math.pow(10,nbApVirg);
	}
	
	public void affichePanier(Client c){
		ConsoleHelper.display("---------------------------MON PANIER DE PRODUITS-----------------------------\n");
		if(this.getProduits().isEmpty())
			ConsoleHelper.display("--> Pas encore de produits dans votre panier ! Ajoutez-en !");
		ConsoleHelper.display(c.getCommande().affiche());
		ConsoleHelper.display("-------------------------------------------------------");
		ConsoleHelper.display("MONTANT TOTAL AVANT REDUCTION : "+ this.arrondir((c.getCommande().calculeMontantFinal()), 2) + " €\n");
		ConsoleHelper.display("REDUCTION SUR LA COMMANDE : "+ this.arrondir(c.getReduction()*100, 2) + " %\n");
		ConsoleHelper.display("-------------------------------------------------------");
		double montantTotal = this.arrondir((this.calculeMontantFinalReduction(c)),2);
		ConsoleHelper.display("MONTANT TOTAL DE LA COMMANDE : " + montantTotal+" €\n");
	}
	
	
	
	
	
	

}
