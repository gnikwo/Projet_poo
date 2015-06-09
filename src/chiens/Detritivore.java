package chiens;

import iut.Objet;

/**
 * Classe permettant de g�rer les detritivores tout ce qu'ils font ou peuvent faire.
 * 
 * Hérite de Animal.
 */
public abstract class Detritivore extends Animal {

    public Detritivore(String nom, int x, int y) {
        
        super(nom, x, y);
        listeAlimentation.add(Type.Cadavre);
        listeAlimentation.add(Type.Sediment);
        
             
        listeReproduction.add(Type.Ecrevisse);

        
    }



    /**
     * Déplace l'objet
     * @param dt le temps écoulé en millisecondes depuis le précédent déplacement
     */
    @Override
    public void move(long dt) {
        
        ObjetBase cible = Lac.getInstance().plusPres(this, this.listeReproduction);
        
        double diffX = cible.getMiddleX() - this.getMiddleX();
        double diffY = cible.getMiddleY() - this.getMiddleY();
        
        
        this.move(diffX/100, diffY/100);
        
    }

  

}