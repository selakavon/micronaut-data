package io.micronaut.data.hibernate.reactive

import io.micronaut.data.annotation.Join
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.reactive.ReactorCrudRepository
import io.micronaut.data.tck.entities.Author
import io.micronaut.data.tck.entities.AuthorBooksDto
import io.micronaut.data.tck.entities.BookDto
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import reactor.core.publisher.Mono
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

import javax.transaction.Transactional

@MicronautTest(transactional = false, packages = ["io.micronaut.data.tck.entities", "io.micronaut.data.hibernate.entities"])
@Stepwise
@Transactional
class FetchByJoinTypeSpec extends Specification implements PostgresHibernateReactiveProperties {

    @Repository
    static interface AuthorLeftFetchRepository extends ReactorCrudRepository<Author, Long> {

        @Join(value = "books", type = Join.Type.LEFT_FETCH)
        @Transactional
        Mono<Author> findByName(String name)

    }

    @Inject
    @Shared
    BookRepository bookRepository

    @Inject
    @Shared
    AuthorRepository authorRepository

    @Inject
    private AuthorLeftFetchRepository leftFetchRepository


    def setupSpec() {
        bookRepository.saveAuthorBooks(authorRepository, [
                new AuthorBooksDto("Stephen King", Arrays.asList(
                        new BookDto("The Stand", 1000),
                        new BookDto("Pet Cemetery", 400)
                )),
                new AuthorBooksDto("James Patterson", Arrays.asList(
                        new BookDto("Along Came a Spider", 300),
                        new BookDto("Double Cross", 300)
                )),
                new AuthorBooksDto("Don Winslow", Arrays.asList(
                        new BookDto("The Power of the Dog", 600),
                        new BookDto("The Border", 700)
                ))]).block()
    }

    void "dummy test"() {
        given:
        def a = 1

        expect:
        a == 1
    }

    void "left fetch fetches books"() {
        given:
        def booksMap = leftFetchRepository.findByName("Stephen King").flatMap {
            author -> Mono.fromSupplier {() -> author.books}
        }.block().collectEntries {book -> [book.title, book.pages]}

        expect:
        booksMap.size() == 2
//        booksMap.get("The Stand") == 1000
    }

}
