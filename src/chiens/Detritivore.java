package chiens;

/**
 * Classe permettant de g�rer les detritivores tout ce qu'ils font ou peuvent faire.
 * 
 * Hérite de Animal.
 */
public abstract class Detritivore extends Animal {

    /**
     * @author ep298924, nb462425
     * @param nom
     * @param x
     * @param y
     */
    public Detritivore(String nom, int x, int y) {
        
        super(nom, x, y);
        listeAlimentation.add(Type.Cadavre);
        listeAlimentation.add(Type.Sediment);
        
    }

}