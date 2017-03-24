package com.feign;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.feign.model.Contributor;
import com.feign.model.GitHub;

import feign.Feign;
import feign.Feign.Builder;
import feign.gson.GsonDecoder;

@SpringBootApplication
public class FeignClientApplication {

	private static final String GITHUB_API_URL = "https://api.github.com";

	public static void main(String[] args) {

		List<Contributor> contributors = listGithubContributors("rodrigocprates", "nodeschool");
		
		contributors.forEach(System.out::println); // allowed only running on java 8
		
		// System.out.println(contributors); // :-)

	}

	/**
	 * Receives the owner and github repository name as parameters to list contributors.
	 * @param owner Github owner
	 * @param repository Repository name
	 * @return a list of contributors
	 */
	private static List<Contributor> listGithubContributors(String owner, String repository) {
		Builder feignBuilder = Feign.builder();

		Builder decoder = feignBuilder.decoder(new GsonDecoder());

		// mount and proxy github api url + GitHub mapped repository
		GitHub github = decoder.target(GitHub.class, GITHUB_API_URL);

		// fetch and print a list of the contributors to this library.
		List<Contributor> contributors = github.contributors(owner, repository);
		
		return contributors;
	}

}
