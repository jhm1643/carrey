package com.nexus.push.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.nexus.push.domain.Notice;

@Repository(value = "noticeMapper")
public interface NoticeMapper {
	public int noticeListCount();
	public List<Notice> noticeList(Notice notice);
	public Notice noticeOne(String notice_id);
	public int noticeInsert(Notice notice);
	public int noticeUpdate(Notice notice);
	public int noticeDelete(String notice_id);
}
