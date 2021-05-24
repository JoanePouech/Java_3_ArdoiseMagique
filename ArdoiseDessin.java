import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ArdoiseDessin extends JPanel {

	// Gestion d'une collection de points = ArrayList
	private String forme = "Carré";
	private String couleur = "Rouge";
	private int posX, posY;
	private int dim = 20;
	private ArrayList<ArdoisePoint> points = new ArrayList<ArdoisePoint>();
	private boolean effacer = false;
	
	//Constructeur par défaut
	public ArdoiseDessin () {
		this.addMouseListener(new Dessin());
		this.addMouseMotionListener(new Dessin());
	}	

	// Classe pour dessiner au clic de la souris
	class Dessin implements MouseMotionListener, MouseListener {
		public void mouseDragged(MouseEvent e) {
			posX = e.getX();
			posY = e.getY();
			ArdoisePoint point = new ArdoisePoint(forme, couleur, posX, posY, dim);
			points.add(point);
			repaint();
		}
		public void mousePressed(MouseEvent e) {
			posX = e.getX();
			posY = e.getY();
			ArdoisePoint point = new ArdoisePoint(forme, couleur, posX, posY, dim);
			points.add(point);
			repaint();
		}		
		public void mouseMoved(MouseEvent e) { /* inutile ici*/	}
		public void mouseClicked(MouseEvent e) { /* inutile ici*/ }
		public void mouseReleased(MouseEvent e) { /* inutile ici*/ }
		public void mouseEntered(MouseEvent e) { /* inutile ici*/ }
		public void mouseExited(MouseEvent e) { /* inutile ici*/ }
	}

	// Methode pour définir le dessin
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		if (effacer == true) {
			points.removeAll(points);	
			this.effacer = false;
		}
		for (int i =0 ; i < this.points.size() ; i++) {
			if (points.get(i).couleurPoint.equals("Bleu")) g.setColor(Color.BLUE);
			else if (points.get(i).couleurPoint.equals("Vert")) g.setColor(Color.GREEN);
			else g.setColor(Color.RED);
			if (points.get(i).formePoint.equals("Carré")) g.fillRect(points.get(i).posXPoint, points.get(i).posYPoint, 20, 20);
			else g.fillOval(points.get(i).posXPoint, points.get(i).posYPoint, 20, 20);
		}
	}	
	
	//Methode pour définir la forme
	public void setForme (String forme) {
		this.forme = forme;
	}
	
	//Méthode pour définir la couleur
	public void setCouleur (String couleur) {
		this.couleur = couleur;
	}
	
	//Methode pour définir l'effaçage
	public void setEffacage (boolean efface) {
		this.effacer = efface;
	}
}
