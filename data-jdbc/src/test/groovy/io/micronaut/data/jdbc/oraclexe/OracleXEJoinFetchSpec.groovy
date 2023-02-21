package io.micronaut.data.jdbc.oraclexe

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.tck.repositories.*
import io.micronaut.data.tck.tests.AbstractJoinFetchSpec

class OracleXEJoinFetchSpec extends AbstractJoinFetchSpec implements OracleTestPropertyProvider {

    @Override
    BookRepository getBookRepository() {
        return context.getBean(OracleXEBookRepository)
    }

    @Override
    AuthorRepository getAuthorRepository() {
        return context.getBean(OracleXEAuthorRepository)
    }

    @Override
    AuthorJoinLeftFetchRepository getAuthorJoinLeftFetchRepository() {
        return context.getBean(OracleXEAuthorJoinLeftFetchRepository)
    }

    @Override
    AuthorJoinLeftRepository getAuthorJoinLeftRepository() {
        return context.getBean(OracleXEAuthorJoinLeftRepository)
    }

    @Override
    AuthorJoinRightFetchRepository getAuthorJoinRightFetchRepository() {
        return context.getBean(OracleXEAuthorJoinRightFetchRepository)
    }

    @Override
    AuthorJoinRightRepository getAuthorJoinRightRepository() {
        return context.getBean(OracleXEAuthorJoinRightRepository)
    }

    @Override
    AuthorJoinOuterRepository getAuthorJoinOuterRepository() {
        return context.getBean(OracleXEAuthorJoinOuterRepository)
    }

    @Override
    AuthorJoinOuterFetchRepository getAuthorJoinOuterFetchRepository() {
        return context.getBean(OracleXEAuthorJoinOuterFetchRepository)
    }

    @Override
    AuthorJoinFetchRepository getAuthorJoinFetchRepository() {
        return context.getBean(OracleXEAuthorJoinFetchRepository)
    }

    @Override
    AuthorJoinInnerRepository getAuthorJoinInnerRepository() {
        return context.getBean(OracleXEAuthorJoinInnerRepository)
    }
}

@JdbcRepository(dialect = Dialect.ORACLE)
interface OracleXEAuthorJoinFetchRepository extends AuthorJoinFetchRepository {
}

@JdbcRepository(dialect = Dialect.ORACLE)
interface OracleXEAuthorJoinInnerRepository extends AuthorJoinInnerRepository {
}

@JdbcRepository(dialect = Dialect.ORACLE)
interface OracleXEAuthorJoinLeftFetchRepository extends AuthorJoinLeftFetchRepository {
}

@JdbcRepository(dialect = Dialect.ORACLE)
interface OracleXEAuthorJoinLeftRepository extends AuthorJoinLeftRepository {
}

@JdbcRepository(dialect = Dialect.ORACLE)
interface OracleXEAuthorJoinOuterFetchRepository extends AuthorJoinOuterFetchRepository {
}

@JdbcRepository(dialect = Dialect.ORACLE)
interface OracleXEAuthorJoinOuterRepository extends AuthorJoinOuterRepository {
}

@JdbcRepository(dialect = Dialect.ORACLE)
interface OracleXEAuthorJoinRightFetchRepository extends AuthorJoinRightFetchRepository {
}

@JdbcRepository(dialect = Dialect.ORACLE)
interface OracleXEAuthorJoinRightRepository extends AuthorJoinRightRepository {
}
