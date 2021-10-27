package com.kosta.model;

import java.util.List;

public class JobService {
	JobDAO dao = new JobDAO();

	public List<JobVo> selectAll() {
		return dao.selectAll();
	}

}
