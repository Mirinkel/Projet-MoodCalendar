package fr.catamania.dal;

public class MoodBoardDAOFact {

	public static MoodBoardDAO getInstance(){
		return new MoodBoardDAOImpl();
	}
}
