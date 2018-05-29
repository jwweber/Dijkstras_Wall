import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileIO extends JPanel {
	private String[] names;
	private int[] scores;
	private BufferedReader br;
	private JLabel title;
	private JLabel[] entries;
	private JPanel subPanelOne;
	private JPanel subPanelTwo;
	public FileIO() throws IOException{
		this.setPreferredSize(new Dimension(600,600));
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new FlowLayout());
		title = new JLabel("High Scores:");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		names = new String[100];
		scores = new int[100];
		read();
		quickSort(scores,names,0,99);
		entries = new JLabel[10];
		subPanelOne = new JPanel();
		subPanelOne.setPreferredSize(new Dimension(100,500));
		subPanelOne.setBackground(Color.LIGHT_GRAY);
		subPanelTwo = new JPanel(new GridLayout(11,1));
		subPanelTwo.setPreferredSize(new Dimension(350,500));
		subPanelTwo.setBackground(Color.LIGHT_GRAY);
		subPanelTwo.add(title);
		for(int i = 0; i < 10;++i){
			entries[i] = new JLabel();
			if(names[99-i] != null){
				entries[i].setFont(new Font("Times New Roman", Font.BOLD, 28));
				entries[i].setText(i+1+". "+names[99-i]+"     "+scores[99-i]);
			}
			else{
				entries[i].setFont(new Font("Times New Roman", Font.BOLD, 28));
				entries[i].setText(i+1+". ");
			}
			subPanelTwo.add(entries[i]);
		
			
		}
		this.add(subPanelOne);
		this.add(subPanelTwo);
	}
	private void read() throws IOException{
		br = new BufferedReader(new FileReader("res/scores.txt"));
		int i = 0;
		String line = br.readLine();
		names[i] = line.substring(0, line.indexOf('|'));
		scores[i] = Integer.parseInt(line.substring(line.indexOf('|')+1));
		i++;
		line = br.readLine();
		while(line != null){
			names[i] = line.substring(0, line.indexOf('|'));
			scores[i] = Integer.parseInt(line.substring(line.indexOf('|')+1));
			i++;
			line = br.readLine();
		}
		br.close();
	}
	public void write(String s) throws IOException{
		int lineCounter = 0;
		BufferedReader file = new BufferedReader(new FileReader("res/scores.txt"));
		String line;
		StringBuffer inputBuffer = new StringBuffer();
		while ((line = file.readLine()) != null) {
			    inputBuffer.append(line);
				inputBuffer.append(System.getProperty("line.separator"));
		}
		inputBuffer.append(s);
		inputBuffer.append(System.getProperty("line.separator"));
		String inputString = inputBuffer.toString();
		file.close();
		FileOutputStream fileOut = new FileOutputStream("res/scores.txt");
		fileOut.write(inputString.getBytes());
		fileOut.close();
	}
	public void iterate(){
		for(int i = 0; i < 100; i++){
			System.out.println(names[i] + " " +scores[i]);
		}
	}
	public boolean newHigh(int score){
		boolean ret = false;
		for(int i = 90; i <= 99; i++){
			if(scores[i] < score){
				ret = true;
			}
		}
		return ret;
	}
	private void quickSort(int[] A, String[] B, int p, int r){
		if(p < r){
			int q = partition(A,B,p,r);
			quickSort(A,B,p,q-1);
			quickSort(A,B,q+1,r);
		}
	}
	private int partition(int[] A, String[] B, int p, int r){
		int pivot = A[r];
		int i = p - 1;
		for(int j = p; j <=r ; j++){
			if(A[j] <= pivot){
				i++;
				exchange(A,i,j);
				exchangeString(B,i,j);
			}
		}
		return i;
	}
	private void exchange(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	private void exchangeString(String[] A, int i, int j){
		String temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
