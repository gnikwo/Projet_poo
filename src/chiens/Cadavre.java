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
     * @param x
     * @param y
     */
    public Cadavre( int x, int y) {
        
        super("Sprites/cadavre", x, y);
        
        this.vitalite = 250;
        this.vitaliteMax = 250;
        this.vitesseX = 0;
        this.vitesseY = 0 ;
    }

    /**
     * Indique si l'objet est en vie ou non
     * @return true si l'objet est en vie
     */
    @Override
    public boolean isAlive() {

        return false;
        
    }

    /**
     * Fait évoluer l'objet
     * @param dt le temps écoulé depuis la dernière évolution (en ms)
     */
    @Override
    public void evoluate(long dt) {
        
        
        
    }

    /**
     * Deplace l'objet
     * @param dt le temps ecoule en millisecondes depuis le precedent deplacement
     */
    @Override
    public void move(long dt) {
        this.move(vitesseX, 0);
    }

    /**
     * Permet d'acceder aux variables contenu dans l'enumeration Type.
     * @return 
     */
    @Override
    public Type getType() {
        
        return Type.Cadavre;
    }

    @Override
    public void effect(Objet objet) {
    }
    
    
    @Override
    public void estMort(){
        
        
        System.out.println("Deviens sédiment");
        Sediment.getInstance().addMatiere(100);
        
        try {
            Lac.getInstance().remove(this);
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(ObjetBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}