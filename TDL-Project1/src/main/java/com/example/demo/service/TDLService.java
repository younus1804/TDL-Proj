package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.model.TDL;
import com.example.demo.data.repository.TDLRepository;
import com.example.demo.dto.TDLDTO;
import com.example.demo.exceptions.TaskNotFoundException;
import com.example.demo.mapper.TDLMapper;


@Service
public class TDLService {

	private TDLRepository tdlRepository;
	private TDLMapper tdlMapper;
	
	@Autowired
	public TDLService(TDLRepository tdlRepository, TDLMapper tdlMapper) {
		this.tdlRepository = tdlRepository;
		this.tdlMapper = tdlMapper;
	}
	
	public List<TDLDTO> readAllTasks() {
		List<TDL> tdls = tdlRepository.findAll();
		List<TDLDTO> tdlDTOs = new ArrayList<TDLDTO>();
		
		tdls.forEach(tdl -> tdlDTOs.add(tdlMapper.mapToDTO(tdl)));

		return tdlDTOs;
	}
	
	public TDLDTO readById(Integer id) {
		Optional<TDL> tdl = tdlRepository.findById(id);
		
		if (tdl.isPresent()) {
			return tdlMapper.mapToDTO(tdl.get());
		} else {
			throw new TaskNotFoundException("Task not found");
		}
	}
	
	public TDLDTO createTDL(TDL tdl) {
		TDL newTDL = tdlRepository.save(tdl);
		
		return tdlMapper.mapToDTO(newTDL);
	}
	
	public TDLDTO updateTDL(Integer id, TDL tdl) throws EntityNotFoundException {
		Optional<TDL> tdlInDbOpt = tdlRepository.findById(id);
		TDL tdlInDb;
		
		if (tdlInDbOpt.isPresent()) {
			tdlInDb = tdlInDbOpt.get();
		} else {
			throw new TaskNotFoundException("Task not found");
		}
		
		tdlInDb.setTask(tdl.getTask());
		tdlInDb.setPriority(tdl.getPriority());
		tdlInDb.setDate(tdl.getDate());
		tdlInDb.setTaskStatus(tdl.getTaskStatus());
		
		TDL updatedTDL = tdlRepository.save(tdlInDb);
		
		return tdlMapper.mapToDTO(updatedTDL);
	}
	
	public boolean deleteTDL(Integer id) {
		if (!tdlRepository.existsById(id)) {
			throw new TaskNotFoundException();
		}
		tdlRepository.deleteById(id);
		
		boolean exists = tdlRepository.existsById(id);
		
		return !exists;
	}
	
}
