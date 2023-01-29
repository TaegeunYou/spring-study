package study.board.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import study.board.entity.QBoardEntity.boardEntity

class BoardRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): BoardCustomRepository {

    override fun findFirst(): Long? {
        return queryFactory
            .select(
                boardEntity.id
            )
            .from(boardEntity)
            .fetchOne()
    }
}