
public class ArdoisePoint {

	// Informations relatives � un point trac�
	String formePoint;
	String couleurPoint;
	int posXPoint;
	int posYPoint;
	int dimPoint = 20;

	//Constructeur par d�faut
	public ArdoisePoint () {
	}
	
	//Constructeur avec param�tres
	public ArdoisePoint (String forme, String couleur, int posX, int posY, int dim) {
		this.formePoint = forme;
		this.couleurPoint = couleur;
		this.posXPoint = posX;
		this.posYPoint = posY;
		this.dimPoint = dim;
	}

}
