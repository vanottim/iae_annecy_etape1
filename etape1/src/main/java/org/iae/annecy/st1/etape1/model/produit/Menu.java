package org.iae.annecy.st1.etape1.model.produit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.iae.annecy.st1.tools.ConsoleHelper;

public class Menu {

	Catalogue catalogue;
	Annuaire annuaire;
	
	
	private Scanner saisie = new Scanner(System.in);

	public Annuaire getAnnuaire() {
		return annuaire;
	}

	public void setA(Annuaire a) {
		this.annuaire = a;
	}

	public int menuvendeur() {
		int choix;
		this.saisie.reset();
		ConsoleHelper.display("/---- GESTION VENDEUR ----/\n");
		ConsoleHelper.display(
				"1. Visualiser les produits achet�s par un client\n2. Indiquer un achat de produit par un client\n3. Menu pr�c�dent");
		choix = this.saisie.nextInt();
		return choix;
	}

	public int menugeneral() {
		int choixmenu;

		ConsoleHelper.display("/---- MENU PRINCIPAL ----/\n");
		ConsoleHelper.display(
				"--> Vous �tes : \n1. Responsable produit\n2. Responsable client�le\n3. Client\n4. Vendeur\n5. Terminer");
		choixmenu = this.saisie.nextInt();

		return choixmenu;

	}

	public void ecrireSurCatalogue() {
		try {
			FileOutputStream fout = new FileOutputStream("catalogue.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this.catalogue);
			oos.close();
			fout.close();
		} catch (IOException e) {
			ConsoleHelper.display("Erreur �criture catalogue" + e.getMessage());
		}

	}

	public void ecrireSurAnnuaire() {
		try {
			FileOutputStream fout = new FileOutputStream("annuaire.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this.annuaire);
			oos.close();
			fout.close();
		} catch (IOException e) {
			ConsoleHelper.display("Erreur �criture annuaire" + e.getMessage());
		}

	}

	public Produit trouverProduit(String maRef) {
		Produit monProd = null;
		for (int i = 0; i < this.getCat().getProduits().size(); i++) {
			Produit p = this.getCat().getProduits().get(i);
			if (p.getRef().equals(maRef))
				monProd = p;
		}
		if (monProd == null) {
			ConsoleHelper.display("Ce produit n'est pas dans la liste");
		}

		return monProd;
	}

	public Catalogue getCat() {
		return catalogue;
	}

	public void setCat(Catalogue cat) {
		this.catalogue = cat;
	}

	public Menu(Catalogue cat, Annuaire a) {
		super();
		this.catalogue = cat;
		this.annuaire = a;

	}

	public void ajouterProduit() {
		@SuppressWarnings("resource")
		Produit newProd = new Produit();
		String ref, desc, descL, nom;
		double prix;
		Scanner sc = new Scanner(System.in);

		do {
			ConsoleHelper.display("R�f�rence ?\n");
			ref = sc.nextLine();
			if (catalogue.refExiste(ref) == true)
				ConsoleHelper.display("Cette r�f�rence est d�j� dans le syst�me, veuillez en saisir une autre : `\n");
		} while (catalogue.refExiste(ref) == true);

		newProd.setRef(ref);
		ConsoleHelper.display("Nom ?\n");
		nom = sc.nextLine();
		newProd.setNom(nom);
		ConsoleHelper.display("Description ?\n");
		desc = sc.nextLine();
		newProd.setDesc(desc);
		do {
			ConsoleHelper.display("Prix ?\n");
			prix = sc.nextDouble();
			if (prix < 0)
				ConsoleHelper.display("Veuillez saisir un prix positif : \n");
		} while (prix < 0);
		newProd.setPrix(prix);
		ConsoleHelper.display("Description longue ?\n");
		sc.nextLine();
		descL = sc.nextLine();
		newProd.setDescLongue(descL);
		this.getCat().ajouterProduit(newProd);
		this.ecrireSurCatalogue();
		ConsoleHelper.display("Le produit " + newProd.getNom() + " a bien �t� ajout� au catalogue");
		ConsoleHelper.display(newProd.affiche());

	}

	public void ajouterClient() {
		@SuppressWarnings("resource")
		Client newClient = new Client();
		Commande commande = new Commande();
		newClient.setCommande(commande);
		String numClient, prenom, nom;
		int codePromo;
		Scanner sc = new Scanner(System.in);

		ConsoleHelper.display("Num�ro de client ?\n");
		numClient = sc.nextLine();

		newClient.setNumClient(numClient);
		ConsoleHelper.display("Nom client ?\n");
		nom = sc.nextLine();
		newClient.setNom(nom);
		ConsoleHelper.display("Pr�nom client ?\n");
		prenom = sc.nextLine();
		newClient.setPrenom(prenom);
		int newCode;
		ConsoleHelper.display("Choisissez le code promo du client : 1. 10%  2. 25%  3. 50%\n");
		newCode =this.saisie.nextInt();
		if(newCode==1){
			newClient.attribuerReduction(10);
			newClient.setCodePromo(10);
		}else if(newCode == 2){
			newClient.attribuerReduction(25);
			newClient.setCodePromo(25);
		}else if(newCode == 3){
			newClient.attribuerReduction(50);
			newClient.setCodePromo(50);
		}
		
		
		annuaire.ajouterClient(newClient);
		this.ecrireSurAnnuaire();
		ConsoleHelper.display(
				"Le client " + newClient.getNom() + " " + newClient.getPrenom() + " a bien �t� ajout� au catalogue !");
		ConsoleHelper.display(newClient.affiche());

	}

	public void supprimerProduit() {
		String reference;
		Produit prodTrouve;
		ConsoleHelper.display("Quel produit voulez-vous supprimer ? (Entrez sa r�f�rence) : ");
		reference = this.saisie.next();
		prodTrouve = catalogue.rechercherProduit(reference);
		if (prodTrouve != null) {
			catalogue.getProduits().remove(prodTrouve);
			this.ecrireSurCatalogue();
			ConsoleHelper.display("Le produit a �t� supprim� avec succ�s ! \n");
		} else {
			ConsoleHelper.display("le produit n'�xiste pas");
		}
	}

	public void menuResponsableClient(int choix) {
		int choixAttribut = 0;
		String choixClient, numClient;
		Client cliTrouve;
		boolean clientTrouve;

		if (choix == 1) {
			ConsoleHelper.display("------------------------------ANNUAIRE DE CLIENTS------------------------------");
			ConsoleHelper.display(this.getAnnuaire().affiche());
		} else if (choix == 2) {
			this.modifierClient();
		} else if (choix == 3) {
			ConsoleHelper.display("Num�ro du client recherch� : ");
			numClient = this.saisie.next();

			cliTrouve = annuaire.rechercherClient(numClient);
			clientTrouve = annuaire.numExiste(numClient);
			if (clientTrouve == true) {
				ConsoleHelper.display("Le client est dans le catalogue !\n");
				ConsoleHelper.display(cliTrouve.affiche());
			} else {
				ConsoleHelper.display("\nLe client que vous recherchez n'�xiste pas !\n");
			}

		} else if (choix == 4) {
			this.ajouterClient();
		} else if (choix == 5) {
			this.choixAction();
		}

	}

	public void menuResponsableProduit(int choix) {
		int choixAttribut = 0;
		String choixProduit, reference;
		Produit prodTrouve;
		boolean produitTrouve;
		Scanner sc = new Scanner(System.in);
		// do{
		if (choix == 1) {

			ConsoleHelper
					.display("------------------------------LES PRODUITS DU CATALOGUE------------------------------");
			ConsoleHelper.display(this.getCat().affiche());
		} else if (choix == 2) {
			ConsoleHelper.display("\nQuel produit de la liste voulez-vous modifier ? (REF) \n");
			ConsoleHelper.display(this.getCat().affiche());
			// sc.nextLine();
			choixProduit = sc.next();
			Produit monProd = catalogue.rechercherProduit(choixProduit);

			ConsoleHelper.display("Quel attribut ?\n\n 1. Description\n 2. Prix\n 3. Nom\n 4. Description longue");
			choixAttribut = sc.nextInt();

			if (choixAttribut == 1) {
				String newDescription = " ";
				ConsoleHelper.display("Saisissez la nouvelle description : ");
				sc.nextLine();
				newDescription = newDescription + sc.nextLine();
				monProd.setDesc(newDescription);
				this.ecrireSurCatalogue();
				ConsoleHelper.display("Le produit avec la r�f�rence : " + monProd.getRef()
						+ " a bien �t� modifi� - Nouvelle description : " + monProd.getDesc() + "\n");

			}

			else if (choixAttribut == 4) {
				String newDescription = " ";
				ConsoleHelper.display("Saisissez la nouvelle description : ");
				sc.nextLine();
				newDescription = newDescription + sc.nextLine();
				monProd.setDescLongue(newDescription);
				this.ecrireSurCatalogue();
				ConsoleHelper.display("Le produit avec la r�f�rence : " + monProd.getRef()
						+ " a bien �t� modifi� - Nouvelle description : " + monProd.getDescLongue() + "\n");

			} else if (choixAttribut == 2) {
				double newPrix;
				do {

					ConsoleHelper.display("Saisissez le nouveau prix : ");
					newPrix = sc.nextDouble();
					if (newPrix < 0) {
						ConsoleHelper.display("Prix n�gatif ! Recommencez : ");
					} else {
						monProd.setPrix(newPrix);
						this.ecrireSurCatalogue();
						ConsoleHelper.display("Le produit avec la r�f�rence : " + monProd.getRef()
								+ " a bien �t� modifi� - Nouveau prix : " + monProd.getPrix() + "\n");
					}
				} while (newPrix < 0);
			} else if (choixAttribut == 3) {
				String newNom;
				ConsoleHelper.display("Saisissez le nouveau nom : ");
				sc.nextLine();
				newNom = sc.nextLine();
				monProd.setNom(newNom);
				this.ecrireSurCatalogue();
				ConsoleHelper.display("Le produit avec la r�f�rence : " + monProd.getRef()
						+ " a bien �t� modifi� - Nouveau nom : " + monProd.getNom() + "\n");

			}

		}

		else if (choix == 3) {
			ConsoleHelper.display("R�f�rence du produit recherch� : ");
			reference = this.saisie.next();

			prodTrouve = catalogue.rechercherProduit(reference);
			produitTrouve = catalogue.refExiste(reference);
			if (produitTrouve == true) {
				ConsoleHelper.display("Le produit est dans le catalogue !\n");
				ConsoleHelper.display(prodTrouve.affiche());
			} else {
				ConsoleHelper.display("\nLe produit que vous recherchez n'�xiste pas !\n");
			}
		} else if (choix == 4) {
			this.ajouterProduit();
		} else if (choix == 5) {
			this.supprimerProduit();
		} else if (choix == 6) {
			this.choixAction();
		}

	}

	public void modifierClient() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String numClient;
		int choixAttribut;
		ConsoleHelper.display("------------------------------ANNUAIRE DE CLIENTS------------------------------");
		ConsoleHelper.display(this.getAnnuaire().affiche());
		ConsoleHelper.display("\nQuel client voulez-vous modifier (Entrez son num�ro) ?");
		// sc.nextLine();
		numClient = sc.nextLine();
		Client monClient = annuaire.rechercherClient(numClient);

		ConsoleHelper.display("Quel attribut ?\n\n 1. Nom\n 2. Pr�nom\n 3. Code Promotionnel");
		choixAttribut = sc.nextInt();

		if (choixAttribut == 1) {
			String newNom = " ";
			ConsoleHelper.display("Saisissez le nouveau nom : ");
			sc.nextLine();
			newNom = sc.nextLine();
			monClient.setNom(newNom);
			this.ecrireSurAnnuaire();
			ConsoleHelper.display("Le client avec le num�ro : " + monClient.getNumClient()
					+ " a bien �t� modifi� - Nouveau nom : " + monClient.getNom());

		}

		else if (choixAttribut == 2) {
			String newPrenom = " ";
			ConsoleHelper.display("Saisissez le nouveau pr�nom : ");
			sc.nextLine();
			newPrenom = sc.nextLine();
			monClient.setPrenom(newPrenom);
			this.ecrireSurAnnuaire();
			ConsoleHelper.display("Le client avec le num�ro : " + monClient.getNumClient()
					+ " a bien �t� modifi� - Nouveau pr�nom : " + monClient.getPrenom());

		}

		else if (choixAttribut == 3) {
			int rep;
			ConsoleHelper.display("Choisissez le code promo du client : 1. 10%  2. 25%  3. 50%");
			rep =this.saisie.nextInt();
			if(rep==1){
				monClient.attribuerReduction(10);
				monClient.setCodePromo(10);
			}else if(rep == 2){
				monClient.attribuerReduction(25);
				monClient.setCodePromo(25);
			}else if(rep == 3){
				monClient.attribuerReduction(50);
				monClient.setCodePromo(50);
			}
			
			this.ecrireSurAnnuaire();
			ConsoleHelper.display("Le client avec le num�ro : " + monClient.getNumClient()
					+ " a bien �t� modifi� - Nouveau code : " + monClient.getCodePromo());

		}

	}

	public Client ajouterProduit(Client client) {
		String ref;
		Produit produitInconnu;
		int choix, quantite;
		int reponse = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		// do{
		ConsoleHelper.display("-------CHOISIR UN PRODUIT A AJOUTER---------- :\n");
		ConsoleHelper.display(catalogue.affiche());
		ConsoleHelper.display("Veuillez saisir la r�f�rence du produit � acheter : \n");
		ref = sc.nextLine();
		Produit monProd = client.getCommande().rechercherProduit(ref);
		produitInconnu = catalogue.rechercherProduit(ref);
		if (monProd != null) {
			ConsoleHelper.display("Ce produit est d�j� pr�sent dans votre panier en quantit� : "
					+ monProd.getQteCommandee() + "\nVoulez-vous modifier la quantit� souhait�e ? 1. oui  2. non ");
			reponse = sc.nextInt();
			if (reponse == 1) {
				ConsoleHelper.display("\nQuelle quantit� souhaitez-vous ?");
				quantite = sc.nextInt();
				monProd.setQteCommandee(quantite);
				this.ecrireSurCatalogue();
				this.ecrireSurAnnuaire();
				ConsoleHelper.display("La quantit� du produit " + monProd.getRef() + " a bien �t� modifi�e !\n");
			}
		} else if (monProd == null) {
			ConsoleHelper.display("Entrez la quantit� � acheter pour ce produit : ");
			quantite = sc.nextInt();
			client.getCommande().ajouterProduit(produitInconnu, quantite);
			this.ecrireSurCatalogue();
			this.ecrireSurAnnuaire();
			ConsoleHelper.display("Le produit " + produitInconnu.getRef() + " a bien �t� ajout� !\n");
		}

		return client;
	}

	public void menuPanier(Client monClient) {
		int choix;
		do {
			// ConsoleHelper.display(monClient.getCommande().affiche());
			if (monClient.getCommande().getEtat().equals("Envoyee")) {
				ConsoleHelper.display("/----------GESTION DE MON PANIER : " + monClient.getPrenom() + " "
						+ monClient.getNom()
						+ " ! ---------/\n1. Voir ma commande et son prix\n4. Menu pr�c�dent");
				ConsoleHelper.display(
						"INDICATION : Votre commande est valid�e, vous ne pouvez plus lui ajouter de produits");
			} else if (monClient.getCommande().getEtat().equals("En cours"))
				ConsoleHelper.display("/----------GESTION DE MON PANIER : " + monClient.getPrenom() + " "
						+ monClient.getNom()
						+ " ! ---------/\n1. Voir mon panier et son prix\n2. Ajouter un produit\n3. Valider mon panier\n4. Menu pr�c�dent");
			choix = saisie.nextInt();
			if (choix == 1) {
				monClient.getCommande().affichePanier(monClient);

			} else if (choix == 2) {
				monClient = this.ajouterProduit(monClient);
			}

			else if (choix == 3) {
				monClient.getCommande().validerPanier();
				//monClient.getHistoriqueCommandes().ajouterCommande(monClient.getCommande());
				this.ecrireSurAnnuaire();
			} /*else if (choix == 4) {

				if (monClient.getCommande().getEtat().equals("Envoyee")) {
					ConsoleHelper.display("Le client a achet� les produits suivants : ");
					ConsoleHelper.display(monClient.getCommande().affiche2());
				} else
					ConsoleHelper
							.display("Ce client n'a pas encore achet� de produits, sa commande doit �tre valid�e !\n");*/
			 else if (choix == 4)
				this.choixAction();
		} while (choix != 4);
	}

	public void menuVendeur(Client client){
		String reference;
		Produit monProduit;
		Produit produitInconnu;
		int quantite = 0;
		int choix = 0;
		int reponse;
		do{
		ConsoleHelper.display("/---- GESTION VENDEUR --> Gestion du client : "+client.getPrenom()+ " " +client.getNom()+"  ----/\n");
		ConsoleHelper.display("1. Ajouter un produit au panier d'un client\n2. Visualiser les produits achet�s par un client\n3. Menu pr�c�dent");
		choix = this.saisie.nextInt();
		if(choix ==1){
			ConsoleHelper.display("Veuillez choisir un produit � acheter dans la liste (Entrez sa r�f�rence) : \n");
			ConsoleHelper.display(this.getCat().affiche());
			reference = this.saisie.next();
			Produit monProd = client.getCommande().rechercherProduit(reference);
			produitInconnu = catalogue.rechercherProduit(reference);
			if(monProd != null){
				ConsoleHelper.display("Ce produit est d�j� pr�sent dans le panier du client en quantit� : "+monProd.getQteCommandee()+"\nVoulez-vous modifier la quantit� souhait�e ? 1. oui  2. non ");
				reponse= this.saisie.nextInt();
				if(reponse==1){
					ConsoleHelper.display("\nQuelle quantit� pour ce produit ?");
					quantite = this.saisie.nextInt();
					monProd.setQteCommandee(quantite);
					this.ecrireSurCatalogue();
					this.ecrireSurAnnuaire();
					ConsoleHelper.display("La quantit� du produit " + monProd.getRef()+" pour le client a bien �t� modifi�e dans son panier !\n");
				}
			}
			else if(monProd == null){
				ConsoleHelper.display("Quelle quantit� pour ce produit : ");
				quantite = this.saisie.nextInt();
				client.getCommande().ajouterProduit(produitInconnu,quantite);
				this.ecrireSurCatalogue();
				this.ecrireSurAnnuaire();
				ConsoleHelper.display("Le produit " + produitInconnu.getRef()+" a bien �t� ajout� avec la quantit� : "+produitInconnu.getQteCommandee()+" !\n");
			}
			/*monProduit = this.getCat().rechercherProduit(reference);
			ConsoleHelper.display("Entrez la quantit� � ajouter pour ce produit : ");
			quantite = this.saisie.nextInt();
			if(reference == null){
				ConsoleHelper.display("Cette r�f�rence n'est li�e � aucun produit dans le syst�me");
			}
			else{
				client.getCommande().ajouterProduit(monProduit, quantite);
				this.ecrireSurAnnuaire();
				ConsoleHelper.display("Le produit a bien �t� ajout� au panier du client !\n");
			}*/
		}
		else if(choix == 2){
			/*if(client.getHistoriqueCommandes() == null){
				ConsoleHelper.display("Ce client n'a encore achet� aucun produit ! Il doit valider sa commande\n ");
			}
			else{
				client.getHistoriqueCommandes().afficherProduitsAchet�s();
			}	*/
			
		}
		
		}while(choix != 3);
		if(choix == 3){
			this.choixAction();
		}
		

		
	}

	public void choixAction() {

		int choix = 0;
		choix = this.menugeneral();

		do {

			int choix2 = 0;
			@SuppressWarnings("resource")

			Scanner sc = new Scanner(System.in);

			if (choix == 1) {

				ConsoleHelper.display("/---- GESTION CATALOGUE : RESPONSABLE PRODUIT ----/\n");
				ConsoleHelper.display(
						"1. Afficher les produits\n2. Modifier un produit\n3. Rechercher un produit\n4. Ajouter un produit\n5. Supprimer un produit\n6. Menu pr�c�dent");
				choix2 = sc.nextInt();
				this.menuResponsableProduit(choix2);
			}

			else if (choix == 2) {

				ConsoleHelper.display("/---- GESTION CLIENTS : RESPONSABLE CLIENT ----/\n");
				ConsoleHelper.display(
						"1. Afficher les clients\n2. Modifier un client\n3. Rechercher un client\n4. Ajouter un client\n5. Menu pr�c�dent");
				choix2 = sc.nextInt();
				this.menuResponsableClient(choix2);

			} else if (choix == 3) {
				Client monClient;
				ConsoleHelper.display(
						"Veuillez vous authentifier (� l'aide de votre num�ro de client) : \n\n" + annuaire.affiche2());
				this.getAnnuaire().affiche();
				String numero = sc.next();
				monClient = annuaire.rechercherClient(numero);
				if (monClient == null) {
					ConsoleHelper.display("\nCe num�ro de client ne correspond � aucun client dans le syst�me !\n");
				} else
					this.menuPanier(monClient);

			} else if (choix == 4) {
				Client monClient;
				ConsoleHelper.display("Veuillez renseigner le num�ro du client � g�rer parmis ceux de la liste : \n");
				ConsoleHelper.display(this.getAnnuaire().affiche2());
				String numero = sc.next();
				monClient = annuaire.rechercherClient(numero);
				if (monClient == null) {
					ConsoleHelper.display("Ce num�ro de client ne correspond � aucun client dans le syst�me !\n");
				} else
					this.menuVendeur(monClient);

			} else if (choix == 5) {
				ConsoleHelper.display("----------------FIN-----------------");
				System.exit(0);
			}
		} while (choix != 5);

	}

}
