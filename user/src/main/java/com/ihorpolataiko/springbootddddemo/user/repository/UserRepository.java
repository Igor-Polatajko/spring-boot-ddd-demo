package com.ihorpolataiko.springbootddddemo.user.repository;

import com.ihorpolataiko.springbootddddemo.user.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    List<User> findAll();

}
