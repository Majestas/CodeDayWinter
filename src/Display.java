import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.KeyEvent;
import com.sun.prism.Image;

public class Display extends JPanel {

	// main stuff
	private static JFrame mainFrame;
	private static JMenuBar menuBar;
	private static boolean puzzleActive = true;
	private static boolean actionActive = false;
	private static int level = 1;
	
	public static BufferedImage bufferedImage;

	// stats panel
	private static JPanel statsPanel;
	private static JPanel statsNumberPanel;

	private static JLabel levelLabel;
	private static JLabel robotNameLabel;

	public static JLabel healthLabel;
	public static JLabel speedLabel;
	public static JLabel defenseLabel;
	public static JLabel attackLabel;
	public static JLabel moveLabel;
	
	public static JLabel moveImageLabel;
	
	// game panle
	private static JPanel gamePanel;
	// private static JPanel actionPanel;

	// Puzzle class
	private static JPanel puzzlePanel;
	private static JPanel puzzleBackgroundPanel;

	// actionPanel
	private static JPanel actionPanel;
	private static JPanel actionBackgroundPanel;
	
	//Stats
	private static JPanel dataPanel;
	private static JPanel dataBackgroundPanel;

	public static void initDisplay() throws IOException {
		initMainFrame();
		initMenuBar();
		initStatsPanel();
		initGamePanel();
		initPuzzleScreen();
		initActionScreen();
		updateActionScreen();
		// updatePuzzleScreen();
		Puzzle.runPuzzle(5+(level*5));
		// changeMode();
	}

	private static void initMainFrame() {

		mainFrame = new JFrame("Robot Resuce");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setPreferredSize(new Dimension(1280, 720));
		mainFrame.setVisible(true);
		mainFrame.getContentPane().setLayout(new BorderLayout());
		mainFrame.pack();
		mainFrame.setResizable(true);
		mainFrame.setVisible(true);
	}

	private static void initMenuBar() {

		// System.setProperty("apple.laf.useScreenMenuBar", "true");

		menuBar = new JMenuBar();

		/// File////////
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

		JMenuItem SaveOption = new JMenuItem("Save");
		SaveOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}

		});
		fileMenu.add(SaveOption);

		JMenuItem aboutOption = new JMenuItem("About the Game");
		aboutOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}

		});
		fileMenu.add(aboutOption);

		/// Game////////
		JMenu GameMenu = new JMenu("Game");
		GameMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(GameMenu);

		JMenuItem pauseOption = new JMenuItem("Pause");
		aboutOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}

		});
		GameMenu.add(pauseOption);

		JMenuItem regenerateOption = new JMenuItem("Retest");
		regenerateOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				changeMode();
			}

		});
		GameMenu.add(regenerateOption);

		JMenu StatsMenu = new JMenu("Stats");
		StatsMenu.setMnemonic(KeyEvent.VK_T);
		menuBar.add(StatsMenu);
		JMenuItem statsOption = new JMenuItem("View Stats");
		statsOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				displayStats();
			}
		});
		mainFrame.setJMenuBar(menuBar);
		mainFrame.setVisible(true);
	}

	private static void initStatsPanel() throws IOException {
		statsPanel = new JPanel(new GridBagLayout());
		// statsPanel.setSize(80,720);
		statsPanel.setPreferredSize(new Dimension(280, 720));
		statsPanel.setBackground(new Color(200, 200, 200));
		statsPanel.setBorder(new EmptyBorder(5, 10, 5, 5));
		mainFrame.add(statsPanel, BorderLayout.WEST);

		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.ipadx = 10;
		c.ipady = 50;
		c.fill = GridBagConstraints.HORIZONTAL;
		int statsImageSize = 50;
		int fontSize = 24;

		robotNameLabel = new JLabel("ROBOT");
		robotNameLabel.setFont(new Font("futura", Font.PLAIN, fontSize));
		c.gridx = 0;
		c.gridy = 0;
		statsPanel.add(robotNameLabel, c);

		levelLabel = new JLabel("Level: 1");
		levelLabel.setFont(new Font("futura", Font.PLAIN, fontSize));
		c.gridx = 0;
		c.gridy = 1;
		statsPanel.add(levelLabel, c);

		////
		healthLabel = new JLabel("Health: 000", JLabel.LEADING);
		healthLabel.setFont(new Font("futura", Font.PLAIN, fontSize));
		c.gridx = 1;
		c.gridy = 2;
		statsPanel.add(healthLabel, c);

		JLabel heartImageLabel = createImageLabel("src/stats/health.png", statsImageSize, statsImageSize);
		c.gridx = 0;
		c.gridy = 2;
		statsPanel.add(heartImageLabel, c);
		///////

		///
		attackLabel = new JLabel("Attack: 000", JLabel.LEADING);
		attackLabel.setFont(new Font("futura", Font.PLAIN, fontSize));
		c.gridx = 1;
		c.gridy = 3;
		statsPanel.add(attackLabel, c);

		JLabel attackImageLabel = createImageLabel("src/stats/sword.png", statsImageSize, statsImageSize);
		c.gridx = 0;
		c.gridy = 3;
		statsPanel.add(attackImageLabel, c);
		///

		//
		defenseLabel = new JLabel("Defense: 000", JLabel.LEADING);
		defenseLabel.setFont(new Font("futura", Font.PLAIN, fontSize));
		c.gridx = 1;
		c.gridy = 4;
		statsPanel.add(defenseLabel, c);

		JLabel defenseImageLabel = createImageLabel("src/stats/shield.png", statsImageSize, statsImageSize);
		c.gridx = 0;
		c.gridy = 4;
		statsPanel.add(defenseImageLabel, c);
		//

		//
		speedLabel = new JLabel("Speed: 000", JLabel.LEADING);
		speedLabel.setFont(new Font("futura", Font.PLAIN, fontSize));
		c.gridx = 1;
		c.gridy = 5;
		statsPanel.add(speedLabel, c);

		JLabel speedImageLabel = createImageLabel("src/stats/speed.png", statsImageSize, statsImageSize);
		c.gridx = 0;
		c.gridy = 5;
		statsPanel.add(speedImageLabel, c);
		//

		//
		moveLabel = new JLabel("Moves: 000", JLabel.LEADING);
		moveLabel.setFont(new Font("futura", Font.PLAIN, fontSize));
		c.gridx = 1;
		c.gridy = 6;
		statsPanel.add(moveLabel, c);
		if(puzzleActive) {
		moveImageLabel = createImageLabel("src/stats/moves.png", statsImageSize, statsImageSize);
		c.gridx = 0;
		c.gridy = 6;
		statsPanel.add(moveImageLabel, c);
		}

	}

	public static void initGamePanel() {
		gamePanel = new JPanel(new BorderLayout());
		// gamePanel.setBackground(Color.GREEN);
		gamePanel.setPreferredSize(new Dimension(1000, 720));
		mainFrame.add(gamePanel, BorderLayout.CENTER);

		KeyListener keyListeners = new KeyListener() {
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyTyped(java.awt.event.KeyEvent e) {

			}

			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {

				if (actionActive) {

					Action.move(e);
				}

				else if (puzzleActive) {
					switch (e.getKeyCode()) {

					case (KeyEvent.VK_RIGHT): {

						Puzzle.moveBox(1);
						break;
					}
					case (KeyEvent.VK_LEFT): {

						Puzzle.moveBox(2);
						break;
					}

					case (KeyEvent.VK_UP): {
						Puzzle.moveBox(3);
						break;
					}
					case (KeyEvent.VK_DOWN): {
						Puzzle.moveBox(4);
						break;
					}

					case (KeyEvent.VK_D): {
						Puzzle.rotate(1);
						break;
					}
					case (KeyEvent.VK_W): {
						Puzzle.rotate(3);
						break;
					}
					case (KeyEvent.VK_A): {
						Puzzle.rotate(2);
						break;
					}
					case (KeyEvent.VK_S): {

						Puzzle.rotate(4);
						break;
					}

					}
				}

			}

			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {

			}
		};
		mainFrame.addKeyListener(keyListeners);
	}

	public static void updateGameScreen() {

	}

	public static void hideGameScreen() {

	}

	public static void initPuzzleScreen() {
		puzzlePanel = new JPanel();
		puzzlePanel.setPreferredSize(new Dimension(1000, 720));
		puzzlePanel.setBackground(Color.BLACK);

		gamePanel.add(puzzlePanel, BorderLayout.CENTER);
		mainFrame.add(gamePanel, BorderLayout.CENTER);
	}

	public static void updatePuzzleScreen(int[][] puzzleGrid) {

		ArrayList<Integer> gearArray = interpret2dArray(puzzleGrid);

		
		 /*puzzleBackgroundPanel = new JPanel();
		  puzzleBackgroundPanel.setPreferredSize(new Dimension(1000,720));
		  
		  puzzleBackgroundPanel.add(createImageLabel("src/action/factory.jpg",
		  1000,720));
		  puzzlePanel.add(puzzleBackgroundPanel,BorderLayout.CENTER);
		  puzzlePanel.setComponentZOrder(puzzleBackgroundPanel, 0);
		  puzzlePanel.add(puzzleBackgroundPanel,BorderLayout.CENTER);
		  puzzlePanel.setComponentZOrder(puzzleBackgroundPanel, 1);*/
		 

		puzzlePanel.removeAll();
		puzzlePanel.revalidate();

		int normalHeight = 0;
		int highlightedHeight = 0;
		JLayeredPane tempLP = new JLayeredPane();
		for (int k = 0; k < gearArray.size(); k++) {
			JLabel tempLabel; 
			
			switch (gearArray.get(k)) {

			
			case 0: {
				tempLabel = createImageLabel("src/action/blankGear.png");
				puzzlePanel.add(tempLabel, normalHeight);

				break;
			}
			case 1: {
				 tempLabel = createImageLabel("src/action/healthGear.png");
				break;
			}
			case 2: {
				tempLabel = createImageLabel("src/action/defenseGear.png");
				break;
			}
			case 3: {
				tempLabel = createImageLabel("src/action/attackGear.png");
				break;
			}
			case 4: {
				tempLabel = createImageLabel("src/action/speedGear.png");
				break;
			}
			case 5: {
				tempLabel = createImageLabel("src/action/healthGearHighlighted.png");
				break;
			}
			case 6: {
				tempLabel = createImageLabel("src/action/defenseGearHighlighted.png");
				break;
			}
			case 7: {
				tempLabel = createImageLabel("src/action/attackGearHighlighted.png");
				break;
			}
			case 8: {
				tempLabel = createImageLabel("src/action/speedGearHighlighted.png");
				break;
			}
			default: {
				tempLabel = createImageLabel("src/action/factory.jpg");
				break;
			}
			}
			
			puzzlePanel.add(tempLabel);
			
		}
		
		JLabel temp17 = createImageLabel("src/action/platform.png");
		temp17.setLocation(500, 700);
		actionPanel.add(temp17);

		gamePanel.add(puzzlePanel, BorderLayout.CENTER);
		mainFrame.add(gamePanel, BorderLayout.CENTER);

	}

	public static void hidePuzzelScreen() {

	}

	public static void initActionScreen() throws IOException {
		
		
		
		actionPanel = new JPanel(null);
		actionPanel.setPreferredSize(new Dimension(1000, 720));
		actionPanel.setBackground(Color.BLUE);

		
		
		gamePanel.add(actionPanel, BorderLayout.CENTER);
		mainFrame.add(gamePanel, BorderLayout.CENTER);
      		
		//updateActionScreen();
    }
		
		
		
		


	public static void updateActionScreen() {

		//JLabel temp8 = createImageLabel("src/action/factory.jpg");
		//temp8.setLocation(500, 200);
		//actionPanel.add(temp8);
		
		
		int [][] platformsArray = new int[][] {{200, 500, 50, 30}, {100,300,50,30}};
		
		for (int i = 0; i < platformsArray.length; i ++){

			
				//JLabel tempLabel = createImageLabel("src/action/platform.png",platformsArray[i][2], platformsArray[i][3] );
				//tempLabel.setLocation(500,600);
				//actionPanel.add(tempLabel);
			
		}
		
		
		puzzlePanel.removeAll();
		actionPanel.revalidate();
		
		
		
		JLabel temp9 = createImageLabel("src/action/platform.png");
		//temp9.setLocation(500, 400);
		actionPanel.add(temp9);
		
		
		actionPanel.revalidate();
		gamePanel.add(actionPanel, BorderLayout.CENTER);
		mainFrame.add(gamePanel, BorderLayout.CENTER);
	}

	public static ArrayList<Integer> interpret2dArray(int[][] puzzleGrid) {
		ArrayList<Integer> tempArray = new ArrayList<Integer>();

		for (int i = 0; i < puzzleGrid.length; i++) {
			for (int k = 0; k < puzzleGrid[i].length; k++) {
				tempArray.add(puzzleGrid[i][k]);
			}
		}

		return tempArray;
	}

	public static JLabel createImageLabel(String filePath, int width, int height) {

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e1) {
			System.out.println("Someone Fucked up");
		}

		JLabel imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(width, height, 0)));

		return imageLabel;

	}

	
	public static JLabel createImageLabel(String filePath) {

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e1) {
			System.out.println("Someone Fucked up");
		}

		JLabel imageLabel = 
				new JLabel(
						new ImageIcon(
								image));
		//imageLabel.setBounds(0, 0, 100, 100);

		return imageLabel;

	}
	

	public static void changeMode() {
		level += 1;
		levelLabel.setText("Level: " + level);

		if (actionActive) {
			actionActive = false;
			puzzleActive = true;
			dataPanel.setVisible(false);
			actionPanel.setVisible(false);
			actionPanel.removeAll();
			
			moveLabel.setVisible(true);
			moveImageLabel.setVisible(true);
			puzzlePanel.setVisible(true);
			dataPanel.setVisible(false);
			Puzzle.runPuzzle(5+(5*level));
			// gamePanel.revalidate();
			// initPuzzleScreen();
			gamePanel.revalidate();

		} else if (puzzleActive) {
			actionActive = true;
			puzzleActive = false;
			puzzlePanel.setVisible(false);
			puzzlePanel.removeAll();
			gamePanel.revalidate();
			
			actionPanel.setVisible(true);

			//updateActionScreen();

			updateActionScreen();

			gamePanel.revalidate();
			

			moveLabel.setVisible(false);
			moveImageLabel.setVisible(false);

		}

	}
	public static void displayStats() {
		actionPanel.setVisible(false);
		actionPanel.removeAll();
		puzzlePanel.setVisible(false);
		puzzlePanel.removeAll();
		moveLabel.setVisible(false);
		moveImageLabel.setVisible(false);
		dataPanel.setVisible(true);
		dataPanel = new JPanel(new GridBagLayout());
		dataPanel.setPreferredSize(new Dimension(1000, 720));
		dataPanel.setBackground(Color.RED);
		mainFrame.add(gamePanel, BorderLayout.CENTER);
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.ipadx = 10;
		c.ipady = 50;
		c.fill = GridBagConstraints.HORIZONTAL;
		int fontsize = 24;
		
	    JLabel healthStatLabel = new JLabel("Health: "+Robot.getHealth());
		healthStatLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 1;
		dataPanel.add(healthStatLabel, c);
		
		JLabel attackStatLabel = new JLabel("Attack: "+Robot.getAttack());
		attackStatLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 2;
		dataPanel.add(attackStatLabel, c);
		
		JLabel defenseStatLabel = new JLabel("Defense: "+Robot.getDefense());
		defenseStatLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 3;
		dataPanel.add(defenseStatLabel, c);
		
		JLabel speedStatLabel = new JLabel("Max Speed: "+Robot.getMaxSpeed());
		speedStatLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 4;
		dataPanel.add(speedStatLabel, c);
		
		JLabel killsLabel = new JLabel("Attack: "+Robot.getKills());
		killsLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 5;
		dataPanel.add(killsLabel, c);
		
		JLabel matchesLabel = new JLabel("Total Matches Made: "+Robot.getTotalMatches());
		matchesLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 6;
		dataPanel.add(matchesLabel, c);
		
		JLabel redLabel = new JLabel("Red Tiles Cleared: "+Robot.getRedTilesCleared());
		redLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 7;
		dataPanel.add(redLabel, c);
		
		JLabel blueLabel = new JLabel("Blue Tiles Cleared: "+Robot.getBlueTilesCleared());
		blueLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 8;
		dataPanel.add(blueLabel, c);
		
		JLabel greenLabel = new JLabel("Green Tiles Cleared: "+Robot.getGreenTilesCleared());
		greenLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 9;
		dataPanel.add(greenLabel, c);
		
		JLabel yellowLabel = new JLabel("Yellow Tiles Cleared: "+Robot.getYellowTilesCleared());
		yellowLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 10;
		dataPanel.add(yellowLabel, c);
		
		JLabel tilesLabel = new JLabel("Total Tiles Cleared: "+Robot.getTilesCleared());
		tilesLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 11;
		dataPanel.add(tilesLabel, c);
		
		JLabel cascadeLabel = new JLabel("Best Cascade: "+Robot.getBestCascade());
		cascadeLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 12;
		dataPanel.add(cascadeLabel, c);
		
		JLabel shotsFiredLabel = new JLabel("Shots Fired: "+Robot.getShotsFired());
		shotsFiredLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 13;
		dataPanel.add(shotsFiredLabel, c);
		
		JLabel shotsHitLabel = new JLabel("Shots Hit: "+Robot.getShotsHit());
		shotsHitLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 14;
		dataPanel.add(shotsHitLabel, c);
		
		JLabel shotsTakenLabel = new JLabel("Shots Taken: "+Robot.getShotsFired());
		shotsFiredLabel.setFont(new Font("futura", Font.PLAIN, fontsize));
		c.gridx = 0;
		c.gridy = 15;
		dataPanel.add(shotsTakenLabel, c);
		
		gamePanel.revalidate();
	}
	
}