package com.VegCity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.VegCity.model.User;
import com.VegCity.model.entity.RecipeEntity;
import com.VegCity.model.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "Select * From Users u Where u.username =?1 OR u.email=?2", nativeQuery = true)
    Optional<List<UserEntity>> findByUsernameOrEmail(String userName, String mail);

    Optional<UserEntity> findByUsername(String username);

    void save(RecipeEntity recipeEntity);

    Optional<List<RecipeEntity>> findByUsername(User user);

}
