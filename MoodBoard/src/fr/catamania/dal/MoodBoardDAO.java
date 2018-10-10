package fr.catamania.dal;

import java.util.List;

import fr.catamania.bo.Humor;
import fr.catamania.bo.Managed;
import fr.catamania.bo.Team;
import fr.catamania.bo.User;

public interface MoodBoardDAO {

	public List<User> getAll();

	public void createUser(User user);

	public void createHumor(Humor humor);

	public void createTeam(Team team);	
	
	public List<User> deleteUserById(Integer idUser);

	public void modifyUser(User user);

	public void createManaged(Managed managed);
	
	public List<Team> getAllTeam();

}
