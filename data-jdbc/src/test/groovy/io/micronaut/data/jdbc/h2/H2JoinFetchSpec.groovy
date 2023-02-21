package io.micronaut.data.jdbc.h2

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.tck.repositories.*
import io.micronaut.data.tck.tests.AbstractJoinFetchSpec
import io.micronaut.inject.visitor.VisitorContext
import jakarta.inject.Inject

class H2JoinFetchSpec extends AbstractJoinFetchSpec implements H2TestPropertyProvider {

    boolean outerJoinSupported = false

    boolean outerFetchJoinSupported = false

    @Override
    BookRepository getBookRepository() {
        return context.getBean(H2BookRepository)
    }

    @Override
    AuthorRepository getAuthorRepository() {
        return context.getBean(H2AuthorRepository)
    }

    @Override
    AuthorJoinLeftFetchRepository getAuthorJoinLeftFetchRepository() {
        return context.getBean(H2AuthorJoinLeftFetchRepository)
    }

    @Override
    AuthorJoinLeftRepository getAuthorJoinLeftRepository() {
        return context.getBean(H2AuthorJoinLeftRepository)
    }

    @Override
    AuthorJoinRightFetchRepository getAuthorJoinRightFetchRepository() {
        return context.getBean(H2AuthorJoinRightFetchRepository)
    }

    @Override
    AuthorJoinRightRepository getAuthorJoinRightRepository() {
        return context.getBean(H2AuthorJoinRightRepository)
    }

    @Override
    AuthorJoinOuterRepository getAuthorJoinOuterRepository() {
        throw new UnsupportedOperationException("Full Outer Join is not supported by H2.")
    }

    @Override
    AuthorJoinOuterFetchRepository getAuthorJoinOuterFetchRepository() {
        throw new UnsupportedOperationException("Full Outer Join is not supported by H2.")
    }

    @Override
    AuthorJoinFetchRepository getAuthorJoinFetchRepository() {
        return context.createBean(H2AuthorJoinFetchRepository)
    }

    @Override
    AuthorJoinInnerRepository getAuthorJoinInnerRepository() {
        return context.getBean(H2AuthorJoinInnerRepository)
    }
}

@JdbcRepository(dialect = Dialect.H2)
interface H2AuthorJoinFetchRepository extends AuthorJoinFetchRepository {
}

@JdbcRepository(dialect = Dialect.H2)
interface H2AuthorJoinInnerRepository extends AuthorJoinInnerRepository {
}

@JdbcRepository(dialect = Dialect.H2)
interface H2AuthorJoinLeftFetchRepository extends AuthorJoinLeftFetchRepository {
}

@JdbcRepository(dialect = Dialect.H2)
interface H2AuthorJoinLeftRepository extends AuthorJoinLeftRepository {
}

@JdbcRepository(dialect = Dialect.H2)
interface H2AuthorJoinRightFetchRepository extends AuthorJoinRightFetchRepository {
}

@JdbcRepository(dialect = Dialect.H2)
interface H2AuthorJoinRightRepository extends AuthorJoinRightRepository {
}
