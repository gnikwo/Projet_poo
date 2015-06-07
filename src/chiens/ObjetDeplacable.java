package chiens;

import iut.World;

/**
 * Classe permettant de gérer les objetDeplacable tout ce qu'ils font ou peuvent faire.
 * 
 * Hérite d'objetBase.
 */
public abstract class ObjetDeplacable extends ObjetBase {
    /**
     * Attribut privé qui correspond à la vitesse sur l'axe X d'un objet déplaçable.
     */
    protected double vitesseX;
    /**
     * Attribut privé qui correspond à la vitesse sur l'axe Y d'un objet déplaçable.
     */
    protected double vitesseY;
    /**
     * Attribut privé qui correspond à l'orientation sur l'axe X d'un objet déplaçable.
     */
    protected double orientationX;
    /**
     * Attribut privé qui correspond à l'orientation sur l'axe Y d'un objet déplaçable.
     */
    protected double orientationY;
    /**
     * Attribut privé qui correspond à la vitalité d'un objet déplaçable.
     */
    protected int vitalite;
    /**
     * Attribut privé qui correspond à la vitalité maximum qu'un objet déplaçable peut atteindre.
     */
    protected int vitaliteMax;

    /**
     * Initialise un objet déplaçable.
     * @param g
     * @param nom
     * @param x
     * @param y
     */
    public ObjetDeplacable(World g, String nom, int x, int y) {
         super(g,nom, x, y);
    }

    /**
     * Permet d'accéder à la variable d'instance vitesseX.
     * @return 
     */
    public double getVitesseX() {
            return this.vitesseX;
    }

    /**
     * Permet de modifier la valeur de la variable d'instance vitesseX.
     * @param vitesseX
     */
    public void setVitesseX(double vitesseX) {
            this.vitesseX = vitesseX;
    }

    /**
     * Permet d'accéder à la variable d'instance vitesseY.
     * @return 
     */
    public double getVitesseY() {
            return this.vitesseY;
    }

    /**
     * Permet de modifier la valeur de la variable d'instance vitesseY.
     * @param vitesseY
     */
    public void setVitesseY(double vitesseY) {
            this.vitesseY = vitesseY;
    }

    /**
     * Permet d'accéder à la variable d'instance orientationX.
     * @return 
     */
    public double getOrientationX() {
            return this.orientationX;
    }

    /**
     * Permet de modifier la valeur de la variable d'instance orientationX.
     * @param orientationX
     */
    public void setOrientationX(double orientationX) {
            this.orientationX = orientationX;
    }

    /**
     * Permet d'accéder à la variable d'instance orientationY.
     * @return 
     */
    public double getOrientationY() {
            return this.orientationY;
    }

    /**
     * Permet de modifier la valeur de la variable d'instance orientationX.
     * @param orientationY
     */
    public void setOrientationY(double orientationY) {
            this.orientationY = orientationY;
    }

    @Override
    public void estMange() {
            throw new UnsupportedOperationException();
    }

    public void estMort() {
            throw new UnsupportedOperationException();
    }

    /**
     * Permet d'accéder à la vitalité de l'objet déplaçable.
     * @return 
     */
    public int getVitalite() {
            return this.vitalite;
    }

    /**
     * Permet d'accéder à la vitalité maximum de l'objet déplaçable.
     * @return 
     */
    public int getVitaliteMax() {
            return this.vitaliteMax;
    }
}