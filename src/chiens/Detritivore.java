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
        
             

        
    }

}