package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager manager;

    public JpaMemberRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Member save(Member member) {
        manager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = manager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = manager.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return manager.createQuery("select m from  Member m", Member.class)
                .getResultList();

//        List<Member> result = manager.createQuery("select m from  Member m", Member.class)
//                .getResultList();
//        return result;
    }
}
