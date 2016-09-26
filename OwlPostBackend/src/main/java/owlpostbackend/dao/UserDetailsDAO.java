package fashionplussBackEnd.dao;

import java.util.List;

import fashionplussBackEnd.model.UserDetails;

public interface UserDetailsDAO {
	
	public List<UserDetails> list();
	
	public UserDetails get(String id, String password);
	
	public UserDetails get(String id);
	
	public boolean save(UserDetails userDetails);
	
	public boolean update(UserDetails userdetails);
	
	public void delete(String id);
	
	public UserDetails isValidUserDetails(String id, String name);

}
