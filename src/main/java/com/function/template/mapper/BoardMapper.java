package com.function.template.mapper;

import java.util.List;

import com.function.template.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;
    void insertBoard(BoardDto board) throws Exception;
}