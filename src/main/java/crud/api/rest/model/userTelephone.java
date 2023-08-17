package crud.api.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class userTelephone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String numero;

	@JsonIgnore
	@org.hibernate.annotations.ForeignKey(name = "userId_FK")
	@ManyToOne(optional = false)
	private appUser phoneUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public appUser getPhoneUser() {
		return phoneUser;
	}

	public void setPhoneUser(appUser phoneUser) {
		this.phoneUser = phoneUser;
	}

}
