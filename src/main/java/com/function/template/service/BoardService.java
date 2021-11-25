package com.function.template.service;

import com.function.template.dto.BoardDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.function.template.dto.BoardFileDto;
import java.util.List;

public interface BoardService {

    List<BoardDto> selectBoardList() throws Exception;
    void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
    BoardDto selectBoardDetail(int boardIdx) throws Exception;
    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(int boardIdx) throws Exception;
    BoardFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception;
    void deleteBoardFile(int idx, int boardIdx) throws Exception;
}