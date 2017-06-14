package co.simplon.dao;

import org.springframework.data.repository.CrudRepository;

import co.simplon.domain.Role;

public interface RoleDao extends CrudRepository<Role, Long> {

}
