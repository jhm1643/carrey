package com.nexus.push.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nexus.push.dao.NoticeDao;
import com.nexus.push.domain.Notice;
import com.nexus.push.domain.Paging;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NoticeController {

	@Resource(name = "noticeDao")
	private NoticeDao noticeDao;
	
	@RequestMapping(value = "/noticeList")
	public String noticeList(@ModelAttribute("Notice") Notice notice,
							@RequestParam(defaultValue="1") int curPage,
							Model model
								) {
		logger.info("noticeList page");
		int listCnt = noticeDao.getNoticeListCount();
		Paging paging = new Paging(listCnt, curPage);
		notice.setStartIndex(paging.getStartIndex());
		notice.setCntPerPage(paging.getPageSize());
			
		List<Notice> noticeList=noticeDao.getNoticeList(notice);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("paging", paging);
		return "notice/noticeList";
	}
	
	@RequestMapping(value = "/noticeRegi")
	public String noticeRegi() {
		logger.info("notice Regi page");
			return "notice/noticeDetail";
	}
	
	@RequestMapping(value = "/noticeDetail/{notice_id}")
	public String noticeEdit(@PathVariable String notice_id, Model model) {
		logger.info("notice detail page [notice_id = {}]",notice_id);
		model.addAttribute("notice",noticeDao.getNoticeOne(notice_id));
		return "notice/noticeDetail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/noticeInsert", method=RequestMethod.POST)
	public int noticeInsert(Notice notice) {
		logger.info("notice insert"); 
		return noticeDao.NoticeInsert(notice);
	}
	
	@ResponseBody
	@RequestMapping(value = "/noticeUpdate", method=RequestMethod.POST)
	public int noticeUpdate(Notice notice) {
		logger.info("notice update {} ", notice.getNotice_id()); 
		return noticeDao.NoticeUpdate(notice);
	}
	
	@ResponseBody
	@RequestMapping(value = "/noticeDelete", method=RequestMethod.POST)
	public int noticeDelete(Notice notice) {
		logger.info("notice delete {} ", notice.getNotice_id()); 
		return noticeDao.NoticeDelete(notice.getNotice_id());
	}
	
	@ResponseBody
	@RequestMapping(value = "/noticePush/{notice_id}")
	public String noticePush(@PathVariable String notice_id, Model model) {
		logger.info("notice push execute [notice_id = {}]",notice_id);
		noticeDao.getNoticeOne(notice_id);
		return "";
	}
	
}
