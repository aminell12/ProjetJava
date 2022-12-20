package InterfaceGraphqiue;



import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import GestionUtil.*;
import consoCarbone.*;
import InterfaceGraphqiue.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Accueil extends JFrame{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	Utilisateur util;
	Alimentation alim;
	Logement log;
	BienConso bc;
	Transport tr;
	ServicesPublics sp;



	public Accueil ()  {
        super ("Accueil");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,600);
        this.setLayout(null);
        this.setLocationRelativeTo(null); //Centre la fenêtre à partir de l'écran de l'utilisateur
        //setResizable(false); //On interdit la redimensionnement de la fenêtre

        /*Construction de la barre de menu */
        this.setJMenuBar(creetMenuBar());


        /*Construction de la fenêtre*/
        JPanel contentFen = (JPanel) this.getContentPane();
        contentFen.setLayout(new BorderLayout());


        //Titre de ma fenêtre
        JLabel Titre = new JLabel("Bienvenue dans notre Projet Empreinte Carbonne", SwingConstants.CENTER);
        //Titre.setVerticalAlignment(JLabel.TOP);
        //Titre.setBounds(50, 20, 1000, 100);
        Titre.setFont(new Font("Serif", Font.BOLD,20));
        contentFen.add(Titre);


        //Ajouter Logo REVOIR !!!!!!!!!!!!!!!!!!!!!!!!!!
        //contentFen.add(creeLogo(),BorderLayout.CENTER);

        //Bouton Suivant
        JPanel next = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //Bouton Suivant
        JButton BTnext = new JButton("Suivant");
        next.add(BTnext, BorderLayout.SOUTH);
        BTnext.addActionListener(new Fenetre2());
        this.add(next,BorderLayout.SOUTH);
        this.setVisible(true);
    }

    /*Méthode de constrcution de la barre de menu */
    private JMenuBar creetMenuBar() {
        //Barre de menu
        JMenuBar menubar = new JMenuBar();
        //Menu déroulant
        JMenu mnufile = new JMenu("Projet");
        menubar.add (mnufile);

        mnufile.setFont(new Font (null, Font.BOLD, 12));

        //Élement qu'on ajoute au menu déroulant
        JMenuItem BTquitter = new JMenuItem("Quitter le Projet Empreinte Carbone");
        mnufile.add(BTquitter);
        //Raccourci
        BTquitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));

        //Listener BTquitter
        BTquitter.addActionListener( e -> {
            this.dispose();
        });
        return menubar;
    }

    //Action pour le Bouton suivant
   /* private void BTnextListener(ActionEvent event){


    }*/



    //Création du logo REVOOIR !!!!!!!!!!!!!!!!!!!!!
    private JLabel creeLogo(){
        ImageIcon img = new ImageIcon("logo_projet.png");
        JLabel logo = new JLabel(img);
        logo.setBounds(10, 10, 100, 100);
        return logo;
    }


	//         ---MAIN---
    public static void main(String [] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel()) ;
        //Ouvrir ma fenêtre
        Accueil accueil = new Accueil();
        accueil.setVisible(true);
    }


    class Fenetre2 extends JFrame implements ActionListener{
		//Nouvelle fenêtre créee en cliquant sur le bouton suivant
		private static final long serialVersionUID = 1L;
		JPanel boutons;
		JButton BTal = new JButton ("Alimentation");
		JButton BTbc = new JButton ("Biens consommations");
		JButton BTtrans = new JButton ("Transports");
		JButton BTlog = new JButton ("Logements");
		JButton BTbs = new JButton ("Biens et Services");

		public Fenetre2() {
			super ("Présentation");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Accueil.this.dispose();
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        this.setSize(800,600);
	        this.setLayout(null);
	        this.setLocationRelativeTo(null);
	        this.setJMenuBar(creetMenuBar());

	        JPanel contentFen = (JPanel) this.getContentPane();
	        contentFen.setLayout(new BorderLayout());
			//Titre de la page
	        JLabel Titre = new JLabel("Quelle poste de consommation voulez vous analyser?", SwingConstants.CENTER);
	        Titre.setFont(new Font("Serif", Font.BOLD,20));
	        contentFen.add(Titre);

	        boutons = new JPanel();
	       	boutons.add(BTal);
	       	BTal.addActionListener(new PageAlim());

	       	boutons.add(BTbc);
	       	BTbc.addActionListener(new PageBC());

	       	boutons.add(BTtrans);
	       	BTtrans.addActionListener(new PageTrans());


	       	boutons.add(BTlog);
	       	//BTlog.addActionListener(new PageLog());

	       	boutons.add(BTbs);
	       	//BTbs.addActionListener(new Pagebs());

	        this.add(boutons,BorderLayout.SOUTH);
	        this.setVisible(true);

		}

		public class PageAlim extends JFrame implements ActionListener {

			
			private static final long serialVersionUID = 1L;
			String s;
			double tauxb,tauxv;
			boolean succes = false;

			public PageAlim() {
				super("Alimentation");
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre2.this.setVisible(false);
				boutons.remove(BTal);
				while (!succes) {
					try {
						
						s= JOptionPane.showInputDialog(null, "Veuillez entrer votre taux de consommation de beouf annuel (entre 0 et 1)", "Taux de boeuf", JOptionPane.QUESTION_MESSAGE);
						tauxb=Double.parseDouble(s);
						if(tauxb>1 || tauxb<0) throw new InvalidRateException();
						succes=true;
					}
					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "L'élément que vous avez entré au clavier n'est pas un nombre à decimal !", "Attention!", JOptionPane.WARNING_MESSAGE);
		        	}
					catch (InvalidRateException e2) {
						JOptionPane.showMessageDialog(null, "L'élément que vous avez entré au clavier ne correspond pas à un taux !", "Attention!", JOptionPane.WARNING_MESSAGE);
					}
				}
				succes=false;
				while (!succes) {
					try {
						
						s = JOptionPane.showInputDialog(null, "Veuillez entrer votre taux de consommation de végétarien annuel (entre 0 et 1)", "Taux de vegetarien", JOptionPane.QUESTION_MESSAGE);
						tauxv=Double.parseDouble(s);
						if(tauxv>1 || tauxv<0) throw new InvalidRateException();
						succes=true;
					}
					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "L'élément que vous avez entré au clavier n'est pas un nombre a decimal !", "Attention!", JOptionPane.WARNING_MESSAGE);
		        	}
					catch (InvalidRateException e2) {
						JOptionPane.showMessageDialog(null, "L'élément que vous avez entré au clavier ne correspond pas à un taux !", "Attention!", JOptionPane.WARNING_MESSAGE);
					}
				}
				alim = new Alimentation(tauxb,tauxv);
				JOptionPane.showMessageDialog(null, alim.toString(), "Consommation du poste alimentation", JOptionPane.INFORMATION_MESSAGE);
				Fenetre2.this.setVisible(true);
			}
		}


		public class PageBC extends JFrame implements ActionListener {
			private static final long serialVersionUID = 1L;
			String s;
			double montant;
			boolean succes = false;

			public PageBC() {
				super("Bien Consommation");
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre2.this.setVisible(false);
				boutons.remove(BTbc);


				while (!succes) {
					try {
						
						s = JOptionPane.showInputDialog(null, "Veuillez entrer le montant de la consommation des biens", "Montant biens conso", JOptionPane.QUESTION_MESSAGE);
						montant = Double.parseDouble(s);
						succes = true;
					}
					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "L'élément que vous avez entré au clavier n'est pas un nombre à décimal !", "Attention!", JOptionPane.WARNING_MESSAGE);
		        	}
				}
				bc = new BienConso(montant);
				JOptionPane.showMessageDialog(null, bc.toString(), "Consommation du poste bien conso", JOptionPane.INFORMATION_MESSAGE);
				Fenetre2.this.setVisible(true);
			}

		}

		public class PageTrans extends JFrame implements ActionListener {
			private static final long serialVersionUID = 1L;

			boolean possede;
    		Taille taille;
    		int kilomAnnee;
   			int amortissement;

			String s;
			boolean succes = false;

			public PageTrans(){
				super("Transport");
			}
	
			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre2.this.setVisible(false);
				boutons.remove(BTtrans);


				while (!succes) {
					try {
						//JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
						s = JOptionPane.showInputDialog(null, "Veuillez entrer le montant de la consommation des biens", "Montant biens conso", JOptionPane.QUESTION_MESSAGE);
						possede = s;
						succes = true;
					}
					catch (InvalidBooleanException e2) {
						JOptionPane.showMessageDialog(null, "L'élément que vous avez entré au clavier n'est pas une reponse adéquate !", "Attention!", JOptionPane.WARNING_MESSAGE);
		        	}
				}

				while (!succes) {
					try {
						//JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
						s = JOptionPane.showInputDialog(null, "Veuillez entrer le montant de la consommation des biens", "Montant biens conso", JOptionPane.QUESTION_MESSAGE);
						taille = s;
						succes = true;
					}
					catch (InvalidSizeException e1) {
						JOptionPane.showMessageDialog(null, "L'élément que vous avez entré au clavier n'est pas une Taille !", "Attention!", JOptionPane.WARNING_MESSAGE);
					}
				}
				

				bc = new Transport();
				JOptionPane.showMessageDialog(null, bc.toString(), "Consommation du poste bien conso", JOptionPane.INFORMATION_MESSAGE);
				Fenetre2.this.setVisible(true);
			}
		}
    }

}
