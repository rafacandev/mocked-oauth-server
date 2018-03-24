package com.github.rafasantos.oauthserver.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/oauth")
public class SignInController {

	@GetMapping("/sign-in")
	public String signInPage(Model model,
			@RequestParam(value="state") String state,
			@RequestParam(value="redirect_uri") String redirectUri) {
		model.addAttribute("state", state);
		model.addAttribute("redirect_uri", redirectUri);
		return "sign-in";
	}
	
	@GetMapping("/redirect")
	public String redirectSignIn(Model model,
			@RequestParam(value="username") String username, 
			@RequestParam(value="password") String password, 
			@RequestParam(value="redirect_uri") String redirectUri,
			@RequestParam(value="state") String state) throws URISyntaxException {
		if (username.startsWith("alice") ||
			username.startsWith("bob")   ||
			username.startsWith("carol") ||
			username.startsWith("dylan") ||
			username.startsWith("elton")) {
			URI uri = new URI(redirectUri + "?state=" + state + "&code=" + username);
			return "redirect:" + uri;			
		} else {
			model.addAttribute("errorMessage", "Username [" + username + "] is not registered.");
			return "error";
		}
	}
	
}
