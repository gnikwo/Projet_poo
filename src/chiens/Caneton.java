package chiens;

import iut.World;

/**
<<<<<<< .mine
 * Classe permettant de créer des Canetons et de gérer tout ce qu'ils font ou peuvent faire.
=======
 * Classe permettant de creer des Canetons et de gerer tout ce qu'ils font ou peuvent faire.
>>>>>>> .r42
 * 
 * Hérite de Herbivore.
 */
public class Caneton extends Herbivore {

	/**
	 * Constructeur de la classe Caneton.
	 */
	public Caneton( World g , int x, int y) {
            super (g, "Sprites/caneton", x, y);
	}

	/**
<<<<<<< .mine
	 * Permet d'accéder aux variables contenu dans l'énuémration Type.
=======
	 * Permet d'acceder aux variables contenu dans l'enumeration Type.
>>>>>>> .r42
	 */
	public Type getType() {
		return Type.Caneton;
	}
}