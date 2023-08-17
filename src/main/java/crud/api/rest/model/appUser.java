package crud.api.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class appUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String appLogin;

	private String appSenha;
	private String appNome;

	@OneToMany(mappedBy = "phoneUser", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<userTelephone> telephones = new ArrayList<userTelephone>();

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getAppLogin() {
		return appLogin;
	}

	public void setAppLogin(String appLogin) {
		this.appLogin = appLogin;
	}

	public String getAppSenha() {
		return appSenha;
	}

	public void setAppSenha(String appSenha) {
		this.appSenha = appSenha;
	}

	public String getAppNome() {
		return appNome;
	}

	public void setAppNome(String appNome) {
		this.appNome = appNome;
	}

	public List<userTelephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<userTelephone> telephones) {
		this.telephones = telephones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		appUser other = (appUser) obj;
		return Objects.equals(Id, other.Id);
	}

}
