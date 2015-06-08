package chiens;

import iut.Objet;

/**
 * Classe permettant de créer des Maskinonges et de gérer tout ce qu'ils font ou peuvent faire.
 * 
 * 
 * Hérite de Carnivore.
 */
public class Maskinonge extends Carnivore {

    /**
     * Constructeur de la classe Maskinonge.
     * @param x
     * @param y
     */
    public Maskinonge(int x, int y) {
        super("Sprites/maskinonge", x, y);
    }

    /**
     * Permet d'accéder aux variables contenu dans l'énumération Type.
     * @return 
     */
    @Override
    public Type getType() {
        return Type.Maskinonge;
    }

    @Override
    public void effect(Objet objet) {
    }

    @Override
    protected void mettreBas() {
        
    }
}