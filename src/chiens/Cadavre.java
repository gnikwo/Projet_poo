package chiens;

import iut.Objet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe permettant de gerer les Cadavre tout ce qu'ils font ou peuvent faire.
 */
public class Cadavre extends ObjetDeplacable {

    /**
     * Constructeur de la classe cadavre.
     * @author ep298924, nb462425
     * @param x
     * @param y
     */
    public Cadavre( int x, int y) {
        super("Sprites/cadavre", x, y);
        this.vitalite =300;
        
    }

    /**
     * Indique si l'objet est en vie ou non
     * @author ep298924
     * @return true si l'objet est en vie
     */
    @Override
    public boolean isAlive() {

        return false;
        
    }

    /**
     * Fait évoluer l'objet
     * @param dt le temps écoulé depuis la dernière évolution (en ms)
     * @author nb462425
     */
    @Override
    public void evoluate(long dt) {
        
        vitalite--;
        if(this.vitalite <= 0){
            
            this.estMort();
            
        }
        
    }

    /**
     * Deplace l'objet
     * @param dt le temps ecoule en millisecondes depuis le precedent deplacement
     * @author nb462425
     */
    @Override
    public void move(long dt) {
        
        if(this.getBottom() < Sediment.getInstance().getTop())
            this.moveY(5);
        
        if(this.getBottom() > Sediment.getInstance().getTop())
            this.moveY(Sediment.getInstance().getTop()-this.getBottom());
        
        this.move(-vitesseX, 0);
        
        super.move(dt);
        
    }

    /**
     * Permet d'acceder aux variables contenu dans l'enumeration Type.
     * @author ma951979
     * @return 
     */
    @Override
    public Type getType() {
        return Type.Cadavre;
    }

    /**
     *
     * @param objet
     */
    @Override
    public void effect(Objet objet) {
    }
    
    /**
     * @author nb462425
     */
    @Override
    public void estMort(){
        
        Sediment.getInstance().addMatiere(5);
        
        try {
            Lac.getInstance().remove(this);
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(ObjetBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}