package chiens;

import iut.World;

/**
 * Classe permettant de creer des Canetons et de gerer tout ce qu'ils font ou peuvent faire.
 * Hérite de Herbivore.
 */
public class Caneton extends Herbivore {

    /**
    * Constructeur de la classe Caneton.
    * @param g
    * @param x
    * @param y
    */
   public Caneton( World g , int x, int y) {
       super (g, "Sprites/caneton", x, y);
   }

    /**
    * Permet d'accéder aux variables contenu dans l'énuémration Type.
    * @return 
    */
   @Override
    public Type getType() {
            return Type.Caneton;
    }
}