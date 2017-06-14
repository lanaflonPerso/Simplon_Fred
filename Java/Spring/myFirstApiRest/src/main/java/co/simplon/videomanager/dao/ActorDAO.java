package co.simplon.videomanager.dao;

import java.util.List;

import co.simplon.videomanager.domain.Actor;

public interface ActorDAO {

	public List<Actor> listActors(String search) throws Exception;

	public Actor getActor(Long id) throws Exception;

	public void insertActor(Actor actor) throws Exception;

	public void updateActor(Actor actor) throws Exception;
	
	public void deleteActor(Long id) throws Exception;

}
