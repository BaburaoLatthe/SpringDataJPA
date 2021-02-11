package com.jpa.springjpahibernateexample.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Viewer")
public class Viewer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nickName;

	@JsonManagedReference
	@ManyToMany(cascade = {
					        CascadeType.PERSIST,
					        CascadeType.MERGE
    })
	@JoinTable(name = "followed_viewer", 
				joinColumns = @JoinColumn(name = "viewer_id"), 
				inverseJoinColumns = @JoinColumn(name = "stream_id")
	)
	private List<Stream> followedStreams = new ArrayList<>();

	public Viewer() {
		super();
	}

	public Viewer(Long id, String nickName, List<Stream> followedStreams) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.followedStreams = followedStreams;
	}

//	Utility Methods for adding and removing
	public void addFollowedStream(Stream stream) {
		followedStreams.add(stream);
		stream.getFollowers().add(this);
	}

	public void removeFollowedStream(Stream stream) {
		followedStreams.remove(stream);
		stream.getFollowers().remove(this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public List<Stream> getFollowedStreams() {
		return followedStreams;
	}

	public void setFollowedStreams(List<Stream> followedStreams) {
		this.followedStreams = followedStreams;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((followedStreams == null) ? 0 : followedStreams.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viewer other = (Viewer) obj;
		if (followedStreams == null) {
			if (other.followedStreams != null)
				return false;
		} else if (!followedStreams.equals(other.followedStreams))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}

}
