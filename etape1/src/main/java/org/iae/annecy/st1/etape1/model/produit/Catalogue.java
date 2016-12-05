package org.iae.annecy.st1.etape1.model.produit;

import java.util.ArrayList;
import java.util.Iterator;

public class Catalogue {
	
	private ArrayList<Produit> produits = new ArrayList<Produit>();
	
	public Produit rechercherProduit(String ref){
		Iterator<Produit> it = this.getProduits().iterator();
		Produit monProd = new Produit();
		while(it.hasNext()){
			Produit current = it.next();
			if(current.getRef().equals(ref)){
				monProd = current;
				break;
			}
			
		}
		
		return monProd;
	}

	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
	
	public void ajouterProduit(Produit p){
		produits.add(p);
	}
	
	public String affiche(){
		String chaine = "";
		for(Produit p : produits){
			chaine = chaine + p.affiche();
		}
		
		return chaine;
	}
	
	public boolean refExiste(String ref){
		boolean bool = false;
		for(Produit p : produits)
		{
			if(ref.equals(p.getRef()))
				bool = true;
					
		}
		return bool;
	}
	
	

}
