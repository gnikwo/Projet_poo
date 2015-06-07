package chiens;

import iut.Objet;
import iut.World;
import java.util.ArrayList;

/**
 * Classe permettant de g�rer les detritivores tout ce qu'ils font ou peuvent faire.
 * 
 * Hérite de Animal.
 */
public abstract class Detritivore extends Animal {

    public Detritivore(World g, String nom, int x, int y) {
        
        super(g, nom, x, y);
        _listeAlimentation.add(Type.Cadavre);
        _listeAlimentation.add(Type.Sediment);
        
    }



    /**
     * Déplace l'objet
     * @param dt le temps écoulé en millisecondes depuis le précédent déplacement
     */
    @Override
    public void move(long dt) {
        this.move(vitesseX, vitesseY);
    }

    /**
     * Action : effet d'une collision entre l'objet et le paramétre
     * @param o
     */
    @Override
    public void effect(Objet o) {
    }

}