package chiens;

/**
 * Classe permettant de créer des OtocinclusAffinis et de gérer tout ce qu'ils font ou peuvent faire.
 * 
 * Hérite de Omnivore.
 */
public class OtocinclusAffinis extends Omnivore {

    /**
     * Constructeur de la classe OtocinclusAffinis.
     * @param x
     * @param y
     */
    public OtocinclusAffinis(int x, int y) {
        super("Sprites/otocinclus_affinis", x, y);
    }

    /**
     * Permet d'accéder aux variables contenu dans l'énumération Type.
     * @return 
     */
    @Override
    public Type getType() {
            return Type.OtocinclusAffinis;
    }

    @Override
    protected void mettreBas() {
    }
}