package org.example.springDataJdbc01;

import org.springframework.data.repository.CrudRepository;

// Spring Data jdbc에서 제공해주는 CrudRepository 인터페이스 extends..
// p.65 - [구현 자동화 설명 정리할 것]
public interface BookRepository extends CrudRepository<Book, Integer> { // <엔디티, id의 타입>
    // 기본메서드는 추가안해줘도,, 자동 구현해줌,,
    Book findByTitle(String title); // 커스텀 메서드
    Book findByAuthor(String author); // 커스텀 메서드
}
