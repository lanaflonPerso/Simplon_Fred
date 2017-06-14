package co.simplon.videomanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.videomanager.dao.ActorDAO;
import co.simplon.videomanager.domain.Actor;

@Service
public class ActorService {

	@Autowired
	private ActorDAO dao;

	public List<Actor> listActors(String search) throws Exception {
		return dao.listActors(search);
	}

	public Actor getActor(Long id) throws Exception {
		return dao.getActor(id);
	}

	public Actor insertActor(Actor actor) throws Exception {
		dao.insertActor(actor);
		return actor;
	}

	public void updateActor(Actor actor) throws Exception {
		dao.updateActor(actor);
	}

	public void deleteActor(Long id) throws Exception {
		dao.deleteActor(id);
	}

}
