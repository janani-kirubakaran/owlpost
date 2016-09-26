package fashionplussBackEnd.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="fp_UserProfile")
public class UserProfile implements Serializable{

	
	private static final long serialVersionUID = 19L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int profileId;
	@OneToOne
	@JoinColumn(name="userName")
	private UserDetails userdetails;
	@OneToOne
	@JoinColumn(name="date_of_birth")
	private UserDetails userdetails1;
	private String studied;
	private String about;
	private String college;
	private String hobbies;
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public UserDetails getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}
	public UserDetails getUserdetails1() {
		return userdetails1;
	}
	public void setUserdetails1(UserDetails userdetails1) {
		this.userdetails1 = userdetails1;
	}
	public String getStudied() {
		return studied;
	}
	public void setStudied(String studied) {
		this.studied = studied;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	
	

}
