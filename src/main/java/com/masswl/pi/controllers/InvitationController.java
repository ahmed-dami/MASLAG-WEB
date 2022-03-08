package com.masswl.pi.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masswl.pi.entities.Invitation;
import com.masswl.pi.repository.InvitationRepository;
import com.masswl.pi.repository.UserRepository;
import com.masswl.pi.services.InvitationService;

@RestController
@RequestMapping({"/inv" })
@CrossOrigin(origins = "*")
public class InvitationController {

	private final UserRepository userRepository;
	private final InvitationRepository invitationRepository;

	@Autowired
	public InvitationController(UserRepository userRepository, InvitationRepository invitationRepository) {
		this.userRepository = userRepository;
		this.invitationRepository = invitationRepository;
	}
	
	@Autowired
	InvitationService invitationService;

	@GetMapping("/list")
	public List<Invitation> getAllInv() {
		return invitationService.retrieveAllInvitations() ;
	}

	@GetMapping("/{invId}")
	public Invitation retrieveInvitationById(@PathVariable(value = "invId") Long idInv) {
		return invitationService.retrieveInvitationById(idInv) ;
	}
	
	
	@PostMapping("/add/{userId}")
	Invitation createInv(@PathVariable(value = "userId") Long userId, @Valid @RequestBody Invitation invitation) {
		return userRepository.findById(userId).map(user -> {
			invitation.setUser(user);
			return invitationRepository.save(invitation);
		}).orElseThrow(() -> new IllegalArgumentException("userId" + userId + " not found"));
	}
	

}
