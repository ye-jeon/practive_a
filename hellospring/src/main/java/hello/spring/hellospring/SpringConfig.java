package hello.spring.hellospring;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import hello.spring.hellospring.repository.MemberRepository;
import hello.spring.hellospring.repository.MemoryRepositoryImpl;
import hello.spring.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository(memberRepository()));
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryRepositoryImpl();
	}
	                      
	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml");
        
        sessionFactory.setMapperLocations(res);
        
        return sessionFactory.getObject();
    }
}
