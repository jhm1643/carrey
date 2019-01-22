package com.nexus.push.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nexus.push.dao.NoticeDao;
import com.nexus.push.domain.Notice;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NoticeController {

	@Autowired
	SqlSession sqlSession;
	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)
	public String noticeList(Model model) {
		logger.info("noticeList page!!!");
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		List<Notice> noticeList=noticeDao.noticeList();
		model.addAttribute("noticeList", noticeList);
		return "notice/noticeList";
	}
	
	@RequestMapping(value = "/noticeDetail", method = RequestMethod.GET)
	public String noticeEdit() {
		logger.info("noticeDetail page!!!");
		return "notice/noticeEdit";
	}
	
}
