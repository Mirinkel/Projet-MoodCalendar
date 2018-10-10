package fr.catamania.ws;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.catamania.bo.Team;
import fr.catamania.bo.User;
import fr.catamania.dal.MoodBoardDAOFact;

@Path("/backWS")
public class BackWS {

	@Path("/getAll")
	@GET
	public List<User> getAll() {
		List<User> users = MoodBoardDAOFact.getInstance().getAll();
		return users;
	}

	@Path("/createUser")
	@POST
	public void createUser(@FormParam("type") String type, @FormParam("login") String login,
			@FormParam("password") String password, @FormParam("nom") String nom, @FormParam("prenom") String prenom,
			@FormParam("email") String email, @FormParam("agence") String agence, @FormParam("manager") String manager,
			@FormParam("nomTeam") String nomTeam) {

		User user = new User();
		user.setType(type);
		user.setLogin(login);
		user.setPassWord(password);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setAgence(agence);

		
		Team team = new Team();
		List<Team> teams = MoodBoardDAOFact.getInstance().getAllTeam();
		for (Team t : teams) {
			if (!(t.getNomTeam().equals(nomTeam))) {
				team.setNomTeam(nomTeam);
				Set<User> users = new HashSet<>();
				users.add(user);
				team.setListeUsers(users);
			} else {
				t.getListeUsers().add(user);
			}
		}
		MoodBoardDAOFact.getInstance().createTeam(team);

	}

	@Path("/modifyUser")
	@PUT
	public void modifyUser(@FormParam("idUser") Integer idUser, @FormParam("type") String type, @FormParam("login") String login,
			@FormParam("password") String password, @FormParam("nom") String nom, @FormParam("prenom") String prenom,
			@FormParam("email") String email, @FormParam("agence") String agence, @FormParam("manager") String manager,
			@FormParam("nomTeam") String nomTeam) {
		
		
		User user = new User();
		user.setIdUser(idUser);
		user.setType(type);
		user.setLogin(login);
		user.setPassWord(password);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setAgence(agence);	

		MoodBoardDAOFact.getInstance().modifyUser(user);
	}

	@Path("/deleteUser/{idUser}")
	@DELETE
	public void deleteUser(@PathParam("idUser") Integer idUser) {
		List<User> users = MoodBoardDAOFact.getInstance().deleteUserById(idUser);
	}
	
	public List<User> getManagers() {
		List<User> managers = new ArrayList<>();
		List<User> users = MoodBoardDAOFact.getInstance().getAll();
		for (User user : users) {
			if (user.getType().equals("Manager")) {
				managers.add(user);
			}
		}
		return managers;
	}
	
	public List<String> getNomManagers() {
		List<String> nomManagers = new ArrayList<>();
		String nomManager = "";
		List<User> managers = getManagers();
		for (User manager : managers){
			nomManager = manager.getPrenom() + ' ' + manager.getNom();
			nomManagers.add(nomManager);
		}
		nomManagers.add(" ");
		return nomManagers;
	}
	
	@Path("/displayNomManagers")
	@GET
	
	public List<String> displayNomManagers() {
		List<String> nomManagers = getNomManagers();
		return nomManagers;
	}
}
