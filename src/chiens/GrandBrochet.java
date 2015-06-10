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
     *
     * @param x
     * @param y
     */
    public GrandBrochet(int x, int y) {
        super("Sprites/grand_brochet", x, y);
        this.sexe = ((int)(Math.random()*2)) > 0.5 ? Sexe.Male : Sexe.Femelle; //condition ternaire : (condition ? retourne ceci si vrai : cela si faux)
        System.out.println("Nouveau GrandBrochet " + this.sexe);

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
        super.move(l);
    }

}
