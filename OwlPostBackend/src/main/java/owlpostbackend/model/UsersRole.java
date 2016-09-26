package fashionplussBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fp_usersrole")
public class UsersRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="user_id", updatable = false, insertable = false)
	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
    @ManyToOne
    @JoinColumn(name="role_id", updatable = false, insertable = false)
    private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
