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
		;
		Query query = em.createQuery("from User user");
		listeUsers = query.getResultList();

		return listeUsers;
	}

	@Override
	public User createUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user;
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
		User humormodify = em.find(User.class, user.getIdUser());

		em.getTransaction().begin();

		if (humormodify == null) {
			throw new IllegalArgumentException("modification impossible l'utilisateur n'existe pas");

		} else {
			humormodify.setType(user.getType());
			humormodify.setNom(user.getNom());
			humormodify.setPrenom(user.getPrenom());
			humormodify.setEmail(user.getEmail());
			humormodify.setAgence(user.getAgence());
			humormodify.setLogin(user.getLogin());
			humormodify.setPassWord(user.getPassWord());
			em.merge(humormodify);

		}
		em.getTransaction().commit();
	}

	@Override
	public void modifyHumor(Humor humor) {
		Humor humormodify = em.find(Humor.class, humor.getIdHumor());

		em.getTransaction().begin();

		if (humormodify == null) {
			throw new IllegalArgumentException("modification impossible l'humeur n'existe pas");

		} else {
			humormodify.setDate(humor.getDate());
			humormodify.setTypeHumor(humor.getTypeHumor());
			em.merge(humormodify);

		}
		em.getTransaction().commit();
	}

	@Override
	public void deleteUser(User user) {

		User userDelete = em.find(User.class, user.getIdUser());
		em.getTransaction().begin();
		if (userDelete == null) {
			throw new IllegalArgumentException("suppression impossible car aucun user");
		} else {
			em.remove(userDelete);
		}
		em.getTransaction().commit();
	}

	@Override
	public void createManaged(Managed managed) {
		em.getTransaction().begin();
		em.persist(managed);
		em.getTransaction().commit();
	}

	@Override
	public User getLogin(User user) {
		User userLogin = em.find(User.class, user.getIdUser());
		userLogin.getLogin();
		userLogin.getPassWord();
		return userLogin;

	}

}
