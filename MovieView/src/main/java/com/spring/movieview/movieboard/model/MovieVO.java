package com.spring.movieview.movieboard.model;

import java.util.Date;

public class MovieVO {
	
	private Integer movieNo;
	private String title;
	private String genre;
	private String nation;
	private String openDate;
	private String director;
	private String actor;
	private String synoposis;
	private Integer score;
	
	public Integer getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(Integer movieNo) {
		this.movieNo = movieNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getSynoposis() {
		return synoposis;
	}
	public void setSynoposis(String synoposis) {
		this.synoposis = synoposis;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "MovieVO [movieNo=" + movieNo + ", title=" + title + ", genre=" + genre + ", nation=" + nation
				+ ", openDate=" + openDate + ", director=" + director + ", actor=" + actor + ", synoposis=" + synoposis
				+ ", score=" + score + "]";
	}
	
	
	
	
}
