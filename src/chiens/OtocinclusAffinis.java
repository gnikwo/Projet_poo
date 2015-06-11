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
        
        this.listePredateur.add(Type.BrochetTigre);
        this.listePredateur.add(Type.GrandBrochet);
        this.listePredateur.add(Type.Maskinonge);
        
        this.listeReproduction.add(Type.OtocinclusAffinis);
        
        this.ageMax = 1200;
        
        this.tpsGestationMax = 50;
        this.tpsDepuisBas = 40;
        this.tpsDepuisBasLimite = 30;
               
        this.vitalite = 1200;
        this.vitaliteMax =1200;
        
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
        
            
        Lac.getInstance().add(new OtocinclusAffinis(this.getLeft()+(int)(Math.random()*50)-25, this.getTop()+(int)(Math.random()*50)-25));
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
    
    
    @Override
    public void move(long l) {
        
        ObjetBase predateur = Lac.getInstance().plusPresType(this, this.listePredateur);
        ObjetBase proie = Lac.getInstance().plusPresType(this, this.listeAlimentation);
        
        double distPredateurX = predateur.getMiddleX() - this.getMiddleX();
        double distPredateurY = predateur.getMiddleY() - this.getMiddleY();
        
        double distProieX = proie.getMiddleX() - this.getMiddleX();
        double distProieY = proie.getMiddleY() - this.getMiddleY();
        
        if(this.distance(predateur) < 200){
            
            this.move(-distPredateurX/20, -distPredateurY/20);
            if(vitesseX/vitesseY != -distPredateurX/-distPredateurY){
                
                vitesseX = -distPredateurX/100;
                vitesseY = -distPredateurY/100;
                
            }
                                        
        }else if(this.distance(proie) < 200){
            
            this.move(distProieX/100, distProieY/100);
            if(vitesseX/vitesseY != distProieX/distProieY){
                
                vitesseX = distProieX/100;
                vitesseY = distProieY/100;
                
            }
            
        }else if(this.getSexe()== Sexe.Femelle){
        
            ObjetBase reproducteur = Lac.getInstance().plusPresRepro(this, this.listeReproduction);
            double distReproducteurX = reproducteur.getMiddleX() - this.getMiddleX();
            double distReproducteurY = reproducteur.getMiddleY() - this.getMiddleY();
            
            if(this.distance(reproducteur) < 200){
                
                if(this.phaseReprod()){
                
                    this.move(distReproducteurX/100, distReproducteurY/100);
                    if(vitesseX/vitesseY != distReproducteurX/distReproducteurY){

                        vitesseX = distReproducteurX/100;
                        vitesseY = distReproducteurY/100;

                    }
                    
                }else if(this.gestation()){
                    
                    this.move(-distReproducteurX/100, -distReproducteurY/100);
                    if(vitesseX/vitesseY != -distReproducteurX/-distReproducteurY){

                        vitesseX = -distReproducteurX/100;
                        vitesseY = -distReproducteurY/100;

                    }
                    
                }else{
                
                    this.move(vitesseX, vitesseY);
                
                }
            
            }else{
                
                this.move(vitesseX, vitesseY);
                
            }
            
        }else{
            
            this.move(vitesseX, vitesseY);
            
        }
        
        super.move(l);
        
    }
}