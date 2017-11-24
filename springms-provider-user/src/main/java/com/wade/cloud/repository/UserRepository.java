package com.wade.cloud.repository;

import com.wade.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tingyun on 2017/11/24.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
