package chiens;

import iut.Objet;
import iut.World;

/**
 * Classe permettant de créer des BrochetTigre et de gérer tout ce qu'ils font ou peuvent faire. (hybride des deux autres carnivore)
 * 
 * Hérite de Carnivore.
 */
public class BrochetTigre extends Carnivore {

	/**
	 * Constructeur de la classe BrochetTigre.
	 */
	public BrochetTigre(World g, int x, int y) {
            super(g,"sprites/brochet_tigre", x, y);
	}

	/**
	 * Permet d'accéder aux variables contenu dans l'énumération Type.
	 */
	public Type getType() {
		return Type.BrochetTigre;
	}

    @Override
    public void effect(Objet objet) {
    }
}