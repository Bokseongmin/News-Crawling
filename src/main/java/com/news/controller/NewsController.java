package com.news.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.news.service.NewsService;
import com.news.vo.NewsVo;

@Controller
@RequestMapping("/news/*")
public class NewsController {
	@Resource
	private NewsService service;
	
	@ResponseBody
	@RequestMapping(value="/rss", method = RequestMethod.GET)
	public void get_rss(NewsVo vo) throws Exception {
		service.rss_get(vo);
	}
}
