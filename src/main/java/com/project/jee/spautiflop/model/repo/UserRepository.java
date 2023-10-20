package com.project.jee.spautiflop.model.repo;

import com.project.jee.spautiflop.model.LocalUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<LocalUser, Long> {

}
