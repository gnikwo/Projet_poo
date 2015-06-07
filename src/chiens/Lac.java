package chiens;

import iut.Sprite;
import iut.SpriteStore;
import iut.World;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Classe représentant le lac ou l'aquarium dans lequel les animaux vont évoluer
 */
public class Lac extends World {

    public Lac(int largeur, int hauteur, String title) {
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
        Image img = ImageIO.read(new File("Sprites/background.png"));
        g.drawImage(img, 0, 0, this.width(), this.height(), this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * créé les objets de départ du monde
     */
    public void createObjects() {

        this.add(new Planorbe(this, 10, 20));
        this.add(new Planorbe(this, 15, 25));
        this.add(new BrochetTigre(this,30,35));
        this.add(new BrochetTigre(this,40,45));
        this.add(new Cadavre(this,50,55));
        this.add(new Cadavre(this,60,65));
        this.add(new Caneton(this,70,75));
        this.add(new Caneton(this,80,85));
        this.add(new Ecrevisse(this,90,95));
        this.add(new Ecrevisse(this,100,105));
        this.add(new GrandBrochet(this,110,115));
        this.add(new GrandBrochet(this,120,125));
        this.add(new Maskinonge(this,130,135));
        this.add(new Maskinonge(this,140,145));
        this.add(new OtocinclusAffinis(this,150,155));
        this.add(new OtocinclusAffinis(this,160,165));
        this.add(Sediment.getInstance());
        this.add(Sediment.getInstance());
        this.add(new VegetalMarin(this, 170,175));
        this.add(new VegetalMarin(this,180,185));


    }
}
