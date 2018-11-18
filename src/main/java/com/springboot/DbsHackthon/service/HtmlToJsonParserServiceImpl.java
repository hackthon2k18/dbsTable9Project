package com.springboot.DbsHackthon.service;

import org.springframework.stereotype.Service;

import com.springboot.DbsHackthon.model.HtmlToJson;
import com.springboot.DbsHackthon.model.Type;

@Service
public class HtmlToJsonParserServiceImpl implements HtmlToJsonPareserService {

	public StringBuilder convert2json(HtmlToJson json) {
		
		// JSON-SOURCE can be File/InputStream/String/etc..

		StringBuilder sb = new StringBuilder("<nz-form-item>");

		try {
			for (Type t : json.getType()) {
				if (t.getType().equals("text")) {
					sb.append("<nz-form-label nzFor=\"name\" nzRequired>" + t.getLabel().substring(0, 1).toUpperCase()+t.getLabel().substring(1) + "</nz-form-label>");
					sb.append("<nz-form-control>" + "<input nz-input formControlName='" + t.getLabel()
							+ "' id=\"name\" placeholder=\"name\">"
							+ " <nz-form-explain *ngIf=\"agreementsForm.controls."+t.getLabel()+".invalid && (agreementsForm.controls."+t.getLabel()+".dirty || agreementsForm.controls."+t.getLabel()+".touched)\">Required</nz-form-explain>"
							+ "</nz-form-control>");
				}
				if (t.getType().equals("number")) {
					sb.append("<nz-form-label nzFor=\"name\" nzRequired>" + t.getLabel().substring(0, 1).toUpperCase()+t.getLabel().substring(1) + "</nz-form-label>");
					sb.append("<nz-form-control>" + "<input nz-input formControlName='"+ t.getLabel()
							+ "' id=\"name\" placeholder=\"enter number\">"
							+ " <nz-form-explain *ngIf=\"agreementsForm.controls."+t.getLabel()+".invalid && (agreementsForm.controls."+t.getLabel()+".dirty || agreementsForm.controls."+t.getLabel()+".touched)\">Required</nz-form-explain>"
							+ "</nz-form-control>");
				}
				if (t.getType().equals("search")) {
					sb.append("<nz-form-label nzFor=\"name\" nzRequired>" + t.getLabel().substring(0, 1).toUpperCase()+t.getLabel().substring(1) + "</nz-form-label>");
					sb.append("<nz-form-control>" + "<input nz-input formControlName='" + t.getLabel()
							+ "' id=\"name\" placeholder=\"search\">"
							+ " <nz-form-explain *ngIf=\"agreementsForm.controls."+t.getLabel()+".invalid && (agreementsForm.controls."+t.getLabel()+".dirty || agreementsForm.controls."+t.getLabel()+".touched)\">Required</nz-form-explain>"
							+ "</nz-form-control>");
				}
				if (t.getType().equals("email")) {
					sb.append("<nz-form-label nzFor=\"name\" nzRequired>" + t.getLabel().substring(0, 1).toUpperCase()+t.getLabel().substring(1) + "</nz-form-label>");
					sb.append("<nz-form-control>" + "<input nz-input formControlName='" + t.getLabel()
							+ "' id=\"name\" placeholder=\"search\">"
							+ " <nz-form-explain *ngIf=\"agreementsForm.controls."+t.getLabel()+".invalid && (agreementsForm.controls."+t.getLabel()+".dirty || agreementsForm.controls."+t.getLabel()+".touched)\">Required</nz-form-explain>"
							+ "</nz-form-control>");
				}
			}
		} finally {
			sb.append("</nz-form-item>");
		}
		return sb;
	}

}
