package com.example.userprovider.request.repository;

import com.example.userprovider.request.domain.RequestData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestDataJpaRepository extends JpaRepository<RequestData, Long> {
    Optional<RequestData> findByLogin(String login);
}
