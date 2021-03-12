package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.model.TDL;
import com.example.demo.dto.TDLDTO;
import com.example.demo.service.TDLService;


@RestController
@RequestMapping(path = "/tdl")
@CrossOrigin
public class TDLController {

	private TDLService tdlService;
	
	@Autowired
	public TDLController(TDLService tdlService) {
		this.tdlService = tdlService;
	}
	
	@GetMapping
	public ResponseEntity<List<TDLDTO>> getAllTasks() {
		List<TDLDTO> data = tdlService.readAllTasks();
		return new ResponseEntity<List<TDLDTO>>(data, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TDLDTO> getTaskById(@PathVariable("id") Integer id) {
		TDLDTO tdl = tdlService.readById(id);
		return new ResponseEntity<TDLDTO>(tdl, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TDLDTO> createDuck(@Valid @RequestBody TDL tdl) {
		// A Duck is retrieved from the incoming request body (the conversion from json to duck is automatic)
		// - `@RequestBody Duck duck` makes this happen
		// - @Valid is used to employ our models validation on the incoming request
		
		TDLDTO newTDL = tdlService.createTDL(tdl);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newTDL.getId()));
	
		return new ResponseEntity<TDLDTO>(newTDL, headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TDLDTO> updateDuck(@PathVariable("id") int id,
										   @RequestBody TDL tdl) {
		TDLDTO updatedTDL = tdlService.updateTDL(id, tdl);
		
		return new ResponseEntity<TDLDTO>(updatedTDL, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteTDL(@PathVariable("id") int id) {		
		return new ResponseEntity<Boolean>(tdlService.deleteTDL(id), HttpStatus.OK);
	}
	
}
