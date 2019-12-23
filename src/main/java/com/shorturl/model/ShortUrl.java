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
@Table(name = "shorturl")
public class ShortUrl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shorturl_id")
	private Long shorturlId;

	@Column(name = "shorturl_code")
	private String shorturlCode;

	@Column(name = "shorturl_originlurl")
	private String shorturlOriginalUrl;

	@Column(name = "shorturl_date")
	private Date shorturlDate;

	@Column(name = "shorturl_validdate")
	private Date shorturlValiddate;

	@Column(name = "shorturl_hitcount")
	private int shorturlHitcount;

	// ------------------------

	public Long getShorturlId() {
		return shorturlId;
	}

	public void setShorturlId(Long shorturlId) {
		this.shorturlId = shorturlId;
	}

	public String getShorturlCode() {
		return shorturlCode;
	}

	public void setShorturlCode(String shorturlCode) {
		this.shorturlCode = shorturlCode;
	}

	public String getShorturlOriginalUrl() {
		return shorturlOriginalUrl;
	}

	public void setShorturlOriginalUrl(String shorturlOriginalUrl) {
		this.shorturlOriginalUrl = shorturlOriginalUrl;
	}

	public Date getShorturlDate() {
		return shorturlDate;
	}

	public void setShorturlDate(Date shorturlDate) {
		this.shorturlDate = shorturlDate;
	}

	public Date getShorturlValiddate() {
		return shorturlValiddate;
	}

	public void setShorturlValiddate(Date shorturlValiddate) {
		this.shorturlValiddate = shorturlValiddate;
	}

	public int getShorturlHitcount() {
		return shorturlHitcount;
	}

	public void setShorturlHitcount(int shorturlHitcount) {
		this.shorturlHitcount = shorturlHitcount;
	}

}
