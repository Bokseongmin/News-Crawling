package com.news.service;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.news.dao.NewsDao;
import com.news.vo.NewsVo;

@Service
public class NewsServiceImpl implements NewsService{
	@Resource
	private NewsDao dao;

	public void rss_get(NewsVo vo) throws Exception {
		String uri = "https://newsis.com/RSS/sokbo.xml";
		Document doc = Jsoup.connect(uri).get();
		Elements refind = doc.select("item");
		
		for(Element a : refind) {
			Elements chosun_link = a.select("link");
			String str = chosun_link.text();
			
			Document subDoc = Jsoup.connect(str).get();
			
			Elements title = subDoc.select("p.tit title_area");
			Elements content = subDoc.select("div.viewer article text");
			Elements press = subDoc.select("");
			Elements date = subDoc.select("");
			
			vo.setTitle(title.text());
			vo.setContent(content.text());
			vo.setPress(press.text());
			vo.setDate(date.text());
			
			System.out.println(title.text());
			System.out.println(content.text());
			System.out.println(press.text());
			System.out.println(date.text());
			//dao.rss_insert(vo);
		}
	}
}
