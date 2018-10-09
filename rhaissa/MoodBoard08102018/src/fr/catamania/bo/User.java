package fr.catamania.bo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idUser")

	private Integer idUser;

	private String type;
	private String nom;
	private String prenom;
	private String email;
	private String agence;
	private String login;
	private String passWord;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "TeamUser", joinColumns = { @JoinColumn(name = "idUser") }, inverseJoinColumns = {
			@JoinColumn(name = "idTeam") })
	private Set<Team> listeTeams = new HashSet<>();

	public User() {
		super();
	}

	public User(String type, String nom, String prenom, String email, String agence, String login, String passWord) {
		super();
		this.type = type;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.agence = agence;
		this.login = login;
		this.passWord = passWord;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public Set<Team> getListeTeams() {
		return listeTeams;
	}

	public void setListeTeams(Set<Team> listeTeams) {
		this.listeTeams = listeTeams;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [idUser=");
		builder.append(idUser);
		builder.append(", type=");
		builder.append(type);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", email=");
		builder.append(email);
		builder.append(", agence=");
		builder.append(agence);
		builder.append(", login=");
		builder.append(login);
		builder.append(", passWord=");
		builder.append(passWord);
		builder.append("]");
		return builder.toString();
	}

}
