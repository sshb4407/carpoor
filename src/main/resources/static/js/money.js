                                var money = $('#money').text();
                                var money2 = $('#money2').text();
                                var money3 = money2.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                $('#money').text(money3);

                                var modelPrice = $('.modelPrice2').text();
                                var modelPrice2 = modelPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                $('.modelPrice1').text(modelPrice2+"원");


                                 var wholePrice = $('.wholePrice2').text();
                                   var wholePrice2 = wholePrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                   $('.wholePrice1').text(wholePrice2+"원");




                                        function comma(str) {
                                                                                str = String(str);
                                                                                return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
                                                                            }

                                                                            function uncomma(str) {
                                                                                str = String(str);
                                                                                return str.replace(/[^\d]+/g, '');
                                                                            }

                                                                            function inputNumberFormat(obj) {
                                                                                obj.value = comma(uncomma(obj.value));
                                                                            }

                                                                            function inputOnlyNumberFormat(obj) {
                                                                                obj.value = onlynumber(uncomma(obj.value));
                                                                            }

                                                                            function onlynumber(str) {
                                                                        	    str = String(str);
                                                                        	    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g,'$1');
                                                                        	}

                                //마이페이지  내 차 들의 견적서에서 가격 표시 하는거

                                                                 $(document).ready(function() {

                                                                     var $checkElements = $('.main-box2-body-container');

                                                                      // 각 .check 요소에 대한 작업을 수행합니다.
                                                                      $checkElements.each(function() {
                                                                        // 현재 .check 요소 내에서 .price 클래스를 찾습니다.
                                                                        var $priceElement = $(this).find(".myPage-price2");
                                                                        var money4 = $priceElement.text();
                                                                        console.log(money4+"머니4");

                                                                        // .price2 클래스를 가진 요소를 찾습니다.
                                                                        var $money5 = $(this).find(".myPage-price1");

                                                                        // 숫자 형식을 변환하여 콤마를 추가합니다.
                                                                        var money6 = money4.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                                                        console.log(money6);

                                                                        // 변환된 값을 .price2 클래스를 가진 요소의 텍스트로 설정합니다.
                                                                        $money5.text(money6+"원");
                                                                      });
                                                                        });






                                   // section2 에서  옵션 여러개 나오는 가격들에 콤마 붙이는 함수

                                 var moneyP=$('.check');
                                 $(document).ready(function() {

                                     var $checkElements = $('.check');

                                      // 각 .check 요소에 대한 작업을 수행합니다.
                                      $checkElements.each(function() {
                                        // 현재 .check 요소 내에서 .price 클래스를 찾습니다.
                                        var $priceElement = $(this).find(".price");
                                        var money4 = $priceElement.text();
                                        console.log(money4);

                                        // .price2 클래스를 가진 요소를 찾습니다.
                                        var $money5 = $(this).find(".price2");

                                        // 숫자 형식을 변환하여 콤마를 추가합니다.
                                        var money6 = money4.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                        console.log(money6);

                                        // 변환된 값을 .price2 클래스를 가진 요소의 텍스트로 설정합니다.
                                        $money5.text(money6);
                                      });
                                        });



                   // myPageDetail 에서  옵션 여러개 나오는 가격들에 콤마 붙이는 함수

                                 $(document).ready(function() {

                                     var $checkElements = $('.select-option-thing');

                                      // 각 .check 요소에 대한 작업을 수행합니다.
                                      $checkElements.each(function() {
                                        // 현재 .check 요소 내에서 .price 클래스를 찾습니다.
                                        var $priceElement = $(this).find(".optionPrice2");
                                        var money4 = $priceElement.text();
                                        console.log(money4);

                                        // .price2 클래스를 가진 요소를 찾습니다.
                                        var $money5 = $(this).find(".optionPrice1");

                                        // 숫자 형식을 변환하여 콤마를 추가합니다.
                                        var money6 = money4.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                        console.log(money6);

                                        // 변환된 값을 .price2 클래스를 가진 요소의 텍스트로 설정합니다.
                                        $money5.text(money6+"원");
                                      });
                                        });


//  myPageDetail js 부분


                 var price1 =  parseFloat($(".wholePrice2").text(), 10);
                 var price2 =  parseFloat($(".modelPrice2").text(), 10);

                 var optionAllPrice=price1-price2;
                 console.log(optionAllPrice);


                       var optionAllPrice2 = optionAllPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                        $('.optionAllPrice1').text(optionAllPrice2+"원");


                        $(document).ready(function() {

                                                                                             var $checkElements = $('.main-box2-body-container');

                                                                                              // 각 .check 요소에 대한 작업을 수행합니다.
                                                                                              $checkElements.each(function() {
                                                                                                // 현재 .check 요소 내에서 .price 클래스를 찾습니다.
                                                                                                var $priceElement = $(this).find(".myPage-price2");
                                                                                                var money4 = $priceElement.text();
                                                                                                console.log(money4+"머니4");

                                                                                                // .price2 클래스를 가진 요소를 찾습니다.
                                                                                                var $money5 = $(this).find(".myPage-price1");

                                                                                                // 숫자 형식을 변환하여 콤마를 추가합니다.
                                                                                                var money6 = money4.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                                                                                console.log(money6);

                                                                                                // 변환된 값을 .price2 클래스를 가진 요소의 텍스트로 설정합니다.
                                                                                                $money5.text(money6+"원");
                                                                                              });
                                                                                                });
