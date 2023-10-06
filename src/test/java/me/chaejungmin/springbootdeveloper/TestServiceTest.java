//package me.chaejungmin.springbootdeveloper;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest // 테스트용 컨텍스트 생성
//@AutoConfigureMockMvc // 테스트용 mvc를 만들어 컨트롤러 테스트
//class TestServiceTest {
//    @Autowired
//    protected MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @BeforeEach // 테스트 실행 전 수행(목 설정)
//    public void setMockMvcSetup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//    @AfterEach // 테스트 실행 후 수행(테이블 데이터 제거)
//    public void cleanUp() {
//        memberRepository.deleteAll();
//    }
//
//    @DisplayName("getAllMembers: 아티클 조회에 성공한다.")
//    @Test
//    public void getAllMembers() throws Exception {
//        // given
//        String url = "/test";
//        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));
//
//        // when
//        final ResultActions result = mockMvc.perform(get(url)
//                .accept(MediaType.APPLICATION_JSON)); // 요청 전송
//
//        // then
//        result
//                .andExpect(status().isOk()) // 응답 코드 확인
//                .andExpect(jsonPath("$[0].id").value(savedMember.getId())) // JSON 응답 값과 일치하는지 확인
//                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
//    }
//}