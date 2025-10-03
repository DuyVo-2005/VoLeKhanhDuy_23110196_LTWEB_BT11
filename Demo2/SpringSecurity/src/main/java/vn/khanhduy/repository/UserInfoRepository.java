package vn.khanhduy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.khanhduy.entities.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

	Optional<UserInfo> findByName(String name);
}
