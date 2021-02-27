package com.gfg.lecture1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "returns user object")
public class User {

	@ApiModelProperty(notes = "id of user")
	private int id;

	private String name;

}
