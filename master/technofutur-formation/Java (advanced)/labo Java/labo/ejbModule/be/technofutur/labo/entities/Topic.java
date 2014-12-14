package be.technofutur.labo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Topic")
public class Topic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
	private int id;
	
	@Column(name="title", nullable = false, length = 255)
    private String title;
	
	@Column(name="creationTime", nullable = false)
	private Date creationTime;
	
	@Column(name="lastPostTime", nullable = false)
	private Date lastPostTime;
	
	@Column(name="totalViews", nullable = true)
	private int totalViews;
	
	@Column(name="totalReplies", nullable = true)
	private int totalReplies;
	
	@Column(name="createdBy", nullable = false)
	private String createdBy;
	
	@Column(name="lastPostBy", nullable = false)
	private String lastPostBy;
	
	@Column(name = "forumId", nullable = false)
	private int forumId;
	
	public Topic() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastPostTime() {
		return lastPostTime;
	}

	public void setLastPostTime(Date lastPostTime) {
		this.lastPostTime = lastPostTime;
	}

	public int getTotalViews() {
		return totalViews;
	}

	public void setTotalViews(int totalViews) {
		this.totalViews = totalViews;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setLastPostBy(String lastPostBy) {
		this.lastPostBy = lastPostBy;
	}

	public int getTotalReplies() {
		return totalReplies;
	}

	public void setTotalReplies(int totalReplies) {
		this.totalReplies = totalReplies;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy.getUsername();
	}

	public String getLastPostBy() {
		return lastPostBy;
	}

	public void setLastPostBy(User lastPostBy) {
		this.lastPostBy = lastPostBy.getUsername();
	}

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
}
