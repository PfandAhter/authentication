package intern.freedesk.authentication.repository;

import intern.freedesk.authentication.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.userId = ?1")
    User findByUserId (String userId);

}
