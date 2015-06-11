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
    private int quantite = 100;
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

    /**
     * @author ma951979
     * @param q
     */
    public void addMatiere(int q){

        quantite += q;

    }
    
    /**
     * @author tl
     * @return
     */
    public int quantiteCourante() {
        
        return this.quantite;
        
    }

    /**
     * @author ma951979
     */
    @Override
    public void estMange() {
        
        quantite -= 1;
        
    }

    
    
    /**
     * Fait évoluer l'objet
     * @param dt le temps écoulé depuis la dernière évolution (en ms)
     * @author nb462425
     */
    @Override
    public void evoluate(long dt) {
        // Height = hauteur et Top = le dessus
        moveY(Lac.getInstance().getHeight()-Sediment.getInstance().quantite - this.getTop());
        System.out.println("Sediment : " + this.getTop());
    }
    
    /**
     * Indique si l'objet est en vie ou non
     * @return true si l'objet est en vie
     * @author ep298924
     */
    @Override
    public boolean isAlive() {
        
        return false;
        
    }

    /**
     * retourne l'attribut instance de type Sédiment.
     * @return 
     * @author nb462425
     */
    public final static Sediment getInstance() {
        
        if(instance == null)
            instance = new Sediment();
        return instance;
    }

    /**
     * Permet d'accéder aux variables contenu dans l'énumération Type.
     * @return 
     * @author ma951979
     */
    @Override
    public Type getType() {
        return Type.Sediment;
    }
    
    /**
     *
     * @param objet
     */
    @Override
    public void effect(Objet objet) {
    }
       
}
