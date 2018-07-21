/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wahiba and Jacques                                           
 */

import java.awt.Color;
import java.awt.Graphics;

class Cellule {

	int x, y; // coordonées de la cellule dans l'automate

	boolean celluleOccupee; // état de la cellule, true si occupée

	boolean ancienEtat; // état de la cellule à la génération précédente

	private Graphics g; // pour le graphisme

	public int etat() {// retourne l'état de la cellule, 0 si vide, 1 si
		// occupée

		int occupe = 1;
		int vide = 0;
		if (ancienEtat)

			return occupe; // retourne 1: la cellule est occupée

		else

			return vide; // retourne 0: la cellule est vide

	}

	public void basculer() {// changement de génération, mémoriser l'état de la
							// cellule

		ancienEtat = celluleOccupee;

	}

	public void changementGeneration(int nombreVoisins) {

		if (ancienEtat) // cellule reste occupee si exactement 2 ou 3 voisins

			celluleOccupee = (nombreVoisins == 2) || (nombreVoisins == 3);

		else
			// naissance si exactement 3 voisins

			celluleOccupee = (nombreVoisins == 3);

	}

	public Cellule(int coordx, int coordy, Graphics appletG) {// constructeur
																// de cellule

		g = appletG; // pour le graphisme
		this.x = coordx;
		this.y = coordy;
		this.celluleOccupee = false; // à la génèse le monde était vide

	}

	public void creer() {// déclarer la cellule occupée

		this.celluleOccupee = true;

	}

	public void paint() {// graphisme : affichage de la cellule

		int nx, ny;
		nx =10*x;
		ny =10*y;
                
		if (celluleOccupee) { // si cellule occupée

			g.setColor(Color.black);
			g.fillOval(nx + 1, ny + 1, 15 - 2, 15 - 2);
		} // dessiner = cercle noir

		else { // si cellule vide

			g.setColor(Color.white);
			g.fillRect(nx + 1, ny + 1, 10 - 2, 10 - 2);
		} // effacer = carré blanc

	}

} // fin de la classe Cellule
