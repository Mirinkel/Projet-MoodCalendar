package fr.catamania.dal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import fr.catamania.bo.Humor;
import fr.catamania.bo.Managed;
import fr.catamania.bo.Team;
import fr.catamania.bo.User;

public class MoodBoardDAOImpl implements MoodBoardDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persitator");
	EntityManager em = emf.createEntityManager();

	@Override
	public List<User> getAll() {
		
		List<User> listeUsers = new ArrayList<>();		
		Query query = em.createQuery("from User user");
		listeUsers = query.getResultList();
		return listeUsers;
	}

	@Override
	public void createUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	@Override
	public void createHumor(Humor humor) {
		em.getTransaction().begin();
		em.persist(humor);
		em.getTransaction().commit();

	}

	@Override
	public void createTeam(Team team) {
		em.getTransaction().begin();
		em.persist(team);
		em.getTransaction().commit();

	}

	@Override
	public void modifyUser(User user) {
		User usermodify = em.find(User.class, user.getIdUser());

		em.getTransaction().begin();

		if (usermodify == null) {
			throw new IllegalArgumentException("modification impossible l'utilisateur n'existe pas");

		} else {
			usermodify.setType(user.getType());
			usermodify.setNom(user.getNom());
			usermodify.setPrenom(user.getPrenom());
			usermodify.setEmail(user.getEmail());
			usermodify.setAgence(user.getAgence());
			usermodify.setLogin(user.getLogin());
			usermodify.setPassWord(user.getPassWord());
			System.out.println(usermodify.getIdUser());
			em.merge(usermodify);

		}
		em.getTransaction().commit();
	}
	
	@Override
	public List<User> deleteUserById(Integer idUser){	
		
		User userDelete = new User();
		List<User> listeUsersBefore = getAll();
		for (User user: listeUsersBefore) {
			if(user.getIdUser().equals(idUser)) {
				userDelete = user;
			}
		}		

		userDelete = em.find(User.class, idUser);
		em.getTransaction().begin();
		if (userDelete == null) {
			throw new IllegalArgumentException("suppression impossible car aucun user");
		} else {
			em.remove(userDelete);
		}
		em.getTransaction().commit();
		
		List<User> listeUsersAfter = getAll();
		
		return listeUsersAfter;
	}
	
	
	@Override
	public void createManaged(Managed managed) {
		em.getTransaction().begin();
		em.persist(managed);
		em.getTransaction().commit();
	}
	
	@Override
	public List<Team> getAllTeam(){
		List<Team> listeTeams = new ArrayList<>();
		Query query = em.createQuery("from User user");
		listeTeams = query.getResultList();		
		return listeTeams;		
	}

}
