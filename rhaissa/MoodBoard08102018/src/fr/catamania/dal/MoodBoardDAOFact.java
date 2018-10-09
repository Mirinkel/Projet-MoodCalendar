package fr.catamania.dal;

import fr.catamania.bo.User;

public class MoodBoardDAOFact {

	public static MoodBoardDAO getInstance(){
		return new MoodBoardDAOImpl();
	}
}
