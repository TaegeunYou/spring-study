package study.plugin

import com.zaxxer.hikari.HikariDataSource
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DBConnectionTest @Autowired constructor(
    val dataSource: HikariDataSource,
) {

    @Test
    fun dataSourceTest() {
        val connection = dataSource.connection
        println(connection.metaData.url)
        println(connection.metaData.userName)
    }

}