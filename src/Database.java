import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	public static boolean connected = false;
	public static Connection conn;

	static String[][] players;
	static String player;
	static int playerID;
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
	
	static int[][] platforms = new int[3][4];
	
	static String[][] stats = new String[100][2];
	
	public static void main(String[] args)
	{
		initDatabase();
	}
	
	public static void initDatabase()
	{
		
		try 
		{
			conn = getConnection();
			readPlatforms();
			readPlayer();
			readStats();
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

	public static void setPlayer(String player) throws SQLException {
		Database.player = player;
		writePlayer();
	}
	
	public static int getPlayerID() {
		return playerID;
	}
	
	public static void setPlayerID(int playerID) {
		Database.playerID = playerID;
	}
	
	public static String[][] getPlayers() {
		return players;
	}
	
	public static void setPlayers(String[][] players) {
		Database.players = players;
	}
	
	public static void readPlayer() throws SQLException {
		
	    Statement stmt = null;
	    String query = "SELECT ID, Name, Level " +
	                   "FROM mydb.Players";
	    try {
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        int i = 0;
	        while (rs.next()) {
	        	if (i == 0)
	        	{
	        		playerID = rs.getInt("ID");
	        		player = rs.getString("Name");
		            level = rs.getInt("Level");
	        	}
	        	else
	        	{
	        		players[i-1][0] = String.valueOf(rs.getInt("ID"));
	        		players[i-1][1] = rs.getString("Name");
	        		players[i-1][2] = String.valueOf(rs.getInt("Level"));
	        	}
	            i++;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        players = new String[1][1];
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
		
	}
	
	public static void writePlayer() throws SQLException {
		
	    Statement stmt = null;
	    String query = "UPDATE mydb.Players " +
	                   "SET Level=" + level + 
	                   "WHERE ID=" + playerID;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeQuery(query);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        players = new String[1][1];
	    } finally {
	        if (stmt != null) stmt.close();
	    }
		
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
	
	public static void readPlatforms() throws SQLException
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
	            if (i > 2) platforms[i][0] = (int) (Math.random() * 1000 + 1);
	            if (i > 2) platforms[i][1] = (int) ((Math.random()*11) * 60 );
	            platforms[i][2] = length;
	            platforms[i][3] = width;
	            i++;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        platforms = new int[4][4];
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
		
	}

	public static int getHealth() {
		return health;
	}

	public static void setHealth(int health) throws SQLException {
		Database.health = health;
		writeStats();
	}
	
	public static void readStats() throws SQLException
	{
		
	    Statement stmt = null;
	    String query1 = "SELECT Value, Stats_ID "+
	                    "FROM mydb.PlayerStats " +
	                    "WHERE Players_ID=" + playerID;
	    String query2 = "SELECT ID, Name "+
                		"FROM mydb.Stats";
	    try {
	        stmt = conn.createStatement();
	        ResultSet rs1 = stmt.executeQuery(query1);
	        stmt = conn.createStatement();
	        ResultSet rs2 = stmt.executeQuery(query2);
	        int i = 0;
	        while(rs2.next())
	        {
	        	stats[i][0] = String.valueOf(rs2.getInt("ID"));
	        	stats[i][1] = rs2.getString("Name");
	        }
	        i = 0;
	        int[] values = new int[100];
	        while (rs1.next()) {
	            if (rs1.getInt("Stats_ID") == Integer.parseInt(stats[i][0])) values[i] = rs1.getInt("Value");
	        }
	        health = values[0];
	        attack = values[1];
	        defense = values[2];
	        speed = values[3];
	        kills = values[4];
	    	matches = values[5];
	    	tilesCleared = values[6];
	    	tileTypeCleared = values[7];
	    	shotsFired = values[8];
	    	shotsHit = values[9];
	    	shotsTaken = values[10];
	    	numOfMatchesIn1Game = values[11];
	    } catch (SQLException e) {
	        e.printStackTrace();
	        health = 0;
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
		
	}
	
	public static void writeStats() throws SQLException {
		
		Statement stmt = null;
	    try {
		    String query = "UPDATE mydb.PlayerStats " +
		    				"SET Value=" + health +
		    				"WHERE Stats_ID=" + Integer.parseInt(stats[0][0]);
	        stmt = conn.createStatement();
	        stmt.executeQuery(query);
		    query = "UPDATE mydb.PlayerStats " +
    				"SET Value=" + attack +
    				"WHERE Stats_ID=" + Integer.parseInt(stats[1][0]);
		    stmt = conn.createStatement();
		    stmt.executeQuery(query);
		    query = "UPDATE mydb.PlayerStats " +
    				"SET Value=" + defense +
    				"WHERE Stats_ID=" + Integer.parseInt(stats[2][0]);
		    stmt = conn.createStatement();
		    stmt.executeQuery(query);
		    query = "UPDATE mydb.PlayerStats " +
    				"SET Value=" + speed +
    				"WHERE Stats_ID=" + Integer.parseInt(stats[3][0]);
		    stmt = conn.createStatement();
		    stmt.executeQuery(query);
		    query = "UPDATE mydb.PlayerStats " +
    				"SET Value=" + kills +
    				"WHERE Stats_ID=" + Integer.parseInt(stats[4][0]);
		    stmt = conn.createStatement();
		    stmt.executeQuery(query);
		    query = "UPDATE mydb.PlayerStats " +
    				"SET Value=" + matches +
    				"WHERE Stats_ID=" + Integer.parseInt(stats[5][0]);
		    stmt = conn.createStatement();
		    stmt.executeQuery(query);
		    query = "UPDATE mydb.PlayerStats " +
    				"SET Value=" + tilesCleared +
    				"WHERE Stats_ID=" + Integer.parseInt(stats[6][0]);
		    stmt = conn.createStatement();
		    stmt.executeQuery(query);
		    query = "UPDATE mydb.PlayerStats " +
    				"SET Value=" + tileTypeCleared +
    				"WHERE Stats_ID=" + Integer.parseInt(stats[7][0]);
		    stmt = conn.createStatement();
		    stmt.executeQuery(query);
		    query = "UPDATE mydb.PlayerStats " +
    				"SET Value=" + shotsFired +
    				"WHERE Stats_ID=" + Integer.parseInt(stats[8][0]);
		    stmt = conn.createStatement();
		    stmt.executeQuery(query);
		    query = "UPDATE mydb.PlayerStats " +
    				"SET Value=" + shotsHit +
    				"WHERE Stats_ID=" + Integer.parseInt(stats[9][0]);
		    stmt = conn.createStatement();
		    stmt.executeQuery(query);
		    query = "UPDATE mydb.PlayerStats " +
    				"SET Value=" + shotsTaken +
    				"WHERE Stats_ID=" + Integer.parseInt(stats[10][0]);
		    stmt = conn.createStatement();
		    stmt.executeQuery(query);
		    query = "UPDATE mydb.PlayerStats " +
    				"SET Value=" + numOfMatchesIn1Game +
    				"WHERE Stats_ID=" + Integer.parseInt(stats[11][0]);
		    stmt = conn.createStatement();
		    stmt.executeQuery(query);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
		
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
