package kr.smhrd.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.domain.Book;
import kr.smhrd.mapper.BookMapper;

@RestController
public class BookRestController {
	
	@Autowired
	private BookMapper mapper;
	
	@RequestMapping("/bookListAjax.do")
	public List<Book> bookListAjax() {
		List<Book> list = mapper.bookList();
		return list;
	}

}
