package co.micol.pj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.pj.notice.service.NoticeService;
import co.micol.pj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;
	
	@RequestMapping("/noticeList.do") 
	public String noticeList(Model model) {
		model.addAttribute("notices", noticeDao.noticeSelectList());
		return "notice/noticeList";
	}
	
	@RequestMapping("/noticeWriteForm.do") //단순히 입력하는 폼 호출
	public String noticeWriteForm() {
		return "notice/noticeWriteForm";
	}
	@RequestMapping("/noticeWrite.do")
	public String noticeWrite(NoticeVO vo) { //선언만 해주면 form에 있는값들이 자동으로 들어옴
		int n = noticeDao.noticeInsert(vo);
		if(n != 0) {
			return "redirect:noticeList.do"; //..do로 돌릴때는 redirect(컨트롤러에서 요청을 호출할때) 
		}
		return "notice/noticeError"; 
	}
	
	@PostMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) { 
		//model은 처리된 결과를 실어서 페이지로 보낸다 
	vo = noticeDao.noticeSelect(vo);
	if(vo != null) {
		model.addAttribute("notice", vo);
		noticeDao.noticeHitUpdate(vo.getNoticeId());
		return "notice/noticeSelect";
	}else {
		model.addAttribute("message", "게시글이 존재하지 않습니다");
		return "notice/noticeError";
	}
		
		
	}
}
