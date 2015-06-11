package chiens;

import java.util.ArrayList;

/**
 * Classe permettant de gérer les Animaux, tout ce qu'ils font ou peuvent faire.
 * Hérite d'objetDeplacable.
 */
public abstract class Animal extends ObjetDeplacable {

    /**
     * Attribut permettant de définir si les animaux on atteint la maturité et
     * peuvent donc se reproduire.
     */
    protected boolean maturite = false;
    /**
     * Stocke l'âge maximum que peuvent atteindre les animaux.
     */
    protected int ageMax;
    /**
     * Stocke l'âge actuel des animaux.
     */
    protected int age = 0;
    /**
     * Dit si l'animal est en gestation ou non
     */
    protected boolean gestation = false;
    /**
     * Borne de fin de la gestion de l'animal. Lorsqu'elle est atteinte,
     * l'animal met bas
     */
    protected int tpsGestationMax;
    /**
     * Stocke le temps de gestation courant de l'animal
     */
    protected int tpsGestation = 0;
    /**
     * Borne à atteindre avant de pouvoir remettre à bas
     */
    protected int tpsDepuisBasLimite;
    /**
     * Stocke le temps passé depuis la dernière mise à bas
     */
    protected int tpsDepuisBas;
    /**
     *
     */
    protected Animal reproducteur = null;
    /**
     * Stocke le degré de faim entre 0 et 100
     */
    protected int hunger = 100;
    protected Sexe sexe = null;
    protected ArrayList<Type> listeReproduction = new ArrayList<>();
    protected ArrayList<Type> listePredateur = new ArrayList<>();

    /**
     * Constructeur de la classe animal
     *
     * @param nom
     * @param x
     * @param y
     */
    public Animal( String nom, int x, int y) {
        super( nom, x, y);
               
    }

    /**
     * Indique si l'objet est en vie ou non
     *
     * @return true si l'objet est en vie
     */
    @Override
    public boolean isAlive() {

        return true;

    }

    /**
     * Fait évoluer l'objet
     *
     * @param dt le temps écoulé depuis la dernière évolution (en ms)
     */
    @Override
    public void evoluate(long dt) {
        try{
            
            if(this.gestation)
                this.tpsGestation += 10;

            if(this.tpsGestation >= this.tpsGestationMax){

                this.mettreBas();
                this.tpsGestation = 0;
                this.tpsDepuisBas = 0;
                this.gestation = false;
            
            }

            this.hunger--;

            if(this.hunger <= 0){

                this.vitalite--;

            }

            if(this.vitalite <= 0){

                this.estMort();

            }
                
            if(this.age > ageMax*0.3)
                this.maturite = true;
            
            
        }catch(Exception e){
            
            System.out.println(this.getType() + " : " + e.getMessage());
            
        }
    }

    /**
     * Lorsqu'un animal se nourrit, l'objet passé en paramètre disparait
     *
     * @param o
     */
    public void seNourrit(ObjetBase o) {
        this.vitalite += 1; // la vitalite augmente de 1
        o.estMange(); // l'objet disparaît
        this.hunger -= 1; // la faim diminue de 1
    }

    /**
     * Action de reproduction
     *
     * @param o
     */
    public void seReproduit(ObjetBase o) {

        this.reproducteur = (Animal) o;
        this.gestation = true;
        this.tpsGestation = 0;

    }

    /**
     * Permet d'accéder à la variable d'instance age.
     *
     * @return
     */
    protected int getAge() {
        return this.age;
    }

    /**
     * Permet d'accéder à la variable d'instance sexe.
     *
     * @return
     */
    protected Sexe getSexe() {
        return this.sexe;
    }

    /**
     * Permet d'accéder à la variable d'instance maturite.
     *
     * @return
     */
    protected boolean getMaturite() {
        return this.maturite;
    }

    /**
     * Permet d'accéder à la variable d'instance ageMax.
     *
     * @return
     */
    protected int getAgeMax() {
        return this.ageMax;
    }

    /**
     * Permet de déterminer si l'animal femelle, quelque soit la race, porte
     * déjà un enfant ou non.
     *
     * @return
     */
    protected boolean gestation() {
        return this.gestation;
    }

    /**
     * Uniquement pour les femelles, permet de dire si elle est en phase de
     * reproduction ou non (période qui arrive tout les x temps (régulière))
     *
     * @return
     */
    protected boolean phaseReprod() {
        return (this.tpsDepuisBas >= this.tpsDepuisBasLimite);
    }

    /**
     * Créé un nouvel animal + fait consommer de l'énergie vitale à la mère
     */
    protected abstract void mettreBas();

    /**
     * fonction qui vérifie si l'animal a faim ou non.
     *
     * @return
     */
    protected boolean isHungry() {
        return this.hunger < 90;
        
    }
    
    /**
     * Deplace l'objet
     * @param dt le temps écoulé en millisecondes depuis le precedent deplacement
     */
    @Override
    public void move(long dt) {

        ObjetBase predateur = Lac.getInstance().plusPresType(this, this.listePredateur);
        ObjetBase proie = Lac.getInstance().plusPresType(this, this.listeAlimentation);
        
        double distPredateurX = predateur.getMiddleX() - this.getMiddleX();
        double distPredateurY = predateur.getMiddleY() - this.getMiddleY();
        
        double distProieX = proie.getMiddleX() - this.getMiddleX();
        double distProieY = proie.getMiddleY() - this.getMiddleY();
        
        if(Math.sqrt(Math.pow(distPredateurX,2)) + Math.sqrt(Math.pow(distPredateurY,2)) < 300){
            
            this.move(-distPredateurX/10, -distPredateurY/10);
                        
        }else if(Math.sqrt(Math.pow(distProieX,2)) + Math.sqrt(Math.pow(distProieY,2)) < 200){
            
            this.move(distProieX/10, distProieY/10);
            
        }else if(this.getSexe()== Sexe.Femelle){
        
            ObjetBase reproducteur = Lac.getInstance().plusPresRepro(this, this.listeReproduction);
            double distReproducteurX = reproducteur.getMiddleX() - this.getMiddleX();
            double distReproducteurY = reproducteur.getMiddleY() - this.getMiddleY();

            ObjetBase male = Lac.getInstance().plusPresSexe(this, Sexe.Male);
            double distMaleX = male.getMiddleX() - this.getMiddleX();
            double distMaleY = male.getMiddleY() - this.getMiddleY();
            
            if(this.phaseReprod() && Math.sqrt(Math.pow(distReproducteurX,2)) + Math.sqrt(Math.pow(distReproducteurY, 2)) < 200){
                
                this.move(distReproducteurX/10, distReproducteurY/10);
            
            }else if(this.gestation() && Math.sqrt(Math.pow(distMaleX,2)) + Math.sqrt(Math.pow(distMaleY, 2)) < 200){
                
                this.move(-distMaleX/10, -distMaleY/10);
                
            }else{
                
                this.move(vitesseX, vitesseY);
                
            }
            
        }else{
            
            this.move(vitesseX, vitesseY);
            
        }
        
        
        if(this.getMiddleX() > Lac.getInstance().getWidth()){

            System.out.println( this.getMiddleX() - Lac.getInstance().getWidth());
            this.moveX(- (Lac.getInstance().getWidth()));

        }
        
        if(this.getMiddleX() < 0){

            this.moveX(Lac.getInstance().getWidth() - Math.abs(this.getMiddleX()));

        }

        if(this.getTop() < 100){

            this.moveY(100 - this.getTop());
            this.vitesseY *= -1;


        }

        if(this.getBottom() > (Lac.getInstance().getHeight() - Sediment.getInstance().quantiteCourante())){

            this.moveY(Lac.getInstance().getHeight() - Sediment.getInstance().quantiteCourante() - this.getBottom());
            this.vitesseY *= -1;

        }
      
        
    }
    
    
}
