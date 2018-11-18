package com.springboot.dbshackathon.service;

import org.springframework.stereotype.Service;

import com.springboot.dbshackathon.model.HtmlToJson;

@Service
public interface HtmlToJsonPareserService {

	public StringBuilder convert2json(HtmlToJson json);
}
