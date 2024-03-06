package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,  @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy=discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {//주문이 들어오면
       Member member=memberRepository.findById(memberId); //회원을 찾고
       int discountPrice=discountPolicy.discount(member,itemPrice); //회원정보에 따른 할인금액 찾고

       return new Order(memberId,itemName,itemPrice,discountPrice); //생성된 주문 반환
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
