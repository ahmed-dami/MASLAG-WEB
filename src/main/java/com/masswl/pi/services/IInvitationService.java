package com.masswl.pi.services;

import java.util.List;

import com.masswl.pi.entities.Invitation;

public interface IInvitationService {

	
	Invitation addInvitation (Invitation invitation) ;
	List<Invitation> retrieveAllInvitations();
	Invitation retrieveInvitationById(long idInv);
}
