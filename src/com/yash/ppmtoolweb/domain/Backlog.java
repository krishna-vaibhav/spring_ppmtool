package com.yash.ppmtoolweb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Backlog to add task to the project task table.
 * @author krishna.vaibhav
 *
 */
@Entity
@Table(name="backlogs")
public class Backlog {

	/**
	 * id of backlog 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/**
	 * task sequence of project task
	 */
	private String tSequence;
	/**
	 * identifier which identify project
	 */
	private String project_identifier;
	/**
	 * unquie id of project
	 */
	@OneToOne
	@JoinColumn(name="project_id")
	private Project project_id;
	
	@OneToMany(mappedBy="backlog_id")
	private List<ProjectTask> projectTask = new ArrayList<ProjectTask>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String gettSequence() {
		return tSequence;
	}
	public void settSequence(String tSequence) {
		this.tSequence = tSequence;
	}
	public String getProject_identifier() {
		return project_identifier;
	}
	public void setProject_identifier(String project_identifier) {
		this.project_identifier = project_identifier;
	}
	public Project getProject_id() {
		return project_id;
	}
	public void setProject_id(Project project_id) {
		this.project_id = project_id;
	}
	
	
	
	public List<ProjectTask> getProjectTask() {
		return projectTask;
	}
	public void setProjectTask(List<ProjectTask> projectTask) {
		this.projectTask = projectTask;
	}
	@Override
	public String toString() {
		return "Backlog [id=" + id + ", tSequence=" + tSequence + ", project_identifier=" + project_identifier
				+ ", project_id=" + project_id + "]";
	}
	
	
	
	
}
