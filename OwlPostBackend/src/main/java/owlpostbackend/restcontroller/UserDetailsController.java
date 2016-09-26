package fashionplussBackEnd.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fashionplussBackEnd.dao.UserDetailsDAO;
import fashionplussBackEnd.model.Role;
import fashionplussBackEnd.model.UserDetails;
import fashionplussBackEnd.model.UsersRole;

@RestController
public class UserDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsController.class);
	
	@Autowired
	UserDetails userDetails;
	
	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	@Autowired
	UsersRole usersRole;
	
	@Autowired
	Role role;
	
	@GetMapping("/UserDetails")
	public ResponseEntity<List<UserDetails>> listAllUserDetailss(){
		
	}
	

}
