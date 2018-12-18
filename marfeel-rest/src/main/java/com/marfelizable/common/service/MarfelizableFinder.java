package com.marfelizable.common.service;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marfelizable.common.persistence.MarfelizableSite;
import com.marfelizable.common.persistence.MarfelizableSiteRepository;

@Component
public class MarfelizableFinder {
	
	private static Logger LOG =  Logger.getLogger(MarfelizableFinder.class);
	
	@Autowired
	private MarfelizableSiteRepository marfelizableSiteRepository;

	public void MarfelizeFile(JSONObject site, String tag, String containingWord) {
		
		Document doc;
		try {
			doc = Jsoup.connect(site.getString("url")).get();
			LOG.info((doc.title()));
			Elements tagsElement = doc.getElementsByTag(tag);
			for (Element headline : tagsElement) {
			  String[] matchingWords = containingWord.split(";");
			  if(headline.data().contains(matchingWords[0]) || headline.data().contains(matchingWords[1])) {
				  MarfelizableSite marfelizableSite = 
						  new MarfelizableSite(site.getString("url"),site.getInt("rank"));
				  
				  marfelizableSiteRepository.insert(marfelizableSite);
				  break;
			  }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
