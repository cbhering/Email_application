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

    //M�thode pour �tablir le d�partement
    private String setDepartement() {
    	System.out.println("Nouvel employ�: " + prenom + " " + nom + ". Codes des D�partements\n1 pour Ventes\n2 pour D�veloppement\n3 pour Comptabilit� \n4 pour Juridique \n0 "
    			+ "pour aucun\nSaisir code du d�partement: ");
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
      
    //G�n�rer un mot de passe al�atoire
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
    			"\nCAPACIT� DE LA BO�TE DU COURRIEL: " + capaciteBoiteCourriel + "Mb";
    }
}
