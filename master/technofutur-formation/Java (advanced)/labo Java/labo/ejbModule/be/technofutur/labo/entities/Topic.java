package be.technofutur.labo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	@Column(name="creation_time", nullable = false)
	private Date creationTime;
	
	@Column(name="last_post_time", nullable = false)
	private Date lastPostTime;
	
	@Column(name="total_view", nullable = true)
	private int totalView;
	
	@Column(name="total_replies", nullable = true)
	private int totalReplies;
	
	@Column(name="created_by", nullable = false)
	private User createdBy;
	
	@Column(name="last_post_by", nullable = false)
	private User lastPostBy;

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

	public int getTotalView() {
		return totalView;
	}

	public void setTotalView(int totalView) {
		this.totalView = totalView;
	}

	public int getTotalReplies() {
		return totalReplies;
	}

	public void setTotalReplies(int totalReplies) {
		this.totalReplies = totalReplies;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getLastPostBy() {
		return lastPostBy;
	}

	public void setLastPostBy(User lastPostBy) {
		this.lastPostBy = lastPostBy;
	}
}
