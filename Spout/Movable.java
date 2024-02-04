public abstract class Movable {
    protected int x, y; // Posições do objeto no jogo
    protected int speed; // Velocidade de movimento do objeto

    public Movable(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    // Método para mover o objeto, a ser implementado pelas subclasses
    public abstract void move();

    // Métodos getters e setters básicos
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

