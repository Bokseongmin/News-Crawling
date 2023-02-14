package com.news.service;

import com.news.vo.NewsVo;

public interface NewsService {
	
	public void rss_get(NewsVo vo) throws Exception;
}
