package com.guestbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guestbook.model.Guest;
import com.guestbook.service.GuestService;

@RestController
public class GuestController {

	@Autowired
	GuestService guestService;

	@RequestMapping(value = "/guest/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Guest> getAllUsers(@PathVariable Long id) {
		return guestService.findById(id);
	}

	@RequestMapping(value = "/guestByName/{name}", method = RequestMethod.GET)
	public List<Guest> getGuesteByName(@PathVariable String name) {
		return guestService.findByName(name);
	}

	@RequestMapping(value = "/guest", method = RequestMethod.GET)
	public List<Guest> getAll() {
		System.out.println("Inside GuestController");
		return guestService.getAllGuests();
	}

	@RequestMapping(value = "/guest/{id}", method = RequestMethod.DELETE)
	public HttpStatus deletePersnone(@PathVariable Long id) {
		guestService.deleteGuest(id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/guest", method = RequestMethod.POST)
	public HttpStatus insertGueste(@RequestBody Guest guest) {
		return guestService.addGuest(guest) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/guest", method = RequestMethod.PUT)
	public HttpStatus updateGuest(@RequestBody Guest guest) {
		return guestService.updateGuest(guest) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
}
