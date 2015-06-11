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
        
        super("Sprites/brochet_tigre", x, y);
        this.sexe = ((int)(Math.random()*2)) > 0.5 ? Sexe.Male : Sexe.Femelle; //condition ternaire : (condition ? retourne ceci si vrai : cela si faux)
        
        this.ageMax=1000;
        
               
       this.vitalite = 1000;
       this.vitaliteMax =1000;
                
    }

    /**
    * Créé un nouvel animal + fait consommer de l'énergie vitale à la mère
    */
    @Override
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
        
                
        if(this.listeAlimentation.contains(((ObjetBase)objet).getType())){
            
            if(this.isHungry()){
                
                this.seNourrit((ObjetBase)objet);
                
            }
            
        }
    }

    @Override
    public void move(long l) {
        
        super.move(l);
        
    }
}