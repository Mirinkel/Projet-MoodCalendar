package fr.catamania.ws;

import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import fr.catamania.bo.Humor;
import fr.catamania.bo.User;
import fr.catamania.dal.MoodBoardDAOFact;

public class FrontWS {

	@Path("/createHumor/{date}/{type}")
//	@GET
	public void createHumor(@FormParam("date") Date date, @FormParam("typeHumor") String typeHumor) {

		Humor humor = new Humor();
		humor.setDate(date);
		humor.setTypeHumor(typeHumor);
		MoodBoardDAOFact.getInstance().createHumor(humor);

	}

	@Path("/modifyHumor")
//	@PUT
	public void modifyHumor(@FormParam("date") Date date, @FormParam("typeHumor") String typeHumor) {

		Humor humor = new Humor();
		humor.setDate(date);
		humor.setTypeHumor(typeHumor);
		MoodBoardDAOFact.getInstance().modifyHumor(humor);

	}
	
	@Path("/getLogin")
	@POST
	public void get(@FormParam("login") String login, @FormParam("passWord") String passWord) {
		User user = new User();
		user.setLogin(login);
		user.setPassWord(passWord);
		MoodBoardDAOFact.getInstance().getLogin(user);
		
	}

}
