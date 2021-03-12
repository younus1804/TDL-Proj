package com.example.demo.dto;

import java.util.List;

import com.example.demo.data.model.TDL;

public class UserDTO {

	private int userid;
	private String name;
	private List<TDL> tdl;
	
	public UserDTO() {
	}

	public UserDTO(int userid, String name, List<TDL> tdl) {
		super();
		this.userid = userid;
		this.name = name;
		this.tdl = tdl;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TDL> getTdl() {
		return tdl;
	}

	public void setTdl(List<TDL> tdl) {
		this.tdl = tdl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tdl == null) ? 0 : tdl.hashCode());
		result = prime * result + userid;
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
		UserDTO other = (UserDTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tdl == null) {
			if (other.tdl != null)
				return false;
		} else if (!tdl.equals(other.tdl))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	
	
	
}
