package com.finartz.firebase.springfirebaseproject.repository;

import com.finartz.firebase.springfirebaseproject.entity.RssEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RssRepo extends JpaRepository<RssEntity, Long> {

}