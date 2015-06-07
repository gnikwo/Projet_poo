package chiens;

import iut.Objet;
import iut.World;

/**
 * Classe permettant de créer des GrandBrochets et de gérer tout ce qu'ils font
 * ou peuvent faire.
 *
 *
 * Hérite de Carnivore.
 */
public class GrandBrochet extends Carnivore {

    /**
     * Constructeur de la classe GrandBrochet.
     *
     * @param g
     * @param x
     * @param y
     */
    public GrandBrochet(World g, int x, int y) {
        super(g, "Sprites/grand_brochet", x, y);
    }

    /**
     * Permet d'accéder aux variables contenu dans l'énumération Type.
     *
     * @return
     */
    @Override
    public Type getType() {
        return Type.GrandBrochet;
    }

    @Override
    public void effect(Objet objet) {
        
        
        if((this._listeReproduction.contains( ((ObjetBase) objet).getType() )) && (this.sexe.equals(Sexe.Femelle)) ){
            
            if(this.tpsDepuisBas >= this.tpsDepuisBasLimite){
            
                if(!this.gestation)
                    this.seReproduit((ObjetBase) objet);
            
            }

        }
            
        
    }

    /**
     * Créé un nouvel animal + fait consommer de l'énergie vitale à la mère
     */
    @Override
    protected void mettreBas() {

        
        if(this.reproducteur.getType() == Type.Maskinonge){
            l.add(new BrochetTigre(this.l, this.getLeft(), this.getTop()));
        }
        
        if(this.reproducteur.getType() == Type.GrandBrochet){
            GrandBrochet g2 = new GrandBrochet(Lac.getInstance(),this.getLeft()+100,this.getLeft()+100);
            g2.sexe = Sexe.Male;
            g2.setVitesseY(2);
            Lac.getInstance().add(g2);
        }
        
        //this.vitalite -= this.vitaliteMax * 0.1;

    }

}
