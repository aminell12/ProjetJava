package InterfaceGraphique;



import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import GestionUtil.*;
import consoCarbone.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Accueil est la classe qui s'occupe de la mise en page et de l'affichage de l'interface graphique 
 * Elle extends la classe JFrame puisqu'elle se base sur une premiere fenetre qui en generera d'autres grâce a l'activation de boutons
 */
public class Accueil extends JFrame{
    /* serialVersionUID: Accueil est serialisable, il est donc preferable d'initialiser un ID permettant de serialiser ou deserialiser la class 
	 */
	private static final long serialVersionUID = 1L;
	/*util: l'utilisateur que nous allons initialiser grace a l'interface
	 */
	Utilisateur util;
	Alimentation alim;
	Collection <Logement> log=new ArrayList <Logement>();
	BienConso bc;
	Collection <Transport> tr=new ArrayList <Transport>();
	ServicesPublics sp; 
	
	
	/* nom, prenon: espace dans une frame qui permettra de recuperer le nom et le prenom de l'utilisateur
	 */
	JTextField nom,prenom;
	/*Id:fenetre sur laquelle l'utilisatuer pourra entrer son nom et son prenom
	 */
	JDialog Id=new JDialog((JFrame)null,"Identité",true);
	
	
	/**
	 * Construction de la classe Accueil
	 */
	public Accueil ()  {
        super ("Accueil"); //creation de la fenetre d'accueil
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,600);
        this.setLayout(null);
        this.setLocationRelativeTo(null); //Centre la fenêtre à partir de l'écran de l'utilisateur

        
      //Apparition d'un pop-up informatif avant la fenetre demandant l'identité de l'utilisateur
        JOptionPane.showMessageDialog(null, "Avant de commencer, veuillez entrer votre nom et votre prénom" , "Identité", JOptionPane.INFORMATION_MESSAGE);
        
      //Création de la fenêtre qui va permettre la récupération de l'identité de l'utilisateur
        Id.setSize(300, 200);
	    Id.setLocationRelativeTo(null);
	    Id.setResizable(false);
	    Id.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        
        
        JPanel panNom=new JPanel();
		nom=new JTextField();
		nom.setPreferredSize(new Dimension(90, 25));
		panNom.setBorder(BorderFactory.createTitledBorder(""));
		JLabel nomLab=new JLabel("Nom: ");
		panNom.add(nomLab);
		panNom.add(nom);
        
		JPanel panPrenom=new JPanel();
		prenom=new JTextField();
		prenom.setPreferredSize(new Dimension(90, 25));
		panPrenom.setBorder(BorderFactory.createTitledBorder(""));
		JLabel prenomLab=new JLabel("Prenom: ");
		panPrenom.add(prenomLab);
		panPrenom.add(prenom);
		
	
        
        JPanel ide = new JPanel();
        JPanel boutons=new JPanel();

        ide.add(panNom);
		ide.add(panPrenom);
		
		//Le bouton valider va permettre de faire disparaitre et de supprimer la fenetre sur laquelle on est 
		JButton val = new JButton("Valider");
		val.addActionListener( e -> {
			Id.dispose();
		});
		boutons.add(val);
		
		Id.getContentPane().add(ide, BorderLayout.CENTER);
		Id.getContentPane().add(boutons,BorderLayout.SOUTH);
		
		//Affichage de la fenetre recuperant l'identité sur l'ecran de l'utilisateur 
		Id.setVisible(true);
        
        
        /*Construction de la barre de menu */
        this.setJMenuBar(creetMenuBar(this));


        /*Construction de la fenêtre*/
        JPanel contentFen = (JPanel) this.getContentPane();
        contentFen.setLayout(new BorderLayout());
        

        //Titre de ma fenêtre
        JLabel Titre = new JLabel("Bienvenue "+prenom.getText()+" "+nom.getText()+" dans notre Projet Empreinte Carbonne!", SwingConstants.CENTER);
        Titre.setFont(new Font("Serif", Font.BOLD,20));
        contentFen.add(Titre);
        

        //Panel du bouton Suivant
        JPanel next = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        //Bouton Suivant 
        JButton BTnext = new JButton("Suivant");
        next.add(BTnext, BorderLayout.SOUTH);
        BTnext.addActionListener(new Fenetre2()); //Lorsque l'utilisateur appuie sur le bouton suivant, la creation de la 2e fenetre est lancée
        this.add(next,BorderLayout.SOUTH);
        
        
        
    }
	

    /**
     * Méthode de constrcution de la barre de menu 
    */
    private JMenuBar creetMenuBar(JFrame page) {
        //Barre de menu
        JMenuBar menubar = new JMenuBar();
        //Menu déroulant
        JMenu mnufile = new JMenu("Projet");
        menubar.add (mnufile);
        
        mnufile.setFont(new Font (null, Font.BOLD, 12));

        
        //élement qu'on ajoute au menu déroulant
        JMenuItem BTquitter = new JMenuItem("Quitter le Projet Empreinte Carbone");
        mnufile.add(BTquitter);
        
        //Raccourci
        BTquitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));

        //Listener BTquitter 
        BTquitter.addActionListener( e -> {
            page.dispose();
        });
        return menubar;
    }

 


    
    /**
     * Fenetre2 est la classe qui definira la nouvelle fenêtre créee en cliquant sur le bouton suivant dans la page d'accueil
     *
     */
    class Fenetre2 extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L;
		/**boutons: Panel qui va recueillir tous les boutons correspondant a chacun des postes de consommation
		 */
		JPanel boutons=new JPanel(); 
		
		JButton BTal = new JButton ("Alimentation");
		JButton BTbc = new JButton ("Biens consommations");
		JButton BTtrans = new JButton ("Transports");
		JButton BTlog = new JButton ("Logements");
		JButton BTsp = new JButton ("Biens et Services");

		/**
		 * Creation de la page de presentation (ou Fenetre2)
		 */
		public Fenetre2() {
			super ("Présentation"); 
		}
		
		
		/**
		 * redéfinition de la methode actionPerformed de la classe ActionListener
		 * elle permet de décider de ce qu'il se passera lorsque l'activation d'un bouton initialise un nouvel element de Fenetre2
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Accueil.this.dispose(); //Des que le bouton suivant de la fenetre Accueil est activé, la fenetre Accueil disparait et est supprimée  
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        this.setSize(800,600);
	        this.setLayout(null);
	        this.setLocationRelativeTo(null);
	        this.setJMenuBar(creetMenuBar(this));

	        JPanel contentFen = (JPanel) this.getContentPane();
	        contentFen.setLayout(new BorderLayout());
	        
	        
			//Titre de la page
	        JLabel Titre = new JLabel("Quelle poste de consommation voulez vous analyser?", SwingConstants.CENTER);
	        Titre.setFont(new Font("Serif", Font.BOLD,20));
	        contentFen.add(Titre);
	        
	        //Chacun des boutons va activer la page de renseignement qui lui est associée
	       	boutons.add(BTal);
	       	BTal.addActionListener(new PageAlim());

	       	boutons.add(BTbc);
	       	BTbc.addActionListener(new PageBC());

	       	boutons.add(BTtrans);
	       	BTtrans.addActionListener(new PageTrans());

	        
	       	boutons.add(BTlog);
	       	BTlog.addActionListener(new PageLog());

	       	boutons.add(BTsp);
	       	BTsp.addActionListener(new PageSP());

	        this.add(boutons,BorderLayout.SOUTH);
	        this.setVisible(true);//affiche la fenetre de Présentation avec tous les boutons et la phrase de présentation
			
		}
		
		
		
		/**
		 *PageAlim correspond a l'étape ou l'on renseigne les habitudes alimentaire de l'utilisateur
		 */
		class PageAlim implements ActionListener {

			
			String s;
			double tauxb,tauxv;
			boolean succes = false;

			public PageAlim() {
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre2.this.setVisible(false);//la fenetre de presentation disparait le temps d'entrer les données qui serviront a initialiser l'alimentation de l'utilisateur
				boutons.remove(BTal);//puisque l'alimentation sera traité ici, on n'aura plus besoin du bouton qui referencera a l'initialisation de cet élément
				while(!succes) {
					try {
						while (!succes) {
							try {
						
								s= JOptionPane.showInputDialog(null, "Veuillez entrer votre taux de consommation de boeuf annuel (entre 0 et 1)", "Taux de boeuf", JOptionPane.QUESTION_MESSAGE);
								tauxb=Double.parseDouble(s); 
								if(tauxb>1 || tauxb<0) throw new InvalidRateException();
								succes=true;
							}	
							catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "L'élément que vous avez entré au clavier n'est pas un nombre à decimal !", "Attention!", JOptionPane.WARNING_MESSAGE);
							}
							catch (InvalidRateException e2) {
								JOptionPane.showMessageDialog(null, e2.getMessage(), "Attention!", JOptionPane.WARNING_MESSAGE);
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
								JOptionPane.showMessageDialog(null, e2.getMessage(), "Attention!", JOptionPane.WARNING_MESSAGE);
							}
						}
						if (tauxb+tauxv>1) {
							succes=false;
							throw new InvalidRateException();
						}
					}
					catch(InvalidRateException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage()+"\n Veuillez réessayer en verifiant la valeur de vos taux.", "Attention!", JOptionPane.WARNING_MESSAGE);
					}
				}
				
				alim = new Alimentation(tauxb,tauxv); //on initialise l'élément alimentation de l'utilisateur à l'aide des données récupérées 
				JOptionPane.showMessageDialog(null, alim.toString(), "Consommation du poste alimentation", JOptionPane.INFORMATION_MESSAGE);
				if (boutons.getComponentCount()!=0) Fenetre2.this.setVisible(true);//dans le cas ou il nous reste encore des boutons sur la fentre de presentation, on la raffiche sur l'ecran de l'utilisateur 
				else {// si il n'y en a plus, cela signifie que l'on a traité tous les postes de consommation, on peut donc supprimer la fenetre de presentationet passer a la derniere page
					Fenetre2.this.dispose();
					new Final();
				}
				
			}
		}
		
		
		
		
		/**
		 *PageBC correspond a l'étape ou l'on renseigne les habitudes des biens conso de l'utilisateur
		 */
		class PageBC implements ActionListener {

			String s;
			double montant;
			boolean succes = false;

			public PageBC() {
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
				if (boutons.getComponentCount()!=0) Fenetre2.this.setVisible(true);
				else {
					Fenetre2.this.dispose();
					new Final();
				}
			}
			
		}

		
		
		/**
		 *PageTrans correspond a l'étape où l'on renseigne le nombre de véhicule de l'utilisateur et les informations liées à cahcune d'entre elle 
		 */
		class PageTrans implements ActionListener {
			

			String s;
			boolean succes = false;
			
			int nbvoiture;

			public PageTrans(){
			}
	
			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre2.this.setVisible(false);
				boutons.remove(BTtrans);
				
				while (!succes) {
					try {
						s = JOptionPane.showInputDialog(null, "Combien de voitures possédez vous? ", "Nombre de voitures", JOptionPane.QUESTION_MESSAGE);
						nbvoiture=Integer.parseInt(s);
						if (nbvoiture <0) throw new NumberFormatException();
						succes = true;
					}
					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "L'élément que vous avez entré au clavier n'est pas un un nombre entier positif !", "Attention!", JOptionPane.WARNING_MESSAGE);
		        	}
				}
				JOptionPane.showMessageDialog(null, "Le formulaire suivant va s'afficher "+nbvoiture+" fois.\nVeuillez entrer les informations de chacun de vos véhicules", "Information", JOptionPane.INFORMATION_MESSAGE);
				for (int i =1;i<=nbvoiture;i++) {
					new FormTr(null, "Véhicule "+i,true);//un nouveau formulaire est créé pour chaque voiture que possede l'utilisateur
					JOptionPane.showMessageDialog(null, ((ArrayList<Transport>) tr).get(i-1).toString(), "Consommation des transports", JOptionPane.INFORMATION_MESSAGE);
				}
				
				if (boutons.getComponentCount()!=0) Fenetre2.this.setVisible(true);
				else {
					Fenetre2.this.dispose();
					new Final();
				}
			}
			
			class FormTr extends JDialog{

				private static final long serialVersionUID = 1L;
				
				private JComboBox<String> size;
				private Taille taille;
				private int kilomAnnee,amortissement;
				private JTextField kilomA,amort;
				private JLabel sizeLab,kilomLab,amortLab;
				
				public FormTr(JFrame parent,String title,boolean modal) {
					super(parent, title, modal);
					this.setSize(550, 270);
				    this.setLocationRelativeTo(null);
				    this.setResizable(false);
				    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				    this.initComponent();
				    
				    this.setVisible(true);
				}
				
				public void initComponent() {
					
					//Taille
					JPanel panTaille=new JPanel ();
					panTaille.setBorder(BorderFactory.createTitledBorder("Taille du véhicule"));
					size=new JComboBox<String>();
					size.addItem("Petite");
					size.addItem("Grande");
					sizeLab=new JLabel ("Taille :");
					panTaille.add(sizeLab);
					panTaille.add(size);
					
					
					//Killometres par an
					JPanel panKilom=new JPanel();
					kilomA=new JTextField();
					kilomA.setPreferredSize(new Dimension(90, 25));
					panKilom.setBorder(BorderFactory.createTitledBorder("Kilomètres par an"));
					kilomLab=new JLabel("Nombre de kilomètres par an :");
					panKilom.add(kilomLab);
					panKilom.add(kilomA);
					panKilom.add(new JLabel("km."));
					
					
					//Amortissement
					JPanel panAmort= new JPanel();
					amort=new JTextField();
					amort.setPreferredSize(new Dimension(90, 25));
					panAmort.setBorder(BorderFactory.createTitledBorder("Amortissement"));
					amortLab=new JLabel("Amortissement :");
					panAmort.add(amortLab);
					panAmort.add(amort);
					
					
					JPanel content =new JPanel();
					content.add(panTaille);
					content.add(panKilom);
					content.add(panAmort);
					
					JPanel boutons = new JPanel();
					JButton next= new JButton("Suivant");
					next.addActionListener(new ActionListener() {//Des qu'on appuie sur next, on cache la page et on teste les valeurs qui ont été entrée par l'utilisateur 
																//si des valeurs posent problemes, on raffiche le formulaire pour que l'utilisateur puisse entrer une nouvelle valeur 
						public void actionPerformed(ActionEvent a) {
							setVisible(false);
							succes=false;
							while (!succes) {
								try {
									s=kilomA.getText();
									kilomAnnee=Integer.parseInt(s);
									if (kilomAnnee <0) throw new NumberFormatException();
									succes = true;
								}
								catch (NumberFormatException e1) {
									JOptionPane.showMessageDialog(null, "L'élément kilometre par an que vous avez entré au clavier n'est pas un un nombre entier positif !", "Attention!", JOptionPane.WARNING_MESSAGE);
									kilomA.removeAll();
									kilomA.repaint();
									setVisible(true);
					        	}
							}
							succes=false;
							while (!succes) {
								try {
									s=amort.getText();
									amortissement=Integer.parseInt(s);
									if (amortissement <0) throw new NumberFormatException();
									succes = true;
								}
								catch (NumberFormatException e1) {
									JOptionPane.showMessageDialog(null, "L'élément amortissement que vous avez entré au clavier n'est pas un un nombre entier positif !", "Attention!", JOptionPane.WARNING_MESSAGE);
									amort.removeAll();
									amort.repaint();
									setVisible(true);
					        	}
							}
							if (size.getSelectedItem().equals("Petite")) taille=Taille.P;
							else taille= Taille.G;
							tr.add(new Transport(taille,kilomAnnee,amortissement));
							dispose(); //si toutes les conditions sont respectées, on supprime la page
						}
					});
					
					boutons.add(next);
					
					this.getContentPane().add(content, BorderLayout.CENTER);
				    this.getContentPane().add(boutons, BorderLayout.SOUTH);
					
				}
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		 *PageLog correspond a l'étape où l'on renseigne le nombre de logement de l'utilisateur et les informations liées à cahcun d'entre eux 
		 */
		class PageLog implements ActionListener {
			
			String s;
			boolean succes = false;
			
			int nblog;

			public PageLog(){
			}
	
			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre2.this.setVisible(false);
				boutons.remove(BTlog);
				
				while (!succes) {
					try {
						s = JOptionPane.showInputDialog(null, "Combien de logements possédez vous? ", "Nombre de logements", JOptionPane.QUESTION_MESSAGE);
						nblog=Integer.parseInt(s);
						if (nblog <0) throw new NumberFormatException();
						succes = true;
					}
					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "L'élément que vous avez entré au clavier n'est pas un un nombre entier positif !", "Attention!", JOptionPane.WARNING_MESSAGE);
		        	}
				}
				
				JOptionPane.showMessageDialog(null, "Le formulaire suivant va s'afficher "+nblog+" fois.\nVeuillez entrer les informations de chacun de vos logements.", "Information", JOptionPane.INFORMATION_MESSAGE);
				for (int i =1;i<=nblog;i++) {
					new FormLog(null, "Logement "+i,true);
					JOptionPane.showMessageDialog(null, ((ArrayList<Logement>) log).get(i-1).toString(), "Consommation des logements", JOptionPane.INFORMATION_MESSAGE);
				}
				
				if (boutons.getComponentCount()!=0) Fenetre2.this.setVisible(true);
				else {
					Fenetre2.this.dispose();
					new Final();
				}
			}
			
			class FormLog extends JDialog{

				private static final long serialVersionUID = 1L;
				
				private JComboBox<String> ce;
				private JTextField size;
				private JLabel sizeLab,ceLab;
				
				
				private int superficie;
			    private CE classeE;
				
				public FormLog(JFrame parent,String title,boolean modal) {
					super(parent, title, modal);
					this.setSize(550, 270);
				    this.setLocationRelativeTo(null);
				    this.setResizable(false);
				    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				    this.initComponent();
				    
				    this.setVisible(true);
				}
				
				public void initComponent() {
					
					//Taille
					JPanel panCE=new JPanel ();
					panCE.setBorder(BorderFactory.createTitledBorder("Taille du véhicule"));
					ce=new JComboBox<String>();
					ce.addItem("A");
					ce.addItem("B");
					ce.addItem("C");
					ce.addItem("D");
					ce.addItem("E");
					ce.addItem("F");
					ce.addItem("G");
					
					ceLab=new JLabel ("Classe énergetique :");
					panCE.add(ceLab);
					panCE.add(ce);
					
					
					//Superficie
					JPanel panSup=new JPanel();
					size=new JTextField();
					size.setPreferredSize(new Dimension(90, 25));
					panSup.setBorder(BorderFactory.createTitledBorder("Superficie du logement"));
					sizeLab=new JLabel("Superficie :");
					panSup.add(sizeLab);
					panSup.add(size);
					panSup.add(new JLabel ("m²."));
					
					
					
					JPanel content =new JPanel();
					content.add(panCE);
					content.add(panSup);
					
					JPanel boutons = new JPanel();
					JButton next= new JButton("Suivant");
					next.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent a) {
							setVisible(false);
							succes=false;
							while (!succes) {
								try {
									s=size.getText();
									superficie=Integer.parseInt(s);
									if (superficie <0) throw new NumberFormatException();
									succes = true;
								}
								catch (NumberFormatException e1) {
									JOptionPane.showMessageDialog(null, "L'élément superficie que vous avez entré au clavier n'est pas un un nombre entier positif !", "Attention!", JOptionPane.WARNING_MESSAGE);
									size.removeAll();
									size.repaint();
									setVisible(true);
					        	}
							}
							
							classeE=CE.valueOf((String)ce.getSelectedItem());
							log.add(new Logement(superficie,classeE));
							dispose();
						}
					});
					
					boutons.add(next);
					
					this.getContentPane().add(content, BorderLayout.CENTER);
				    this.getContentPane().add(boutons, BorderLayout.SOUTH);
					
				}
				
			}
		}
		
		
		/**
		 *PageSP correspond a l'étape ou l'on récupères l'impact des services publics
		 */
		class PageSP implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Fenetre2.this.setVisible(false);
				boutons.remove(BTsp);
				
				JOptionPane.showMessageDialog(null, "Cette classe de consommation ne nécessite aucune donnée.\n La valeur de son impact est commune a tous les français", "Information", JOptionPane.INFORMATION_MESSAGE);
				sp=new ServicesPublics();
				JOptionPane.showMessageDialog(null, sp.toString(), "Consommation des services publics", JOptionPane.INFORMATION_MESSAGE);
				if (boutons.getComponentCount()!=0) Fenetre2.this.setVisible(true);
				else {
					Fenetre2.this.dispose();
					new Final();
				}
			}
			
			
		}
		
		/**
		 *Final correspond a la derniere etape qui va résumer les données a l'utilisateur
		 */
class Final extends JFrame{
			
			
			private static final long serialVersionUID = 1L;

			
			public Final() {
				
				super ("Fin du programme"); 
		        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        this.setSize(800,400);
		        this.setLayout(null);
		        this.setLocationRelativeTo(null);
		        this.setJMenuBar(creetMenuBar(this));
				this.getContentPane().setLayout(new BorderLayout());
		        
		        JPanel contentFen = new JPanel();
		        contentFen.setLayout(new BorderLayout());
		        
		        util=new Utilisateur(alim,bc,log,tr,sp,nom.getText(),prenom.getText());
     
		        JPanel P=new JPanel();
		        //P.setBorder(BorderFactory.createTitledBorder(""));
		        JLabel Titre=new JLabel("Le calcul de votre consommation carbone est terminé.",SwingConstants.CENTER);
		        Titre.setFont(new Font("Serif", Font.BOLD,30));
		        P.add(Titre);
		        
		        JPanel RC=new JPanel(new BorderLayout());
		        //RC.setBorder(BorderFactory.createTitledBorder(""));
		        RC.add(new JLabel("Vous trouverez un résumé de votre consommation et quelques conseils en appuyant sur le bouton Résumé ci dessous.",SwingConstants.CENTER));
		        
		        contentFen.add(P,BorderLayout.NORTH);
		        contentFen.add(RC,BorderLayout.CENTER);
		        
		        JPanel boutons=new JPanel();
		        JButton Res=new JButton("Résumé");
		        Res.addActionListener( e-> {
		        	this.dispose();
		        	JOptionPane.showMessageDialog(null, util.conseil() , "Identité", JOptionPane.INFORMATION_MESSAGE);
		        });
		        
		        JButton F=new JButton("Fermer");
		        F.addActionListener(e ->{
		        	this.dispose();
		        });
		        
		        boutons.add(F);
		        boutons.add(Res);
				
		        this.getContentPane().add(contentFen,BorderLayout.CENTER);
		        this.getContentPane().add(boutons,BorderLayout.SOUTH);
		        this.setVisible(true);
		        
		        
			}
		}
    }
    /**
     * Méthode main
     * @param args
     * @throws Exception
     */
    public static void main(String [] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel()) ;
        //Ouvrir ma fenêtre
        Accueil accueil = new Accueil();
        accueil.setVisible(true);
    }

}
