package com.news.dao;

import org.springframework.stereotype.Repository;

import com.news.vo.NewsVo;

@Repository("NewsDao")
public class NewsDao extends CommonDao {
	public void rss_insert(NewsVo vo) throws Exception {
		getSqlSession().insert("", vo);
	}
}