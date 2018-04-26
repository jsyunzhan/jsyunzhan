package domain.Test.dao;

import domain.Test.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Mark.chen on 2018/04/26.
 */
@Repository
public interface UserDao {

    UserEntity getUser();
}
