package chiens;

import iut.Objet;
import java.awt.Color;
import java.awt.Graphics;

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
    public void evoluate(long l){
        
        
        
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
    
     @Override
    public void draw(Graphics g) throws Exception{
        
        super.draw(g);
        
        if(info){
            /*g.setColor(new Color(10,10,10,50));
            g.fillRect(this.getMiddleX(), this.getMiddleY(), (int)(this.getWidth()*1.5), (int)(this.getWidth()));
            g.setColor(new Color(255,0,0));
            
            
            g.setColor(new Color(0,0,0));
            g.drawString("Type : " + this.getType(), this.getMiddleX()+2, this.getMiddleY()+10);
            g.drawString("Age : " + this.age + "/" + this.ageMax, this.getMiddleX()+2, this.getMiddleY()+20);
            g.drawString("Vitalite : " + this.vitalite, this.getMiddleX()+2, this.getMiddleY()+30);
            g.drawString("Hunger : " + this.hunger, this.getMiddleX()+2, this.getMiddleY()+40);
            g.drawString("Sexe : " + this.sexe, this.getMiddleX()+2, this.getMiddleY()+50);*/
        }
        
    }
    
     
}