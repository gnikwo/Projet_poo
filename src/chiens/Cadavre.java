package chiens;

import iut.Objet;
import iut.World;

/**
 * Classe permettant de gerer les Cadavre tout ce qu'ils font ou peuvent faire.
 */
public class Cadavre extends ObjetDeplacable {

    /**
     * Constructeur de la classe cadavre.
     */
    public Cadavre(World g, int x, int y) {
        super(g,"Sprites/cadavre", x, y);;
    }

    /**
     * Indique si l'objet est en vie ou non
     * @return true si l'objet est en vie
     */
    public boolean isAlive() {

        return false;
    }

    /**
     * Fait évoluer l'objet
     * @param dt le temps écoulé depuis la dernière évolution (en ms)
     */
    public void evoluate(long dt) {
    }

    /**
     * Deplace l'objet
     * @param dt le temps ecoule en millisecondes depuis le precedent deplacement
     */
    public void move(long dt) {
        this.move(vitesseX, 0);
    }

    /**
     * Permet d'acceder aux variables contenu dans l'enumeration Type.
     */
    public Type getType() {
            return Type.Cadavre;
    }

    @Override
    public void effect(Objet objet) {
    }

}