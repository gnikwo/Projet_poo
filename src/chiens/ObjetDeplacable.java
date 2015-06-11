package chiens;

/**
 * Classe permettant de gérer les objetDeplacable tout ce qu'ils font ou peuvent faire.
 * 
 * Hérite d'objetBase.
 */
public abstract class ObjetDeplacable extends ObjetBase {
    /**
     * Attribut privé qui correspond à la vitesse sur l'axe X d'un objet déplaçable.
     */
    protected double vitesseX = 2;
    /**
     * Attribut privé qui correspond à la vitesse sur l'axe Y d'un objet déplaçable.
     */
    protected double vitesseY = -2;
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
     * @author ep298924, nb462425
     * @param nom
     * @param x
     * @param y
     */
    public ObjetDeplacable(String nom, int x, int y) {
         super(nom, x, y);
         
         vitesseX = Math.random() * 10 - 5;
         vitesseY = Math.random() * 10 - 5;
         
    }

    /**
     * Permet d'accéder à la variable d'instance vitesseX.
     * @author tl
     * @return 
     */
    public double getVitesseX() {
            return this.vitesseX;
    }

    /**
     * Permet de modifier la valeur de la variable d'instance vitesseX.
     * @author tl
     * @param vitesseX
     */
    public void setVitesseX(double vitesseX) {
            this.vitesseX = vitesseX;
    }

    /**
     * Permet d'accéder à la variable d'instance vitesseY.
     * @author tl
     * @return 
     */
    public double getVitesseY() {
            return this.vitesseY;
    }

    /**
     * Permet de modifier la valeur de la variable d'instance vitesseY.
     * @author tl
     * @param vitesseY
     */
    public void setVitesseY(double vitesseY) {
            this.vitesseY = vitesseY;
    }

    /**
     * Permet d'accéder à la vitalité de l'objet déplaçable.
     * @author tl
     * @return 
     */
    public int getVitalite() {
            return this.vitalite;
    }

    /**
     * Permet d'accéder à la vitalité maximum de l'objet déplaçable.
     * @author tl
     * @return 
     */
    public int getVitaliteMax() {
            return this.vitaliteMax;
    }
    
    /**
     * Deplace l'objet
     * @param dt le temps écoulé en millisecondes depuis le precedent deplacement
     * @author nb462425
     */
    @Override
    public void move(long dt) {
        
        if(this.getMiddleX() > Lac.getInstance().getWidth()){

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