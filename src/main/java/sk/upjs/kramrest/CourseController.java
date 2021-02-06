package sk.upjs.kramrest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kram.storage.DaoFactory;
import kram.storage.EntityNotFoundException;
import kram.storage.course.Course;
import kram.storage.course.CourseDao;


@RestController
@RequestMapping("/courses")
@CrossOrigin
public class CourseController {
	
//	public String acceptDismissStudent( int bool, Long idStudent, Long idCourse);
//	void addToCourse(Long idCourse, Long idUser) throws EntityNotFoundException;
//	List<Course> getAllRowMapperWithoutUser(Long id) throws EntityNotFoundException;
//	List<Course> getBySubstringWithoutU(String string, Long id);
	
	private CourseDao courseDao = DaoFactory.INSTATNCE.getCourseDao();
	
	@GetMapping()
	private List<Course> getAllusers() {
		return courseDao.getAll();
	}
	
	@GetMapping("{idCourse}")
	public Course getById(@PathVariable("idCourse") long idCourse) throws EntityNotFoundException {
		return courseDao.getById(idCourse);
		
	}
	
	@GetMapping("/idTeacher/{idTeacher}")
	public List<Course> getAllForTeacher(@PathVariable("idTeacher") long idTeacher) throws EntityNotFoundException {
		return courseDao.getAllByTeacherId(idTeacher);
		
	}
	
	@GetMapping("/idStudent/{idStudent}")
	public List<Course> getAllForUser(@PathVariable("idStudent") long idStudent) throws EntityNotFoundException {
		return courseDao.getAllByStudentId(idStudent);
		
	}
	
	@PostMapping()
	public Course saveUser(@RequestBody Course course) throws EntityNotFoundException {
		return courseDao.saveCourse(course);
	}
	
	@DeleteMapping("{id}")
	public void deleteCourse(@PathVariable("id") Long idCourse) throws EntityNotFoundException {
		courseDao.deleteCourse(idCourse);
	}
}
