package com.yash.ppmtoolweb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.yash.ppmtoolweb.util.DBUtil;


/**
 * This project is working as data traveller among different layer.
 * @author krishna.vaibhav
 *
 */
@Entity
@Table(name="projects")
public class Project implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * project id used to uniquely identify
     */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/**
	 * name of project to be created
	 */
	private String project_name;
	/**
	 * project_identifier to be used for creating task and backlog
	 */
	@Column(unique=true,length=30)
	private String project_identifier;
	/**
	 * short description of project
	 */
	private String description;
	/**
	 * date at which project is created
	 */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date start_date;
	/**
	 * date at which project is completed
	 */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date end_date;
	/**
	 * time at which project is created
	 */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date created_At;
	/**
	 * time at which project is updated
	 */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date updated_At;
	
	@OneToOne(mappedBy="project_id")
	Backlog backlog;
	
	@OneToMany(mappedBy="project_identifier")
	private List<ProjectTask> projectTask = new ArrayList<ProjectTask>();
	
	public Project() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_identifier() {
		return project_identifier;
	}

	public void setProject_identifier(String project_identifier) {
		this.project_identifier = project_identifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

	public List<ProjectTask> getProjectTask() {
		return projectTask;
	}

	public void setProjectTask(List<ProjectTask> projectTask) {
		this.projectTask = projectTask;
	}

	@Override
	public String toString() {
		return "Project [project_name=" + project_name + ", project_identifier=" + project_identifier + ", description="
				+ description + "]";
	}

	
	/*@Override
	public String toString() {
		return "Project [id=" + id + ", project_name=" + project_name + ", project_identifier=" + project_identifier
				+ ", description=" + description + ", start_date=" + DBUtil.formatDate(start_date) + ", end_date=" + DBUtil.formatDate(end_date)
				+ ", created_At=" + DBUtil.formatDate(created_At) + ", updated_At=" + DBUtil.formatDate(updated_At) + "]";
	}*/
	
	
	

	
	
	
	
	
}
