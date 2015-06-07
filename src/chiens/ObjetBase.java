package chiens;

import iut.World;
import iut.ObjetTouchable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe permettant de g�rer les objetBase, c'est � dire tout les objets.
 */
public abstract class ObjetBase extends ObjetTouchable {
	
    protected Lac l;
    protected ArrayList<TypeAlimentation> _listeAlimentation = new ArrayList<TypeAlimentation>();

    public ObjetBase(World g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    /**
     * Fonction qui verifie si l'objet de base est ou non un omnivore, en renvoyant true ou false.
     */
    public ArrayList<TypeAlimentation> getAlimentation(){
        return null;
    }

    public Type getType() {
        return null;
    }
        
    public void estMange(){

        try {
            this.l.remove(this);
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(ObjetBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Renvoie la distance entre deux entit�s
     */
    public int distance(ObjetBase o) {
        return 0;
    }

    /**
     * Renvoie l'objet de type t le pres
     */
    public ObjetBase plusPres(Type t) {
        return null;
    }
}