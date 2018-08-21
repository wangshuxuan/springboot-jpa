package com.wsx.repository;

import com.wsx.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author wangshuxuan
 * @date 2018/8/20 10:01
 * User表操作接口
 */
@Repository
public interface UserRepositoty extends JpaRepository<User,Long> {

    @Query("select t from User t where t.name = :name")
    User findByUserName(@Param("name") String name);

}
