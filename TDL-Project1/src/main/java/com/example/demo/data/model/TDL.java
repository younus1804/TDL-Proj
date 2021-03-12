package com.example.demo.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tdl")
public class TDL {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tdl_id")
	private int id;
	
	@NotNull
	private String task;
	
	@NotNull
	private String date;
	
	@Min(1)
	@Max(5)
	@Column(name = "priority")
	private int priority;
	
	private TaskStatus taskStatus;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_user_id")
	private User user; 
	
	public TDL() {

	}

	

	public TDL(int id, String task, String date, int priority,
			TaskStatus taskStatus) {
		super();
		this.id = id;
		this.task = task;
		this.date = date;
		this.priority = priority;
		this.taskStatus = taskStatus;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}



	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + priority;
		result = prime * result + ((task == null) ? 0 : task.hashCode());
		result = prime * result + ((taskStatus == null) ? 0 : taskStatus.hashCode());
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
		TDL other = (TDL) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (priority != other.priority)
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		if (taskStatus != other.taskStatus)
			return false;
		return true;
	}
}
