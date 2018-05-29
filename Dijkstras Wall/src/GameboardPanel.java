import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameboardPanel extends JLayeredPane implements Runnable{
	private JPanel upperPanel;
	private Color innerColor = Color.LIGHT_GRAY;
	private Color outerColor = Color.LIGHT_GRAY;
	private Graph board;
	private Node start, end;
	private Stack path;
	private Node current;
	private JButton startButton;
	private JButton toggleSpeed;
	private int speed;
	private SpanningTree s;
	private Thread t;
	private Thread timeT;
	private boolean isRunning;
	private static GameboardPanel instance;
	int state;
	private String name;
	private File soundOne;
	private File soundThree;
	private File soundFour;
	private JLabel title;
	private JButton ok;
	private JFrame f;
	private JLabel speedLabel;
	private int timeElapsed;
	private JLabel timeLabel;
	private BasicTimer timer;
	private JLabel l;
	private JLabel l2;
	private JLabel author;
	private JButton scores;
	private JPanel newHighScore;
	JTextArea ta;
	private GameboardPanel(){
		this.setSize(new Dimension(1200,800));
		this.setLayout(new FlowLayout());
		this.setBackground(Color.BLACK);
		timeElapsed = 0;
		soundOne = new File("res/sound116.wav");
		soundThree = new File("res/sound73.wav");
		soundFour = new File("res/sound104.wav");
		speed = 500;
		l = new JLabel();
		l.setFont(new Font("Times New Roman", Font.BOLD, 18));
		title = new JLabel("_______Dijkstra's Wall_______");
		title.setFont(new Font("Times New Roman", Font.BOLD, 82));
		board = new Graph();
		isRunning = false;
		upperPanel = new JPanel();
		upperPanel.setPreferredSize(new Dimension(1200,180));
		upperPanel.setBackground(innerColor);
		upperPanel.add(title);
		startButton = new JButton("Start");
		startButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		startButton.addActionListener(new BoardListener());
		upperPanel.add(startButton);
		timeLabel = new JLabel("| Time Elapsed "+timeElapsed+" Seconds. |");
		timeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		upperPanel.add(timeLabel);
		toggleSpeed = new JButton("Toggle Speed");
		toggleSpeed.setFont(new Font("Times New Roman", Font.BOLD, 24));
		toggleSpeed.addActionListener(new BoardListener());
		upperPanel.add(toggleSpeed);
		speedLabel = new JLabel("| Normal Speed |");
		speedLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		upperPanel.add(speedLabel);
		scores = new JButton("High Scores");
		scores.addActionListener(new BoardListener());
		scores.setFont(new Font("Times New Roman", Font.BOLD, 24));
		upperPanel.add(scores);
		author = new JLabel("|      By Jamison Weber |");
		author.setFont(new Font("Times New Roman", Font.BOLD, 24));
		upperPanel.add(author);
		this.add(upperPanel);
		for(int i = 1; i <= 264; i++){
			this.add(board.addVertex('n', i));
		}
		start = board.addVertex('s', 265);
		start.changeState(2);
		this.add(start);
		
		for(int i = 266; i <= 296; i++){
			this.add(board.addVertex('n', i));
		}
		end = board.addVertex('e', 297);
		end.changeState(3);
		this.add(end);
		for(int i = 298; i <= 528; i++){
			this.add(board.addVertex('n', i));
		}
		//Add edges
		int rowLength = 33;
		int j = 1;
		for(int i = 1; i <= 8; i++){
		    while(j <= rowLength -1){
				board.addBiEdge(j, 'n', j+1, 'n', 1);
				j++;
			}
		    j++;
		    rowLength += 33;
		}
		board.addBiEdge(265,'s',266,'n',1);
		board.addBiEdge(266, 'n', 267, 'n', 1);
		board.addBiEdge(267, 'n', 268, 'n', 1);
		board.addBiEdge(268, 'n', 269, 'n', 1);
		board.addBiEdge(269, 'n', 270, 'n', 1);
		board.addBiEdge(270, 'n', 271, 'n', 1);
		board.addBiEdge(271, 'n', 272, 'n', 1);
		board.addBiEdge(272, 'n', 273, 'n', 1);
		board.addBiEdge(273, 'n', 274, 'n', 1);
		board.addBiEdge(274, 'n', 275, 'n', 1);
		board.addBiEdge(275, 'n', 276, 'n', 1);
		board.addBiEdge(276, 'n', 277, 'n', 1);
		board.addBiEdge(277, 'n', 278, 'n', 1);
		board.addBiEdge(278, 'n', 279, 'n', 1);
		board.addBiEdge(279, 'n', 280, 'n', 1);
		board.addBiEdge(280, 'n', 281, 'n', 1);
		board.addBiEdge(281, 'n', 282, 'n', 1);
		board.addBiEdge(282, 'n', 283, 'n', 1);
		board.addBiEdge(283, 'n', 284, 'n', 1);
		board.addBiEdge(284, 'n', 285, 'n', 1);
		board.addBiEdge(285, 'n', 286, 'n', 1);
		board.addBiEdge(286, 'n', 287, 'n', 1);
		board.addBiEdge(287, 'n', 288, 'n', 1);
		board.addBiEdge(288, 'n', 289, 'n', 1);
		board.addBiEdge(289, 'n', 290, 'n', 1);
		board.addBiEdge(290, 'n', 291, 'n', 1);
		board.addBiEdge(291, 'n', 292, 'n', 1);
		board.addBiEdge(292, 'n', 293, 'n', 1);
		board.addBiEdge(293, 'n', 294, 'n', 1);
		board.addBiEdge(294, 'n', 295, 'n', 1);
		board.addBiEdge(295, 'n', 296, 'n', 1);
		board.addBiEdge(296, 'n', 297, 'e', 1);
		j = 298;
		rowLength += 33;
		for(int i = 10; i <= 16; i++){
		    while(j <= rowLength -1){
				board.addBiEdge(j, 'n', j+1, 'n', 1);
				j++;
			}
		    j++;
		    rowLength += 33;
		}
		board.addBiEdge(1, 'n', 34, 'n', 1);
		board.addBiEdge(34, 'n', 67, 'n', 1);
		board.addBiEdge(67, 'n', 100, 'n', 1);
		board.addBiEdge(100, 'n', 133, 'n', 1);
		board.addBiEdge(133, 'n', 166, 'n', 1);
		board.addBiEdge(166, 'n', 199, 'n', 1);
		board.addBiEdge(199, 'n', 232, 'n', 1);
		board.addBiEdge(232, 'n', 265, 's', 1);
		board.addBiEdge(265, 's', 298, 'n', 1);
		board.addBiEdge(298, 'n', 331, 'n', 1);
		board.addBiEdge(331, 'n', 364, 'n', 1);
		board.addBiEdge(364, 'n', 397, 'n', 1);
		board.addBiEdge(397, 'n', 430, 'n', 1);
		board.addBiEdge(430, 'n', 463, 'n', 1);
		board.addBiEdge(463, 'n', 496, 'n', 1);
		for(int i = 1; i <= 31; i++){
			board.addBiEdge(1+i, 'n', 34+i, 'n', 1);
			board.addBiEdge(34+i, 'n', 67+i, 'n', 1);
			board.addBiEdge(67+i, 'n', 100+i, 'n', 1);
			board.addBiEdge(100+i, 'n', 133+i, 'n', 1);
			board.addBiEdge(133+i, 'n', 166+i, 'n', 1);
			board.addBiEdge(166+i, 'n', 199+i, 'n', 1);
			board.addBiEdge(199+i, 'n', 232+i, 'n', 1);
			board.addBiEdge(232+i, 'n', 265+i, 'n', 1);
			board.addBiEdge(265+i, 'n', 298+i, 'n', 1);
			board.addBiEdge(298+i, 'n', 331+i, 'n', 1);
			board.addBiEdge(331+i, 'n', 364+i, 'n', 1);
			board.addBiEdge(364+i, 'n', 397+i, 'n', 1);
			board.addBiEdge(397+i, 'n', 430+i, 'n', 1);
			board.addBiEdge(430+i, 'n', 463+i, 'n', 1);
			board.addBiEdge(463+i, 'n', 496+i, 'n', 1);
		}
		int i =32;
		board.addBiEdge(1+i, 'n', 34+i, 'n', 1);
		board.addBiEdge(34+i, 'n', 67+i, 'n', 1);
		board.addBiEdge(67+i, 'n', 100+i, 'n', 1);
		board.addBiEdge(100+i, 'n', 133+i, 'n', 1);
		board.addBiEdge(133+i, 'n', 166+i, 'n', 1);
		board.addBiEdge(166+i, 'n', 199+i, 'n', 1);
		board.addBiEdge(199+i, 'n', 232+i, 'n', 1);
		board.addBiEdge(232+i, 'n', 265+i, 'e', 1);
		board.addBiEdge(265+i, 'e', 298+i, 'n', 1);
		board.addBiEdge(298+i, 'n', 331+i, 'n', 1);
		board.addBiEdge(331+i, 'n', 364+i, 'n', 1);
		board.addBiEdge(364+i, 'n', 397+i, 'n', 1);
		board.addBiEdge(397+i, 'n', 430+i, 'n', 1);
		board.addBiEdge(430+i, 'n', 463+i, 'n', 1);
		board.addBiEdge(463+i, 'n', 496+i, 'n', 1);
		current = start;
	}
	public static GameboardPanel getInstance(){
		if(instance == null){
			instance = new GameboardPanel();
		}
		return instance;
	}
	public Graph getBoard(){
		return board;
	}
	public JLabel getTimerLabel(){
		return timeLabel;
	}
	public void setPath(Stack path){
		this.path = path;
	}
	public Node getCurrent(){
		return current;
	}
	public boolean getIsRunning(){
		return isRunning;
	}
	public JLabel getBoxLabel(){
		return l;
	}
	public void setTime(int t){
		timeElapsed = t;
	}
	public int calculateScore(){
		int s = 0;
		if(speed == 1000){
			s = (timeElapsed * 100)/3;
		}
		else if(speed == 500){
			s= timeElapsed * 100;
		}
		else if(speed == 250){
			s = timeElapsed * 650;
		}
		return s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		current = start;
		timeElapsed = 0;
		timeLabel.setText("Time Elapsed "+timeElapsed+" Seconds.");
		board.graphColorAllGray();
		end.changeState(3);
		start.changeState(2);
		while(current != end && isRunning){
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s = board.dijkstra(current);
			path = s.printPath(s.getNode(end.id));
			path.pop();
			current.changeState(1);
			current = board.getNode(path.pop().id);
			current.changeState(2);
			if(current.isWalledCheck()){
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(soundThree));
					clip.start();
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				current.getBox().setBackground(Color.LIGHT_GRAY);
				current.nodeValide();
				current.setWalled();
				board.disableCanPlace();
			}
			else{
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(soundOne));
					clip.start();
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				board.setCanPlace();
			}
			if(current == end){
				//signify end
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(soundFour));
					clip.start();
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JPanel p = new JPanel();
				p.setPreferredSize(new Dimension(400,100));
				p.setBackground(Color.LIGHT_GRAY);
				
				p.add(l);
				ok = new JButton("ok");
				ok.addActionListener(new BoardListener());
				ok.setPreferredSize(new Dimension(100,40));
				ok.setFont(new Font("Times New Roman", Font.BOLD, 24));
				p.add(ok);
				l2 = new JLabel("Score: "+ calculateScore());
				l2.setFont(new Font("Times New Roman", Font.BOLD, 18));
				p.add(l2);
				JLabel nhs = new JLabel("New High Score! Check Leader Board.");
				nhs.setFont(new Font("Times New Roman", Font.BOLD, 18));
				FileIO fi;
				try {
					fi = new FileIO();
					if(fi.newHigh(calculateScore())){
						p.add(nhs);
					}
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}		
				newHighScore = new JPanel();
				newHighScore.setPreferredSize(new Dimension(400,100));
				JLabel newHighLab = new JLabel("Enter name into Leader Board");
				newHighLab.setFont(new Font("Times New Roman", Font.BOLD, 18));
				ta = new JTextArea();
				ta.setPreferredSize(new Dimension(200,20));
				newHighScore.add(newHighLab);
				newHighScore.add(ta);
				newHighScore.setBackground(Color.LIGHT_GRAY);
				JPanel pane = new JPanel();
				pane.setPreferredSize(new Dimension(410,250));
				pane.add(p);
				pane.add(newHighScore);
				pane.setBackground(Color.LIGHT_GRAY);
				f = new JFrame();
				f.setSize(410,250);
				f.setContentPane(pane);
				f.setLocationRelativeTo(null);
				f.setVisible(true);	
			}
		}
		isRunning = false;
	}
	private class BoardListener implements ActionListener{
		private GameboardPanel gbp;
		public void actionPerformed(ActionEvent e) {
			gbp = GameboardPanel.getInstance();
			if(e.getSource() == startButton){
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(soundOne));
					clip.start();
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				t = new Thread(gbp);
				timer = new BasicTimer();
				timeT = new Thread(timer);
				if(!isRunning){
					isRunning = true;
					t.start();
					timeT.start();
				}	
			}
			else if(e.getSource() == toggleSpeed){
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(soundOne));
					clip.start();
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(speed == 1000){
					speed = 500;
					speedLabel.setText("| Normal Speed |");
				}
				else if(speed == 500){
					speed = 250;
					speedLabel.setText("| Fast Speed |");
				}
				else{
					speed = 1000;
					speedLabel.setText("| Slow Speed |");
				}
			}
			else if(e.getSource() == ok){
				name = ta.getText();
				FileIO fi;
				try {
					fi = new FileIO();
					if(!name.equals("")){
						fi.write(name+"|"+calculateScore());
					}
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				f.dispose();
			}
			else if(e.getSource() == scores){
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(soundOne));
					clip.start();
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FileIO fi;
				try {
					fi = new FileIO();
					
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				JFrame f = new JFrame();
				f.setSize(600,600);
				f.setLocationRelativeTo(null);
				try {
					f.setContentPane(new FileIO());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				f.setVisible(true);
			}
		}
		
	}
}
