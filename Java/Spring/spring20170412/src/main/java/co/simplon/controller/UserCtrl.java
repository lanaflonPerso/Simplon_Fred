package co.simplon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.domain.UserDom;
import co.simplon.service.UserSrc;


@RestController
@RequestMapping("/user")
public class UserCtrl {

	@Autowired
	UserSrc userS;

//	@RequestMapping(method = RequestMethod.GET)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") Long id) throws Exception {
		UserDom userD = null;
		userD = userS.getUser(id);
		if (userD == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(userD);
	}
}
