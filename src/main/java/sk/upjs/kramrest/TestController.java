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
import kram.storage.test.KramTest;
import kram.storage.test.TestDao;


@RestController
@RequestMapping("/tests")
@CrossOrigin
public class TestController {
	
//	KramTest saveTestToCourse(KramTest kramTest, long idCourse) throws EntityNotFoundException;

//	List<KramTest> getAllInfo(long userId) throws EntityNotFoundException;
//	List<KramTest> getAllBySubjectId(Long id) throws EntityNotFoundException;
//	List<KramTest> getAllByCourseId(Long id) throws EntityNotFoundException;
//	List<KramTest> getAllByTopicId(Long id) throws EntityNotFoundException;
//	List<KramTest> getAllBySubjectUserId(Long id, Long userId) throws EntityNotFoundException;
//	List<KramTest> getAllByTopicUserId(Long id, Long userId) throws EntityNotFoundException;
//	List<KramTest> getAllByCourseTeacherId(Long id, Long idTeacher) throws EntityNotFoundException;
//	List<KramTest> getAllByCourseTeacherUserId(Long id, Long idTeacher, Long idUser) throws EntityNotFoundException;
//	List<KramTest> getAllInfoByCourse(long idUser, long idCourse) throws EntityNotFoundException;

	private TestDao testDao = DaoFactory.INSTATNCE.getTestDao();
	
	@GetMapping()
	private List<KramTest> getAllTests() {
		return testDao.getAll();
	}
				
	@PostMapping()
	public KramTest saveTest(@RequestBody KramTest question) throws EntityNotFoundException, NullPointerException {
		return testDao.saveTest(question);
	}
	
	@DeleteMapping("{id}")
	public KramTest deleteTest(@PathVariable("id") Long idTest) throws EntityNotFoundException {
		return testDao.deleteTest(idTest);
	}
}
