import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Player extends Movable {
    private int width, height; // Dimensões do player
    private Color color; // Cor do player
    private LinkedList<int[]> tailPositions; // Lista para armazenar posições da cauda
    private int tailLength; // Comprimento da cauda

    public Player(int x, int y, int speed, int width, int height, int tailLength, Color color) {
        super(x, y, speed);
        this.width = width;
        this.height = height;
        this.tailLength = tailLength;
        this.color = color;
        this.tailPositions = new LinkedList<>();
    }

    @Override
    public void move(int dx, int dy) {
        // Atualiza a posição do player
        this.x += dx;
        this.y += dy;

        // Adiciona a nova posição à lista da cauda
        tailPositions.addFirst(new int[]{x, y});

        // Mantém o tamanho da cauda ao remover o elemento mais antigo, se necessário
        while (tailPositions.size() > tailLength) {
            tailPositions.removeLast();
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        // Desenha o player
        g.fillRect(x, y, width, height);

        // Desenha cada segmento da cauda
        for (int[] pos : tailPositions) {
            g.fillRect(pos[0], pos[1], width, height);
        }
    }
}
