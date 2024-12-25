package com.kubemachine.engine.api.identity.repository;

import com.kubemachine.engine.api.identity.model.Identity;
import com.kubemachine.engine.api.generic.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "identity", path = "identity")
public interface IdentityRepository extends BaseRepository<Identity, UUID> {
    List<Identity> findAllByIdentityFirstNameContainsIgnoreCaseOrIdentityLastNameContainsIgnoreCase(String identityName, String identityUrl);
}