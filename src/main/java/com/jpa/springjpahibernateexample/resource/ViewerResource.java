package com.jpa.springjpahibernateexample.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.springjpahibernateexample.model.Stream;
import com.jpa.springjpahibernateexample.model.Viewer;
import com.jpa.springjpahibernateexample.repository.ViewerRepository;

@RestController
@RequestMapping(path = "/rest/viewer/streams")
public class ViewerResource {

	@Autowired
	private ViewerRepository viewerRepository;

	@RequestMapping(path = "/all/{name}/{nickname}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Viewer> getAllViewers(@PathVariable(name = "name") String name,
			@PathVariable(name = "nickname") String nickName) {

		Viewer viewer = new Viewer();
		viewer.setNickName(nickName);
		Stream stream = new Stream();
		stream.setName(name);

		viewer.addFollowedStream(stream);

		viewerRepository.save(viewer);

		return viewerRepository.findAll();
	}

}
