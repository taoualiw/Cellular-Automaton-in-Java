/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wahiba and jacques
 */
public class Fourmi {
	static final int NORD = 1; // les orientations dans la grille

	static final int WEST = 2;

	static final int SUD = 3;

	static final int EST = 4;

	static final int N = 100;// la taille de la grille

	int orientation;

	int x;

	int y;

	// la grille, l'espace dans lequel s'effectue le déplacement
	Cellule[][] planfourmi = new Cellule[N][N];

	public Fourmi() {
	}// constructeur vide

	public Fourmi(int x, int y, int sonOrientation, Cellule[][] plan)
	// constructeur
	{
		this.x = x;
		this.y = y;
		this.orientation = sonOrientation;
		this.planfourmi = plan;
	}

	// compteur permettant de calculer le nombre de pas effectués
	static int cpt = 0;

	public void deplacement()
	// la gestion de déplacement, règles de l'automate
	{
		cpt = cpt + 1;
		if (this.orientation == NORD) {
			planfourmi[x][y - 1].celluleOccupee = (!planfourmi[x][y - 1].celluleOccupee);
			if (planfourmi[x][y - 1].celluleOccupee == true) {
				orientation = 2;
			} else {
				orientation = 4;
			}
			;
			y = y - 1;
		} else if (this.orientation == WEST) {
			planfourmi[x - 1][y].celluleOccupee = (!planfourmi[x - 1][y].celluleOccupee);
			if (planfourmi[x - 1][y].celluleOccupee == true)

			{
				orientation = 3;
			} else {
				orientation = 1;
			}
			;
			x = x - 1;
		} else if (this.orientation == SUD) {
			planfourmi[x][y + 1].celluleOccupee = (!planfourmi[x][y + 1].celluleOccupee);
			if (planfourmi[x][y + 1].celluleOccupee == true) {
				orientation = 4;
			} else {
				orientation = 2;
			}
			;
			y = y + 1;
		}

		else if (this.orientation == EST) {
			planfourmi[x + 1][y].celluleOccupee = (!planfourmi[x + 1][y].celluleOccupee);
			if (planfourmi[x + 1][y].celluleOccupee == true)

			{
				orientation = 1;
			} else {
				orientation = 3;
			}
			;
			x = x + 1;
		}
		System.out.println(cpt);
	}

}//fin de la classe fourmi
