package kr.smhrd.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import kr.smhrd.domain.Board;

public interface BoardMapper {

   //전체 게시물 가지고 오기
   public ArrayList<Board> boardList();
   
   //게시물 작성
   public void boardInsert(Board vo);
   
   //특정 게시물 번호를 가진 게시물정보 가지고 오기 
   public Board boardContent(int inx);
   
   //특정 게시물 번호를 가진 게시물 삭제
   //@Delete("delete from springboard where inx=#{inx}")
   //public void boardDelete(int inx);
   
   //특정 게시물 번호를 가진 게시물 수정(내용,타이틀)
   public void boardUpdate(Board vo);
   
   //특정 게시물 번호를 가진 게시물 수정(내용)
   @Update("update springboard set content=#{content} where inx=#{inx}")
   public void boardContentUpdate(Board vo);
   
   //특정 게시물 번호를 가진 게시물 수정(타이틀, 작성자)
   //@Update("update springboard set title=#{title},writer=#{writer} where inx=#{inx}")
   public void boardTWUpdate(Board vo);
   
 //특정 게시물 번호를 가진 게시물 삭제(내용)
   @Delete("delete from springboard where inx=#{inx}")
   public void boardDelete(int inx);
   
}