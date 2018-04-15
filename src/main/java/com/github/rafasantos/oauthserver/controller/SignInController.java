package com.github.rafasantos.oauthserver.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SignInController {

	@GetMapping("sign-in")
	public String signInPage(Model model,
			@RequestParam(value="state") String state,
			@RequestParam(value="redirect_uri") String redirectUri) {
		System.out.println("Sign-in request with state: " + state + "; redirect_uri: " + redirectUri);
		model.addAttribute("state", state);
		model.addAttribute("redirect_uri", redirectUri);
		return "sign-in";
	}
	
	@GetMapping("redirect")
	public String redirectSignIn(Model model,
			@RequestParam(value="username") String username, 
			@RequestParam(value="password") String password, 
			@RequestParam(value="redirect_uri") String redirectUri,
			@RequestParam(value="state") String state) throws URISyntaxException {
		String parsedUsername = username.toLowerCase();
		if (parsedUsername.startsWith("a")) {
			parsedUsername = "alice";
		} else if (parsedUsername.startsWith("b")) {
			parsedUsername = "bob";
		} else if (parsedUsername.startsWith("c")) {
			parsedUsername = "carol";
		} else if (parsedUsername.startsWith("d")) {
			parsedUsername = "dylan";
		} else if (parsedUsername.startsWith("e")) {
			parsedUsername = "elton";
		}
		
		if (parsedUsername.startsWith("alice") ||
			parsedUsername.startsWith("bob")   ||
			parsedUsername.startsWith("carol") ||
			parsedUsername.startsWith("dylan") ||
			parsedUsername.startsWith("elton")) {
			URI uri = new URI(redirectUri + "?state=" + state + "&code=" + username);
			System.out.println("Redirect request with username: " + username + "; password: " + password + "; redirect_uri: " + redirectUri + "; state: " + state);
			return "redirect:" + uri;			
		} else {
			model.addAttribute("errorMessage", "Username [" + username + "] is not registered.");
			return "error";
		}
	}
	
}
