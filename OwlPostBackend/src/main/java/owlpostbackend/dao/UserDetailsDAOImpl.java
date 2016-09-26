package fashionplussBackEnd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fashionplussBackEnd.model.UserDetails;

public class UserDetailsDAOImpl implements UserDetailsDAO {
	
	private static final Logger log = LoggerFactory.getLogger(UserDetailsDAOImpl.class);

	@Autowired(required = true)
	private SessionFactory sessionFactory;
	
	@Autowired
	private UserDetails userDetails;
	
	public UserDetailsDAOImpl(SessionFactory sessionFactory){
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			log.error("Unable to connect database");
			e.printStackTrace();
		}
		
	}
	
	@Transactional
	public List<UserDetails> list() {
		log.debug("calling list method");
		
	
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) sessionFactory.getCurrentSession()
		.createCriteria(UserDetails.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

	public UserDetails get(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDetails get(String id) {
		String hql = "from userdetails where id="+"'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		if (list != null && !list.isEmpty()){
			return list.get(0);
			
		}
		return null;
	}
	@Transactional

	public boolean save(UserDetails userDetails) {
		log.debug("calling update method");
		try {
			sessionFactory.getCurrentSession().update(userDetails);
		    return true;  
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		return false;
		}
		
	}

	public boolean update(UserDetails user) {
		log.debug("calling update method");
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	
    @Transactional
	public void delete(String id) {
    	log.debug("calling delete method");
		UserDetails userDetails = new UserDetails();
        userDetails.setId(id);
		
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	@SuppressWarnings("unused")
	private UserDetails getUserDetails(String hql)
	{
		log.debug("calling getUser method");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		 
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		if(list !=null && list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	public UserDetails isValidUserDetails(String id, String password) {
		log.debug("calling list isValidUserDetails");
		String hql = "from UserDetails where id='"+id+"' and "+"password='"+password;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		userDetails = null;
		
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		if(list != null && list.isEmpty()){
			userDetails = list.get(0);
		}
		return userDetails;
	}

}
