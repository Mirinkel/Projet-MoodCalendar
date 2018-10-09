package fr.catamania.bo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idTeam")
	private Integer idTeam;
	private String nomTeam;
	@ManyToMany(mappedBy = "listeTeams")
	private Set<User> listeUsers = new HashSet<>();

	public Team() {
	}

	public Team(String nomTeam) {
		super();
		this.nomTeam = nomTeam;
	}

	public Integer getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	public String getNomTeam() {
		return nomTeam;
	}

	public void setNomTeam(String nomTeam) {
		this.nomTeam = nomTeam;
	}

	public Set<User> getListeUsers() {
		return listeUsers;
	}

	public void setListeUsers(Set<User> listeUsers) {
		this.listeUsers = listeUsers;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Team [idTeam=");
		builder.append(idTeam);
		builder.append(", nomTeam=");
		builder.append(nomTeam);
		builder.append("]");
		return builder.toString();
	}

}
