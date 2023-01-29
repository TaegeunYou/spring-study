package study.board.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.board.entity.BoardEntity

interface BoardRepository: JpaRepository<BoardEntity, Long>, BoardCustomRepository