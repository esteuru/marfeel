package com.marfelizable.common.controller;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParser;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.marfelizable.common.service.MarfelizableFinder;


public class MarfelizableController extends AbstractController {
	
	@Autowired
	private MarfelizableFinder marfelizableFinder;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("Welcome");
		
		
		if(request.getMethod().equals("POST")){
			
			StringBuffer jb = new StringBuffer();
			
			try{
				
				String str;
				
				BufferedReader br = request.getReader();
				while ((str = br.readLine()) != null) {
					jb.append(str);
				}
				
				JSONArray jsonArray = new JSONArray(jb.toString());
				
				for(int i= 0; i< jsonArray.length(); i++)
				{
					JSONObject json = (JSONObject) jsonArray.get(i);
					marfelizableFinder.MarfelizeFile(json,"<TITLE>","NEWS;NOTICIAS");
				}
				
				
				
			} catch (Exception e){
				logger.error(e);
			}
		}
		

		return model;
	}
}
