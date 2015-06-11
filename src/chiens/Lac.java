package chiens;

import iut.Objet;
import iut.World;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant le lac ou l'aquarium dans lequel les animaux vont évoluer
 */
public final class Lac extends World {

    /**
     *
     */
    public static Lac instance;

    /**
     *
     */
    protected ArrayList<ObjetBase> liste = new ArrayList<>();
    
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

    /**
     *
     * @return
     */
    public static Lac getInstance(){
        
        //Méthode qui permet d'adapter la fenêtre à la taille de l'écran.
        
        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int hauteur = (int)tailleEcran.getHeight()-100;
        int largeur = (int)tailleEcran.getWidth()-50; 
       
        if(Lac.instance == null)
        
        instance = new Lac(largeur, hauteur, "Lac");
        
       return instance;
      
    }
    
    /**
     * Renvoie l'objet de type t le pres
     * @param o
     * @param t
     * @return      
     */
    public ObjetBase plusPresType(ObjetBase o, ArrayList<Type> t) {
        
        double dist = this.getWidth();
        int indice = 0;
        
        for(int i = 0; i < liste.size(); i++){
            
            if(this.liste.get(i).distance(o) < dist){
                
                if(t.contains(liste.get(i).getType())){
                    
                    dist = this.liste.get(i).distance(o);
                    indice = i;
                    
                }
                
            }
                        
        }
              
        return this.liste.get(indice);
        
    }
    
    /**
     * Renvoie l'objet de type t le pres
     * @param o
     * @param t
     * @return      
     */
    public ObjetBase plusPresRepro(ObjetBase o, ArrayList<Type> t) {
        
        double dist = this.getWidth();
        int indice = 0;
        
        for(int i = 0; i < liste.size(); i++){
            
            if(this.liste.get(i).distance(o) < dist){
                
                if(t.contains(liste.get(i).getType()) && (((Animal)(liste.get(i))).getSexe() == Sexe.Male)){
                    
                    dist = this.liste.get(i).distance(o);
                    indice = i;
                    
                }
                
            }
                        
        }
              
        return this.liste.get(indice);
        
    }
    
    /**
     * Renvoie l'objet de type t le pres
     * @param o
     * @param s
     * @return      
     */
    public ObjetBase plusPresSexe(ObjetBase o, Sexe s) {
        
        double dist = this.getWidth();
        int indice = 0;
        
        for(int i = 0; i < liste.size(); i++){
            
            if(this.liste.get(i).distance(o) < dist){
                
                try{
                    
                    if(s.equals(((Animal)(liste.get(i))).getSexe())){

                        dist = this.liste.get(i).distance(o);
                        indice = i;

                    }
                    
                }catch(Exception e){
                    
                    
                }
                
            }
                        
        }
              
        return this.liste.get(indice);
        
    }
    
    /**
     *
     * @param o
     */
    @Override
    public void add(Objet o){
        super.add(o);
        this.liste.add((ObjetBase)o);
    }
   
    /**
     *
     * @param o
     */
    @Override
    public void remove(Objet o){
        
        super.remove(o);
        this.liste.remove(o);
        
    }
    
    
    /**
     * créé les objets de départ du monde
     */
    @Override
    public void createObjects() {

        
        
        this.add(Sediment.getInstance());

        //Permet de fixer la position des poissons grâce aux pourcentages.
        
        
        this.add(new BrochetTigre((int)( this.getWidth()*0.5),(int)(this.getHeight()*0.5)));
        this.add(new BrochetTigre((int)( this.getWidth()*0.7),(int)(this.getHeight()*0.2)));
        
        this.add(new Caneton((int)( this.getWidth()*0.4),(int)(this.getHeight()*0.025)));
        this.add(new Caneton((int)( this.getWidth()*0.6),(int)(this.getHeight()*0.020)));
        this.add(new Caneton((int)( this.getWidth()*0.7),(int)(this.getHeight()*0.025)));
        this.add(new Caneton((int)( this.getWidth()*0.2),(int)(this.getHeight()*0.025)));
        this.add(new Caneton((int)( this.getWidth()*0.1),(int)(this.getHeight()*0.025)));
        
        this.add(new Ecrevisse((int)( this.getWidth()*0.3),(int)(this.getHeight()*0.8)));
        this.add(new Ecrevisse((int)( this.getWidth()*0.7),(int)(this.getHeight()*0.8)));
        
        this.add(new GrandBrochet((int)( this.getWidth()*0.2),(int)(this.getHeight()*0.2)));
        this.add(new GrandBrochet((int)( this.getWidth()*0.3),(int)(this.getHeight()*0.3)));

        this.add(new Cadavre((int)( this.getWidth()*0.5), 20));
        
        this.add(new Maskinonge((int)( this.getWidth()*0.2),(int)(this.getHeight()*0.7)));
        this.add(new Maskinonge((int)( this.getWidth()*0.1),(int)(this.getHeight()*0.2)));
        
        this.add(new Planorbe((int)( this.getWidth()*0.1),(int)(this.getHeight()*0.8)));
        this.add(new Planorbe((int)( this.getWidth()*0.9),(int)(this.getHeight()*0.8)));
        this.add(new Planorbe((int)( this.getWidth()*0.6),(int)(this.getHeight()*0.8)));
        
        this.add(new OtocinclusAffinis((int)( this.getWidth()*0.3),(int)(this.getHeight()*0.55)));;
        this.add(new OtocinclusAffinis((int)( this.getWidth()*0.4),(int)(this.getHeight()*0.65)));
        this.add(new OtocinclusAffinis((int)( this.getWidth()*0.47),(int)(this.getHeight()*0.75)));
        this.add(new OtocinclusAffinis((int)( this.getWidth()*0.35),(int)(this.getHeight()*0.50)));
        
        
        this.add(new VegetalMarin((int)( this.getWidth()*0.2),(int)(this.getHeight()*0.66)));
        this.add(new VegetalMarin((int)( this.getWidth()*0.5),(int)(this.getHeight()*0.66)));
        this.add(new VegetalMarin((int)( this.getWidth()*0.6),(int)(this.getHeight()*0.66)));
        this.add(new VegetalMarin((int)( this.getWidth()*0.8),(int)(this.getHeight()*0.66)));
        this.add(new VegetalMarin((int)( this.getWidth()*0.10),(int)(this.getHeight()*0.66)));
        

        
        this.addMouseInteractiveObject(new MouseHandler());
        
        
    }

    private static class MouseHandler implements MouseMotionListener, MouseListener {
        
        public MouseHandler() {
            
            
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            
            int x = e.getX();
            int y = e.getY();
            
            for(int i = 0; i < Lac.getInstance().liste.size(); i++){
                
                ObjetBase o = Lac.getInstance().liste.get(i);
                
                if( x > o.getLeft() && x < o.getRight()){
                    
                    if( y > o.getBottom() && y < o.getTop()){
                    
                        System.out.println(o.getType());
                        o.estMort();
                    
                    }   
                    
                }                
                
            }
            
        }

        @Override
        public void mouseClicked(MouseEvent e) {
             
            int x = e.getX();
            int y = e.getY();
            
            System.out.println("Mouse clicked at : " + x + " ; " + y);
            for(int i = 0; i < Lac.getInstance().liste.size(); i++){
                
                ObjetBase o = Lac.getInstance().liste.get(i);
                
                if( x > o.getLeft() && x < o.getRight()){
                    
                    if( y < o.getBottom() && y > o.getTop()){
                    
                        System.out.println(o.getType());
                        o.estMort();
                    
                    }   
                    
                }                
                
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    }

    
}
