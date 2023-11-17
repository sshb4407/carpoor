package com.project.carPoor.service;

import com.project.carPoor.domain.*;
import com.project.carPoor.repository.CarDetailRepository;
import com.project.carPoor.repository.CarOptionRepository;
import com.project.carPoor.repository.CarRepository;
import com.project.carPoor.repository.SelectOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final CarOptionRepository carOptionRepository;

    private final CarDetailRepository carDetailRepository;

    private final SelectOptionRepository selectOptionRepository;



    public List<Car> getCarsBySearch(List<String> brand, List<String> size, String engine, Long displacement) {
        return carRepository.getCarsBySearch(brand, size, engine, displacement);
    }




    public List<CarDetail> getColor() {
        return carDetailRepository.getColor();
    }

    public List<CarDetail> getCarDetailByColorId(List<Integer> id) {
        return carDetailRepository.getCarDetailByColorId(id);
    }

    public List<CarDetail2> getCarDetail2ByColorId(List<Integer> id) {
        return carDetailRepository.getCarDetail2ByColorId(id);
    }


    public List<CarDetail2> getColor2() {
        return carDetailRepository.getColor2();
    }

    public List<CarOption> getCarOptionList() {
        return carOptionRepository.findAll();
    }



    public List<CarOption> getCarOptionById(List<Integer> id){ return carOptionRepository.findById(id);}

//    public List<CarOption> getCarOptionByOptionId(List<List<Integer>> optionIds) {
//        return carOptionRepository.getCarDetailByColorId(optionIds);
//    }

//    public List<Integer> getCarOptionIdsById(Integer id) {
//        return carOptionRepository.findById(id);
//    }

    public List<Integer> getSelectOptionIdsById(Integer i) {
        return selectOptionRepository.findOptionDetailById(i);
    }

    public void delete(List<Integer> id) {
        this.carOptionRepository.doDelete(id);
        this.carOptionRepository.doDelete2(id);


    }
    public void delete2(List<Integer> id) {


    }

    public List<SelectOption> getLastSelectOption() {
        return this.selectOptionRepository.getLastSelectOption();
    }


    public SelectOption create( Integer inColorId,List<Integer> optionId ,Integer outColorId,
                               Integer wholePrice ,String outImgUrl, String inImgUrl,
                               Long userId ) {



        return selectOptionRepository.create(inColorId,optionId,outColorId,wholePrice,outImgUrl,inImgUrl,userId);
    }

    public List<SelectOption> getSelectOptionList(Long userId) {
        return this.selectOptionRepository.findAll(userId);
    }




    public List<SelectOption> getListBySelectOptionId(Integer selectOptionId) {
        return this.selectOptionRepository.findBySelectOptionId(selectOptionId);
    }


}
