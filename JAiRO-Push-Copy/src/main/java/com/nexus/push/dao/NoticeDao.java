package com.nexus.push.dao;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.nexus.push.domain.Notice;

@Service(value = "noticeDao")
public class NoticeDao{

	@Resource(name = "noticeMapper")
	private NoticeMapper noticeMapper;
	
	public int getNoticeListCount() {
		return noticeMapper.noticeListCount();
	}
	
	public List<Notice> getNoticeList(Notice notice){
		return noticeMapper.noticeList(notice);
	}
	
	public Notice getNoticeOne(String notice_id) {
		return noticeMapper.noticeOne(notice_id);
	}
	
	public int NoticeInsert(Notice notice) {
		return noticeMapper.noticeInsert(notice);
	}
	
	public int NoticeUpdate(Notice notice) {
		return noticeMapper.noticeUpdate(notice);
	}
	
	public int NoticeDelete(String notice_id) {
		return noticeMapper.noticeDelete(notice_id);
	}
}
