package com.masswl.pi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masswl.pi.entities.Invitation;
import com.masswl.pi.repository.InvitationRepository;
import com.masswl.pi.repository.UserRepository;


@Service
public class InvitationService implements IInvitationService{
	
	@Autowired
	InvitationRepository invitationRepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Invitation addInvitation(Invitation invitation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Invitation> retrieveAllInvitations() {
		return (List<Invitation>) invitationRepository.findAll();
	}

	@Override
	public Invitation retrieveInvitationById(long idInv) {
		return invitationRepository.findById(idInv).get();
	}



}
