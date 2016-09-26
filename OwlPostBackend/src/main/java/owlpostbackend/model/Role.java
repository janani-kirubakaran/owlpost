package fashionplussBackEnd.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fp_role")

public class Role implements Serializable {

	
	private static final long serialVersionUID = 19L;
	
	@Id
	@Column(name="id")
	private String id;
	private String rolename;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	} 

}
