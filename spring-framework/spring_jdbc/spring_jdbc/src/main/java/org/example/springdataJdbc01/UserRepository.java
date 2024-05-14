package org.example.springdataJdbc01;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Spring Data jdbc에서 제공해주는 CrudRepository 인터페이스 extends
// p.65 - [구현 자동화 설명 정리할 것]
public interface UserRepository extends CrudRepository<User,Long> { // <엔디티, id의 타입>
    User findByName(String name);

    List<User> findAllByName(String name);
}
