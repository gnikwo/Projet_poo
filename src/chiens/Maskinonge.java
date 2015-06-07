package chiens;

import iut.Objet;
import iut.World;

/**
 * Classe permettant de créer des Maskinonges et de gérer tout ce qu'ils font ou peuvent faire.
 * 
 * 
 * Hérite de Carnivore.
 */
public class Maskinonge extends Carnivore {

	/**
	 * Constructeur de la classe Maskinonge.
	 */
	public Maskinonge(World g, int x, int y) {
            super(g,"Sprites/maskinonge", x, y);
	}

	/**
	 * Permet d'accéder aux variables contenu dans l'énumération Type.
	 */
	public Type getType() {
		return Type.Maskinonge;
	}

    @Override
    public void effect(Objet objet) {
    }
}