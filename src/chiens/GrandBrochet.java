package chiens;

import iut.Objet;

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
     * @author ep298924,nb462425
     * @param x
     * @param y
     */
    public GrandBrochet(int x, int y) {
        super("Sprites/grand_brochet", x, y);
        this.sexe = ((int)(Math.random()*2)) > 0.5 ? Sexe.Male : Sexe.Femelle; //condition ternaire : (condition ? retourne ceci si vrai : cela si faux)
        
        listeReproduction.add(Type.GrandBrochet);
        listeReproduction.add(Type.Maskinonge);
        
        this.ageMax=1200;
        
        this.tpsGestationMax=85;
        this.tpsDepuisBas = 50;
        this.tpsDepuisBasLimite = 40;
               
        this.vitalite = 1200;
        this.vitaliteMax =1200;

    }

    /**
     * Permet d'accéder aux variables contenu dans l'énumération Type.
     * @author ma951979
     * @return
     */
    @Override
    public Type getType() {
        return Type.GrandBrochet;
    }

    /**
     * @author nb462425, ep298924 
     * @param objet
     */
    @Override
    public void effect(Objet objet) {
        
        if((this.listeReproduction.contains(((ObjetBase)objet).getType())) && (this.sexe.equals(Sexe.Femelle)) && (((Animal)objet).sexe.equals(Sexe.Male))){
            
            if(this.phaseReprod() && (this.maturite)){
            
                if(!this.gestation)
                    this.seReproduit((ObjetBase) objet);
            
            }

        }
        
        if(this.listeAlimentation.contains( ((ObjetBase)objet).getType() )){
            
            if(this.isHungry()){
                
                this.seNourrit((ObjetBase)objet);
                
            }
            
        }
            
        
    }

    /**
     * 
     * Créé un nouvel animal + fait consommer de l'énergie vitale à la mère
     */
    @Override
    protected void mettreBas() {

        
        if(this.reproducteur.getType() == Type.Maskinonge){
            Lac.getInstance().add(new BrochetTigre(this.getLeft(), this.getTop()));
        }
        
        if(this.reproducteur.getType() == Type.GrandBrochet){
            GrandBrochet g2 = new GrandBrochet(this.getLeft()+((int)(Math.random()*10))-5,this.getLeft()+((int)(Math.random()*10))-5);
            Lac.getInstance().add(g2);
        }
        
        this.vitalite -= this.vitaliteMax * 0.1;

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
