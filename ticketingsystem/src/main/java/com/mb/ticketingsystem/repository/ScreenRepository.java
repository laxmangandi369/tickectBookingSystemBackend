package com.mb.ticketingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.ticketingsystem.entity.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,Long> {

}
