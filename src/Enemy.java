
public class Enemy {
	private int health;
	private int attack;
	private int speed;
	private int defense;
	private int posX;
	private int posY;
	public Enemy(int h, int a, int d, int s, int x, int y) {
		this.setHealth(h);
		this.setAttack(a);
		this.setDefense(d);
		this.setSpeed(s);
		this.setPosX(x);
		this.setPosY(y);
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
}
