
public class Puzzle {
	// Variables for puzzle
	private static int[][] puzzleGrid = new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	private static int[][] highlightedGrid = new int[7][10];
	private static int moves = 0;
	private static int maxMoves = 0;
	private static int boxX = 0;
	private static int boxY = 0;

	// Stats variables
	private static int tilesCleared = 0;
	private static int matchesMade = 0;
	private static int redCleared = 0;
	private static int yellowCleared = 0;
	private static int greenCleared = 0;
	private static int blueCleared = 0;
	private static int bestCascade = 0;

	// Puzzle methods
	private static void checkMatches() {
		boolean deletedTiles = false;
		int cascade = 0;
		int[][] match = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		for (int i = 0; i < 7; i++) {
				if ((puzzleGrid[i][0] == puzzleGrid[i][1])
						&& (puzzleGrid[i][0] == puzzleGrid[i][2])
						&& (puzzleGrid[i][0] == puzzleGrid[i][3])
						&& (puzzleGrid[i][0] == puzzleGrid[i][4])
						&& (puzzleGrid[i][0] == puzzleGrid[i][5])
						&& (puzzleGrid[i][0] == puzzleGrid[i][6])
						&& (puzzleGrid[i][0] == puzzleGrid[i][7])
						&& (puzzleGrid[i][0] == puzzleGrid[i][8])
						&& (puzzleGrid[i][0] == puzzleGrid[i][9])) {
					switch (puzzleGrid[i][0]) {
					case 1:
						redCleared += 10;
						Robot.setHealth(Robot.getHealth() + 10);
						break;
					case 2:
						greenCleared += 10;
						Robot.setDefense(Robot.getDefense() + 10);
						break;
					case 3:
						yellowCleared += 10;
						Robot.setAttack(Robot.getAttack() + 10);
						break;
					case 4:
						blueCleared += 10;
						Robot.setMaxSpeed(Robot.getMaxSpeed() + 10);
						break;
					default:
						break;
					}
					match[i][0] = 1;
					match[i][1] = 1;
					match[i][2] = 1;
					match[i][3] = 1;
					match[i][4] = 1;
					match[i][5] = 1;
					match[i][6] = 1;
					match[i][7] = 1;
					match[i][8] = 1;
					match[i][9] = 1;
					matchesMade++;
					cascade++;
					deletedTiles = true;
				}
		}
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				if ((puzzleGrid[i][j] == puzzleGrid[i][j + 1])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 2])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 3])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 4])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 5])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 6])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 7])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 8])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						redCleared += 9;
						Robot.setHealth(Robot.getHealth() + 9);
						break;
					case 2:
						greenCleared += 9;
						Robot.setDefense(Robot.getDefense() + 9);
						break;
					case 3:
						yellowCleared += 9;
						Robot.setAttack(Robot.getAttack() + 9);
						break;
					case 4:
						blueCleared += 9;
						Robot.setMaxSpeed(Robot.getMaxSpeed() + 9);
						break;
					default:
						break;
					}
					match[i][j] = 1;
					match[i][j + 1] = 1;
					match[i][j + 2] = 1;
					match[i][j + 3] = 1;
					match[i][j + 4] = 1;
					match[i][j + 5] = 1;
					match[i][j + 6] = 1;
					match[i][j + 7] = 1;
					match[i][j + 8] = 1;
					matchesMade++;
					cascade++;
					deletedTiles = true;
				}
			}
		}
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 3; j++) {
				if ((puzzleGrid[i][j] == puzzleGrid[i][j + 1])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 2])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 3])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 4])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 5])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 6])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 7])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						redCleared += 8;
						Robot.setHealth(Robot.getHealth() + 8);
						break;
					case 2:
						greenCleared += 8;
						Robot.setDefense(Robot.getDefense() + 8);
						break;
					case 3:
						yellowCleared += 8;
						Robot.setAttack(Robot.getAttack() + 8);
						break;
					case 4:
						blueCleared += 8;
						Robot.setMaxSpeed(Robot.getMaxSpeed() + 8);
						break;
					default:
						break;
					}
					match[i][j] = 1;
					match[i][j + 1] = 1;
					match[i][j + 2] = 1;
					match[i][j + 3] = 1;
					match[i][j + 4] = 1;
					match[i][j + 5] = 1;
					match[i][j + 6] = 1;
					match[i][j + 7] = 1;
					matchesMade++;
					cascade++;
					deletedTiles = true;
				}
			}
		}
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 4; j++) {
				if ((puzzleGrid[i][j] == puzzleGrid[i][j + 1])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 2])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 3])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 4])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 5])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 6])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						redCleared += 7;
						Robot.setHealth(Robot.getHealth() + 7);
						break;
					case 2:
						greenCleared += 7;
						Robot.setDefense(Robot.getDefense() + 7);
						break;
					case 3:
						yellowCleared += 7;
						Robot.setAttack(Robot.getAttack() + 7);
						break;
					case 4:
						blueCleared += 7;
						Robot.setMaxSpeed(Robot.getMaxSpeed() + 7);
						break;
					default:
						break;
					}
					match[i][j] = 1;
					match[i][j + 1] = 1;
					match[i][j + 2] = 1;
					match[i][j + 3] = 1;
					match[i][j + 4] = 1;
					match[i][j + 5] = 1;
					match[i][j + 6] = 1;
					matchesMade++;
					cascade++;
					deletedTiles = true;
				}
			}
		}
			for (int j = 0; j < 10; j++) {
				if ((puzzleGrid[0][j] == puzzleGrid[1][j])
						&& (puzzleGrid[0][j] == puzzleGrid[2][j])
						&& (puzzleGrid[0][j] == puzzleGrid[3][j])
						&& (puzzleGrid[0][j] == puzzleGrid[4][j])
						&& (puzzleGrid[0][j] == puzzleGrid[5][j])
						&& (puzzleGrid[0][j] == puzzleGrid[6][j])) {
					switch (puzzleGrid[0][j]) {
					case 1:
						redCleared += 7;
						Robot.setHealth(Robot.getHealth() + 7);
						break;
					case 2:
						greenCleared += 7;
						Robot.setDefense(Robot.getDefense() + 7);
						break;
					case 3:
						yellowCleared += 7;
						Robot.setAttack(Robot.getAttack() + 7);
						break;
					case 4:
						blueCleared += 7;
						Robot.setMaxSpeed(Robot.getMaxSpeed() + 7);
						break;
					default:
						break;
					}
					match[0][j] = 1;
					match[1][j] = 1;
					match[2][j] = 1;
					match[3][j] = 1;
					match[4][j] = 1;
					match[5][j] = 1;
					match[6][j] = 1;
					matchesMade++;
					cascade++;
					deletedTiles = true;
				}
			}
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if ((puzzleGrid[i][j] == puzzleGrid[i][j + 1])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 2])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 3])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 4])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 5])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						redCleared += 6;
						Robot.setHealth(Robot.getHealth() + 6);
						break;
					case 2:
						greenCleared += 6;
						Robot.setDefense(Robot.getDefense() + 6);
						break;
					case 3:
						yellowCleared += 6;
						Robot.setAttack(Robot.getAttack() + 6);
						break;
					case 4:
						blueCleared += 6;
						Robot.setMaxSpeed(Robot.getMaxSpeed() + 6);
						break;
					default:
						break;
					}
					match[i][j] = 1;
					match[i][j + 1] = 1;
					match[i][j + 2] = 1;
					match[i][j + 3] = 1;
					match[i][j + 4] = 1;
					match[i][j + 5] = 1;
					matchesMade++;
					cascade++;
					deletedTiles = true;
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				if ((puzzleGrid[i][j] == puzzleGrid[i + 1][j])
						&& (puzzleGrid[i][j] == puzzleGrid[i + 2][j])
						&& (puzzleGrid[i][j] == puzzleGrid[i + 3][j])
						&& (puzzleGrid[i][j] == puzzleGrid[i + 4][j])
						&& (puzzleGrid[i][j] == puzzleGrid[i + 5][j])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						redCleared += 6;
						Robot.setHealth(Robot.getHealth() + 6);
						break;
					case 2:
						greenCleared += 6;
						Robot.setDefense(Robot.getDefense() + 6);
						break;
					case 3:
						yellowCleared += 6;
						Robot.setAttack(Robot.getAttack() + 6);
						break;
					case 4:
						blueCleared += 6;
						Robot.setMaxSpeed(Robot.getMaxSpeed() + 6);
						break;
					default:
						break;
					}
					match[i][j] = 1;
					match[i + 1][j] = 1;
					match[i + 2][j] = 1;
					match[i + 3][j] = 1;
					match[i + 4][j] = 1;
					match[i + 5][j] = 1;
					matchesMade++;
					cascade++;
					deletedTiles = true;
				}
			}
		}
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				if ((puzzleGrid[i][j] == puzzleGrid[i][j + 1])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 2])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 3])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 4])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						redCleared += 5;
						Robot.setHealth(Robot.getHealth() + 5);
						break;
					case 2:
						greenCleared += 5;
						Robot.setDefense(Robot.getDefense() + 5);
						break;
					case 3:
						yellowCleared += 5;
						Robot.setAttack(Robot.getAttack() + 5);
						break;
					case 4:
						blueCleared += 5;
						Robot.setMaxSpeed(Robot.getMaxSpeed() + 5);
						break;
					default:
						break;
					}
					match[i][j] = 1;
					match[i][j + 1] = 1;
					match[i][j + 2] = 1;
					match[i][j + 3] = 1;
					match[i][j + 4] = 1;
					matchesMade++;
					cascade++;
					deletedTiles = true;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				if ((puzzleGrid[i][j] == puzzleGrid[i + 1][j])
						&& (puzzleGrid[i][j] == puzzleGrid[i + 2][j])
						&& (puzzleGrid[i][j] == puzzleGrid[i + 3][j])
						&& (puzzleGrid[i][j] == puzzleGrid[i + 4][j])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						redCleared += 5;
						Robot.setHealth(Robot.getHealth() + 5);
						break;
					case 2:
						greenCleared += 5;
						Robot.setDefense(Robot.getDefense() + 5);
						break;
					case 3:
						yellowCleared += 5;
						Robot.setAttack(Robot.getAttack() + 5);
						break;
					case 4:
						blueCleared += 5;
						Robot.setMaxSpeed(Robot.getMaxSpeed() + 5);
						break;
					default:
						break;
					}
					match[i][j] = 1;
					match[i + 1][j] = 1;
					match[i + 2][j] = 1;
					match[i + 3][j] = 1;
					match[i + 4][j] = 1;
					matchesMade++;
					cascade++;
					deletedTiles = true;
				}
			}
		}
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if ((puzzleGrid[i][j] == puzzleGrid[i][j + 1])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 2])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 3])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						redCleared += 4;
						Robot.setHealth(Robot.getHealth() + 4);
						break;
					case 2:
						greenCleared += 4;
						Robot.setDefense(Robot.getDefense() + 4);
						break;
					case 3:
						yellowCleared += 4;
						Robot.setAttack(Robot.getAttack() + 4);
						break;
					case 4:
						blueCleared += 4;
						Robot.setMaxSpeed(Robot.getMaxSpeed() + 4);
						break;
					default:
						break;
					}
					match[i][j] = 1;
					match[i][j + 1] = 1;
					match[i][j + 2] = 1;
					match[i][j + 3] = 1;
					matchesMade++;
					cascade++;
					deletedTiles = true;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				if ((puzzleGrid[i][j] == puzzleGrid[i + 1][j])
						&& (puzzleGrid[i][j] == puzzleGrid[i + 2][j])
						&& (puzzleGrid[i][j] == puzzleGrid[i + 3][j])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						redCleared += 4;
						Robot.setHealth(Robot.getHealth() + 4);
						break;
					case 2:
						greenCleared += 4;
						Robot.setDefense(Robot.getDefense() + 4);
						break;
					case 3:
						yellowCleared += 4;
						Robot.setAttack(Robot.getAttack() + 4);
						break;
					case 4:
						blueCleared += 4;
						Robot.setMaxSpeed(Robot.getMaxSpeed() + 4);
						break;
					default:
						break;
					}
					match[i][j] = 1;
					match[i + 1][j] = 1;
					match[i + 2][j] = 1;
					match[i + 3][j] = 1;
					matchesMade++;
					cascade++;
					deletedTiles = true;
				}
			}
		}
		for (int i = 0; i < 7; i++) {
			for (int k = 0; k < 10; k++) {
				if (match[i][k] == 1) {
					tilesCleared++;
					puzzleGrid[i][k] = 0;
					deletedTiles = true;
				}
			}
		}
		if (cascade > bestCascade) {
			bestCascade = cascade;
		}
		if (deletedTiles) {
			Display.healthLabel.setText("Health: "+Robot.getHealth());
			Display.attackLabel.setText("Attack: "+Robot.getAttack());
			Display.defenseLabel.setText("Defense: "+Robot.getDefense());
			Display.speedLabel.setText("Speed: "+Robot.getMaxSpeed());
			displayGrid();
			dropTiles();
		}
	}

	public static void createGrid() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 10; j++) {
				puzzleGrid[i][j] = (int) (Math.random() * 4) + 1;
			}
		}
		checkMatches();
	}

	private static void dropTiles() {
		for (int i = 0; i < 7; i++) {
			for (int k = 0; k < 10; k++) {
				if (puzzleGrid[i][k] == 0) {
					puzzleGrid[i][k] = (int) (Math.random() * 4) + 1;
				}
			}
		}
		displayGrid();
		checkMatches();
	}

	public static void runPuzzle(int move) {
		moves = 0;
		maxMoves = move;
		createGrid();
		displayGrid();
		boxX = 0;
		boxY = 0;
		Display.moveLabel.setText("Moves: "+moves+"/"+maxMoves);
		Display.healthLabel.setText("Health: "+Robot.getHealth());
		Display.attackLabel.setText("Attack: "+Robot.getAttack());
		Display.defenseLabel.setText("Defense: "+Robot.getDefense());
		Display.speedLabel.setText("Speed: "+Robot.getMaxSpeed());
	}

	public static void rotate(int direction) {
		int temp;
		switch (direction) {
		case 1: // Rotate Right
			temp = puzzleGrid[boxY][boxX];
			puzzleGrid[boxY][boxX] = puzzleGrid[boxY + 1][boxX];
			puzzleGrid[boxY + 1][boxX] = puzzleGrid[boxY + 1][boxX + 1];
			puzzleGrid[boxY + 1][boxX + 1] = puzzleGrid[boxY][boxX + 1];
			puzzleGrid[boxY][boxX + 1] = temp;
			break;
		case 2: // Rotate Left
			temp = puzzleGrid[boxY][boxX];
			puzzleGrid[boxY][boxX] = puzzleGrid[boxY][boxX + 1];
			puzzleGrid[boxY][boxX + 1] = puzzleGrid[boxY + 1][boxX + 1];
			puzzleGrid[boxY + 1][boxX + 1] = puzzleGrid[boxY + 1][boxX];
			puzzleGrid[boxY + 1][boxX] = temp;
			break;
		case 3: // Flip Vertically
			temp = puzzleGrid[boxY][boxX];
			puzzleGrid[boxY][boxX] = puzzleGrid[boxY + 1][boxX];
			puzzleGrid[boxY + 1][boxX] = temp;
			temp = puzzleGrid[boxY][boxX + 1];
			puzzleGrid[boxY][boxX + 1] = puzzleGrid[boxY + 1][boxX + 1];
			puzzleGrid[boxY + 1][boxX + 1] = temp;
			break;
		case 4: // Flip Horizontally
			temp = puzzleGrid[boxY][boxX];
			puzzleGrid[boxY][boxX] = puzzleGrid[boxY][boxX + 1];
			puzzleGrid[boxY][boxX + 1] = temp;
			temp = puzzleGrid[boxY + 1][boxX];
			puzzleGrid[boxY + 1][boxX] = puzzleGrid[boxY + 1][boxX + 1];
			puzzleGrid[boxY + 1][boxX + 1] = temp;
			break;
		}
		displayGrid();
		moves++;
		Display.moveLabel.setText("Moves: "+moves+"/"+maxMoves);
		checkMatches();
		checkMoves();
	}

	public static void moveBox(int direction) {

		switch (direction) {
		case 1: {// right
			if (boxX < 8) {
				highlightedGrid[boxY][boxX] -= 4;
				highlightedGrid[boxY + 1][boxX] -= 4;
				highlightedGrid[boxY][boxX + 1] -= 4;
				highlightedGrid[boxY + 1][boxX + 1] -= 4;
				boxX++;
				displayGrid();
			}
			break;
		}
		case 2: { // Left
			if (boxX > 0) {
				highlightedGrid[boxY][boxX] -= 4;
				highlightedGrid[boxY + 1][boxX] -= 4;
				highlightedGrid[boxY][boxX + 1] -= 4;
				highlightedGrid[boxY + 1][boxX + 1] -= 4;
				boxX--;
				displayGrid();
			}
			break;
		}
		case 3: { // Up
			if (boxY > 0) {
				highlightedGrid[boxY][boxX] -= 4;
				highlightedGrid[boxY + 1][boxX] -= 4;
				highlightedGrid[boxY][boxX + 1] -= 4;
				highlightedGrid[boxY + 1][boxX + 1] -= 4;
				boxY--;
				displayGrid();
			}
			break;
		}
		case 4: // Down
			if (boxY < 5) {
				highlightedGrid[boxY][boxX] -= 4;
				highlightedGrid[boxY + 1][boxX] -= 4;
				highlightedGrid[boxY][boxX + 1] -= 4;
				highlightedGrid[boxY + 1][boxX + 1] -= 4;
				boxY++;
				displayGrid();
			}
			break;
		}
		displayGrid();
	}

	public static void checkMoves() {
		if (moves >= maxMoves) {
			Robot.setTilesCleared(Robot.getTilesCleared()+tilesCleared);
			Robot.setRedTilesCleared(Robot.getRedTilesCleared() + redCleared);
			Robot.setBlueTilesCleared(Robot.getBlueTilesCleared() + blueCleared);
			Robot.setGreenTilesCleared(Robot.getGreenTilesCleared()
					+ greenCleared);
			Robot.setYellowTilesCleared(Robot.getYellowTilesCleared()
					+ yellowCleared);
			Robot.setMatches(Robot.getMatches() + matchesMade);
			if (Robot.getBestCascade() < bestCascade) {
				Robot.setBestCascade(bestCascade);
			}
			Display.changeMode();

		}
	}

	public static void displayGrid() {

		for (int i = 0; i < 7; i++)
			for (int k = 0; k < 10; k++)
				highlightedGrid[i][k] = puzzleGrid[i][k];
		// highlightedGrid = puzzleGrid;
		if (highlightedGrid[boxY][boxX] > 4) {

		} else {
			highlightedGrid[boxY][boxX] += 4;
			highlightedGrid[boxY + 1][boxX] += 4;
			highlightedGrid[boxY][boxX + 1] += 4;
			highlightedGrid[boxY + 1][boxX + 1] += 4;
		}

		Display.updatePuzzleScreen(highlightedGrid);
	}
}
