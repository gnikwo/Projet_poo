package chiens;

import iut.ObjetTouchable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe permettant de gérer les objetBase, c'est à dire tout les objets.
 */
public abstract class ObjetBase extends ObjetTouchable {
	
    /**
     *
     */
    protected ArrayList<Type> listeAlimentation = new ArrayList<>();

    /**
     * @author tl
     * @param nom
     * @param x
     * @param y
     */
    public ObjetBase(String nom, int x, int y) {
        super(Lac.getInstance(),nom, x, y);
    }

    /**
     * @author ma951979
     * Fonction qui verifie si l'objet de base est ou non un omnivore, en renvoyant true ou false.
     * @return 
     */
    public ArrayList<Type> getAlimentation(){
        return listeAlimentation;
    }

    /**
     * @author ma951979
     * @return
     */
    public Type getType() {
        return null;
    }
        
    /**
     * @author tl
     */
    public void estMange(){

        try {
            Lac.getInstance().remove(this);
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(ObjetBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * @ author ma951979
     */
    public void estMort(){
        System.out.println("est Mort");
        Lac.getInstance().add(new Cadavre(this.getMiddleX(), this.getMiddleY()));
        
        try {
            Lac.getInstance().remove(this);
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(ObjetBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Renvoie la distance entre deux entit�s
     * @author nb462425
     * @param o
     * @return 
     */
    public double distance(ObjetBase o) {
                
        double a = Math.sqrt(Math.pow(o.getMiddleX()-this.getMiddleX(),2) + Math.pow(o.getMiddleY()-this.getMiddleY(),2));

        return Math.abs(a);
    }
    
    /**
     * @author ma951979
     * @return
     */
    public boolean estAnimal(){
        
        return false;
        
    }

}