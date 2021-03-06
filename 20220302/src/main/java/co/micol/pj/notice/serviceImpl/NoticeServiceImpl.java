package co.micol.pj.notice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.pj.notice.service.NoticeMapper;
import co.micol.pj.notice.service.NoticeService;
import co.micol.pj.notice.vo.NoticeVO;

@Repository("noticeDao") // service , Component 중에 한가지 사용
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper map; 
	

	@Override
	public List<NoticeVO> noticeSelectList() {
		// TODO Auto-generated method stub
		return map.noticeSelectList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeDelete(vo);
	}

	@Override
	public void noticeHitUpdate(int noticeId) {
		map.noticeHitUpdate(noticeId);
	}

}
