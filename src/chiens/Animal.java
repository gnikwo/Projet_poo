package chiens;

import java.util.Vector;
import iut.World;

/**
 * Classe permettant de gérer les Animaux, tout ce qu'ils font ou peuvent faire.
 * Hérite d'objetDeplacable.
 */
public abstract class Animal extends ObjetDeplacable {
    /**
     * Attribut permettant de définir si les animaux on atteint la maturité et peuvent donc se reproduire.
     */
    protected boolean maturite;
    /**
     * Stocke l'âge maximum que peuvent atteindre les animaux.
     */
    protected int ageMax;
    /**
     * Stocke l'âge actuel des animaux
     */
    protected int age;
    /**
     * Dit si l'animal est en gestation ou non
     */
    protected boolean gestation;
    /**
     * Borne de fin de la gestion de l'animal. Lorsqu'elle est atteinte, l'animal met bas
     */
    protected int tpsGestationMax;
    /**
     * Stocke le temps de gestation courant de l'animal
     */
    protected int tpsGestation;
    /**
     * Borne à atteindre avant de pouvoir remettre à bas
     */
    protected int tpsDepuisBasLimite;
    /**
     * Stocke le temps passé depuis la dernière mise à bas
     */
    protected int tpsDepuisBas;
    /**
     * Stocke le degré de faim entre 0 et 100
     */
    protected int hunger;
    public Animal unnamed_Animal_;
    protected Sexe sexe;
    public Vector<TypeReproduction> _listeReproduction = new Vector<TypeReproduction>();

    /**
     * Constructeur de la classe animal
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
     * @return true si l'objet est en vie
     */
    @Override
    public boolean isAlive() {

        return true;

    }

    /**
     * Fait évoluer l'objet
     * @param dt le temps écoulé depuis la dernière évolution (en ms)
     */
    @Override
    public void evoluate(long dt) {
    }

    /**
    * Lorsqu'un animal se nourrit, l'objet passé en paramètre disparait
    * @param o
    */
   public void seNourrit(ObjetBase o) {
       this.vitalite += 1 ; // la vitalite augmente de 1
       o.estMange(); // l'objet disparaît
       this.hunger -= 1; // la faim diminue de 1
    }

    /**
    * Action de reproduction
    * @param o
    */
   public void seReproduit(ObjetBase o) {

   }

    /**
    * Permet d'accéder à la variable d'instance age.
    * @return 
    */
    protected int getAge() {
        return this.age;
    }

    /**
    * Permet d'accéder à la variable d'instance sexe.
    * @return 
    */
    protected Sexe getSexe() {
            return this.sexe;
    }

    /**
    * Permet d'accéder à la variable d'instance maturite.
    * @return 
    */
   protected boolean getMaturite() {
        return this.maturite;
   }

    /**
     * Permet d'accéder à la variable d'instance ageMax.
     * @return 
     */
    protected int getAgeMax() {
            return this.ageMax;
    }

    /**
     * Permet de déterminer si l'animal femelle, quelque soit la race, porte déjà un enfant ou non.
     * @return 
     */
    protected boolean gestation() {
            return this.gestation;
    }

    /**
     * Uniquement pour les femelles, permet de dire si elle est en phase de reproduction ou non (période qui arrive tout les x temps (régulière))
     * @return 
     */
    protected boolean phaseReprod() {
        return this.phaseReprod();
    }

    /**
    * Créé un nouvel animal + fait consommer de l'énergie vitale à la mère
    */
    protected void mettreBas() {

    }

    /**
     * fonction qui vérifie si l'animal a faim ou non.
     * @return 
     */
    protected boolean isHungry() {
        return this.isHungry();
    }
}