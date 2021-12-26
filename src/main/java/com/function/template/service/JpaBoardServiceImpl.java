package com.function.template.service;


import java.util.List;
import java.util.Optional;

import com.function.template.common.FileUtils;
import com.function.template.entity.BoardEntity;
import com.function.template.entity.BoardFileEntity;
import com.function.template.repository.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Service
public class JpaBoardServiceImpl implements JpaBoardService {

    @Autowired
    JpaBoardRepository JpaBoardRepository;

    @Autowired
    FileUtils fileUtils;

    @Override
    public List<BoardEntity> selectBoardList() throws Exception {
        return JpaBoardRepository.findAllByOrderByBoardIdxDesc();
    }

    @Override
    public void saveBoard(BoardEntity board, MultipartHttpServletRequest multipartHttpServletRequest, int hitCnt) throws Exception {
        board.setCreatorId("admin");
        board.setHitCnt(hitCnt);
        List<BoardFileEntity> list = fileUtils.parseFileInfo(multipartHttpServletRequest);
        if(CollectionUtils.isEmpty(list) == false) {
            board.setFileList(list);
        }
        JpaBoardRepository.save(board);
    }

    @Override
    public BoardEntity selectBoardDetail(int boardIdx) throws Exception {
        Optional<BoardEntity> optional = JpaBoardRepository.findById(boardIdx);
        if(optional.isPresent()) {
            BoardEntity board = optional.get();
            board.setHitCnt(board.getHitCnt() + 1);
            JpaBoardRepository.save(board);

            return board;
        }
        else {
            throw new NullPointerException();
        }
    }

    @Override
    public void deleteBoard(int boardIdx) throws Exception {
        JpaBoardRepository.deleteById(boardIdx);
    }

    @Override
    public BoardFileEntity selectBoardFileInformation(int idx, int boardIdx) throws Exception {
        BoardFileEntity boardFile = JpaBoardRepository.findBoardFile(idx, boardIdx);
        return boardFile;
    }

    @Override
    public void deleteBoardFile(int idx, int boardIdx) throws Exception {
        JpaBoardRepository.deleteBoardFile(idx, boardIdx);
    }
}