package chiens;

/**
 * Classe permettant de gérer les objetImmobiles tout ce qu'ils font ou peuvent faire.
 * 
 * Hérite d'objetBase.
 */
public abstract class ObjetImmobile extends ObjetBase {

    /**
     * Constructeur de la classe objetImmobile.
     * @param nom
     * @param x
     * @param y
     */
    public ObjetImmobile(String nom, int x, int y) {
        super(nom, x, y);
    }

    
    /**
     * Déplace l'objet
     *
     * @param dt le temps écoulé en millisecondes depuis le précédent
     * déplacement
     */
    @Override
    public void move(long dt) {
    }

}