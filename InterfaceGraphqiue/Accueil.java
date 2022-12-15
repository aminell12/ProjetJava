package InterfaceGraphqiue;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.*;

public class Accueil extends JFrame {
    public Accueil () {
        super ("Accueil"); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null); //Centre la fenêtre à partir de l'écran de l'utilisateur
        //setResizable(false); //On interdit la redimensionnement de la fenêtre

        /*Construction de la barre de menu */
        this.setJMenuBar(creetMenuBar());

        /*Construction de la fenêtre*/
        JPanel contentFen = (JPanel) this.getContentPane();

        //Titre de ma fenêtre
        JLabel Titre = new JLabel("Bienvenue dans notre Projet Empreinte Carbonne", SwingConstants.CENTER);
        Titre.setFont(new Font("Serif ", Font.BOLD,20));
        contentFen.add(Titre);

    
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
        //Élement qu'on ajoute au menu déroulant
        JMenuItem quitter = new JMenuItem("Quitter le Projet Empreinte Carbone");
        mnufile.add(quitter);
        return menubar;
    }
    /* Méthode de construction du bouton Suivant*/
    private JPanel creeBouton_suivant(){
        JPanel tool = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //Bouton Suivant 
        JButton next = new JButton("Suivant");
        tool.add(next, BorderLayout.SOUTH);
        return tool;
    }

    public static void main(String [] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel()) ;
        //Ouvrir ma fenêtre
        Accueil accueil = new Accueil();
        accueil.setVisible(true);
    }
}
