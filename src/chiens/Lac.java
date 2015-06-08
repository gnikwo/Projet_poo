package chiens;

import iut.World;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Toolkit;

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
        
        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int hauteur = (int)tailleEcran.getHeight();
        int largeur = (int)tailleEcran.getWidth(); 
       
        if(Lac.instance == null)
        
        instance = new Lac(largeur, hauteur, "Lac");
        
       return instance;
      
    }
    
    /**
     * créé les objets de départ du monde
     */
    @Override
    public void createObjects() {

        this.add(Sediment.getInstance());

        this.add(new Planorbe((int)( this.getWidth()*0.1),(int)(this.getHeight()*0.9)));
        this.add(new Planorbe((int)( this.getWidth()*0.9),(int)(this.getHeight()*0.9)));
        this.add(new Planorbe((int)( this.getWidth()*0.6),(int)(this.getHeight()*0.9)));
        
        this.add(new BrochetTigre((int)( this.getWidth()*0.5),(int)(this.getHeight()*0.5)));
        this.add(new BrochetTigre((int)( this.getWidth()*0.7),(int)(this.getHeight()*0.2)));
        
        this.add(new Caneton((int)( this.getWidth()*0.4),(int)(this.getHeight()*0.025)));
        this.add(new Caneton((int)( this.getWidth()*0.6),(int)(this.getHeight()*0.025)));
        this.add(new Caneton((int)( this.getWidth()*0.8),(int)(this.getHeight()*0.025)));
        this.add(new Caneton((int)( this.getWidth()*0.2),(int)(this.getHeight()*0.025)));
        this.add(new Caneton((int)( this.getWidth()*0.1),(int)(this.getHeight()*0.025)));
        
        this.add(new Ecrevisse((int)( this.getWidth()*0.3),(int)(this.getHeight()*0.8)));
        this.add(new Ecrevisse((int)( this.getWidth()*0.7),(int)(this.getHeight()*0.8)));
        // A terminer 
        this.add(new GrandBrochet(110,200));
        this.add(new GrandBrochet(500,600));

        
        this.add(new Maskinonge(600,350));
        this.add(new Maskinonge(1450,500));
        
        
        this.add(new OtocinclusAffinis(100,600));
        this.add(new OtocinclusAffinis(1000,500));
        this.add(new OtocinclusAffinis(200,650));
        this.add(new OtocinclusAffinis(1200,550));
        
        
        this.add(new VegetalMarin((int)( this.getWidth()*0.2),(int)(this.getHeight()*0.77)));
        this.add(new VegetalMarin((int)( this.getWidth()*0.5),(int)(this.getHeight()*0.75)));
        this.add(new VegetalMarin((int)( this.getWidth()*0.6),(int)(this.getHeight()*0.75)));
        this.add(new VegetalMarin((int)( this.getWidth()*0.8),(int)(this.getHeight()*0.75)));
        this.add(new VegetalMarin((int)( this.getWidth()*0.10),(int)(this.getHeight()*0.75)));
        

    }
}
