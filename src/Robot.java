
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
	private static int redTilesCleared = 0;
	private static int blueTilesCleared = 0;
	private static int greenTilesCleared = 0;
	private static int yellowTilesCleared = 0;
	private static int tilesCleared = 0;
	private static int shotsFired = 0;
	private static int shotsHit = 0;
	private static int shotsTaken = 0; //shots which hit you!
	private static int totalMatches = 0;
	private static int bestCascade = 0; //in color matching thing
	private static int x = 0;
	private static int y = 0;
	private static int height = 22;
	private static int width = 15;
	
	
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
	
	public static void updateLoc()
	{
		if(!Robot.collideX())
		{
			Robot.x += Robot.speedX;
		}
		if(!Robot.collideY())
		{
			Robot.y += Robot.speedY;
		}
			
	}
	
	public static boolean collideX()
	{
		boolean response = true;
		
		int ximage = Robot.x + Robot.speedX;
		int yimage = Robot.y + 0;
		
		int[][] plats = {{0,0,0,0},{1,1,1,1}}; //filler for actual platform stuff {x,y,l,h}
		
		for(int[] plat : plats)
		{
			if(ximage > plat[0] && ximage < plat[0] + plat[2])
			{
				response = false;
				break;
			}
			if(ximage > plat[0] && ximage + Robot.width < plat[0] + plat[2])
			{
				response = false;
				break;
			}
			if(yimage > plat[1] && yimage < plat[1] + plat[3])
			{
				response = false;
				break;
			}
			if(ximage > plat[1] && ximage + Robot.height < plat[1] + plat[3])
			{
				response = false;
				break;
			}
		}
		
		
		return response;
	}
	
	public static boolean collideY()
	{
boolean response = true;
		
		int ximage = Robot.x + 0;
		int yimage = Robot.y + Robot.speedY;
		
		int[][] plats = {{0,0,0,0},{1,1,1,1}}; //filler for actual platform stuff {x,y,l,h}
		
		for(int[] plat : plats)
		{
			if(ximage > plat[0] && ximage < plat[0] + plat[2])
			{
				response = false;
				break;
			}
			if(ximage > plat[0] && ximage + Robot.width < plat[0] + plat[2])
			{
				response = false;
				break;
			}
			if(yimage > plat[1] && yimage < plat[1] + plat[3])
			{
				response = false;
				break;
			}
			if(ximage > plat[1] && ximage + Robot.height < plat[1] + plat[3])
			{
				response = false;
				break;
			}
		}
		
		
		return response;
	}

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		Robot.height = height;
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		Robot.width = width;
	}

	public static int getYellowTilesCleared() {
		return yellowTilesCleared;
	}

	public static void setYellowTilesCleared(int yellowTilesCleared) {
		Robot.yellowTilesCleared = yellowTilesCleared;
	}

	public static int getGreenTilesCleared() {
		return greenTilesCleared;
	}

	public static void setGreenTilesCleared(int greenTilesCleared) {
		Robot.greenTilesCleared = greenTilesCleared;
	}

	public static int getBlueTilesCleared() {
		return blueTilesCleared;
	}

	public static void setBlueTilesCleared(int blueTilesCleared) {
		Robot.blueTilesCleared = blueTilesCleared;
	}

	public static int getRedTilesCleared() {
		return redTilesCleared;
	}

	public static void setRedTilesCleared(int redTilesCleared) {
		Robot.redTilesCleared = redTilesCleared;
	}

}
