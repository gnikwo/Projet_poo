package chiens;

/**
 * Classe permettant de g�rer les Omnivores tout ce qu'ils font ou peuvent faire.
 * 
 * H�rite de Animal.
 */
public abstract class Omnivore extends Animal {

    /**
     * Constructeur de la classe Omnivore
     * @author ep298924
     * @param nom
     * @param x
     * @param y
     */
    public Omnivore(String nom, int x, int y) {

        super(nom, x, y);
        listeAlimentation.add(Type.VegetalMarin);
        listeAlimentation.add(Type.Planorbe);
        listeAlimentation.add(Type.Ecrevisse);

    }
	
}