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
     * Action : effet d'une collision entre l'objet et le param�tre
     * @param o
     */
    @Override
    public void effect(Objet o) {
    }

}