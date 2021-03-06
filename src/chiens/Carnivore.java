package chiens;

/**
 * Classe permettant de gerer les Carnivores tout ce qu'ils font ou peuvent faire.
 * 
 * Herite de Animal.
 */
public abstract class Carnivore extends Animal {

    /**
     * Constructeur de la classe Carnivore
     * @author ep298924, nb462425
     * @param nom
     * @param x
     * @param y
     */
    public Carnivore( String nom, int x, int y) {

        super(nom, x, y);

        listeAlimentation.add(Type.OtocinclusAffinis);
        listeAlimentation.add(Type.Ecrevisse);
        
    }
    
}