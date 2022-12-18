package InterfaceGraphqiue;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.image.BufferedImage;
import java.io.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Accueil extends JFrame{
    public Accueil ()  {
        super ("Accueil"); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null); //Centre la fenêtre à partir de l'écran de l'utilisateur
        //setResizable(false); //On interdit la redimensionnement de la fenêtre

        /*Construction de la barre de menu */
        this.setJMenuBar(creetMenuBar());


        /*Construction de la fenêtre*/
        JPanel contentFen = (JPanel) this.getContentPane();
        contentFen.setLayout(new BorderLayout());
        

        //Titre de ma fenêtre
        JLabel Titre = new JLabel("Bienvenue dans notre Projet Empreinte Carbonne", SwingConstants.CENTER);
        Titre.setFont(new Font("Serif ", Font.BOLD,20));
        contentFen.add(Titre);


        //Ajouter Logo REVOIR !!!!!!!!!!!!!!!!!!!!!!!!!!
        this.add(creeLogo());
    
        //Bouton Suivant
        contentFen.add(creeBouton_suivant(), BorderLayout.SOUTH);
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
    private void BTnextListener(ActionEvent event){
        

    }

    /* Méthode de construction du bouton Suivant*/
    private JPanel creeBouton_suivant(){
        JPanel tool = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //Bouton Suivant 
        JButton BTnext = new JButton("Suivant");
        tool.add(BTnext, BorderLayout.SOUTH);
        return tool;
    }


    //Création du logo REVOOIR !!!!!!!!!!!!!!!!!!!!!
    private JLabel creeLogo(){
        ImageIcon img = new ImageIcon("logo_projet.png");
        JLabel logo = new JLabel(img);
        logo.setPreferredSize(new Dimension (2,30));
        return logo;
    }

    public static void main(String [] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel()) ;
        //Ouvrir ma fenêtre
        Accueil accueil = new Accueil();
        accueil.setVisible(true);
    }
}
