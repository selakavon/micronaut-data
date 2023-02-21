package io.micronaut.data.jdbc.postgres

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.tck.repositories.AuthorJoinFetchRepository
import io.micronaut.data.tck.repositories.AuthorJoinInnerRepository
import io.micronaut.data.tck.repositories.AuthorJoinLeftFetchRepository
import io.micronaut.data.tck.repositories.AuthorJoinLeftRepository
import io.micronaut.data.tck.repositories.AuthorJoinOuterFetchRepository
import io.micronaut.data.tck.repositories.AuthorJoinOuterRepository
import io.micronaut.data.tck.repositories.AuthorJoinRightFetchRepository
import io.micronaut.data.tck.repositories.AuthorJoinRightRepository
import io.micronaut.data.tck.repositories.AuthorRepository
import io.micronaut.data.tck.repositories.BookRepository
import io.micronaut.data.tck.tests.AbstractJoinFetchSpec

class PostgresJoinFetchSpec extends AbstractJoinFetchSpec implements PostgresTestPropertyProvider {

    @Override
    BookRepository getBookRepository() {
        return context.getBean(PostgresBookRepository)
    }

    @Override
    AuthorRepository getAuthorRepository() {
        return context.getBean(PostgresAuthorRepository)
    }

    @Override
    AuthorJoinLeftFetchRepository getAuthorJoinLeftFetchRepository() {
        return context.getBean(PostgresAuthorJoinLeftFetchRepository)
    }

    @Override
    AuthorJoinLeftRepository getAuthorJoinLeftRepository() {
        return context.getBean(PostgresAuthorJoinLeftRepository)
    }

    @Override
    AuthorJoinRightFetchRepository getAuthorJoinRightFetchRepository() {
        return context.getBean(PostgresAuthorJoinRightFetchRepository)
    }

    @Override
    AuthorJoinRightRepository getAuthorJoinRightRepository() {
        return context.getBean(PostgresAuthorJoinRightRepository)
    }

    @Override
    AuthorJoinOuterRepository getAuthorJoinOuterRepository() {
        return context.getBean(PostgresAuthorJoinOuterRepository)
    }

    @Override
    AuthorJoinOuterFetchRepository getAuthorJoinOuterFetchRepository() {
        return context.getBean(PostgresAuthorJoinOuterFetchRepository)
    }

    @Override
    AuthorJoinFetchRepository getAuthorJoinFetchRepository() {
        return context.getBean(PostgresAuthorJoinFetchRepository)
    }

    @Override
    AuthorJoinInnerRepository getAuthorJoinInnerRepository() {
        return context.getBean(PostgresAuthorJoinInnerRepository)
    }
}

@JdbcRepository(dialect = Dialect.POSTGRES)
interface PostgresAuthorJoinFetchRepository extends AuthorJoinFetchRepository {
}

@JdbcRepository(dialect = Dialect.POSTGRES)
interface PostgresAuthorJoinInnerRepository extends AuthorJoinInnerRepository {
}

@JdbcRepository(dialect = Dialect.POSTGRES)
interface PostgresAuthorJoinLeftFetchRepository extends AuthorJoinLeftFetchRepository {
}

@JdbcRepository(dialect = Dialect.POSTGRES)
interface PostgresAuthorJoinLeftRepository extends AuthorJoinLeftRepository {
}

@JdbcRepository(dialect = Dialect.POSTGRES)
interface PostgresAuthorJoinOuterFetchRepository extends AuthorJoinOuterFetchRepository {
}

@JdbcRepository(dialect = Dialect.POSTGRES)
interface PostgresAuthorJoinOuterRepository extends AuthorJoinOuterRepository {
}

@JdbcRepository(dialect = Dialect.POSTGRES)
interface PostgresAuthorJoinRightFetchRepository extends AuthorJoinRightFetchRepository {
}

@JdbcRepository(dialect = Dialect.POSTGRES)
interface PostgresAuthorJoinRightRepository extends AuthorJoinRightRepository {
}
