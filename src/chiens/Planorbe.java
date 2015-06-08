package chiens;

import iut.Objet;


/**
 * Classe permettant de créer des Planorbes et de gérer tout ce qu'ils font ou peuvent faire.
 * 
 * Hérite de Detritivore.
 */
public class Planorbe extends Detritivore {

    /**
     * Constructeur de la classe Planorbe.
     * @param x
     * @param y
     */
    public Planorbe(int x, int y) {
        super("Sprites/planorbe", x, y);
        
        System.out.println("Nouveau Planorbe");
    }

    /**
     * Permet d'accéder aux variables contenu dans l'énumération Type.
     * @return 
     */
    @Override
    public Type getType() {
        return Type.Planorbe;
    }

    @Override
    public void effect(Objet objet) {
        
        if((this.listeReproduction.contains(((ObjetBase)objet).getType()))) {
            
            if(this.phaseReprod()){
            
                if(!this.gestation)
                    this.seReproduit((ObjetBase) objet);
            
            }

        }
        
        if(this.listeAlimentation.contains(((ObjetBase)objet).getType())){
            
            if(this.isHungry()){
                
                this.seNourrit((ObjetBase)objet);
                
            }
            
        } 
    }

    @Override
    protected void mettreBas() {
        l.add(new Planorbe(this.getLeft(), this.getTop()));
        this.vitalite -= this.vitaliteMax*0.1;
    }
}