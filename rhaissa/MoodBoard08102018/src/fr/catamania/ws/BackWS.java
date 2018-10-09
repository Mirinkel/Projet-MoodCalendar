package fr.catamania.ws;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import fr.catamania.bo.Team;
import fr.catamania.bo.User;
import fr.catamania.dal.MoodBoardDAOFact;

@Path("/backWS")
public class BackWS {

//	 @Path("/helloConsole")
//	 
//	 @GET public void helloConsole() { System.out.println("Hello"); }
//	 

	@Path("/getManagers")
	@GET
	public List<User> getManagers() {
		List<User> managers = new ArrayList<>();
		managers = MoodBoardDAOFact.getInstance().getAll();
		for (User user : managers) {
			if (user.getType().equals("manager")) {
				managers.add(user);
			}
		}
		System.out.println(managers);
		return managers;

	}

	@Path("/getAll")
	@GET
	public List<User> getAll() {
		List<User> users = MoodBoardDAOFact.getInstance().getAll();
		System.out.println(users);

		return users;
	}

	@Path("/createUser")
	@POST
	public void createUser(@FormParam("type") String type, @FormParam("login") String login,
			@FormParam("password") String password, @FormParam("nom") String nom, @FormParam("prenom") String prenom,
			@FormParam("email") String email, @FormParam("agence") String agence,
			@FormParam("nomTeam") String nomTeam) {

		User user = new User();
		user.setType(type);
		user.setLogin(login);
		user.setPassWord(password);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setAgence(agence);
		MoodBoardDAOFact.getInstance().createUser(user);

	}

	@Path("/modifyUser")
	@PUT
	public void modifyUser(@FormParam("type") String type, @FormParam("login") String login,
			@FormParam("password") String password, @FormParam("nom") String nom, @FormParam("prenom") String prenom,
			@FormParam("email") String email, @FormParam("agence") String agence,
			@FormParam("nomTeam") String nomTeam) {

		User user = new User();
		user.setType(type);
		user.setLogin(login);
		user.setPassWord(password);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setAgence(agence);

		MoodBoardDAOFact.getInstance().modifyUser(user);
	}

	/*
	 * @Path("/deleteUser/{idUser}")
	 * 
	 * @DELETE public void deleteUser(@PathParam("idUser") Integer idUser) {
	 * System.out.println(idUser);
	 * MoodBoardDAOFact.getInstance().deleteUserById(idUser); }
	 */

}
