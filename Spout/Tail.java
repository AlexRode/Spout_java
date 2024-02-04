import java.awt.Color;
import java.awt.Graphics;
public class Tail {
    int x;
    int y;
    private int width = 400; 
    private int height = 250;
    private Color color = Color.BLACK;
  public  Tail(int x,int y,int width,int height){
this.x = x;
this.y = y;
this.height=height;
this.width=width;

    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
