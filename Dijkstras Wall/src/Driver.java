import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Dijkstra's Wall 1.0");
		f.setSize(1200,800);
		f.setLocationRelativeTo(null);
		f.setContentPane(GameboardPanel.getInstance());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
