package study.board.repository

import study.board.dto.query.InsertBoardQDto


interface BoardRepository {

    fun insert(a: InsertBoardQDto) {

    }

}