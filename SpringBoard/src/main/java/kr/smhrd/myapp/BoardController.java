package kr.smhrd.myapp;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.smhrd.domain.Board;
import kr.smhrd.mapper.BoardMapper;

//@Controller : Spring MVC 프로젝트에서 컨트롤러 역할
// 주로 View를 반환하기 위해 사용

@Controller
public class BoardController {

	// 여러개 있으면 찾아줘야해서 -> Autowired씀
	@Autowired
	private BoardMapper mapper;

	// 게시판리스트 요청받는 메서드
	// @RequestMapping : 특정 URI로 요청 처리 방식 정의
	@RequestMapping("/boardList.do")
	public String boardList(Model model) {
		ArrayList<Board> list = mapper.boardList();

		model.addAttribute("list", list);

		// return "/WEB-INF/views/boardList.jsp";
		return "boardList";
	}

	// @GetMapping : Get 요청 처리
	@GetMapping("/boardForm.do")
	public String boardForm() {
		return "boardForm";
	}

	// @PostMapping : Post 요청 처리
	@PostMapping("boardInsert.do")
	// name값 일치 필요..
	public String boardInsert(Board vo) {
		mapper.boardInsert(vo);

		return "redirect:/boardList.do";
	}
	
	//@RequestParam: 쿼리 스트링으로 보낸 파라미터 값을 받을 때 사용 
	@GetMapping("/boardContent.do")
	public String boardContent(@RequestParam("inx")int inx, Model model) {
		
		Board vo = mapper.boardContent(inx);
		model.addAttribute("vo", vo);
		
		return "boardContent";
	}
	
	//@PathVariable: url에서 구분자에 들어오는 값을 처리할 때 사용  
	@GetMapping("/boardDelete.do/{inx}")
	public String boardDelete(@PathVariable int inx) {
		
		mapper.boardDelete(inx);		
		return "redirect:/boardList.do";
	}
	
	@RequestMapping(value="/boardUpdate.do/{inx}", method=RequestMethod.GET)
	public String boardUpdate(@PathVariable int inx, Model model) {
		
		Board vo = mapper.boardContent(inx);
		model.addAttribute("vo", vo);
		return "boardUpdate";
	}
	
	@RequestMapping(value="/boardUpdate.do", method=RequestMethod.POST)
	public String boardUpdatePost(Board vo) {
		
		mapper.boardUpdate(vo);				
		return "redirect:/boardList.do";
	}


}
		
		/*
		 * 
		 * public String boardInsert(HttpServletRequest request) {
		 * String title = request.getParameter("title"); 
		 * String content = request.getParameter("content");
		 * String writer = request.getParameter("writer");
		 *}
		 *
		 */
		
		
		

