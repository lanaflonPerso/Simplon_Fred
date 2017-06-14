package co.simplon.videomanager.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.simplon.videomanager.domain.Role;
import co.simplon.videomanager.domain.RolePK;

public interface RoleRepository extends CrudRepository<Role, RolePK> {
	
	@Query(value = "select * from film_actor where film_id = ?1", nativeQuery = true)
	public Iterable<Role> findByFilm(Long id);

	@Query(value = "select * from film_actor where actor_id = ?1", nativeQuery = true)
	public Iterable<Role> findByActor(Long id);

	@Query(value = "select * from film_actor where actor_id = ?1 and film_id = ?2", nativeQuery = true)
	public Role findOne(Long idActor, Long idFilm);

	@Modifying
	@Transactional
	@Query(value = "delete from film_actor where actor_id = ?1 and film_id = ?2", nativeQuery = true)
	public void delete(Long idActor, Long idFilm);

}