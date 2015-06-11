package chiens;

import iut.Objet;

/**
 * Classe permettant de créer des Maskinonges et de gérer tout ce qu'ils font ou peuvent faire.
 * 
 * 
 * Hérite de Carnivore.
 */
public class Maskinonge extends Carnivore {

    /**
     * Constructeur de la classe Maskinonge.
     * @param x
     * @param y
     */
    public Maskinonge(int x, int y) {
        super("Sprites/maskinonge", x, y);
        this.sexe = ((int)(Math.random()*2)) > 0.5 ? Sexe.Male : Sexe.Femelle; //condition ternaire : (condition ? retourne ceci si vrai : cela si faux)
        System.out.println("Nouveau Maskinonge " + this.sexe);
        
        this.ageMax = 1400;
        
        this.tpsGestationMax = 80 ;
        this.tpsDepuisBas = 50;
        this.tpsDepuisBasLimite = 40;
        
               
       this.vitalite = 1400;
       this.vitaliteMax =1400;
    }

    /**
     * Permet d'accéder aux variables contenu dans l'énumération Type.
     * @return 
     */
    @Override
    public Type getType() {
        return Type.Maskinonge;
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
    protected void mettreBas() {
                
        if(this.reproducteur.getType() == Type.GrandBrochet){
            Lac.getInstance().add(new BrochetTigre(this.getLeft(), this.getTop()));
        }
        
        if(this.reproducteur.getType() == Type.Maskinonge){
            Maskinonge m2 = new Maskinonge(this.getLeft()+((int)(Math.random()*10))-5,this.getLeft()+((int)(Math.random()*10))-5);
            Lac.getInstance().add(m2);
        }
        
        this.vitalite -= this.vitaliteMax * 0.1;

    }

    @Override
    public void move(long l) {
        super.move(l);
    }
    

        
}
