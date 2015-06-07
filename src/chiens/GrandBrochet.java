package chiens;

import iut.Objet;
import iut.World;

/**
 * Classe permettant de créer des GrandBrochets et de gérer tout ce qu'ils font ou peuvent faire.
 * 
 * 
 * Hérite de Carnivore.
 */
public class GrandBrochet extends Carnivore {

	/**
	 * Constructeur de la classe GrandBrochet.
	 */
	public GrandBrochet(World g, int x, int y) {
            super(g,"Sprites/grand_brochet", x, y);
	}

	/**
	 * Permet d'accéder aux variables contenu dans l'énumération Type.
	 */
	public Type getType() {
		return Type.GrandBrochet;
	}

    @Override
    public void effect(Objet objet) {
    }
}