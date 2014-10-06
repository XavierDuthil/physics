package physics.display;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainWindow extends JFrame
{
    DrawingPanel drawingPanel;
    
    public MainWindow()
    {
        super();
        build();
    }
    
    private void build()
    {
        setTitle("Physics");
        setSize(600,600);
        
        setLocationRelativeTo(null); // La fenêtre apparaît centrée sur l'écran
        setResizable(true); // Le redimensionnement de la fenêtre est autorisé
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // L'application se ferme en cas de clic sur la croix rouge
    
        setContentPane(buildContentPane());
        setVisible(true);
    }
    
    private JPanel buildContentPane()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JLabel label = new JLabel("Test");
        panel.add(label, BorderLayout.NORTH);

        drawingPanel = new DrawingPanel();
        drawingPanel.setBorder(new LineBorder(Color.black));
        drawingPanel.setBackground(Color.white);
        panel.add(drawingPanel);
        
        return panel;
    }
    
    public DrawingPanel getDrawingPanel()
    {
        return drawingPanel;
    }
}
