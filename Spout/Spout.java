import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Spout extends JFrame {
    private JPanel gamePanel;
    private Player player;
    private Tail tail;
    private final int SPEED = 5;

    private int height = 600;
    private int width = 800;

    public Spout() {
        this.setTitle("Jogo com KeyBindings");
        this.setSize(height, width);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        
        // Inicializa o player
        player = new Player(100, 100, 50, 50, 50, 400, Color.BLACK);
        //tail = new Tail(100,100,400,200);
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                player.draw(g); // Desenha o player
            }
        };
        gamePanel.setPreferredSize(new Dimension(width, height));
        this.add(gamePanel);
        this.pack();

        // Configura KeyBindings
        setupKeyBindings();

        this.setVisible(true);
    }

    private void setupKeyBindings() {
        gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "moveUp");
        gamePanel.getActionMap().put("moveUp", createAction(0, -SPEED));
    
        gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "moveDown");
        gamePanel.getActionMap().put("moveDown", createAction(0, SPEED));
    
        gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "moveLeft");
        gamePanel.getActionMap().put("moveLeft", createAction(-SPEED, 0));
    
        gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "moveRight");
        gamePanel.getActionMap().put("moveRight", createAction(SPEED, 0));
    }
    
    private Action createAction(final int dx, final int dy) {
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.move();
                gamePanel.repaint();
            }
        };
    }

    public static void main(String[] args) {
        new Spout();
    }
}
