package com.student.results.service;

import org.springframework.stereotype.Service;

import com.student.results.model.HtmlToJson;

@Service
public interface HtmlToJsonPareserService {

	public StringBuilder convert2json(HtmlToJson json);
}
