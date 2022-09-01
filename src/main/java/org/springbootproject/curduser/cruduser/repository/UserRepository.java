package org.springbootproject.curduser.cruduser.repository;

import org.springbootproject.curduser.cruduser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
