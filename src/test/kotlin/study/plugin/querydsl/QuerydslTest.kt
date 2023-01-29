package study.plugin.querydsl

import com.querydsl.jpa.impl.JPAQueryFactory
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Commit
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@SpringBootTest
@Transactional
@Commit
class QuerydslTest @Autowired constructor(
	val jpaQueryFactory: JPAQueryFactory
) {

	@PersistenceContext
	private lateinit var em: EntityManager

	@Test
	fun queryDslTest() {
		val hello = QuerydslTestEntity()
		em.persist(hello)

		val result = jpaQueryFactory
			.selectFrom(
				QQuerydslTestEntity.querydslTestEntity
			)
			.fetchOne()

		Assertions.assertThat(result).isEqualTo(hello)
		Assertions.assertThat(result!!.id).isEqualTo(hello.id)
	}

}
