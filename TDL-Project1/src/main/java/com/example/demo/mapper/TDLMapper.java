package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.data.model.TDL;
import com.example.demo.dto.TDLDTO;


@Component
public class TDLMapper {
	
	private ModelMapper modelMapper;
	
	@Autowired
	public TDLMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public TDLDTO mapToDTO(TDL tdl) {
		return this.modelMapper.map(tdl, TDLDTO.class);
	}
	
	public TDL mapToDTO(TDLDTO tdlDTO) {
		return this.modelMapper.map(tdlDTO, TDL.class);
	}

}
