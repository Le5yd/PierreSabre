package personnages;

public class Humain {
	protected String nom;
	private String boissonFavorite;
	protected int argent;
	protected int nbConnaissance = 0;
	protected Humain[] memoire = new Humain[30];

	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}

	public void gagnerArgent(int gain) {
		argent += gain;
	}

	public void perdreArgent(int perte) {
		argent -= perte;
	}

	public void acheter(String bien, int prix) {
		if (argent >= prix) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.");
		}
	}

	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}

	private void repondre(Humain autreHumain) {
		direBonjour();
		memoriser(autreHumain);
	}

	private void memoriser(Humain autreHumain) {
		memoire[nbConnaissance] = autreHumain;
		nbConnaissance++;
	}

	public void listerConnaissance() {
		String texte = "Je connais beaucoup de monde dont:";
		for (int i = 0; i < nbConnaissance-1; i++) {
			String humain = memoire[i].getNom();
			texte = texte + " " + humain + ",";
		}
		String humain = memoire[nbConnaissance].getNom();
		texte = texte + " " + humain;
		System.out.println(texte);
	}
}