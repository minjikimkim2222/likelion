package org.example.springdatajpa2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

// assertThat api 추가
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class CustomerRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @Autowired
    private CustomerRepository customerRepository;

    // 기본적인 save, delete 테스트
    // 하지만 테스트코드에서 @Transactional을 붙이면, 메서드를 성공적으로 실행해도 롤백시켜서, 변경사항이 반영안된다!!
    @Test
    void save(){
        log.info("!! save test !!");

        Customer customer = new Customer("minjiki2", "minjiki2@exam.com");
        Customer savedCustomer = customerRepository.save(customer);

        Assertions.assertEquals("minjiki2", savedCustomer.getName());
        // 테스트코드에 @Transactional 을 붙였기에, 데이터베이스에 변경사항이 커밋되지 않고, 롤백된다.

    }

    @Test
    void delete(){
        Customer customer = customerRepository.findById(1L).orElse(null);

        log.info("customer name : {}", customer.getName()); // 홍길동

        Assertions.assertEquals(30, customer.getAge());

        // 본격적인 remove
        customerRepository.deleteById(1L);

        assertThat(customerRepository.findById(1L)).isNotPresent();
    }

    @Test
    void findByName(){
        Customer customer = customerRepository.findByName("윤서준");

        Assertions.assertEquals(8L, customer.getId());
    }

    @Test
    void findByEmail(){
        Customer customer = customerRepository.findByEmail("kim@example.com");

        Assertions.assertEquals(25, customer.getAge());
    }

    @Test
    void findByEmailEndingWith(){
        List<Customer> customers = customerRepository.findByEmailEndingWith("g@example.com");

        Assertions.assertEquals(3, customers.size());

    }

    // 테스트케이스를 짤 때는, 시나리오를 아래와 같이 짜는 것이 좋다.
    @Test
    @DisplayName("이메일에 특정문자열 포함여부 체크")
    void findByEmailContaining(){
        // Given
        Customer customer1 = new Customer("user1", "user1@test.com");
        Customer customer2 = new Customer("user2", "user2@test.com");
        Customer customer3 = new Customer("user3", "user3@test.com");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        // When
        List<Customer> customers = customerRepository.findByEmailContaining("test");

        // then
        Assertions.assertEquals(3, customers.size());

    }

    @Test
    void findCustomerByName(){
        // Given
        Customer customer1 = new Customer("user1", "user1@test.com");
        Customer customer2 = new Customer("user2", "user2@test.com");
        Customer customer3 = new Customer("user3", "user3@test.com");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        // when
        List<Customer> users = customerRepository.findCustomerByName("user1");

        // Then
        Assertions.assertEquals(1, users.size());
    }

    @Test
    void findCustomerOrderCount(){
        List<Object[]> customerOrderCount = customerRepository.findCustomerOrderCount();

        customerOrderCount.forEach(result -> {
            Customer customer = (Customer) result[0];
            Long count = (Long) result[1];

            log.info("고객이름 : {}, 주문 수 : {}", customer.getName(), count);
         });
    }
}