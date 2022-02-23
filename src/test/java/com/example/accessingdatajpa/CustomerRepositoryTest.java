package com.example.accessingdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@ActiveProfiles("local")
//@SpringBootTest(properties = "spring.profiles.active=local")
//@RunWith(SpringRunner.class)
//@ExtendWith(MockitoExtension.class)
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void setting() {
        // save a few customers
        customerRepository.save(new Customer("Jack", "Bauer"));
        customerRepository.save(new Customer("Chloe", "O'Brian"));
        customerRepository.save(new Customer("Kim", "Bauer"));
        customerRepository.save(new Customer("David", "Palmer"));
        customerRepository.save(new Customer("Michelle", "Dessler"));

        // 회원 가입
        memberRepository.save(new Member("userId_1", "123451", "홍길동", "860824-1655068"));
        memberRepository.save(new Member("userId_2", "123452", "김둘리", "921108-1582816"));
        memberRepository.save(new Member("userId_3", "123453", "마징가", "880601-2455116"));
        memberRepository.save(new Member("userId_4", "123454", "베지터", "910411-1656116"));
        memberRepository.save(new Member("userId_5", "123455", "손오공", "820326-2715702"));
    }
    
    @Test
    void getCustomInfo() {
        List<Customer> customerList = (List<Customer>) customerRepository.findAll();

        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }

        Customer customer = customerRepository.findById(2L);

        System.out.println(">>>>> Customer: " + customer.toString());
    }

    @Test
    void getMemberInfo() {
        Member member = memberRepository.findByUserId("userId_2");

        System.out.println(">>>>> Member: " + member.toString());
    }
}