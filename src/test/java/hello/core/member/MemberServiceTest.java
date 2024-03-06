package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appconfig=new AppConfig();
        memberService=appconfig.memberService();
    }

    @Test
    void join(){
        //given(이런 환경에서)
        Member member=new Member(1L,"memberA",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember=memberService.findMember(1L);


        //then(이렇게 된다)
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
