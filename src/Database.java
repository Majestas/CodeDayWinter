import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	public static boolean connected = false;
	public static Connection conn;

	static String player;
	static int level;
	static int health;
	static int attack;
	static int defense;
	static int speed;
	
	static int kills;
	static int matches;
	static int tilesCleared;
	static int tileTypeCleared;
	static int shotsFired;
	static int shotsHit;
	static int shotsTaken;
	static int numOfMatchesIn1Game;
	
	static int[][] platforms = new int[4][4];
	
	public static void main(String[] args)
	{
		saveForm();
	}
	
	public static void initDatabase()
	{
		
		
		
	}
	
	public static void saveForm()
	{
		
		try 
		{
			conn = getConnection();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public static Connection getConnection() throws SQLException 
	{
	    
	    conn = DriverManager.getConnection("jdbc:mysql://172.20.41.146:3306/mydb?useSSL=false", "root", "");

	    System.out.println("Connected to database");
	    connected = true;
	    return conn;
	    
	}
	
	public static String getPlayer() {
		return player;
	}

	public static void setPlayer(String player) {
		Database.player = player;
	}
	
	public static void readPlayer() {
		
	}
	
	public static void writePlayer() {
		
	}

	public static int getLevel() {
		return level;
	}

	public static void setLevel(int level) {
		Database.level = level;
	}
	
	public static void readLevel() {
		
	}
	
	public static void writeLevel() {
		
	}

	public static int getKills() {
		return kills;
	}

	public static void setKills(int kills) {
		Database.kills = kills;
	}
	
	public static void readKills() {
		
	}
	
	public static void writeKills() {
		
	}

	public static int getMatches() {
		return matches;
	}

	public static void setMatches(int matches) {
		Database.matches = matches;
	}
	
	public static void readMatches() {
		
	}
	
	public static void writeMatches() {
		
	}

	public static int getTilesCleared() {
		return tilesCleared;
	}

	public static void setTilesCleared(int tilesCleared) {
		Database.tilesCleared = tilesCleared;
	}
	
	public static void readTilesCleared() {
		
	}
	
	public static void writeTilesCleared() {
		
	}

	public static int getTileTypeCleared() {
		return tileTypeCleared;
	}

	public static void setTileTypeCleared(int tileTypeCleared) {
		Database.tileTypeCleared = tileTypeCleared;
	}
	
	public static void readTileTypeCleared() {
		
	}

	public static void writeTileTypeCleared() {
		
	}
	
	public static int getShotsFired() {
		return shotsFired;
	}

	public static void setShotsFired(int shotsFired) {
		Database.shotsFired = shotsFired;
	}
	
	public static void readShotsFired() {
		
	}
	
	public static void writeShotsFired() {
		
	}

	public static int getShotsHit() {
		return shotsHit;
	}

	public static void setShotsHit(int shotsHit) {
		Database.shotsHit = shotsHit;
	}
	
	public static void readShotsHit() {
		
	}
	
	public static void writeShotsHit() {
		
	}

	public static int getShotsTaken() {
		return shotsTaken;
	}

	public static void setShotsTaken(int shotsTaken) {
		Database.shotsTaken = shotsTaken;
	}
	
	public static void readShotsTaken() {
		
	}
	
	public static void writeShotsTaken() {
		
	}

	public static int getNumOfMatchesIn1Game() {
		return numOfMatchesIn1Game;
	}

	public static void setNumOfMatchesIn1Game(int numOfMatchesIn1Game) {
		Database.numOfMatchesIn1Game = numOfMatchesIn1Game;
	}
	
	public static void readNumOfMatchesIn1Game() {
		
	}
	
	public static void writeNumOfMatchesIn1Game() {
		
	}

	public static int[][] getPlatforms() {
		return platforms;
	}

	public static void setPlatforms(int[][] platforms) {
		Database.platforms = platforms;
	}
	
	public static int[][] readPlatforms() throws SQLException
	{
		
	    Statement stmt = null;
	    String query = "SELECT LengthX, WidthY "+
	                   "FROM mydb.Platforms";
	    try {
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        int i = 0;
	        while (rs.next()) {
	            int length = rs.getInt("LengthX");
	            int width = rs.getInt("WidthY");
	            platforms[i][0] = (int) (Math.random() * (1000) + 1);
	            platforms[i][1] = (int) (Math.random() * (600) + 100);
	            platforms[i][2] = length;
	            platforms[i][3] = width;
	            i++;
	        }
	        return platforms;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        platforms = new int[4][4];
	        return platforms;
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
		
	}

	public static int getHealth() {
		return health;
	}

	public static void setHealth(int health) {
		Database.health = health;
	}
	
	public static void readHealth() {
		
	}
	
	public static void writeHealth() {
		
	}

	public static int getAttack() {
		return attack;
	}

	public static void setAttack(int attack) {
		Database.attack = attack;
	}
	
	public static void readAttack() {
		
	}
	
	public static void writeAttack() {
		
	}

	public static int getDefense() {
		return defense;
	}

	public static void setDefense(int defense) {
		Database.defense = defense;
	}
	
	public static void readDefense() {
		
	}
	
	public static void writeDefense() {
		
	}

	public static int getSpeed() {
		return speed;
	}

	public static void setSpeed(int speed) {
		Database.speed = speed;
	}
	
	public static void readSpeed() {
		
	}

	public static void writeSpeed() {
		
	}
	
}
