
public class BasicTimer implements Runnable{
	private int secondsElapsed;
	private GameboardPanel gbp;
	//public constructor
	public BasicTimer(){
		secondsElapsed = 0;
		gbp = GameboardPanel.getInstance();
	}
	@Override
	public void run() {
		secondsElapsed = 0;
		while(gbp.getIsRunning()){
			secondsElapsed++;
			gbp.getTimerLabel().setText("| Time Elapsed "+ secondsElapsed+" Seconds. |");
			gbp.getBoxLabel().setText("Round Over: Time Elapsed "+secondsElapsed+" Seconds.");
			gbp.setTime(secondsElapsed);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//seconds getter
	public int getElapsedSeconds(){
		return secondsElapsed;
	}
}