package com.spring.mvc_mybatis.ch02.dto;

public class BoardDTO_2 {

	private int boardNum;			// mvc_board_tbl board_num => pk
	private String boardTitle;		// mvc_board_tbl board_title
	private String boardContent;	// mvc_board_tbl board_content
	
	public BoardDTO_2() {
		super();
	}
	
	public BoardDTO_2(int boardNum, String boardTitle, String boardContent) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	
	@Override
	public String toString() {
		return "BoardDTO_2 [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ "]";
	}

}


//CREATE TABLE mvc_board_tbl(
//		board_num    NUMBER(3) PRIMARY KEY,
//		board_title  VARCHAR2(50),
//		board_content VARCHAR2(100),
//		user_id 	 NUMBER(2),	// FK
//		CONSTRAINT mvc_board_tbl_user_id_fk FOREIGN KEY(user_id) REFERENCES mvc_user_tbl(user_id)
//	);