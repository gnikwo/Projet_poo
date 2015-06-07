package chiens;

import java.util.Vector;
import iut.World;

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
    protected int ageMax = 100;
    /**
     * Stocke l'âge actuel des animaux
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
    protected int tpsGestationMax = 500;
    /**
     * Stocke le temps de gestation courant de l'animal
     */
    protected int tpsGestation = 0;
    /**
     * Borne à atteindre avant de pouvoir remettre à bas
     */
    protected int tpsDepuisBasLimite = 500;
    /**
     * Stocke le temps passé depuis la dernière mise à bas
     */
    protected int tpsDepuisBas = 600;
    /**
     *
     */
    protected Animal reproducteur = null;
    /**
     * Stocke le degré de faim entre 0 et 100
     */
    protected int hunger = 100;
    protected Sexe sexe = null;
    protected Vector<Type> _listeReproduction = new Vector<Type>();

    /**
     * Constructeur de la classe animal
     *
     * @param g
     * @param nom
     * @param x
     * @param y
     */
    public Animal(World g, String nom, int x, int y) {
        super(g, nom, x, y);
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
}
