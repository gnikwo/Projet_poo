package chiens;

import iut.Objet;
import iut.World;
import java.util.ArrayList;

/**
 * Classe permettant de gerer les Carnivores tout ce qu'ils font ou peuvent faire.
 * 
 * Herite de Animal.
 */
public abstract class Carnivore extends Animal {

	/**
	 * Constructeur de la classe Carnivore
	 */
	public Carnivore(World g, String nom, int x, int y) {
            
            super(g, nom, x, y);
            
            _listeAlimentation.add(TypeAlimentation.Caneton);
            _listeAlimentation.add(TypeAlimentation.OtocinclusAffinis);
            _listeAlimentation.add(TypeAlimentation.Planorbe);
            _listeAlimentation.add(TypeAlimentation.Ecrevisse);
	}

	/**
	 * Deplace l'objet
	 * @param dt le temps �coul� en millisecondes depuis le precedent deplacement
	 */
        @Override
	public void move(long dt) {
            this.move(vitesseX, vitesseY);
	}


}