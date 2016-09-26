package fashionplussBackEnd.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import fashionplussBackEnd.model.UserDetails;


@Entity
@Table(name="fp_blog")
public class Blog implements Serializable {

	
	private static final long serialVersionUID = 18L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Blog_id")
	private String blogId;
	@NotEmpty
	private String blogName;

	
	private String blogMessage;
	@OneToOne
	@JoinColumn(name="userId")
	private UserDetails userDetails;
	@NotNull
	private Date date_time;
	private String status;
	private String reason;
	
	
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getBlogMessage() {
		return blogMessage;
	}
	public void setBlogMessage(String blogMessage) {
		this.blogMessage = blogMessage;
	}
	
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	

}
