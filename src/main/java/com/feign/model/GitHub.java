package com.feign.model;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface GitHub {

	@RequestLine("GET /repos/{owner}/{repo}/contributors")
	List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

}
