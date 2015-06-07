package chiens;

import iut.Objet;
import iut.World;
import java.util.ArrayList;

/**
 * Classe permettant de gerer les Carnivores tout ce qu'ils font ou peuvent faire.
 * 
 * Herite de Animal.
 */
public abstract class Carnivore extends Animal {

    /**
     * Constructeur de la classe Carnivore
     * @param g
     * @param nom
     * @param x
     * @param y
     */
    public Carnivore(World g, String nom, int x, int y) {

        super(g, nom, x, y);

        _listeAlimentation.add(Type.Caneton);
        _listeAlimentation.add(Type.OtocinclusAffinis);
        _listeAlimentation.add(Type.Planorbe);
        _listeAlimentation.add(Type.Ecrevisse);
        
        _listeReproduction.add(Type.GrandBrochet);
        _listeReproduction.add(Type.Maskinonge);
        
    }

    /**
     * Deplace l'objet
     * @param dt le temps écoulé en millisecondes depuis le precedent deplacement
     */
    @Override
    public void move(long dt) {
        
        this.move(vitesseX, vitesseY);
    }


}