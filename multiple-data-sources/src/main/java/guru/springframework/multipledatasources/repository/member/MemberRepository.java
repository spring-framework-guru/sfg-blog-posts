package guru.springframework.multipledatasources.repository.member;

import guru.springframework.multipledatasources.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
