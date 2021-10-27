package com.kosta.model;

public class JobVo {
	String job_id;
	String job_title;

	public JobVo() {
	}

	public JobVo(String job_id, String job_title) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JobVo [job_id=").append(job_id).append(", job_title=").append(job_title).append("]");
		return builder.toString();
	}

}
