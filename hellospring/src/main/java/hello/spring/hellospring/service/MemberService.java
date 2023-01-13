package hello.spring.hellospring.service;

import java.util.List;
import java.util.Optional;

import hello.spring.hellospring.repository.Member;
import hello.spring.hellospring.repository.MemberRepository;
import hello.spring.hellospring.repository.MemoryRepositoryImpl;

public class MemberService {
	
	private final MemberRepository memberRepository = new MemoryRepositoryImpl();
	
	//회원가입
	
	public Long join(Member member) {
		
		Optional<Member> result = memberRepository.findByName(member.getName());
		result.ifPresent(m->{
			throw new IllegalStateException("이미 존재하는 회원입니다.");
			
		});		
		memberRepository.save(member);
		return member.getId();
	}
	
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memeberId){
		Long memberId = null;
		return memberRepository.findById(memberId);
	}
}
