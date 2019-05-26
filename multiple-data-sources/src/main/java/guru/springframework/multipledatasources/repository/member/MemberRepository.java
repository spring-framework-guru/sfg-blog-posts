package guru.springframework.multipledatasources.repository.member;

import guru.springframework.multipledatasources.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author maureen on 26/5/2019
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
}
