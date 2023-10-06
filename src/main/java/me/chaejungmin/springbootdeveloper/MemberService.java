//package me.chaejungmin.springbootdeveloper;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class MemberService {
//    private final MemberRepository memberRepository;
//
//    Long id = 1L;
//
//    public void test() { // 생성
//        memberRepository.save(new Member(id, "A"));
//        // 조회
//        Optional<Member> member = memberRepository.findById(id);
//        List<Member> allMembers = memberRepository.findAll();
//
//        // 삭제
//        memberRepository.deleteById(id);
//    }
//}
