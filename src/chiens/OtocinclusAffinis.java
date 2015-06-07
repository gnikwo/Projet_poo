package chiens;

import iut.World;

/**
 * Classe permettant de créer des OtocinclusAffinis et de gérer tout ce qu'ils font ou peuvent faire.
 * 
 * Hérite de Omnivore.
 */
public class OtocinclusAffinis extends Omnivore {

	/**
	 * Constructeur de la classe OtocinclusAffinis.
	 */
	public OtocinclusAffinis(World g, int x, int y) {
            super(g,"Sprites/otocinclus_affinis", x, y);
	}

	/**
	 * Permet d'accéder aux variables contenu dans l'énumération Type.
	 */
	public Type getType() {
		return Type.OtocinclusAffinis;
	}
}