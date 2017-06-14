package co.simplon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.dao.UserDao;
import co.simplon.domain.UserDom;

@Service
public class UserSrc {

	@Autowired
	private UserDao dao;

	public UserDom getUser(Long id) throws Exception {
		return dao.getUser(id);
	}

	public UserDom addUser(UserDom user) throws Exception {
		dao.addUser(user);
		return user;
	}

	public void majUser(UserDom user) throws Exception {
		dao.majUser(user);
	}

	public void delUser(Long id) throws Exception {
		dao.delUser(id);
	}
	
}
