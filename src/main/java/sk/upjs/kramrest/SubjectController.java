package sk.upjs.kramrest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kram.storage.DaoFactory;
import kram.storage.EntityNotFoundException;
import kram.storage.subject.Subject;
import kram.storage.subject.SubjectDao;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	private SubjectDao subjectDao = DaoFactory.INSTATNCE.getSubjectDao();

	@GetMapping()
	private List<Subject> getAllSubjects() {
		return subjectDao.getAll();
	}
	
	@GetMapping("/{idSubject}")
	public Subject getById(@PathVariable("idSubject") long idSubject) throws EntityNotFoundException {
		return subjectDao.getById(idSubject);
		
	}
	
	@GetMapping("/{idUser}")
	public List<Subject> getAllForUser(@PathVariable("idUser") long idUser) throws EntityNotFoundException {
		return subjectDao.getAllForUser(idUser);
		
	}
	
	@GetMapping("/{subString}")
	public List<Subject> getAllForUser(@PathVariable("subString") String subString) throws EntityNotFoundException {
		return subjectDao.getBySubstring(subString);
		
	}
	
	@PostMapping()
	public Subject saveSubject(@RequestBody Subject subject) throws EntityNotFoundException {
		return subjectDao.saveSubject(subject);
	}
	
	@DeleteMapping("{id}")
	public Subject deleteSubject(@PathVariable("id") Long idSubject) throws EntityNotFoundException {
		return subjectDao.deleteSubject(idSubject);
	}
}
