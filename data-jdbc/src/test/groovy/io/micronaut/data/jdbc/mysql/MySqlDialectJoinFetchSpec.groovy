package io.micronaut.data.jdbc.mysql

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.tck.repositories.*
import io.micronaut.data.tck.tests.AbstractJoinFetchSpec

abstract class MySqlDialectJoinFetchSpec extends AbstractJoinFetchSpec {

    boolean outerJoinSupported = false

    boolean outerFetchJoinSupported = false

    @Override
    BookRepository getBookRepository() {
        return context.getBean(MySqlBookRepository)
    }

    @Override
    AuthorRepository getAuthorRepository() {
        return context.getBean(MySqlAuthorRepository)
    }

    @Override
    AuthorJoinLeftFetchRepository getAuthorJoinLeftFetchRepository() {
        return context.getBean(MySqlAuthorJoinLeftFetchRepository)
    }

    @Override
    AuthorJoinLeftRepository getAuthorJoinLeftRepository() {
        return context.getBean(MySqlAuthorJoinLeftRepository)
    }

    @Override
    AuthorJoinRightFetchRepository getAuthorJoinRightFetchRepository() {
        return context.getBean(MySqlAuthorJoinRightFetchRepository)
    }

    @Override
    AuthorJoinRightRepository getAuthorJoinRightRepository() {
        return context.getBean(MySqlAuthorJoinRightRepository)
    }

    @Override
    AuthorJoinOuterRepository getAuthorJoinOuterRepository() {
        throw new UnsupportedOperationException("Full Outer Join is not supported by MySql.")
    }

    @Override
    AuthorJoinOuterFetchRepository getAuthorJoinOuterFetchRepository() {
        throw new UnsupportedOperationException("Full Outer Join is not supported by MySql.")
    }

    @Override
    AuthorJoinFetchRepository getAuthorJoinFetchRepository() {
        return context.getBean(MySqlAuthorJoinFetchRepository)
    }

    @Override
    AuthorJoinInnerRepository getAuthorJoinInnerRepository() {
        return context.getBean(MySqlAuthorJoinInnerRepository)
    }
}

@JdbcRepository(dialect = Dialect.MYSQL)
interface MySqlAuthorJoinFetchRepository extends AuthorJoinFetchRepository {
}

@JdbcRepository(dialect = Dialect.MYSQL)
interface MySqlAuthorJoinInnerRepository extends AuthorJoinInnerRepository {
}

@JdbcRepository(dialect = Dialect.MYSQL)
interface MySqlAuthorJoinLeftFetchRepository extends AuthorJoinLeftFetchRepository {
}

@JdbcRepository(dialect = Dialect.MYSQL)
interface MySqlAuthorJoinLeftRepository extends AuthorJoinLeftRepository {
}

@JdbcRepository(dialect = Dialect.MYSQL)
interface MySqlAuthorJoinRightFetchRepository extends AuthorJoinRightFetchRepository {
}

@JdbcRepository(dialect = Dialect.MYSQL)
interface MySqlAuthorJoinRightRepository extends AuthorJoinRightRepository {
}
