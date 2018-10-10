package fr.catamania.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

@Entity
public class Managed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idManaged")
	private Integer idManaged;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUser")
	private User user;

	private Integer idManager;

	public Managed() {

	}

	public Managed(User user, Integer idManager) {
		super();
		this.user = user;
		this.idManager = idManager;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getIdManaged() {
		return idManaged;
	}

	public void setIdManaged(Integer idManaged) {
		this.idManaged = idManaged;
	}

	public Integer getIdManager() {
		return idManager;
	}

	public void setIdManager(Integer idManager) {
		this.idManager = idManager;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Manager [idManaged=");
		builder.append(idManaged);
		builder.append(", user=");
		builder.append(user);
		builder.append(", idManager=");
		builder.append(idManager);
		builder.append("]");
		return builder.toString();
	}

}
