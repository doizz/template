package com.function.template.repository;

import java.util.List;

import com.function.template.entity.BoardEntity;
import com.function.template.entity.BoardFileEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface JpaBoardRepository extends CrudRepository<BoardEntity, Integer> {

	List<BoardEntity> findAllByOrderByBoardIDxDesc();

	@Query("SELECT file FROM BoardFileEntity file WHERE board_idx = :boardIdx AND idx = :idx")
	BoardFileEntity findBoardFile(@Param("idx") int idx, @Param("boardIdx") int boardIdx);

	@Query("DELETE FROM BoardFileEntity file WHERE board_idx = :boardIdx AND idx = :idx")
	void deleteBoardFile(@Param("idx") int idx, @Param("boardIdx") int boardIdx);
}