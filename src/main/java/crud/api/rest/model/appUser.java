package crud.api.rest.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class appUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String appLogin;

	private String appSenha;
	private String appNome;

	@OneToMany(mappedBy = "phoneUser", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<userTelephone> telephones = new ArrayList<userTelephone>();

	
	 @OneToMany(fetch = FetchType.EAGER)
	 /* 
	 * @JoinTable(name = "user_on_roles", uniqueConstraints
	 * = @UniqueConstraint(columnNames = { "user_id", "role_id" }, name =
	 * "unique_role_user"), joinColumns = @JoinColumn(name = "user_id",
	 * referencedColumnName = "id", table = "user", unique = false, foreignKey
	 * = @ForeignKey(name = "user_fk", value = ConstraintMode.CONSTRAINT)),
	 * inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName =
	 * "id", table = "user_role", unique = false, updatable = false, foreignKey
	 * = @ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)))
	 */
	private List<userRole> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
