public class Puzzle {
	// Variables for puzzle
	private static int[][] puzzleGrid = new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	private static int[][] highlightedGrid = new int[7][10];
	private static int healthAdded = 0;
	private static int defenseAdded = 0;
	private static int attackAdded = 0;
	private static int speedAdded = 0;
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

	// Puzzle methods
	private static void checkMatches() {
		System.out.println("Starting checking!!!");
		boolean deletedTiles = false;
		int[][] match = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if ((puzzleGrid[i][j] == puzzleGrid[i][j + 1])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 2])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 3])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 4])
						&& (puzzleGrid[i][j] == puzzleGrid[i][j + 5])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						healthAdded += 6;
						redCleared += 6;
						break;
					case 2:
						defenseAdded += 6;
						greenCleared += 6;
						break;
					case 3:
						attackAdded += 6;
						yellowCleared += 6;
						break;
					case 4:
						speedAdded += 6;
						blueCleared += 6;
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
						healthAdded += 6;
						redCleared += 6;
						break;
					case 2:
						defenseAdded += 6;
						greenCleared += 6;
						break;
					case 3:
						attackAdded += 6;
						yellowCleared += 6;
						break;
					case 4:
						speedAdded += 6;
						blueCleared += 6;
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
						healthAdded += 5;
						redCleared += 5;
						break;
					case 2:
						defenseAdded += 5;
						greenCleared += 5;
						break;
					case 3:
						attackAdded += 5;
						yellowCleared += 5;
						break;
					case 4:
						speedAdded += 5;
						blueCleared += 5;
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
						healthAdded += 5;
						redCleared += 5;
						break;
					case 2:
						defenseAdded += 5;
						greenCleared += 5;
						break;
					case 3:
						attackAdded += 5;
						yellowCleared += 5;
						break;
					case 4:
						speedAdded += 5;
						blueCleared += 5;
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
						healthAdded += 4;
						redCleared += 4;
						break;
					case 2:
						defenseAdded += 4;
						greenCleared += 4;
						break;
					case 3:
						attackAdded += 4;
						yellowCleared += 4;
						break;
					case 4:
						speedAdded += 4;
						blueCleared += 4;
						break;
					default:
						break;
					}
					match[i][j] = 1;
					match[i][j + 1] = 1;
					match[i][j + 2] = 1;
					match[i][j + 3] = 1;
					matchesMade++;
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
						healthAdded += 4;
						redCleared += 4;
						break;
					case 2:
						defenseAdded += 4;
						greenCleared += 4;
						break;
					case 3:
						attackAdded += 4;
						yellowCleared += 4;
						break;
					case 4:
						speedAdded += 4;
						blueCleared +=4;
						break;
					default:
						break;
					}
					match[i][j] = 1;
					match[i + 1][j] = 1;
					match[i + 2][j] = 1;
					match[i + 3][j] = 1;
					matchesMade++;
					deletedTiles = true;
				}
			}
		}
		for(int i=0;i<7;i++) {
			for(int k=0;k<10;k++) {
				System.out.print(match[i][k]);
			}
			System.out.println();
		}
		for(int i=0;i<7;i++) {
			for(int k=0;k<10;k++) {
				if(match[i][k]==1) {
					tilesCleared++;
					puzzleGrid[i][k]=0;
					deletedTiles = true;
				}
			}
		}
		if(deletedTiles) {
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
					puzzleGrid[i][k] = (int) (Math.random() * 4) + 2;
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
		case 3: // Flip Vertically
			temp = puzzleGrid[boxY][boxX];
			puzzleGrid[boxY][boxX] = puzzleGrid[boxY + 1][boxX];
			puzzleGrid[boxY + 1][boxX] = temp;
			temp = puzzleGrid[boxY][boxX + 1];
			puzzleGrid[boxY][boxX + 1] = puzzleGrid[boxY + 1][boxX + 1];
			puzzleGrid[boxY + 1][boxX + 1] = temp;
		case 4: // Flip Horizontally
			temp = puzzleGrid[boxY][boxX];
			puzzleGrid[boxY][boxX] = puzzleGrid[boxY][boxX + 1];
			puzzleGrid[boxY][boxX + 1] = temp;
			temp = puzzleGrid[boxY + 1][boxX];
			puzzleGrid[boxY + 1][boxX] = puzzleGrid[boxY + 1][boxX + 1];
			puzzleGrid[boxY + 1][boxX + 1] = temp;
		}
		displayGrid();
		moves++;
		checkMoves();
		checkMatches();
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
		case 2:{ // Left
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
		case 3:{ // Up
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
		System.out.println(boxX + "\n" + boxY);
		//displayGrid();
	}

	public static void checkMoves() {
		if (moves == maxMoves) {
			// Display.setMode();
		}
	}

	public static void displayGrid() {
		
		System.out.println("updating grid");
		highlightedGrid = puzzleGrid;
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