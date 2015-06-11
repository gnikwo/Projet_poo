package chiens;

import iut.Objet;

/**
 * Classe permettant de creer des Canetons et de gerer tout ce qu'ils font ou peuvent faire.
 * Hérite de Herbivore.
 */
public class Caneton extends Herbivore {

   /**
    * Constructeur de la classe Caneton.
    * @author ma951979
    * @param x
    * @param y
    */
   public Caneton( int x, int y) {
       super ( "Sprites/caneton", x, y);
       
       this.ageMax = 9000;
       this.vitalite = 1000;
       this.vitaliteMax = 1000;
   }

    /**
    * Permet d'accéder aux variables contenu dans l'énuémration Type.
    * @author ma951979
    * @return 
    */
   @Override
    public Type getType() {
        return Type.Caneton;
    }

    @Override
    protected void mettreBas() {
    }
    
    
    @Override
    public void move(long dt){
        
        
        this.move(this.vitesseX, Math.sin(this.getMiddleX()/10)/2);
        
        if(this.getMiddleX() > Lac.getInstance().getWidth()){

            this.moveX(- (Lac.getInstance().getWidth()));

        }
        
        if(this.getMiddleX() < 0){

            this.moveX(Lac.getInstance().getWidth() - Math.abs(this.getMiddleX()));

        }
        
        
    }

    /**
     *
     * @param objet
     */
    @Override
    public void effect(Objet objet) {
        
    }
     
}