package com.project.carPoor.repository;

import com.project.carPoor.domain.Car;
import com.project.carPoor.domain.QCar;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;
    private final QCar qCar;

    public CarRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
        this.qCar = QCar.car;
    }

    //검색 옵션에 맞는 자동차 찾기
    public List<Car> getCarsBySearch(List<String> brand, List<String> size, String engine, Long displacement) {
        return query
                .selectFrom(qCar)
                .where(inBrand(brand),
                        inSize(size),
                        ctEngine(engine),
                        loeDisplacement(displacement))
                .fetch();
    }

    // 검색옵션 null(선택안함) 처리 시작
    private BooleanExpression inBrand(List<String> brand) {
        if( brand == null ) return null;
        return qCar.brand.in(brand);
    }

    private BooleanExpression inSize(List<String> size) {
        if( size == null ) return null;
        return qCar.size.in(size);
    }

    private BooleanExpression ctEngine(String engine) {
        if( engine == null ) return null;
        return qCar.engine.contains(engine);
    }

    private BooleanExpression loeDisplacement(Long displacement) {
        if( displacement == null ) return null;
        return qCar.displacement.loe(displacement);
    }
    // 검색옵션 null(선택안함) 처리 끝

}
