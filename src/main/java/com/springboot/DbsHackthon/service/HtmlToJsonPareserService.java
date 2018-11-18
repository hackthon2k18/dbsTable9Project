package com.springboot.DbsHackthon.service;

import org.springframework.stereotype.Service;

import com.springboot.DbsHackthon.model.HtmlToJson;

@Service
public interface HtmlToJsonPareserService {

	public StringBuilder convert2json(HtmlToJson json);
}
