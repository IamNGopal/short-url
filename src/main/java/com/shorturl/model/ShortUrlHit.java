package com.shorturl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shorturl_hit")
public class ShortUrlHit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hit_id")
	private Long hitId;

	@Column(name = "hit_shorturl_id")
	private Long hitShorturlId;

	@Column(name = "hit_ip")
	private String hitIp;

	@Column(name = "hit_date")
	private Date hitDate;

	// ------------------
	public Long getHitId() {
		return hitId;
	}

	public void setHitId(Long hitId) {
		this.hitId = hitId;
	}

	public Long getHitShorturlId() {
		return hitShorturlId;
	}

	public void setHitShorturlId(Long hitShorturlId) {
		this.hitShorturlId = hitShorturlId;
	}

	public String getHitIp() {
		return hitIp;
	}

	public void setHitIp(String hitIp) {
		this.hitIp = hitIp;
	}

	public Date getHitDate() {
		return hitDate;
	}

	public void setHitDate(Date hitDate) {
		this.hitDate = hitDate;
	}

}
