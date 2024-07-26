package com.box.small.user.movie;

public class MovieDto {
	
	private int mo_no;
	private int cat_no;
	private String mo_name;
	private String mo_releaseDate;
	private String mo_endDate;
	private int mo_runningTime;
	private String mo_plot;
	private String mo_status;
	private String mo_director;
	private String mo_mainActor;
	private String mo_rating;
	private String mo_photo;
	@Override
	public String toString() {
		return "Movie [mo_no=" + mo_no + ", cat_no=" + cat_no + ", mo_name=" + mo_name + ", mo_releaseDate="
				+ mo_releaseDate + ", mo_endDate=" + mo_endDate + ", mo_runningTime=" + mo_runningTime + ", mo_plot="
				+ mo_plot + ", mo_status=" + mo_status + ", mo_director=" + mo_director + ", mo_mainActor="
				+ mo_mainActor + ", mo_rating=" + mo_rating + ", mo_photo=" + mo_photo + "]";
	}
	public MovieDto(int mo_no, int cat_no, String mo_name, String mo_releaseDate, String mo_endDate, int mo_runningTime,
			String mo_plot, String mo_status, String mo_director, String mo_mainActor, String mo_rating,
			String mo_photo) {
		super();
		this.mo_no = mo_no;
		this.cat_no = cat_no;
		this.mo_name = mo_name;
		this.mo_releaseDate = mo_releaseDate;
		this.mo_endDate = mo_endDate;
		this.mo_runningTime = mo_runningTime;
		this.mo_plot = mo_plot;
		this.mo_status = mo_status;
		this.mo_director = mo_director;
		this.mo_mainActor = mo_mainActor;
		this.mo_rating = mo_rating;
		this.mo_photo = mo_photo;
	}
	
	public MovieDto(int mo_no, int cat_no, String mo_name, String mo_releaseDate, int mo_runningTime, String mo_status,
			String mo_director, String mo_mainActor, String mo_rating, String mo_photo) {
		super();
		this.mo_no = mo_no;
		this.cat_no = cat_no;
		this.mo_name = mo_name;
		this.mo_releaseDate = mo_releaseDate;
		this.mo_runningTime = mo_runningTime;
		this.mo_status = mo_status;
		this.mo_director = mo_director;
		this.mo_mainActor = mo_mainActor;
		this.mo_rating = mo_rating;
		this.mo_photo = mo_photo;
	}
	public MovieDto() {
		super();
	}
	public int getMo_no() {
		return mo_no;
	}
	public void setMo_no(int mo_no) {
		this.mo_no = mo_no;
	}
	public int getCat_no() {
		return cat_no;
	}
	public void setCat_no(int cat_no) {
		this.cat_no = cat_no;
	}
	public String getMo_name() {
		return mo_name;
	}
	public void setMo_name(String mo_name) {
		this.mo_name = mo_name;
	}
	public String getMo_releaseDate() {
		return mo_releaseDate;
	}
	public void setMo_releaseDate(String mo_releaseDate) {
		this.mo_releaseDate = mo_releaseDate;
	}
	public String getMo_endDate() {
		return mo_endDate;
	}
	public void setMo_endDate(String mo_endDate) {
		  this.mo_endDate = (mo_endDate != null && mo_endDate.isEmpty()) ? null : mo_endDate;
	}
	public int getMo_runningTime() {
		return mo_runningTime;
	}
	public void setMo_runningTime(int mo_runningTime) {
		this.mo_runningTime = mo_runningTime;
	}
	public String getMo_plot() {
		return mo_plot;
	}
	public void setMo_plot(String mo_plot) {
		this.mo_plot = mo_plot;
	}
	public String getMo_status() {
		return mo_status;
	}
	public void setMo_status(String mo_status) {
		this.mo_status = mo_status;
	}
	public String getMo_director() {
		return mo_director;
	}
	public void setMo_director(String mo_director) {
		this.mo_director = mo_director;
	}
	public String getMo_mainActor() {
		return mo_mainActor;
	}
	public void setMo_mainActor(String mo_mainActor) {
		this.mo_mainActor = mo_mainActor;
	}
	public String getMo_rating() {
		return mo_rating;
	}
	public void setMo_rating(String mo_rating) {
		this.mo_rating = mo_rating;
	}
	public String getMo_photo() {
		return mo_photo;
	}
	public void setMo_photo(String mo_photo) {
		this.mo_photo = mo_photo;
	}
	
}
