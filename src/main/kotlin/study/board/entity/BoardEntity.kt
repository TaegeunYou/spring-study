package study.board.entity

import javax.persistence.*

@Entity
class BoardEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    val id: Long,


)