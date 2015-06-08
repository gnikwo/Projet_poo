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

        this.add(new Planorbe( 10, 900));
        this.add(new Planorbe( 550, 900));
        this.add(new Planorbe( 1300, 900));
        
        this.add(new BrochetTigre(600,500));
        this.add(new BrochetTigre(800,250));
        
        
        this.add(new Caneton(200,50));
        this.add(new Caneton(500,50));
        this.add(new Caneton(800,50));
        this.add(new Caneton(850,50));
        this.add(new Caneton(1500,50));
        
        this.add(new Ecrevisse(90,800));
        this.add(new Ecrevisse(900,800));
        
        this.add(new GrandBrochet(110,200));
        this.add(new GrandBrochet(500,125));

        
        this.add(new Maskinonge(130,135));
        this.add(new Maskinonge(1450,500));
        
        
        this.add(new OtocinclusAffinis(100,600));
        this.add(new OtocinclusAffinis(1000,500));
        this.add(new OtocinclusAffinis(200,650));
        this.add(new OtocinclusAffinis(1200,550));
        
        
        this.add(new VegetalMarin(600,725));
        this.add(new VegetalMarin(150,725));
        this.add(new VegetalMarin(200,725));
        this.add(new VegetalMarin(800,725));
        this.add(new VegetalMarin(1500,725));
        
        this.add(Sediment.getInstance());
    

    }
}
