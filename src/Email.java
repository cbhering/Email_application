import java.util.Scanner;

public class Email {
	
    private String prenom;
    private String nom;
    private String motDePasse;
    private String departement;
    private String courriel;
    private int capaciteBoiteCourriel = 500;
    private int longueurMotDePasse = 10;
    private String courrielAlternatif;
    private String suffixeEntreprise = "xyzentreprise";

    //Constructeur
    public Email(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
        
        this.departement = setDepartement();
        
        this.motDePasse = motDePasseAleatoire(longueurMotDePasse);
        System.out.println("Votre Mot de Passe est: " + this.motDePasse);
        
        if (departement == "ventes" || departement == "dev" || departement == "compt" || departement == "jur") {
        	courriel = prenom.toLowerCase() + "." + nom.toLowerCase() + "@" + departement + "." + suffixeEntreprise + ".com";
        } else {
        	courriel = prenom.toLowerCase() + "." + nom.toLowerCase() + "@" + departement + suffixeEntreprise + ".com";
        }
        

    }

    //Méthode pour établir le département
    private String setDepartement() {
    	System.out.println("Nouvel employé: " + prenom + " " + nom + ". Codes des Départements\n1 pour Ventes\n2 pour Développement\n3 pour Comptabilité \n4 pour Juridique \n0 "
    			+ "pour aucun\nSaisir code du département: ");
    	Scanner in = new Scanner(System.in);
    	int depChoix = in.nextInt();
    	in.close();
    	switch(depChoix) {
    	     case 1:
    	    	 return "ventes";
    	     case 2:
    	    	 return "dev";
    	     case 3:
    	    	 return "compt";
    	     case 4:
    	    	 return "jur";
    	     default:
    	    	 return "";	
    	}

    }
      
    //Générer un mot de passe aléatoire
    private String motDePasseAleatoire(int longueur) {
    	String setMotDePasse = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
    	char[] motDePasse = new char[longueur];
    	for (int i=0; i<longueur; i++) {
    		int rand = (int) (Math.random() * setMotDePasse.length());
    		motDePasse[i] = setMotDePasse.charAt(rand);

    	}
    	return new String(motDePasse);
    }

    //Set the mailbox capacity
    public void setcapaciteBoiteCourriel(int capacity) {
    	this.capaciteBoiteCourriel = capacity;
    }
    
    //Set the alternate email
    public void setCourrielAlternatif(String altEmail) {
    	this.courrielAlternatif = altEmail;
    }

    //Change the password
    public void modifierMotDePasse(String password) {
    	this.motDePasse = password;
    }
    
    public int getCapaciteBoiteCourriel() {
    	return capaciteBoiteCourriel;
    }
    
    public String getCourrielAlternatif() {
    	return courrielAlternatif;
    }
    
    public String getMotDePasse() {
    	return motDePasse;
    }

    public String afficherInfo() {
    	return "\nAFFICHER NOM COMPLET: " + prenom + " " + nom + 
    			"\nCOURRIEL DE L'ENTREPRISE: " + courriel + 
    			"\nCAPACITÉ DE LA BOÎTE DU COURRIEL: " + capaciteBoiteCourriel + "Mb";
    }
}
