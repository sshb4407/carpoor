package com.project.carPoor.repository;

import com.project.carPoor.domain.CarOption;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarOptionRepository {

    private final EntityManager em;

    public CarOptionRepository(EntityManager em) {
        this.em = em;
    }



    public List<CarOption> findAll() {
        return em.createQuery("select o from CarOption o", CarOption.class)
                .getResultList();
    }


    public List<CarOption> findById(List<Integer> id) {
        return em.createNativeQuery(
                        "SELECT * FROM CarOption  WHERE CarOption.id in :id",
                        CarOption.class
                )
                .setParameter("id", id)
                .getResultList();
    }





    @Transactional
    @Modifying(clearAutomatically = true)
    public void doDelete(List<Integer> id){
        try {
            System.out.println("삭제1 실행");
            em.createNativeQuery("DELETE FROM selectOption_optionId WHERE SelectOption_id IN (:id)"
                         )
                    .setParameter("id", id)
                     .executeUpdate();
        } catch (Exception e) {
            // Handle the exception (e.g., log it, throw a custom exception, etc.)
            System.out.println("삭제 오류");
            e.printStackTrace();
        }

    }


    @Transactional
    @Modifying(clearAutomatically = true)
    public void doDelete2(List<Integer> id){
        try {
            System.out.println("삭제 2 실행");
            em.createNativeQuery(
                            "DELETE FROM selectOption WHERE id IN (:id)")
                    .setParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            // Handle the exception (e.g., log it, throw a custom exception, etc.)
            System.out.println("삭제 오류");
            e.printStackTrace();
        }

    }



//    @Override
//    public List<CarOption> findByid(Integer optionIds){
//
//        return em.createQuery("select * from CarOption where SelectOption_optionId.id in :id ", CarOption.class)
//                .setParameter("id", optionIds)
//                .getResultList();
//
//    };

//    @Override
//    public List<Integer> getCarDetailByColorId(List<List<Integer>> id){
//
//        return em.createQuery("select * from CarOption where CarOption.id in :id ", CarOption.class)
//                .setParameter("id", id)
//                .getResultList();
//
//    };
}
