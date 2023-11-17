package com.project.carPoor.repository;

import com.project.carPoor.domain.SelectOption;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


//@Transactional
@Repository
public class SelectOptionRepository {

    private final JPAQueryFactory query;
    private final EntityManager em;

    public SelectOptionRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);


    }


    @Transactional
    public SelectOption create(Integer inColorId, List<Integer> optionId, Integer outColorId,
                               Integer wholePrice, String outImgUrl, String inImgUrl, Long userId) {
        SelectOption user = new SelectOption();
        String dateFormat = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));


        user.setInColorId(inColorId);
        user.setOutColorId(outColorId);
        user.setOptionId(optionId);
        user.setWholePrice(wholePrice);

        user.setCreateDate(dateFormat);
        user.setOutImgUrl(outImgUrl);
        user.setInImgUrl(inImgUrl);
        user.setUserId(userId);
        em.persist(user); // 데이터베이스에 저장

        return user;
    }


    public List<SelectOption> findAll(Long id) {
        // EntityManager를 사용하여 적절한 JPQL 또는 Criteria API 쿼리를 작성하여 데이터를 가져옵니다.
        return em.createQuery("SELECT s FROM SelectOption s WHERE s.userId = :id", SelectOption.class)
                .setParameter("id", id)
                .getResultList();


    }



    public List<Integer> findOptionDetailById(Integer id) {
        return em.createNativeQuery(
                        "SELECT option_id FROM selectOption_optionId WHERE SelectOption_id = :id")
                .setParameter("id", id)
                .getResultList();
    }





    public List<SelectOption> findBySelectOptionId(@Param("id") Integer id){

        return em.createQuery("SELECT s FROM SelectOption  s WHERE s.id = :id")

                .setParameter("id",id)
                .getResultList();

    }



    public List<SelectOption> getLastSelectOption(){

        return em.createNativeQuery("SELECT * FROM select_option ORDER BY id DESC LIMIT 1")


                .getResultList();

    }



}
