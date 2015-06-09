package chiens;

import iut.World;
import iut.Objet;

/**
 * Classe permettant de g�rer les Omnivores tout ce qu'ils font ou peuvent faire.
 * 
 * H�rite de Animal.
 */
public abstract class Omnivore extends Animal {

    /**
     * Constructeur de la classe Omnivore
     * @param nom
     * @param x
     * @param y
     */
    public Omnivore(String nom, int x, int y) {

        super(nom, x, y);
        listeAlimentation.add(Type.VegetalMarin);
        listeAlimentation.add(Type.Planorbe);
        
             
        listeReproduction.add(Type.OtocinclusAffinis);

    }

    /**
     * Deplace l'objet
     * @param dt le temps ecoule en millisecondes depuis le precedent deplacement
     */
    @Override
    public void move(long dt) { 
        
        ObjetBase cible = Lac.getInstance().plusPres(this, this.listeReproduction);
        
        double diffX = cible.getMiddleX() - this.getMiddleX();
        double diffY = cible.getMiddleY() - this.getMiddleY();
        
        
        this.move(diffX/100, diffY/100);
    }

    /**
     * Action : effet d'une collision entre l'objet et le parametre
     * @param o
     */
    @Override
    public void effect(Objet o) {
    }

	
}