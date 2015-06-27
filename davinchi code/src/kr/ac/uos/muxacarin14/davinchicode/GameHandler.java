package kr.ac.uos.muxacarin14.davinchicode;

public interface GameHandler {

	void update();

	void dead(int playerindex);

	void gameEnd(int winnerindex);

}
