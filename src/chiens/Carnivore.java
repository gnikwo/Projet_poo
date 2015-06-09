package chiens;

/**
 * Classe permettant de gerer les Carnivores tout ce qu'ils font ou peuvent faire.
 * 
 * Herite de Animal.
 */
public abstract class Carnivore extends Animal {

    /**
     * Constructeur de la classe Carnivore
     * @param nom
     * @param x
     * @param y
     */
    public Carnivore( String nom, int x, int y) {

        super(nom, x, y);

        listeAlimentation.add(Type.Caneton);
        listeAlimentation.add(Type.OtocinclusAffinis);
        listeAlimentation.add(Type.Planorbe);
        listeAlimentation.add(Type.Ecrevisse);
        
        listeReproduction.add(Type.GrandBrochet);
        listeReproduction.add(Type.Maskinonge);
        
    }

    /**
     * Deplace l'objet
     * @param dt le temps écoulé en millisecondes depuis le precedent deplacement
     */
    @Override
    public void move(long dt) {
        
        
        
        ObjetBase cible = Lac.getInstance().plusPres(this, this.listeReproduction);
        
        double diffX = cible.getMiddleX() - this.getMiddleX();
        double diffY = cible.getMiddleY() - this.getMiddleY();
        
        
        this.move(diffX/100, diffY/100);
        
    }


}