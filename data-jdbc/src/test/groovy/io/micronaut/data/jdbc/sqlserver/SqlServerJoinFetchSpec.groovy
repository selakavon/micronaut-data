package io.micronaut.data.jdbc.sqlserver

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.tck.repositories.*
import io.micronaut.data.tck.tests.AbstractJoinFetchSpec

class SqlServerJoinFetchSpec extends AbstractJoinFetchSpec implements MSSQLTestPropertyProvider {

    @Override
    BookRepository getBookRepository() {
        return context.getBean(MSBookRepository)
    }

    @Override
    AuthorRepository getAuthorRepository() {
        return context.getBean(MSAuthorRepository)
    }

    @Override
    AuthorJoinLeftFetchRepository getAuthorJoinLeftFetchRepository() {
        return context.getBean(MSAuthorJoinLeftFetchRepository)
    }

    @Override
    AuthorJoinLeftRepository getAuthorJoinLeftRepository() {
        return context.getBean(MSAuthorJoinLeftRepository)
    }

    @Override
    AuthorJoinRightFetchRepository getAuthorJoinRightFetchRepository() {
        return context.getBean(MSAuthorJoinRightFetchRepository)
    }

    @Override
    AuthorJoinRightRepository getAuthorJoinRightRepository() {
        return context.getBean(MSAuthorJoinRightRepository)
    }

    @Override
    AuthorJoinOuterRepository getAuthorJoinOuterRepository() {
        return context.getBean(MSAuthorJoinOuterRepository)
    }

    @Override
    AuthorJoinOuterFetchRepository getAuthorJoinOuterFetchRepository() {
        return context.getBean(MSAuthorJoinOuterFetchRepository)
    }

    @Override
    AuthorJoinFetchRepository getAuthorJoinFetchRepository() {
        return context.getBean(MSAuthorJoinFetchRepository)
    }

    @Override
    AuthorJoinInnerRepository getAuthorJoinInnerRepository() {
        return context.getBean(MSAuthorJoinInnerRepository)
    }
}

@JdbcRepository(dialect = Dialect.SQL_SERVER)
interface MSAuthorJoinFetchRepository extends AuthorJoinFetchRepository {
}

@JdbcRepository(dialect = Dialect.SQL_SERVER)
interface MSAuthorJoinInnerRepository extends AuthorJoinInnerRepository {
}

@JdbcRepository(dialect = Dialect.SQL_SERVER)
interface MSAuthorJoinLeftFetchRepository extends AuthorJoinLeftFetchRepository {
}

@JdbcRepository(dialect = Dialect.SQL_SERVER)
interface MSAuthorJoinLeftRepository extends AuthorJoinLeftRepository {
}

@JdbcRepository(dialect = Dialect.SQL_SERVER)
interface MSAuthorJoinOuterFetchRepository extends AuthorJoinOuterFetchRepository {
}

@JdbcRepository(dialect = Dialect.SQL_SERVER)
interface MSAuthorJoinOuterRepository extends AuthorJoinOuterRepository {
}

@JdbcRepository(dialect = Dialect.SQL_SERVER)
interface MSAuthorJoinRightFetchRepository extends AuthorJoinRightFetchRepository {
}

@JdbcRepository(dialect = Dialect.SQL_SERVER)
interface MSAuthorJoinRightRepository extends AuthorJoinRightRepository {
}
