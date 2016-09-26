package fashionplussBackEnd.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="fp_Userdetails")
public class UserDetails implements Serializable {

	
	private static final long serialVersionUID = 19L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private String id;
	@NotEmpty
	private String firstName;
	private String lastName;
	@NotEmpty
	private String userName;
	@Email
	@NotEmpty
	private String email;
	@NotNull
	private Date date_of_birth;
	@NotEmpty
	private String password;
	@NotEmpty
	private String Gender;
	
	@OneToMany(mappedBy = "userDetails",fetch = FetchType.EAGER )
	private Set<UsersRole> usersRole;
	
	public Set<UsersRole> getUsersRole() {
		return usersRole;
	}
	public void setUsersRole(Set<UsersRole> usersRole) {
		this.usersRole = usersRole;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	
	

}
