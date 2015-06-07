package chiens;

import iut.World;
import iut.Objet;
import java.util.ArrayList;

/**
 * Classe permettant de gerer les Herbivores tout ce qu'ils font ou peuvent faire. 
 * Herite de Animal.
 */
public abstract class Herbivore extends Animal {

    /**
     * Constructeur de la classe Herbivore
     */
    public Herbivore(World g, String nom, int x, int y) {
        
        super(g, nom, x, y);
        _listeAlimentation.add(Type.VegetalMarin);
        
    }

    /**
     * Deplace l'objet
     * @param dt le temps ecoule en millisecondes depuis le precedent deplacement
     */
    public void move(long dt) {
        this.move(vitesseX, vitesseY);
    }

    /**
     * Action : effet d'une collision entre l'objet et le param�tre
     */
    public void effect(Objet o) {
    }

}