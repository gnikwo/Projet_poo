package chiens;

import iut.Objet;
import iut.World;
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
    private int age;
    /**
    * Attribut stockant l'âge maximum qu'un végétal marin peut atteindre de type Integer.
    */
    private int ageMax;
    
    private int vitalite;
    private int vitaliteMax;

    /**
    * Constructeur de la classe VégetalMarin.
    * @param g
    * @param x
    * @param y
    */
    public VegetalMarin(World g, int x, int y) {
         
      super(g, "Sprites/vegetal_marin", x, y);
      vitaliteMax = 120;
      vitalite = 120;
      ageMax = 100;
      
    }

    /**
    * Fait évoluer l'objet
    * @param dt le temps écoulé depuis la dernière évolution (en ms)
    */
    @Override
    public void evoluate(long dt) {
        
        age ++;
        
        if(age<=50){
            if(this.vitalite >= 30){
 
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
        
        Sediment.getInstance().addMatiere(10);
        
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
   
        if(age>= 50){
        Lac.getInstance().add(new VegetalMarin(Lac.getInstance(), this.getLeft() + 20, this.getTop()));
        vitalite -= vitaliteMax*0.3;
        }
        
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