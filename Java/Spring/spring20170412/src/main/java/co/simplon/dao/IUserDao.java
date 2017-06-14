package co.simplon.dao;

import co.simplon.domain.UserDom;

public interface IUserDao {
	public UserDom getUser(long id) throws Exception;
	public void addUser(UserDom user) throws Exception;
	public void majUser(UserDom user) throws Exception;
	public void delUser(long id) throws Exception;
}
