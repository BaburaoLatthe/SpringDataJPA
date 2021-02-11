package com.jpa.springjpahibernateexample.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Stream")
public class Stream {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@JsonBackReference
	@ManyToMany(mappedBy = "followedStreams")
	private List<Viewer> followers = new ArrayList<>();

	public Stream() {
		super();
	}

	public Stream(Long id, String name, List<Viewer> followers) {
		super();
		this.id = id;
		this.name = name;
		this.followers = followers;
	}
	
	public void addViewer(Viewer viewer) {
		followers.add(viewer);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Viewer> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Viewer> followers) {
		this.followers = followers;
	}
	
	
}
