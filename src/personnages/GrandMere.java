package personnages;

import java.util.Random;

public class GrandMere extends Humain {
	private int nbConnaissanceMax = 5;

	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
	}

	@Override
	protected void memoriser(Humain autreHumain) {
		if (nbConnaissance < nbConnaissanceMax) {
			memoire[nbConnaissance] = autreHumain;
			nbConnaissance++;
		} else {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		}
	}

	private TypeHumain humainHasard() {
		TypeHumain[] types = TypeHumain.values();
		Random random = new Random();
		int i = random.nextInt(types.length);
		return types[i];
	}

	public void ragoter() {
		for (int i = 0; i < nbConnaissance; i++) {
			Humain connaissance = memoire[i];
			if (connaissance instanceof Traitre) {
				TypeHumain type = TypeHumain.TRAITRE;
				parler("Je sais que " + connaissance.getNom() + " est " + type + ". Petit chenapan !");
			} else {
				TypeHumain type = humainHasard();
				parler("Je crois que " + connaissance.getNom() + " est " + type + ".");
			}
		}
	}
}