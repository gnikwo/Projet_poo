package chiens;

import iut.Objet;

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
                
        this.sexe = ((int)(Math.random()*2)) > 0.5 ? Sexe.Male : Sexe.Femelle; //condition ternaire : (condition ? retourne ceci si vrai : cela si faux)
        System.out.println("Nouveau OtocinclusAffinis" + this.sexe);
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
        
            
        l.add(new OtocinclusAffinis(this.getLeft(), this.getTop()));
        this.vitalite -= this.vitaliteMax*0.1;
    }
    
    @Override
    public void effect(Objet objet) {
            
        if((this.listeReproduction.contains(((ObjetBase)objet).getType())) && (this.sexe.equals(Sexe.Femelle)) && (((Animal)objet).sexe.equals(Sexe.Male))){
            
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
}