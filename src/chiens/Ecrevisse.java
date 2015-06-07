package chiens;

import iut.Objet;
import iut.World;


/**
 * Classe permettant de créer des Ecrevisses et de gérer tout ce qu'ils font ou peuvent faire.
 * 
 * Hérite de Detritivore.
 */
public class Ecrevisse extends Detritivore {

	/**
	 * Constructeur de la classe Ecrevisse.
	 */
	public Ecrevisse(World g, int x, int y) {
            super(g,"Sprites/ecrevisse", x, y);
	}

	/**
	 * Permet d'accéder aux variables contenu dans l'énumération Type.
	 */
        @Override
	public Type getType() {
		return Type.Ecrevisse;
	}

        @Override
        public void effect(Objet objet) {
        }
}