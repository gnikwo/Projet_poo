package chiens;

import iut.World;

/**
 * Classe permettant de gérer les objetImmobiles tout ce qu'ils font ou peuvent faire.
 * 
 * Hérite d'objetBase.
 */
public abstract class ObjetImmobile extends ObjetBase {

	/**
	 * Constructeur de la classe objetImmobile.
	 */
	public ObjetImmobile(World g, String nom, int x, int y) {
            super(g, nom, x, y);
	}

	public void estManger() {
	}
}