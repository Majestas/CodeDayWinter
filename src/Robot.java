
public class Robot 
{
	private static int health = 1;
	private static int attack = 1;
	private static int defense = 0;
	private static int speed = 1;
	private static int maxSpeed = 3 * speed;
	private static int speedX = 0;
	private static int speedY = 0;
	private static int kills = 0;
	private static int matches = 0;
	private static int tilesCleared = 0;
	private static int tileTypeCleared = 0;
	private static int shotsFired = 0;
	private static int shotsHit = 0;
	private static int shotsTaken = 0; //shots which hit you!
	private static int totalMatches = 0;
	private static int bestCascade = 0; //in color matching thing
	private static int x = 0;
	private static int y = 0;
	
	
	public Robot(int startx, int starty)
	{
		Robot.setX(startx);
		Robot.setY(startx);
	}
	
	public static int getHealth() {
		return Robot.health;
	}

	public static void setHealth(int health) {
		Robot.health = health;
	}

	public static int getAttack() {
		return Robot.attack;
	}

	public static void setAttack(int attack) {
		Robot.attack = attack;
	}

	public static int getDefense() {
		return Robot.defense;
	}

	public static void setDefense(int defense) {
		Robot.defense = defense;
	}

	public static int getSpeed() {
		return Robot.speed;
	}

	public static void setSpeed(int speed) {
		Robot.speed = speed;
	}

	public static int getKills() {
		return Robot.kills;
	}

	public static void setKills(int kills) {
		Robot.kills = kills;
	}

	public static int getMatches() {
		return Robot.matches;
	}

	public static void setMatches(int matches) {
		Robot.matches = matches;
	}

	public static int getTilesCleared() {
		return Robot.tilesCleared;
	}

	public static void setTilesCleared(int tilesCleared) {
		Robot.tilesCleared = tilesCleared;
	}

	public static int getTileTypeCleared() {
		return Robot.tileTypeCleared;
	}

	public static void setTileTypeCleared(int tileTypeCleared) {
		Robot.tileTypeCleared = tileTypeCleared;
	}

	public static int getShotsFired() {
		return Robot.shotsFired;
	}

	public static void setShotsFired(int shotsFired) {
		Robot.shotsFired = shotsFired;
	}

	public static int getShotsHit() {
		return Robot.shotsHit;
	}

	public static void setShotsHit(int shotsHit) {
		Robot.shotsHit = shotsHit;
	}

	public static int getShotsTaken() {
		return Robot.shotsTaken;
	}

	public static void setShotsTaken(int shotsTaken) {
		Robot.shotsTaken = shotsTaken;
	}

	public static int getTotalMatches() {
		return Robot.totalMatches;
	}

	public static void setTotalMatches(int totalMatches) {
		Robot.totalMatches = totalMatches;
	}

	public static int getBestCascade() {
		return Robot.bestCascade;
	}

	public static void setBestCascade(int bestCascade) {
		Robot.bestCascade = bestCascade;
	}

	public static int getX() {
		return Robot.x;
	}

	public static void setX(int x) {
		Robot.x = x;
	}

	public static int getY() {
		return Robot.y;
	}

	public static void setY(int y) {
		Robot.y = y;
	}

	public static int getSpeedX() {
		return speedX;
	}

	public static void setSpeedX(int speedX) {
		Robot.speedX = speedX;
		
		if(Robot.speedY > Robot.maxSpeed)
		{
			Robot.speedY = Robot.maxSpeed;
		}
		if(Robot.speedY < (-1)*Robot.maxSpeed)
		{
			Robot.speedY = (-1)*Robot.maxSpeed;
		}
	}

	public static int getSpeedY() {
		return speedY;
	}

	public static void setSpeedY(int speedY) {
		Robot.speedY = speedY;
		if(Robot.speedY > Robot.maxSpeed)
		{
			Robot.speedY = Robot.maxSpeed;
		}
	}

}
