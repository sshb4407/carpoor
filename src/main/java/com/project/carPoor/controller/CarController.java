package com.project.carPoor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.carPoor.domain.*;
import com.project.carPoor.service.CarService;
import com.project.carPoor.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/car")  // /car 로 시작하는 url 은 여기서 찾음
// final 변수 생성자
public class CarController {
    private final MemberService memberService;
    private final CarService carService;

    private List<Car> cars; // 검색으로 뽑힌 자동차가 저장될 곳.

    @GetMapping("/list/hyundai")
    public String showListHyundai() {


        List<Car> cars = carService.getCarsBySearch(null, null, null, null);

        this.cars = cars;

        return "/car/list";
    }

    @PostMapping("/list/hyundai") // ajax 비동기 데이터 받기
    public String getSearchForm(SearchForm form) {

        List<Car> cars = carService.getCarsBySearch(form.getBrand(), form.getSize(), form.getEngine(), form.getDisplacement());

        this.cars = cars;

        for(Car car : cars) { // 데이터 잘 뽑히는지 로그 환인용
            System.out.println(car.getId());
        }

        return "/car/list";
    }


    @GetMapping("/getCars") // ajax 비동기 데이터 전송
    @ResponseBody
    public String getCars() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper(); // List<Car> 를 json 타입으로 변환

        return objectMapper.writeValueAsString(this.cars); // List<Car> 를 json 타입으로 변환을 String 으로 변환
    }





    @PreAuthorize("isAuthenticated()")
    @GetMapping("/color")
    public String getColor(Model model) {

        List<CarDetail> carDetails =carService.getColor();
        List<CarDetail2> carDetails2 = carService.getColor2();
        List<CarOption> carOption = carService.getCarOptionList();

        model.addAttribute("selectTrue");

        model.addAttribute("carDetails", carDetails);
        model.addAttribute("carDetails2", carDetails2);
        model.addAttribute("carOption", carOption);

        return "selectOption";

    }

    @GetMapping("/color2")
    public String getColor2(Model model) {

        List<CarDetail> carDetails = carService.getColor();
        List<CarDetail2> carDetails2 = carService.getColor2();
        List<CarOption> carOption = carService.getCarOptionList();

        model.addAttribute("selectTrue");

        model.addAttribute("carDetails", carDetails);
        model.addAttribute("carDetails2", carDetails2);
        model.addAttribute("carOption", carOption);

        return "selectOption2";

    }
        @PostMapping("/car/select")
    public String getSelect(SelectForm selectForm) {

        System.out.println(selectForm.getOptionId());
        System.out.println(selectForm.getInteriorColor());



        return "redirect:/";
    }

    @GetMapping("/myPage") //
    public String showMyPage(Model model,Integer userId, Integer selectOptionId,
                             Principal principal) {


        //여기에는 이제 userId 를 매개변수로 넣어서 그 userId 의 차 견적 정보만 뜨게 하기
        // 지금은 전체 견적 리스트 뽑음
        //상세페이지에서는 이 리스트가 하나만 나오게 해야됨
        //내 차만들기 하고 바로 견적서 보여주려면 로그인한 유저의 가장 최근에 추가된
        // selectOption db 정보를 보여주면 될것같다.
        System.out.println("마이 페이지 실행 시작");
        Member member = memberService.getMemberByLoginId(principal.getName());

        System.out.println(member.getId()+"멤버의 id");
        List<SelectOption> selectOptions = carService.getSelectOptionList(member.getId());


        List<Integer> colorIds = new ArrayList<>();

//         여기에 유저id ,userId 나 그런거 넣으면 optionid 를 리스트 형태로 반환함
        // 지금은 예시용으로 어떤 유저의 첫번쨰 견적 정보 받음
        // 만약 2를 적으면 그 사람의 2번쨰 견적 차량의 optionIds 받는거고
        //여기서 optionIds 는 네비, 폰충전, 등등 내부 옵션등을 말한다.
        List<Integer> optionIds= carService.getSelectOptionIdsById(1);



        for (SelectOption selectOption : selectOptions) {
            // Assuming getColorId() is the method to retrieve the colorId from SelectOption
            int colorId = selectOption.getOutColorId();
            colorIds.add(colorId);
        }

        List<CarOption> carOption =carService.getCarOptionById(optionIds);



        List<CarDetail> carDetail =carService.getCarDetailByColorId(colorIds);
        for(SelectOption selectOption : selectOptions){
            System.out.println(selectOption.getWholePrice());
        }

        for(CarDetail carDetail1: carDetail){
            System.out.println(carDetail1.getImgUrl());
        }

        if(selectOptions.size()==0){

            System.out.println("값없음");
            model.addAttribute("selectOption", null);
        }
        else {
            System.out.println("값있음");
            model.addAttribute("selectOption", selectOptions);
        }


        model.addAttribute("carOption", carOption);


        model.addAttribute("carDetail", carDetail);



        return "myPage";

    }

    @GetMapping("myPageDetail/{selectOptionId}")
    public String showMyPageDetail(Model model, @PathVariable("selectOptionId") Integer selectOptionId) {
        System.out.println("견적 상세페이지 실행됨");
        System.out.println(selectOptionId);

        List<SelectOption> selectOptions= carService.getListBySelectOptionId(selectOptionId);

        System.out.println(selectOptions);
        System.out.println(selectOptions.get(0).getWholePrice());


        List<Integer> colorIds1 = new ArrayList<>();
        List<Integer> colorIds2 = new ArrayList<>();
        List<Integer> optionIds = carService.getSelectOptionIdsById(selectOptionId);

        colorIds1.add(selectOptions.get(0).getOutColorId());
        colorIds2.add(selectOptions.get(0).getInColorId());



//        for (SelectOption selectOption : selectOptions) {
//            // Assuming getColorId() is the method to retrieve the colorId from SelectOption
//            int colorId = selectOption.getOutColorId();
//            colorIds.add(colorId);
//        }



        List<CarOption> carOption =carService.getCarOptionById(optionIds);
        List<CarDetail> carDetail =carService.getCarDetailByColorId(colorIds1);
        List<CarDetail2> carDetail2 =carService.getCarDetail2ByColorId(colorIds2);

        System.out.println(carDetail2);

        model.addAttribute("selectOption", selectOptions);
        model.addAttribute("carDetail", carDetail);
        model.addAttribute("carDetail2", carDetail2);

        model.addAttribute("carOption", carOption);


        return "myPageDetail";
    }


    @PostMapping("/doDelete")
    public String result(Model model, @RequestParam("id") List<Integer> id) {
        System.out.println("삭제 기능 시작");
        System.out.println(id.get(0));

        carService.delete(id);


        return "redirect:/car/myPage";
    }

    @GetMapping("/detail/santafe")
    public String showCarDetail() {

        return "/carDetail";
    }


}


