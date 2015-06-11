package chiens;

import iut.Objet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe permettant de gérer les sédiments tout ce qu'ils font ou peuvent
 * faire.
 *
 * Hérite d'objetImmobile.
 */
public final class Sediment extends ObjetImmobile {

    /**
     * Attribut stockant la quantité de sédiment de type Integer.
     */
    private int quantite = 10;
    /**
     * Attribut stockant la quantité maximum de sédiment qu'il peut y avoir de
     * type Integer.
     */
    private int quantiteMax = 10000;
    /**
     * Instancie sédiment.
     */
    static private Sediment instance;

    /**
     * Constructeur de la classe Sédiment.
     */
    private Sediment() {
        super("Sprites/sediment",0, 0);
    }

    public void addMatiere(int q){

        quantite += q;

    }
    
    
    
    public int quantiteCourante() {
        
        return this.quantite;
        
    }

    
    @Override
    public void estManger() {
        
        quantite -= 1;
        
    }

    
    
    /**
     * Fait évoluer l'objet
     * @param dt le temps écoulé depuis la dernière évolution (en ms)
     */
    @Override
    public void evoluate(long dt) {
        // Height = hauteur et Top = le dessus
        moveY(Lac.getInstance().getHeight()-Sediment.getInstance().quantiteCourante());
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
     * retourne l'attribut instance de type Sédiment.
     * @return 
     */
    public final static Sediment getInstance() {
        
        if(instance == null)
            instance = new Sediment();
        return instance;
    }

    /**
     * Permet d'accéder aux variables contenu dans l'énumération Type.
     * @return 
     */
    @Override
    public Type getType() {
        return Type.Sediment;
    }
    
    
    @Override
    public void effect(Objet objet) {
    }
       
}
