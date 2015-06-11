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
     * @author ep298924, nb462425
     * @param x
     * @param y
     */
    public Planorbe(int x, int y) {
       super("Sprites/planorbe", x, y);
         
       this.listePredateur.add(Type.OtocinclusAffinis);
        
       this.ageMax = 2000;
       
       this.tpsGestationMax=25;
       this.tpsDepuisBas = 50;
       this.tpsDepuisBasLimite = 30;
      
       this.vitalite = 2000;
       this.vitaliteMax =2000;
       
       this.sexe = Sexe.Hermaphrodite;
       
    }

    /**
     * Permet d'accéder aux variables contenu dans l'énumération Type.
     * @author ma951979
     * @return 
     */
    @Override
    public Type getType() {
        return Type.Planorbe;
    }

    /**
     * @author ma951979
     * @param objet
     */
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
        Lac.getInstance().add(new Planorbe(this.getLeft(), this.getTop()));
        this.vitalite -= this.vitaliteMax*0.1;
    }

    @Override
    public void move(long l) {
        
        ObjetBase predateur = Lac.getInstance().plusPresType(this, this.listePredateur);
        ObjetBase proie = Lac.getInstance().plusPresType(this, this.listeAlimentation);
        
        double distPredateurX = predateur.getMiddleX() - this.getMiddleX();
        double distPredateurY = predateur.getMiddleY() - this.getMiddleY();
        
        double distProieX = proie.getMiddleX() - this.getMiddleX();
        double distProieY = proie.getMiddleY() - this.getMiddleY();
        
        if(this.distance(predateur) < 300){
            
            this.move(-distPredateurX/20, 0);
            if(vitesseX/vitesseY != -distPredateurX/-distPredateurY){
                
                vitesseX = -distPredateurX/100;
                vitesseY = -distPredateurY/100;
                
            }
                                        
        }else if(this.distance(proie) < 200){
            
            this.move(distProieX/100, 0);
            if(vitesseX/vitesseY != distProieX/distProieY){
                
                vitesseX = distProieX/100;
                vitesseY = distProieY/100;
                
            }
            
        }else if(this.getSexe()== Sexe.Hermaphrodite){
        
            ObjetBase reproducteur = Lac.getInstance().plusPresRepro(this, this.listeReproduction);
            double distReproducteurX = reproducteur.getMiddleX() - this.getMiddleX();
            double distReproducteurY = reproducteur.getMiddleY() - this.getMiddleY();
            
            if(this.distance(reproducteur) < 200){
                
                if(this.phaseReprod()){
                
                    this.move(distReproducteurX/100, 0);
                    if(vitesseX/vitesseY != distReproducteurX/distReproducteurY){

                        vitesseX = distReproducteurX/100;
                        vitesseY = distReproducteurY/100;

                    }
                    
                }else if(this.gestation()){
                    
                    this.move(-distReproducteurX/100, 0);
                    if(vitesseX/vitesseY != -distReproducteurX/-distReproducteurY){

                        vitesseX = -distReproducteurX/100;
                        vitesseY = -distReproducteurY/100;

                    }
                    
                }else{
                
                    this.move(vitesseX, 0);
                
                }
            
            }else{
                
                this.move(vitesseX, 0);
                
            }
            
        }else{
            
            this.move(vitesseX, 0);
            
        }
        
        if(this.getBottom() < Lac.getInstance().getHeight() - Sediment.getInstance().quantiteCourante()){
            
            this.moveY(Lac.getInstance().getHeight() - Sediment.getInstance().quantiteCourante() - this.getBottom());
            
        }
        
        
        super.move(l);
        
    }
}