package chiens;

import iut.Objet;

/**
 * Classe permettant de créer des BrochetTigre et de gérer tout ce qu'ils font ou peuvent faire. (hybride des deux autres carnivore)
 * 
 * Hérite de Carnivore.
 */
public class BrochetTigre extends Carnivore {

    /**
     * Constructeur de la classe BrochetTigre.
     * @param x
     * @param y
     */
    public BrochetTigre(int x, int y) {
        super("sprites/brochet_tigre", x, y);
    }

    /**
    * Créé un nouvel animal + fait consommer de l'énergie vitale à la mère
    */
    protected void mettreBas() {  
    
        
        
    }
    
    /**
     * Permet d'accéder aux variables contenu dans l'énumération Type.
     * @return 
     */
    @Override
    public Type getType() {
            return Type.BrochetTigre;
    }

    @Override
    public void effect(Objet objet) {
    }
}