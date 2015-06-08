package chiens;

import iut.Objet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Classe permettant de gérer les VégétauxMarins tout ce qu'ils font ou peuvent faire.
* 
* Hérite d'objetImmobile.
*/
public class VegetalMarin extends ObjetImmobile {
    /**
    * Attribut stockant l'âge d'un végétal marin de type Integer.
    */
    private int age=0;
    /**
    * Attribut stockant l'âge maximum qu'un végétal marin peut atteindre de type Integer.
    */
    private int ageMax=100;
    
    private int vitalite=120;
    private int vitaliteMax=120;

    /**
    * Constructeur de la classe VégetalMarin.
    * @param x
    * @param y
    */
    public VegetalMarin(int x, int y) {
         
      super("Sprites/vegetal_marin", x, y);
  
    }

    /**
    * Fait évoluer l'objet
    * @param dt le temps écoulé depuis la dernière évolution (en ms)
    */
    @Override
    public void evoluate(long dt) {
        
        age++;
        if(age>=ageMax*0.5){
            if(this.vitalite >= vitaliteMax*0.3){
 
                this.clonage();
    
            }  
        }
        
        if(this.age>=ageMax){
            this.estMort();
        }
        
        
        if(this.vitalite <= 0){
  
            this.estMort();
  
        }
        
        
    }

    /**
    * Procédure permettant de faire mourir le végétal marin.
    */
    @Override
    public void estMort() {
        
        Sediment.getInstance().addMatiere(5);
        
        try {
            Lac.getInstance().remove(this);
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(ObjetBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
    * Indique si l'objet est en vie ou non
    * @return true si l'objet est en vie
    */
    @Override
    public boolean isAlive() {

        return true;
    }

    /**
    * Déplace l'objet
    * @param dt le temps écoulé en millisecondes depuis le précédent déplacement
    */
    @Override
    public void move(long dt) {
    }

    /**
    * Permet à la plante de se reproduire, consomme 30% de son énergie vitale
    */
    public void clonage() {
   
        
        Lac.getInstance().add(new VegetalMarin(this.getLeft() + 20, this.getTop()));
        vitalite -= vitaliteMax*0.3;
 
    }

    /**
    * Permet d'accéder aux variables contenu dans l'énumération Type.
    * @return 
    */
    @Override
    public Type getType() {
            return Type.VegetalMarin;
    }

    @Override
    public void effect(Objet objet) {
    }
}