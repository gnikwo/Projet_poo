package chiens;

import iut.Objet;

/**
 * Classe permettant de gerer les Herbivores tout ce qu'ils font ou peuvent faire. 
 * Herite de Animal.
 */
public abstract class Herbivore extends Animal {

    /**
     * Constructeur de la classe Herbivore
     * @param nom
     * @param x
     * @param y
     */
    public Herbivore(String nom, int x, int y) {
        
        super(nom, x, y);
        listeAlimentation.add(Type.VegetalMarin);

        listeReproduction.add(Type.Planorbe);

    }

}