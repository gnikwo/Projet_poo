package chiens;

import iut.World;
import iut.Objet;
import java.util.ArrayList;

/**
 * Classe permettant de g�rer les Omnivores tout ce qu'ils font ou peuvent faire.
 * 
 * H�rite de Animal.
 */
public abstract class Omnivore extends Animal {

	/**
	 * Constructeur de la classe Omnivore
	 */
	public Omnivore(World g, String nom, int x, int y) {
            
            super(g, nom, x, y);
            _listeAlimentation.add(TypeAlimentation.VegetalMarin);
            _listeAlimentation.add(TypeAlimentation.Planorbe);
           
	}

	/**
	 * D�place l'objet
	 * @param dt le temps �coul� en millisecondes depuis le pr�c�dent d�placement
	 */
	public void move(long dt) {
            this.move(vitesseX, vitesseY);
	}

	/**
	 * Action : effet d'une collision entre l'objet et le param�tre
	 */
	public void effect(Objet o) {
	}

	
}