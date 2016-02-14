
public class Puzzle {
	//Variables for puzzle
	private int[][] puzzleGrid = new int[][]{
			  { 0, 0, 0, 0, 0, 0},
			  { 0, 0, 0, 0, 0, 0},
			  { 0, 0, 0, 0, 0, 0},
			  { 0, 0, 0, 0, 0, 0},
			  { 0, 0, 0, 0, 0, 0},
			  { 0, 0, 0, 0, 0, 0}
			};
	private int healthAdded = 0;
	private int defenseAdded = 0;
	private int attackAdded = 0;
	private int speedAdded = 0;
	private int moves = 0;
	private int maxMoves = 0;
	private int boxX = 0;
	private int boxY = 0;
	
	//Stats variables
	private int tilesCleared = 0;
	private int matchesMade = 0;
	private int redCleared = 0;
	private int yellowCleared = 0;
	private int greenCleared = 0;
	private int blueCleared = 0;
	
	//Puzzle methods
	private void checkMatches() {
		boolean deletedTiles = false;
		for(int i=0; i<6; i++) {
			for(int j=0; j<2; j++) {
				if((puzzleGrid[i][j] == puzzleGrid[i][j+1]) && (puzzleGrid[i][j] == puzzleGrid[i][j+2]) && (puzzleGrid[i][j] == puzzleGrid[i][j+3]) && (puzzleGrid[i][j] == puzzleGrid[i][j+4])) {
					switch (puzzleGrid[i][j]) {
						case 1:
							healthAdded+=5;
							redCleared+=5;
							break;
						case 2:
							defenseAdded+=5;
							yellowCleared+=5;
							break;
						case 3:
							attackAdded+=5;
							greenCleared+=5;
							break;
						case 4:
							speedAdded+=5;
							blueCleared+=5;
							break;
						default:
							break;
					}
				puzzleGrid[i][j] = 0;
				puzzleGrid[i][j+1] = 0;
				puzzleGrid[i][j+2] = 0;
				puzzleGrid[i][j+3] = 0;
				puzzleGrid[i][j+4] = 0;
				matchesMade++;
				tilesCleared+=5;
				deletedTiles = true;
				}
			}
		}
		for(int i=0;i<2;i++) {
			for(int j=0;j<6;j++) {
				if((puzzleGrid[i][j] == puzzleGrid[i+1][j]) && (puzzleGrid[i][j] == puzzleGrid[i+2][j]) && (puzzleGrid[i][j] == puzzleGrid[i+3][j]) && (puzzleGrid[i][j] == puzzleGrid[i+4][j])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						healthAdded+=5;
						redCleared+=5;
						break;
					case 2:
						defenseAdded+=5;
						yellowCleared+=5;
						break;
					case 3:
						attackAdded+=5;
						greenCleared+=5;
						break;
					case 4:
						speedAdded+=5;
						blueCleared+=5;
						break;
					default:
						break;
					}
					puzzleGrid[i][j] = 0;
					puzzleGrid[i+1][j] = 0;
					puzzleGrid[i+2][j] = 0;
					puzzleGrid[i+3][j] = 0;
					puzzleGrid[i+4][j] = 0;
					matchesMade++;
					tilesCleared+=5;
					deletedTiles = true;
				}
			}
		}
		for(int i=0; i<6; i++) {
			for(int j=0; j<3; j++) {
				if((puzzleGrid[i][j] == puzzleGrid[i][j+1]) && (puzzleGrid[i][j] == puzzleGrid[i][j+2]) && (puzzleGrid[i][j] == puzzleGrid[i][j+3])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						healthAdded+=4;
						redCleared+=4;
						break;
					case 2:
						defenseAdded+=4;
						yellowCleared+=4;
						break;
					case 3:
						attackAdded+=4;
						greenCleared+=4;
						break;
					case 4:
						speedAdded+=4;
						blueCleared+=4;
						break;
					default:
						break;
					}
				puzzleGrid[i][j] = 0;
				puzzleGrid[i][j+1] = 0;
				puzzleGrid[i][j+2] = 0;
				puzzleGrid[i][j+3] = 0;
				matchesMade++;
				tilesCleared+=4;
				deletedTiles = true;
				}
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<6;j++) {
				if((puzzleGrid[i][j] == puzzleGrid[i+1][j]) && (puzzleGrid[i][j] == puzzleGrid[i+2][j]) && (puzzleGrid[i][j] == puzzleGrid[i+3][j])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						healthAdded+=4;
						redCleared+=4;
						break;
					case 2:
						defenseAdded+=4;
						yellowCleared+=4;
						break;
					case 3:
						attackAdded+=4;
						greenCleared+=4;
						break;
					case 4:
						speedAdded+=4;
						blueCleared+=4;
						break;
					default:
						break;
					}
					puzzleGrid[i][j] = 0;
					puzzleGrid[i+1][j] = 0;
					puzzleGrid[i+2][j] = 0;
					puzzleGrid[i+3][j] = 0;
					matchesMade++;
					tilesCleared+=4;
					deletedTiles = true;
				}
			}
		}
		for(int i=0; i<6; i++) {
			for(int j=0; j<4; j++) {
				if((puzzleGrid[i][j] == puzzleGrid[i][j+1]) && (puzzleGrid[i][j] == puzzleGrid[i][j+2])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						healthAdded+=3;
						redCleared+=3;
						break;
					case 2:
						defenseAdded+=3;
						yellowCleared+=3;
						break;
					case 3:
						attackAdded+=3;
						greenCleared+=3;
						break;
					case 4:
						speedAdded+=3;
						blueCleared+=3;
						break;
					default:
						break;
					}
				puzzleGrid[i][j] = 0;
				puzzleGrid[i][j+1] = 0;
				puzzleGrid[i][j+2] = 0;
				matchesMade++;
				tilesCleared+=3;
				deletedTiles = true;
				}
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<6;j++) {
				if((puzzleGrid[i][j] == puzzleGrid[i+1][j]) && (puzzleGrid[i][j] == puzzleGrid[i+2][j])) {
					switch (puzzleGrid[i][j]) {
					case 1:
						healthAdded+=3;
						redCleared+=3;
						break;
					case 2:
						defenseAdded+=3;
						yellowCleared+=3;
						break;
					case 3:
						attackAdded+=3;
						greenCleared+=3;
						break;
					case 4:
						speedAdded+=3;
						blueCleared+=3;
						break;
					default:
						break;
					}
					puzzleGrid[i][j] = 0;
					puzzleGrid[i+1][j] = 0;
					puzzleGrid[i+2][j] = 0;
					matchesMade++;
					tilesCleared+=3;
					deletedTiles = true;
				}
			}
		}
		if(deletedTiles) {
			dropTiles();
		}
	}
	private void createGrid() {
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				puzzleGrid[i][j] = (int)(Math.random()*4)+1;
			}
		}
	}
	private void dropTiles() {
		boolean zeros = true;
		do {
			for(int i=5;i>0;i--) {
				for(int j=0;j<6;j++) {
					if(puzzleGrid[i][j]==0) {
						puzzleGrid[i][j] = puzzleGrid[i-1][j];
						puzzleGrid[i-1][j] = 0;
					}
				}
			}
			for(int j=0;j<6;j++) {
				if(puzzleGrid[0][j] == 0) {
					puzzleGrid[0][j] = (int)(Math.random()*4)+1;
				}
			}
			zeros = false;
			for(int i =0; i<6;i++) {
				for(int j=0;j<6;j++) {
					if(puzzleGrid[i][j]==0) {
						zeros = true;
					}
				}
			}
		} while(zeros);
	}
	public void RunPuzzle(int move) {
		moves = 0;
		maxMoves = move;
		createGrid();
	}
	
}