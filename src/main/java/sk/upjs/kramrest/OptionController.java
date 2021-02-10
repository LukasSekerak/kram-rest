package sk.upjs.kramrest;

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
import kram.storage.option.Option;
import kram.storage.option.OptionDao;

@RestController
@RequestMapping("/options")
@CrossOrigin
public class OptionController {
	
//	Map<Option,Boolean> deleteOptions(Map<Option,Boolean> options) throws EntityNotFoundException;
	
	private OptionDao optionDao = DaoFactory.INSTATNCE.getOptionDao();

	@GetMapping("{idOption}")
	public Option getById(@PathVariable("idOption") long idOption) throws EntityNotFoundException {
		return optionDao.getById(idOption);
		
	}
	
	@PostMapping()
	public Option saveOption(@RequestBody Option option) throws EntityNotFoundException {
		return optionDao.saveOption(option);
	}
	
	@DeleteMapping("{id}")
	public Option deleteOption(@PathVariable("id") Long idOption) throws EntityNotFoundException {
		return optionDao.deleteOption(idOption);
	}
}
