package fr.catamania.bo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Humor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idHumor")
	private Integer idHumor;
	@Temporal(TemporalType.DATE)
	private Date date;

	private String typeHumor;

//	@ManyToMany(cascade = { CascadeType.ALL })
//	@JoinTable(name = "HumorUser", joinColumns = { @JoinColumn(name = "idHumor") }, inverseJoinColumns = {
//			@JoinColumn(name = "idUser") })
//	private Set<User> listeUsers = new HashSet<>();

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUser")
	private User user;

	public Humor() {

	}

	public Humor(Date date, String typeHumor, User idUser) {
		super();
		this.date = date;
		this.typeHumor = typeHumor;

		this.user = idUser;
	}

	public Integer getIdHumor() {
		return idHumor;
	}

	public void setIdHumor(Integer idHumor) {
		this.idHumor = idHumor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTypeHumor() {
		return typeHumor;
	}

	public void setTypeHumor(String typeHumor) {
		this.typeHumor = typeHumor;
	}

	public User getIdUser() {
		return user;
	}

	public void setIdUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Humor [date=");
		builder.append(date);
		builder.append(", typeHumor=");
		builder.append(typeHumor);
		builder.append(", listeUsers=");
		builder.append(", idUser=");
		builder.append("]");
		return builder.toString();
	}

}
