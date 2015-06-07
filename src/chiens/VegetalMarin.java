package chiens;

import iut.Objet;
import iut.World;

/**
* Classe permettant de gérer les VégétauxMarins tout ce qu'ils font ou peuvent faire.
* 
* Hérite d'objetImmobile.
*/
public class VegetalMarin extends ObjetImmobile {
    /**
    * Attribut stockant l'âge d'un végétal marin de type Integer.
    */
    private int age;
    /**
    * Attribut stockant l'âge maximum qu'un végétal marin peut atteindre de type Integer.
    */
    private int ageMax;

    /**
    * Constructeur de la classe VégetalMarin.
    * @param g
    * @param x
    * @param y
    */
    public VegetalMarin(World g, int x, int y) {
      super(g, "Sprites/vegetal_marin", x, y);
    }

    /**
    * Fait évoluer l'objet
    * @param dt le temps écoulé depuis la dernière évolution (en ms)
    */
    @Override
    public void evoluate(long dt) {
    }

    /**
    * Procédure permettant de faire mourir le végétal marin.
    */
    public void estMort() {
    }

    /**
    * Indique si l'objet est en vie ou non
    * @return true si l'objet est en vie
    */
    @Override
    public boolean isAlive() {

        return true;
    }

    /**
    * Déplace l'objet
    * @param dt le temps écoulé en millisecondes depuis le précédent déplacement
    */
    @Override
    public void move(long dt) {
    }

    /**
    * Permet à la plante de se reproduire, consomme 30% de son énergie vitale
    */
    public void clonage() {
    }

    /**
    * Permet d'accéder aux variables contenu dans l'énumération Type.
    * @return 
    */
    @Override
    public Type getType() {
            return Type.VegetalMarin;
    }

    @Override
    public void effect(Objet objet) {
    }
}