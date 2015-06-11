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
     * @author ep298924, nb462425
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
     * @author ma951979
     * @return 
     */
    @Override
    public Type getType() {
        return Type.BrochetTigre;
    }

    /**
     * @author nb462425
     * @param objet
     */
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
        
        ObjetBase proie = Lac.getInstance().plusPresType(this, this.listeAlimentation);
        
        double distProieX = proie.getMiddleX() - this.getMiddleX();
        double distProieY = proie.getMiddleY() - this.getMiddleY();
        
        if(this.distance(proie) < 200){
            
            this.move(distProieX/100, distProieY/100);
            if(vitesseX/vitesseY != distProieX/distProieY){
                
                vitesseX = distProieX/100;
                vitesseY = distProieY/100;
                
            }
            
        }else{
            
            this.move(vitesseX, vitesseY);
            
        }
        
        super.move(l);
        
    }
}