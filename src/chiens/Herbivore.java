package chiens;

import iut.World;
import iut.Objet;
import java.util.ArrayList;

/**
 * Classe permettant de g�rer les Herbivores tout ce qu'ils font ou peuvent faire.
 * 
 * H�rite de Animal.
 */
public abstract class Herbivore extends Animal {

    /**
     * Constructeur de la classe Herbivore
     */
    public Herbivore(World g, String nom, int x, int y) {
        
        super(g, nom, x, y);
        _listeAlimentation.add(TypeAlimentation.VegetalMarin);
        
    }

    /**
     * D�place l'objet
     * @param dt le temps �coul� en millisecondes depuis le pr�c�dent d�placement
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