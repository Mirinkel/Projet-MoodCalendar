package fr.catamania.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.catamania.dal.MoodBoardDAOFact;

public class Test {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persitator");
		EntityManager em = emf.createEntityManager();

		User user1 = new User("Manager", "David", "Julien", "agence cat", "DJ@yahoo.fr", "DJJ", "ks8ds");
		User user2 = new User("Collaborateur", "Michel", "John", "agence cat", "MJ@yahoo.fr", "MLM", "re1et");
		User user3 = new User("Collaborateur", "Pierre", "louis", "agence cat", "PL@yahoo.fr", "FJF", "EL5EO");

		User user4 = new User("Manager", "Isabelle", "Daniel", "agence cat", "ID@yahoo.fr", "MTR", "nh5i8");
		User user5 = new User("Collaborateur", "Nicholas", "Sebastien", "agence cat", "NS@yahoo.fr", "NST", "er8uz");
		User user6 = new User("Collaborateur", "Marguerite", "Johnathon", "agence cat", "MJ@yahoo.fr", "IDD", "pokj4");

		MoodBoardDAOFact.getInstance().createUser(user1);
		MoodBoardDAOFact.getInstance().createUser(user2);
		MoodBoardDAOFact.getInstance().createUser(user3);
		MoodBoardDAOFact.getInstance().createUser(user4);
		MoodBoardDAOFact.getInstance().createUser(user5);
		MoodBoardDAOFact.getInstance().createUser(user6);

		Team team = new Team("Team DEV");
		MoodBoardDAOFact.getInstance().createTeam(team);

		Humor humor1 = new Humor(sdf.parse("06/10/2018"), "Bien", user1);
		Humor humor2 = new Humor(sdf.parse("06/10/2018"), "Pas Mal", user2);
		Humor humor3 = new Humor(sdf.parse("06/10/2018"), "Mal", user3);
		Humor humor4 = new Humor(sdf.parse("06/10/2018"), "Bien", user4);
		Humor humor5 = new Humor(sdf.parse("06/10/2018"), "Tres Bien", user5);
		Humor humor6 = new Humor(sdf.parse("06/10/2018"), "Bien", user6);

		MoodBoardDAOFact.getInstance().createHumor(humor1);
		MoodBoardDAOFact.getInstance().createHumor(humor2);
		MoodBoardDAOFact.getInstance().createHumor(humor3);
		MoodBoardDAOFact.getInstance().createHumor(humor4);
		MoodBoardDAOFact.getInstance().createHumor(humor5);
		MoodBoardDAOFact.getInstance().createHumor(humor6);

		Managed m1 = new Managed(user2, 1);
		Managed m2 = new Managed(user3, 1);
		Managed m3 = new Managed(user5, 4);
		Managed m4 = new Managed(user6, 4);

		MoodBoardDAOFact.getInstance().createManaged(m1);
		MoodBoardDAOFact.getInstance().createManaged(m2);
		MoodBoardDAOFact.getInstance().createManaged(m3);
		MoodBoardDAOFact.getInstance().createManaged(m4);

		Humor humor7 = new Humor(sdf.parse("07/10/2018"), "Pas Mal", user1);
		Humor humor8 = new Humor(sdf.parse("07/10/2018"), "Bien", user2);
		Humor humor9 = new Humor(sdf.parse("07/10/2018"), "Tres Bien", user3);
		Humor humor10 = new Humor(sdf.parse("07/10/2018"), "Mal", user4);
		Humor humor11 = new Humor(sdf.parse("07/10/2018"), "Tres Bien", user5);
		Humor humor12 = new Humor(sdf.parse("07/10/2018"), "Pas Mal", user6);

		MoodBoardDAOFact.getInstance().createHumor(humor7);
		MoodBoardDAOFact.getInstance().createHumor(humor8);
		MoodBoardDAOFact.getInstance().createHumor(humor9);
		MoodBoardDAOFact.getInstance().createHumor(humor10);
		MoodBoardDAOFact.getInstance().createHumor(humor11);
		MoodBoardDAOFact.getInstance().createHumor(humor12);
		
		
		

		System.out.println("ok c bon");
	}
}