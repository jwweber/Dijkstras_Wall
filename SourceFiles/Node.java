import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPanel;

public class Node extends JPanel {
		public char label;
		public int id;
		public Node next;
		public LinkedList ll;
		private boolean isWalled;
		private JButton button;
		private JPanel innerBoxOne;
		private JPanel innerBoxTwo;
		private JPanel innerBoxThree;
		private Color innerColor = Color.LIGHT_GRAY;
		private Color outerColor = Color.LIGHT_GRAY;
		private CardLayout cl = new CardLayout();
		private int state;
		protected int color;
		private Graph g;
		private File soundTwo;
		public Node(Graph g){
			super.setLayout(cl);
			this.g = g;
			soundTwo = new File("res/sound64.wav");
			state = 1;
			color = 1;
			isWalled = false;
			innerBoxOne = new JPanel(new GridLayout(1,1));
			this.setPreferredSize(new Dimension(30,30));
			innerBoxOne.setPreferredSize(new Dimension(26,26));
			this.setBackground(outerColor);
			innerBoxOne.setBackground(innerColor);
			button = new JButton();
			button.addActionListener(new Listener());
			button.setPreferredSize(new Dimension(26,26));
			button.setOpaque(false);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			innerBoxOne.add(button);
			this.add(innerBoxOne,"one");
			innerBoxTwo = new JPanel();
			innerBoxTwo.setBackground(Color.RED);
			this.add(innerBoxTwo,"two");
			innerBoxThree = new JPanel();
			innerBoxThree.setBackground(Color.BLUE);
			this.add(innerBoxThree,"three");
			changeState(state);
		}
		public void changeState(int s){
			state = s;
			if(state == 1){
				cl.show(this,"one");
			}
			else if(state == 2){
				cl.show(this, "two");
			}
			else if(state == 3){
				cl.show(this, "three");
			}
		}
		public boolean isWalledCheck(){
			return isWalled;
		}
		public void toggleWalled(){
			if(isWalled){
				isWalled = false;
			}
		}
		public void setWalled(){
			isWalled = true;
		}
		public JPanel getBox(){
			return innerBoxOne;
		}
		public void nodeValide(){
			revalidate();
		}
		private class Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				Color wallColor = Color.GRAY;
				// TODO Auto-generated method stub
				
					if(e.getSource() == button){
						if(g.getCanPlace()){
							if(id -1 != 0 && id -1 != 33 && id -1 != 66 && id -1 != 99 && id -1 != 132 
									&& id -1 != 165 && id -1 != 198 && id -1 != 231 && id -1 != 264 && id -1 != 297 
									&& id -1 != 330 && id -1 != 363 && id -1 != 396 && id -1 != 429 && id -1 != 462 && id -1 != 495){
								g.setBiWeight(id, id-1, 99999);
							}
							if(id +1 != 34 && id +1 != 67 && id +1 != 100 && id +1 != 133 
									&& id +1 != 166 && id +1 != 199 && id +1 != 232 && id +1 != 265 && id +1 != 298 
									&& id +1 != 331 && id +1 != 364 && id +1 != 397 && id +1 != 430 && id +1 != 463 && id +1 != 496 && id +1 != 529){
								g.setBiWeight(id, id+1, 99999);
							}
							if(id - 33 > 0){
								g.setBiWeight(id, id-33, 99999);
							}
							if(id + 33 <= 528){
								g.setBiWeight(id, id+33, 99999);
							}
							try {
								Clip clip = AudioSystem.getClip();
								clip.open(AudioSystem.getAudioInputStream(soundTwo));
								clip.start();
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							isWalled = true;
							innerBoxOne.setBackground(wallColor);
							revalidate();
						}
					}
					
			}
			
		}
	}