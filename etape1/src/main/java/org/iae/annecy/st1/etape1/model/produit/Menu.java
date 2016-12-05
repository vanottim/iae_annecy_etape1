package org.iae.annecy.st1.etape1.model.produit;

import java.io.File;
import java.util.Scanner;



public class Menu {
	
	Catalogue cat;
	Annuaire a;
	
	
		
	
	public Annuaire getA() {
		return a;
	}



	public void setA(Annuaire a) {
		this.a = a;
	}



	public Produit trouverProduit(String maRef){
		Produit monProd = null;
		for(int i=0; i<this.getCat().getProduits().size() ;i++){
			Produit p = this.getCat().getProduits().get(i);
			if(p.getRef().equals(maRef))
				monProd = p;				
		}
		if(monProd == null){
			System.out.println("Ce produit n'est pas dans la liste");
		}
		
		return monProd;
	}

	
	
	public Catalogue getCat() {
		return cat;
	}

	public void setCat(Catalogue cat) {
		this.cat = cat;
	}
	
	

	public Menu(Catalogue cat, Annuaire a) {
		super();
		this.cat = cat;
		this.a = a;
	}
	
	public void ajouterProduit(){
		@SuppressWarnings("resource")
		Produit newProd = new Produit();
		String ref, desc, descL, nom;
		double prix;
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.println("Référence ?\n");
			ref = sc.nextLine();
			if(cat.refExiste(ref)== true)
				System.out.println("Cette référence est déjà dans le système, veuillez en saisir une autre : `\n");
		}while(cat.refExiste(ref)==true);
		
		newProd.setRef(ref);
		System.out.println("Nom ?\n");
		nom = sc.nextLine();
		newProd.setNom(nom);
		System.out.println("Description ?\n");
		desc = sc.nextLine();
		newProd.setDesc(desc);
		do{
			System.out.println("Prix ?\n");
			prix = sc.nextDouble();
			if(prix < 0 )
				System.out.println("Veuillez saisir un prix positif : \n");
		}while(prix <0);
		newProd.setPrix(prix);
		System.out.println("Description longue ?\n");
		sc.nextLine();
		descL = sc.nextLine();
		newProd.setDescLongue(descL);
		this.getCat().ajouterProduit(newProd);
		
		System.out.println("Le produit " + newProd.getNom() + " a bien été ajouté au catalogue");
		System.out.println(newProd.affiche());
	
		
		
	}
	
	public void ajouterClient(){
		@SuppressWarnings("resource")
		Client newClient = new Client();
		String codePromo, numClient, prenom, nom;
		Scanner sc = new Scanner(System.in);
		

		System.out.println("Référence client ?\n");
		numClient = sc.nextLine();
		
		newClient.setNumClient(numClient);
		System.out.println("Nom client ?\n");
		nom = sc.nextLine();
		newClient.setNom(nom);
		System.out.println("Prénom client ?\n");
		prenom = sc.nextLine();
		newClient.setPrenom(prenom);
		System.out.println("Code promo ?\n");
		codePromo = sc.nextLine();
		newClient.setCodePromo(codePromo);
			
		System.out.println("Le client " + newClient.getNom() + " " + newClient.getPrenom() + " a bien été ajouté au catalogue !");
		System.out.println(newClient.affiche());
					
	}

	public void modifierProduitAttribut(){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choixProduit;
		int choixAttribut;
		System.out.println("Quel produit voulez-vous modifier ?");
		//sc.nextLine();
		choixProduit = sc.nextLine();
		Produit monProd = cat.rechercherProduit(choixProduit);
		
		System.out.println("Quel attribut ?\n\n 1. Description\n 2. Prix\n 3. Nom\n 4. Description longue");
		choixAttribut = sc.nextInt();
		
		/*if(choixAttribut == 1){
			int oldRef = monProd.getRef();
			int newRef=0;
			System.out.println("Saisissez la nouvelle ref : ");
			newRef=sc.nextInt();
			monProd.setRef(newRef);
			System.out.println("Le produit avec la référence : " + oldRef+ " a bien été modifié - Nouvelle référence : "+ monProd.getRef());
		}*/
		if(choixAttribut == 1){
			String oldDesc = monProd.getDesc();
			String newDescription= " ";
			System.out.println("Saisissez la nouvelle description : ");
			sc.nextLine();
			newDescription= newDescription + sc.nextLine();
			monProd.setDesc(newDescription);
			System.out.println("Le produit avec la référence : " + monProd.getRef()+ " a bien été modifié - Nouvelle description : "+ monProd.getDesc());
			
			
		}
		
		else if(choixAttribut == 4){
			String oldDesc = monProd.getDescLongue();
			String newDescription= " ";
			System.out.println("Saisissez la nouvelle description : ");
			sc.nextLine();
			newDescription= newDescription + sc.nextLine();
			monProd.setDescLongue(newDescription);
			System.out.println("Le produit avec la référence : " + monProd.getRef()+ " a bien été modifié - Nouvelle description : "+ monProd.getDescLongue());
			
			
		}
		else if(choixAttribut ==2){
			double oldPrix = monProd.getPrix();
			double newPrix;
			System.out.println("Saisissez le nouveau prix : ");
			newPrix=sc.nextDouble();
			monProd.setPrix(newPrix);
			System.out.println("Le produit avec la référence : " + monProd.getRef()+ " a bien été modifié - Nouveau prix : "+ monProd.getPrix());
			
		}
		else if(choixAttribut ==3){
			String oldNom = monProd.getNom();
			String newNom;
			System.out.println("Saisissez le nouveau nom : ");
			sc.nextLine();
			newNom = sc.nextLine();
			monProd.setNom(newNom);
			System.out.println("Le produit avec la référence : " + monProd.getRef()+ " a bien été modifié - Nouveau nom : "+ monProd.getNom());
			
		}
		
		
		
		
		
	}
	
public void modifierClient(){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String numClient;
		int choixAttribut;
		System.out.println("Quel client voulez-vous modifier ?");
		//sc.nextLine();
		numClient = sc.nextLine();
		Client monClient = a.rechercherClient(numClient);
		
		System.out.println("Quel attribut ?\n\n 1. Nom\n 2. Prénom\n 3. Code Promotionnel");
		choixAttribut = sc.nextInt();
		
			if(choixAttribut == 1){
			String newNom= " ";
			System.out.println("Saisissez le nouveau nom : ");
			sc.nextLine();
			newNom= newNom + sc.nextLine();
			monClient.setNom(newNom);
			System.out.println("Le client avec le numéro : " + monClient.getNumClient()+ " a bien été modifié - Nouveau nom : "+ monClient.getNom());
			
			
		}
		
		
			else if(choixAttribut == 1){
				String newNom= " ";
				System.out.println("Saisissez le nouveau nom : ");
				sc.nextLine();
				newNom= newNom + sc.nextLine();
				monClient.setNom(newNom);
				System.out.println("Le client avec le numéro : " + monClient.getNumClient()+ " a bien été modifié - Nouveau nom : "+ monClient.getNom());
				
				
			}
		
		
		
		
		
	}

	public void choixAction() {
		
		int choix = 0;
		do{@SuppressWarnings("resource")
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n1. Modifier un produit\n2. Afficher Produits\n3. Ajouter un produit\n4. Ajouter client\n5. Terminer\n");
		choix = sc.nextInt();
		
		if(choix == 1)
			this.modifierProduitAttribut();
		else if(choix ==2)
			System.out.println(this.getCat().affiche());
		else if(choix ==3)
			this.ajouterProduit();
		else if(choix ==4)
			this.ajouterClient();
		else if(choix ==5)
			System.out.println("----------------FIN-----------------");
					
		}while(choix != 4);

	}

}
