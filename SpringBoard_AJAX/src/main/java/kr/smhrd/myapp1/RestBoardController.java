package kr.smhrd.myapp1;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.domain.Board;
import kr.smhrd.service.BoardService;

@RestController
public class RestBoardController {
	
	@Autowired
	private BoardService service;
	
	//@ResponseBody : 자바 객체는 HTTP 응답객체로 변환주는데 사용
		@RequestMapping("/boardList.do")
		public ArrayList<Board> boardList() {
			ArrayList<Board> list = service.boardList();
			return list;
		}
		
		//boardContentUpdate.do o
		//메서드 이름은 boardContentUpdate o
		//매개변수 작성 o
		//@ResponseBody 작성 o
		//springboard 수정 추상메서드 interface 작성 o
		//sql문 작성-xml or annotation o
		//반환 데이터 x o

		@RequestMapping("/boardContentUpdate.do")
		public void boardContentUpdate(Board vo) {
			service.boardContentUpdate(vo);
			
		}
		
		@RequestMapping("/boardInsert.do")
		public void boardInsert(Board vo) {
			service.boardInsert(vo);
			
		}
		
		// 1. controller에 boardTWUpdate 메서드 만들기
		// 2. mapper interface boardTWUpdate() 만들기
		// 3. xml updete 추가
		
		
		@RequestMapping("/boardTWUpdate.do")
		public void boardTWUpdate(Board vo) {
			service.boardTWUpdate(vo);
			
		}
		
		@RequestMapping("/boardDelete.do")
		public void boardDelete(int inx) {
			service.boardDelete(inx);
		}

}
