package com.masswl.pi.repository;
import org.springframework.data.repository.CrudRepository;
import com.masswl.pi.entities.Invitation;

public interface InvitationRepository extends CrudRepository<Invitation, Long> {

}
