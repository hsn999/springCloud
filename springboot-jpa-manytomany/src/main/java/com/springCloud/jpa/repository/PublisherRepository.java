package com.springCloud.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springCloud.jpa.domain.Publisher;


public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
