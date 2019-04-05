package com.guestbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guestbook.model.Guest;
import com.guestbook.repository.GuestRepository;

@Service
public class GuestService {

	@Autowired
	GuestRepository<Guest> guestRepository;

	@Transactional
	public List<Guest> getAllGuests() {
		return (List<Guest>) guestRepository.findAll();
	}

	@Transactional
	public List<Guest> findByName(String name) {
		return guestRepository.findByFname(name);
	}

	@Transactional
	public void deleteGuest(Long GuestId) {
		guestRepository.deleteById(GuestId);
	}

	@Transactional
	public boolean addGuest(com.guestbook.model.Guest Guest) {
		return guestRepository.save(Guest) != null;
	}

	@Transactional
	public boolean updateGuest(Guest Guest) {
		return guestRepository.save(Guest) != null;
	}

	public Optional<Guest> findById(Long id) {
		return guestRepository.findById(id);
	}
}
