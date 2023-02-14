package com.news.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.dao.HomeDao;

@Service
public class HomeServiceImpl implements HomeService {
	@Resource
	private HomeDao dao;
}
