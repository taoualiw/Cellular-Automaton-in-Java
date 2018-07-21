/* <applet code=HomeApplet width=550 height=650></applet> */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wahiba and jacques
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

public class FourmiLangton extends Applet implements Runnable {

	// début de la classe principale
	static int N = 100; // taille du plan
       
	Cellule[][] plan = new Cellule[N][N]; // le plan 10x10 est composé de
											// cellules
        Thread tickTock=null;
        Fourmi fourmi;
	public void start() {

		if (tickTock == null) {
			tickTock = new Thread(this);
			tickTock.start();
		}
	}

	public void stop() {

		if (tickTock != null) {
			tickTock.stop();
			tickTock = null;
		}
	}

	public void run() { // calculer indéfiniment, quatre générations par seconde

		while (true) {

			try {
				Thread.currentThread().sleep(1);
			}
			// séquencement à 4 Hz

			catch (InterruptedException e) {
			}
			super.repaint();
		} // pour affichage de l'automate

	}

	public void init() {// initialisations
                setSize(10*N, 10*N);
		// créer un plan NxN de cellules vides
		for (int i = 0; i < N; i++)

			for (int j = 0; j < N; j++) {

				plan[i][j] = new Cellule(i, j, this.getGraphics());
			}

            // placer une fourmi sur le plan
            //fourmi = new Fourmi(50, 50, 3, plan);
            fourmi = new Fourmi(50, 50, 3, plan);
	} // fin d'init



	public final synchronized void update(Graphics g) {
		// mettre à jour la grille
		g.setColor(Color.white); // rend la couleur blanche
                
		g.fillRect(0, 0, 10*N, 10*N); // dessine le fond

		// 1) afficher l'automate, ancienne génération
		for (int i = 0; i < N; i++)

			for (int j = 0; j < N; j++)

				plan[i][j].paint(); // affiche la cellule

		// 2) mémoriser l'état de l'ancienne génération
		for (int i = 0; i < N; i++)

			for (int j = 0; j < N; j++)

				plan[i][j].basculer();

		// 3) calculer la génération prochaine
                
		fourmi.deplacement();

	}

} // fin de la classe principale FourmiLangton
