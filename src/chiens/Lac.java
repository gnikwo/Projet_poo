package chiens;

import iut.World;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Classe représentant le lac ou l'aquarium dans lequel les animaux vont évoluer
 */
public final class Lac extends World {

    public static Lac instance;
    
    private Lac(int largeur, int hauteur, String title) {
        super(largeur, hauteur, title);
    }

    /**
     * Dessine le fond d'écran
     *
     * @param g la surface d'affichage
     */
    @Override
    public void drawBackground(Graphics g) {
        
        try{
        Image img = ImageIO.read(new File("src/Sprites/background.png"));
        g.drawImage(img, 0, 0, this.width(), this.height(), this);
        }catch(IOException e){
        }
    }

    public static Lac getInstance(){
        
       if(Lac.instance == null)
           instance = new Lac(1820, 980, "Lac");
        
       return instance;
      
    }
    
    /**
     * créé les objets de départ du monde
     */
    @Override
    public void createObjects() {

        /*this.add(new Planorbe( 10, 20));
        this.add(new Planorbe( 15, 25));
        this.add(new BrochetTigre(30,35));
        this.add(new BrochetTigre(40,45));
        this.add(new Caneton(70,75));
        this.add(new Caneton(80,85));
        this.add(new Ecrevisse(90,95));
        this.add(new Ecrevisse(100,105));*/
        
        /*GrandBrochet g2 = new GrandBrochet(110,115);
        this.add(g2);
        GrandBrochet g = new GrandBrochet(500,125);
        g.setVitesseX(-3);
        this.add(g);*/
        //this.add(new Maskinonge(130,135));
        //this.add(new Maskinonge(140,145));
        //this.add(new OtocinclusAffinis(150,155));
        //this.add(new OtocinclusAffinis(160,165));
        this.add(new VegetalMarin(600,450));
        this.add(new VegetalMarin(150,450));
        //this.add(Sediment.getInstance());
    

    }
}
