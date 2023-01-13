package hello.spring.hellospring.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OracleRepositoryImpl {
	
	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();

}
