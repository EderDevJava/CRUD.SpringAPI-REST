package crud.api.rest.model;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_role")
@SequenceGenerator(name = "seq_role", sequenceName = "seq_role", allocationSize = 1, initialValue = 1)
public class userRole implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
	private Long id;

	private String descricaorole;

	private boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaorole() {
		return descricaorole;
	}

	public void setDescricaorole(String descricaorole) {
		this.descricaorole = descricaorole;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String getAuthority() {
		return this.descricaorole;
	}

}
