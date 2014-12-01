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
    JLabel fps;
    
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

        JLabel titreLabel = new JLabel("Test");
        panel.add(titreLabel, BorderLayout.NORTH);

        drawingPanel = new DrawingPanel();
        drawingPanel.setBorder(new LineBorder(Color.black));
        drawingPanel.setBackground(Color.white);
        panel.add(drawingPanel);
        
        fps = new JLabel();
        JLabel label_for_fps = new JLabel("FPS : ");
        label_for_fps.setLabelFor(fps);
        
        JPanel infoPanel = new JPanel();
        infoPanel.add(label_for_fps);
        infoPanel.add(fps);
        panel.add(infoPanel, BorderLayout.EAST);
        
        return panel;
    }
    
    public DrawingPanel getDrawingPanel()
    {
        return drawingPanel;
    }
    
    public void setFPS(double fps)
    {
        fps = Math.round(fps * 10) / 10;
        this.fps.setText("" +fps);
    }
}
