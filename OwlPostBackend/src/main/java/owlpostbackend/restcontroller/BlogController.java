package fashionplussBackEnd.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import fashionplussBackEnd.dao.BlogDAO;
import fashionplussBackEnd.model.Blog;

@RestController
public class BlogController {

}
	
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
 
	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private Blog blog;
	
	@GetMapping("/blogs")
	public List<Blog> getBlogs(){
	  logger.debug("calling method getBlogs");
	  return blogDAO.list();
		
	}
	
	@GetMapping("/blog/{id}")
	public ResponseEntity<Blog> getBlog(@PathVariable("id") String id){
		logger.debug("calling method getBlogs with the id"+id);
		Blog blog = blogDAO.get(id);
		if (blog == null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/blog")
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
		Logger.debug("calling method createBlog");
		blogDAO.get(blog.getId())
		blogDAO.saveOrUpdate(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/blog/{id}")
	public ResponseEntity<Blog> deleteBlog(@PathVariable String id){
		Logger.debug("calling method deleteBlog with the id"+id);
		if(blogDAO.get(id)!=null){
			return new ResponseEntity<Blog>(HttpStatus.NOt_FOUND);
		}
		blogDAO.delete(id);
		return new ResponseEntity<Blog>(HttpStatus.OK);
		
	}
	 
	@PutMapping("/blog/{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable String id, @RequestBody Blog blog){
		Logger.debug("calling method updateBlog with the id"+id);
		if(blogDAO.get(id)!=null){
			return new ResponseEntity<Blog>(HttpStatus.NOt_FOUND);
		}
		blogDAO.saveOrUpdate(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		
	}
	
	
}
