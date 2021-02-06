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
import kram.storage.question.Question;
import kram.storage.question.QuestionDao;

@RestController
@RequestMapping("/questions")
@CrossOrigin
public class QuestionController {
	
	
//	List<Question> getByTopicUserId(Long id, Long idUser) throws EntityNotFoundException, NullPointerException;
//	List<Question> getBySubjectUserId(Long id, Long idUser) throws EntityNotFoundException, NullPointerException;
//	List<Question> generateTestQuestions(int pocet, long idZamerania)
//			throws EntityNotFoundException, NullPointerException;
//	List<Question> getByTopicId(Long id) throws EntityNotFoundException, NullPointerException;
//	List<Question> getBySubjectId(Long id) throws EntityNotFoundException, NullPointerException;
	
	private QuestionDao questionDao = DaoFactory.INSTATNCE.getQuestionDao();
	
	@GetMapping()
	private List<Question> getAllusers() {
		return questionDao.getAll();
	}
	
	@GetMapping("{idQuestion}")
	public Question getById(@PathVariable("idQuestion") long idQuestion) throws EntityNotFoundException {
		return questionDao.getById(idQuestion);
		
	}
	
	@GetMapping("/idUser/{idUser}")
	public List<Question> getAllByuser(@PathVariable("idUser") long idUser) throws EntityNotFoundException {
		return questionDao.getAllByUserId(idUser);
		
	}
		
	@PostMapping()
	public Question saveQuestion(@RequestBody Question question) throws EntityNotFoundException, NullPointerException {
		return questionDao.saveQuestion(question);
	}
	
	@DeleteMapping("{id}")
	public void deleteCourse(@PathVariable("id") Long idQuestion) throws EntityNotFoundException {
		questionDao.deleteQuestion(idQuestion);
	}

}
