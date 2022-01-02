package com.movie.Library.BaseReqEnt;

import javax.validation.constraints.NotEmpty;

public class CategorieBaseReq extends BaseRequest {

	@NotEmpty
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
