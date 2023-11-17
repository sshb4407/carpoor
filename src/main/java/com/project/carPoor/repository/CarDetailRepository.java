package com.project.carPoor.repository;


import com.project.carPoor.domain.CarDetail;
import com.project.carPoor.domain.CarDetail2;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CarDetailRepository {

    private final JPAQueryFactory query;

    private final EntityManager em;

    public CarDetailRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public List<CarDetail> getColor() {
        return em.createQuery("select c from CarDetail c", CarDetail.class)
                .getResultList();
    }

    public List<CarDetail2> getColor2() {
        return em.createQuery("select d from CarDetail2 d", CarDetail2.class)
                .getResultList();
    }

    public List<CarDetail> getCarDetailByColorId(List<Integer> id) {
        return em.createNativeQuery(
                        "SELECT * FROM CarDetail  WHERE CarDetail.id in :id",
                        CarDetail.class
                )
                .setParameter("id", id)
                .getResultList();
    }

    public List<CarDetail2> getCarDetail2ByColorId(List<Integer> id) {
        return em.createNativeQuery(
                        "SELECT * FROM CarDetail2  WHERE CarDetail2.id in :id",
                        CarDetail2.class
                )
                .setParameter("id", id)
                .getResultList();
    }
}
