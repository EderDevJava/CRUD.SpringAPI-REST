package crud.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.api.rest.model.appUser;
import crud.api.rest.repository.UserRepository;

@RestController
@RequestMapping(value = "/appCadUser")
public class IndexController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/{Id}", produces = "application/json")
	public ResponseEntity<appUser> init(@PathVariable(value = "Id") Long Id) {

		Optional<appUser> appUser = userRepository.findById(Id);

		return new ResponseEntity<appUser>(appUser.get(), HttpStatus.OK);

	}

	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<appUser>> userall() {

		/*
		 * injentando o UserRepository é possivel usar qualquer metodo pronto que a
		 * interface disponibiliza
		 */
		List<appUser> list = (List<appUser>) userRepository.findAll();

		return new ResponseEntity<List<appUser>>(list, HttpStatus.OK);

	}

	@PostMapping(value = "/postUser", produces = "application/json")
	public ResponseEntity<appUser> postUser(@RequestBody appUser appUser) {

		for (int pos = 0; pos < appUser.getTelephones().size(); pos++) {
			appUser.getTelephones().get(pos).setPhoneUser(appUser);
		}

		appUser usersave = userRepository.save(appUser);

		return new ResponseEntity<appUser>(usersave, HttpStatus.OK);

	}

	@PutMapping(value = "/upUser", produces = "application/json")
	public ResponseEntity<appUser> update(@RequestBody appUser appUser) {

		/* incluir outra rotinas antes de atualizar */
		for (int pos = 0; pos < appUser.getTelephones().size(); pos++) {
			appUser.getTelephones().get(pos).setPhoneUser(appUser);
		}
		
		appUser usersave = userRepository.save(appUser);

		return new ResponseEntity<appUser>(usersave, HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteUser/{id}", produces = "application/text")
	public String deleuser(@PathVariable("id") Long id) {

		userRepository.deleteById(id);

		return "ok";

	}
}
