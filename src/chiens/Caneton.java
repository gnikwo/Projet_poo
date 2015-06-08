package chiens;

/**
 * Classe permettant de creer des Canetons et de gerer tout ce qu'ils font ou peuvent faire.
 * Hérite de Herbivore.
 */
public class Caneton extends Herbivore {
//blablablubli
    /**
    * Constructeur de la classe Caneton.
    * @param x
    * @param y
    */
   public Caneton( int x, int y) {
       
       super ("Sprites/caneton", x, y);
       
       this.vitalite = 100;
       this.vitaliteMax = 100;
       this.vitesseX = 0;
       this.vitesseY = 0 ;
   }

    /**
    * Permet d'accéder aux variables contenu dans l'énuémration Type.
    * @return 
    */
   @Override
    public Type getType() {
            return Type.Caneton;
    }

    @Override
    protected void mettreBas() {
    }
}