
public class ArdoisePoint {

	// Informations relatives à un point tracé
	String formePoint;
	String couleurPoint;
	int posXPoint;
	int posYPoint;
	int dimPoint = 20;

	//Constructeur par défaut
	public ArdoisePoint () {
	}
	
	//Constructeur avec paramètres
	public ArdoisePoint (String forme, String couleur, int posX, int posY, int dim) {
		this.formePoint = forme;
		this.couleurPoint = couleur;
		this.posXPoint = posX;
		this.posYPoint = posY;
		this.dimPoint = dim;
	}

}
