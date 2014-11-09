package da_co;

public interface GameHandler {

	void update();
	
	void dead(int playerindex);
	
	void gameEnd(int winnerindex);

}
