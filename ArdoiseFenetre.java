import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class ArdoiseFenetre extends JFrame {
	
	//Variables affichage
	JPanel fond = new JPanel(new BorderLayout()); //inclus JToolBar + ArdoiseDessin dessin
	ArdoiseDessin dessin = new ArdoiseDessin ();
	//Variables Menu
	JMenuBar menuBar = new JMenuBar();
	JMenu fichier = new JMenu("Fichier"),
		edition = new JMenu("Edition"),
		forme = new JMenu("Forme du pointeur"),
		couleur = new JMenu("Couleur du pointeur");
	JMenuItem effacer = new JMenuItem("Effacer"), 
		quitter = new JMenuItem("Quitter"),
		rond = new JMenuItem("Rond"),
		carre = new JMenuItem("Carré"),
		rouge = new JMenuItem("Rouge"),
		vert = new JMenuItem("Vert"),
		bleu = new JMenuItem("Bleu");
	//Variables Barre d'outils
	JToolBar toolBar = new JToolBar();
	JButton carreBouton = new JButton(new ImageIcon("carre.jpg"));
	JButton rondBouton = new JButton(new ImageIcon("rond.jpg"));
	JButton rougeBouton = new JButton(new ImageIcon("rouge.jpg"));
	JButton vertBouton = new JButton(new ImageIcon("vert.jpg"));
	JButton bleuBouton = new JButton(new ImageIcon("bleu.jpg"));
	
	//Constructeur
	public ArdoiseFenetre () {
		//Caractéristiques de la fenêtre
		this.setTitle("Ardoise magique");
		this.setSize(1500, 900);
		this.setLocation(50, 50);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Initialisation menu et barre d'outils
		this.initMenuBar();
		this.initToolBar();
		
		//Ajout de la planche de dessin
		fond.add(dessin, BorderLayout.CENTER);
		this.setContentPane(fond);
		this.setVisible(true);
	}
	
	//Méthode pour construire et afficher le menu
	private void initMenuBar () {
		// Fichier
		effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		effacer.addActionListener(new Efface());
		fichier.add(effacer);
		fichier.addSeparator();
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		quitter.addActionListener(new Quitter());
		fichier.add(quitter);
		fichier.setMnemonic('f');
		
		//Edition
		rond.addActionListener(new Rond());
		forme.add(rond);
		carre.setMnemonic('c');
		carre.addActionListener(new Carre());
		forme.add(carre);
		forme.setMnemonic('o');
		rouge.addActionListener(new Rouge());
		couleur.add(rouge);
		vert.addActionListener(new Vert());
		couleur.add(vert);
		bleu.addActionListener(new Bleu());
		couleur.add(bleu);
		edition.add(forme);
		edition.addSeparator();
		edition.add(couleur);
		edition.setMnemonic('e');
		
		//MenuBar
		menuBar.add(fichier);
		menuBar.add(edition);
		this.setJMenuBar(menuBar);		
	}
	
	//Méthode pour construire et afficher la barre d'outils
	private void initToolBar () {
		carreBouton.setBackground(Color.WHITE);
		carreBouton.addActionListener(new Carre());
		toolBar.add(carreBouton);
		rondBouton.setBackground(Color.WHITE);
		rondBouton.addActionListener(new Rond());
		toolBar.add(rondBouton);
		toolBar.addSeparator();
		rougeBouton.setBackground(Color.WHITE);
		rougeBouton.addActionListener(new Rouge());
		toolBar.add(rougeBouton);
		vertBouton.setBackground(Color.WHITE);
		vertBouton.addActionListener(new Vert());
		toolBar.add(vertBouton);
		bleuBouton.setBackground(Color.WHITE);
		bleuBouton.addActionListener(new Bleu());
		toolBar.add(bleuBouton);
		toolBar.setFloatable(false);
		fond.add(toolBar, BorderLayout.NORTH);
	}
	
	//Classe pour Forme Carré
	class Carre implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dessin.setForme("Carré");
		}
	}
	//Classe pour Forme Rond
	class Rond implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dessin.setForme("Rond");
		}
	}
	//Classe pour Couleur Rouge
	class Rouge implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dessin.setCouleur("Rouge");			
		}		
	}
	//Classe pour Couleur Vert
	class Vert implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dessin.setCouleur("Vert");			
		}		
	}
	//Classe pour Couleur Bleu
	class Bleu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dessin.setCouleur("Bleu");			
		}		
	}
	//Classe pour Effacer
	class Efface implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dessin.setEffacage(true);	
			repaint();
		}
	}
	//Classe pour Quitter
	class Quitter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}		
	}

}
