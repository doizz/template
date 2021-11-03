package com.function.template.service;


import java.util.List;

import com.function.template.dto.BoardDto;
import com.function.template.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }
}