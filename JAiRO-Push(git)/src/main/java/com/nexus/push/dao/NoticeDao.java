package com.nexus.push.dao;

import java.util.List;

import com.nexus.push.domain.Notice;

public interface NoticeDao {
	public List<Notice> noticeList();
	public Notice noticeOne();
	public void noticeInsert();
	public void noticeUpdate();
	public void noticeDelete();
}
