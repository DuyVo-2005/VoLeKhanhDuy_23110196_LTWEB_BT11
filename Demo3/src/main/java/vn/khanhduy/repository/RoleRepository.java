package vn.khanhduy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.khanhduy.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("select r from Role r where r.name = :name")
	public Role getUserByName(@Param("name") String name);
	Optional<Role> findByName(String name);
}
