package chiens;

import iut.Objet;


/**
 * Classe permettant de créer des Planorbes et de gérer tout ce qu'ils font ou peuvent faire.
 * 
 * Hérite de Detritivore.
 */
public class Planorbe extends Detritivore {

    /**
     * Constructeur de la classe Planorbe.
     * @param x
     * @param y
     */
    public Planorbe(int x, int y) {
        super("Sprites/planorbe", x, y);
    }

    /**
     * Permet d'accéder aux variables contenu dans l'énumération Type.
     * @return 
     */
    @Override
    public Type getType() {
        return Type.Planorbe;
    }

    @Override
    public void effect(Objet objet) {
    }

    @Override
    protected void mettreBas() {
    }
}