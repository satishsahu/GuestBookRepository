package com.guestbook.repository;

import org.springframework.data.repository.CrudRepository;

import com.guestbook.model.Guest;

import java.util.List;

public interface GuestRepository<P> extends CrudRepository<Guest, Long> {
    List<Guest> findByFname(String name);
}
