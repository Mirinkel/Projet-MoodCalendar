package fr.catamania.dal;

import java.util.List;

import fr.catamania.bo.Humor;
import fr.catamania.bo.Managed;
import fr.catamania.bo.Team;
import fr.catamania.bo.User;

public interface MoodBoardDAO {

	public List<User> getAll();

	public User createUser(User user);

	public void createHumor(Humor humor);

	public void createTeam(Team team);

	public void deleteUser(User user);

	public void modifyUser(User user);

	public void createManaged(Managed managed);

	public void modifyHumor(Humor humor);

	public User getLogin(User user);

}
