package chiens;

import java.awt.Color;
import java.awt.Graphics;
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
     * Stocke le reproducteur
     */
    protected Animal reproducteur = null;
    /**
     * Stocke le degré de faim entre 0 et 100
     */
    protected int hunger = 100;

    /**
     * Permet de donner un sexe aux animaux
     */
    protected Sexe sexe = null;

    /**
     * Permet de déterminer qui se reproduit avec qui
     */
    protected ArrayList<Type> listeReproduction = new ArrayList<>();

    /**
     * Permet de déterminer qui mange qui
     */
    protected ArrayList<Type> listePredateur = new ArrayList<>();

    /**
     * Constructeur de la classe animal
     * @author ep298924
     * @param nom
     * @param x
     * @param y
     */
    public Animal( String nom, int x, int y) {
        super( nom, x, y);
               
    }

    /**
     * Indique si l'objet est en vie ou non
     * @author ep298924
     * @return true si l'objet est en vie
     */
    @Override
    public boolean isAlive() {

        return true;

    }

    /**
     * Fait évoluer l'objet
     * @author nb462425
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

            this.hunger-= 0.1;

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
     * @author nb462425
     * @param o
     */
    public void seNourrit(ObjetBase o) {
        this.vitalite += 10; // la vitalite augmente de 1
        o.estMange(); // l'objet disparaît
        this.hunger += 30; // la faim diminue de 1
    }

    /**
     * Action de reproduction
     * @author tl
     * @param o
     */
    public void seReproduit(ObjetBase o) {

        this.reproducteur = (Animal) o;
        this.gestation = true;
        this.tpsGestation = 0;

    }

    /**
     * Permet d'accéder à la variable d'instance age.
     * @author ma951979
     * @return
     */
    protected int getAge() {
        return this.age;
    }

    /**
     * Permet d'accéder à la variable d'instance sexe.
     * @author tl 
     * @return
     */
    protected Sexe getSexe() {
        return this.sexe;
    }

    /**
     * Permet d'accéder à la variable d'instance maturite.
     * @author ma951979
     * @return
     */
    protected boolean getMaturite() {
        return this.maturite;
    }

    /**
     * Permet d'accéder à la variable d'instance ageMax.
     * @author ma951979
     * @return
     */
    protected int getAgeMax() {
        return this.ageMax;
    }

    /**
     * Permet de déterminer si l'animal femelle, quelque soit la race, porte
     * déjà un enfant ou non.
     * @author tl
     * @return
     */
    protected boolean gestation() {
        return this.gestation;
    }

    /**
     * Uniquement pour les femelles, permet de dire si elle est en phase de
     * reproduction ou non (période qui arrive tout les x temps (régulière))
     * @author nb462425
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
     * @author ma951979
     * @return
     */
    protected boolean isHungry() {
        return this.hunger < 70;
        
    }
    
    /**
     * permet de savoir si l'objet est un animal
     * @author nb462425
     * @return
     */
    @Override
    public boolean estAnimal(){
        
        return true;
        
    }
        
    @Override
    public void draw(Graphics g) throws Exception{
        
        super.draw(g);
        
        if(info){
            g.setColor(new Color(10,10,10,50));
            g.fillRect(this.getMiddleX(), this.getMiddleY(), (int)(this.getWidth()*1.5), (int)(this.getWidth()));
            g.setColor(new Color(255,0,0));
            
            g.drawLine(this.getMiddleX(), this.getMiddleY(), (int)this.vitesseX*50 + this.getMiddleX(), (int)this.vitesseY*50 + this.getMiddleY());
            
            g.setColor(new Color(0,0,0));
            g.drawString("Type : " + this.getType(), this.getMiddleX()+2, this.getMiddleY()+10);
            g.drawString("Age : " + this.age + "/" + this.ageMax, this.getMiddleX()+2, this.getMiddleY()+20);
            g.drawString("Vitalite : " + this.vitalite, this.getMiddleX()+2, this.getMiddleY()+30);
            g.drawString("Hunger : " + this.hunger, this.getMiddleX()+2, this.getMiddleY()+40);
            g.drawString("Sexe : " + this.sexe, this.getMiddleX()+2, this.getMiddleY()+50);
            if(this.sexe.equals(Sexe.Femelle)){
                
                g.drawString("  Gestation : " + this.gestation, this.getMiddleX()+2, this.getMiddleY()+60);
                g.drawString("  Temps gestation : " + this.tpsGestation + "/" + this.tpsGestationMax, this.getMiddleX()+2, this.getMiddleY()+70);
                g.drawString("  Temps depuis bas : " + this.tpsDepuisBas+ "/" + this.tpsDepuisBasLimite, this.getMiddleX()+2, this.getMiddleY()+80);
               
            }
        }
        
    }
    
    
    
}
