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

    @Test
    void restApiTest() {

//        // 헤더 설정
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));





//        HashMap<String, Object> result = new HashMap<String, Object>();
//
//        String jsonInString = "";
//
//        try {
//
//            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//            factory.setConnectTimeout(5000); //타임아웃 설정 5초
//            factory.setReadTimeout(5000);//타임아웃 설정 5초
//            RestTemplate restTemplate = new RestTemplate(factory);
//
//            HttpHeaders header = new HttpHeaders();
//            HttpEntity<?> entity = new HttpEntity<>(header);
//
//            String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
//
//            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url+"?"+"key=430156241533f1d058c603178cc3ca0e&targetDt=20120101").build();
//
//            //이 한줄의 코드로 API를 호출해 MAP타입으로 전달 받는다.
//            ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
//            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
//            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
//            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인
//
//            //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
//            ObjectMapper mapper = new ObjectMapper();
//            jsonInString = mapper.writeValueAsString(resultMap.getBody());
//
//        } catch (HttpClientErrorException | HttpServerErrorException e) {
//            result.put("statusCode", e.getRawStatusCode());
//            result.put("body"  , e.getStatusText());
//            System.out.println("dfdfdfdf");
//            System.out.println(e.toString());
//
//        } catch (Exception e) {
//            result.put("statusCode", "999");
//            result.put("body"  , "excpetion오류");
//            System.out.println(e.toString());
//        }

    }
}