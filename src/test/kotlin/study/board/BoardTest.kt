package study.board

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Commit
import org.springframework.transaction.annotation.Transactional
import study.board.entity.BoardEntity
import study.board.repository.BoardRepository

@SpringBootTest
@Transactional
@Commit
class BoardTest @Autowired constructor(
    val boardRepository: BoardRepository
) {

    @Test
    fun saveAndSelectTest() {

        //given
        val boardEntity = boardRepository.save(BoardEntity())

        //when
        val boardId = boardRepository.findFirst()

        //then
        Assertions.assertThat(boardEntity.id).isEqualTo(boardId)

    }

}