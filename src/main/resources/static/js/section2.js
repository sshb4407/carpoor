                    $(document).ready(function() {

                    const externalButton = document.getElementById('externalButton');
                    selectButton(externalButton);


                    var colorListContainer = $(".colorListContainer");
                    var colorList = $(".colorList");

                    $(".dd").on("click", function() {
                        var imgUrl = $(this).attr("data-img-url");
                        $(".cc").attr("src", imgUrl);
                         $(".dbGoOutImg").attr("value", imgUrl);


                        // 스크롤 위치 조정
                        var containerWidth = colorListContainer.width();
                        var selectedDiv = $(this);
                        var selectedDivOffset = selectedDiv.offset().left;
                        var scrollOffset = selectedDivOffset - (containerWidth / 2) + (selectedDiv.width() / 2);
                        colorListContainer.scrollLeft(scrollOffset);
                    });

                    if (colorList.width() > colorListContainer.width()) {
                        colorListContainer.css("overflow-x", "scroll");
                    }
                });

                $(document).ready(function() {

                    const externalButton = document.getElementById('externalButton');
                    selectButton(externalButton);


                    var colorListContainer = $(".colorListContainer");
                    var colorList = $(".colorList");

                    $(".ddd").on("click", function() {
                        var imgUrl = $(this).attr("data-img-url");
                        $(".ccc").attr("src", imgUrl);
                         $(".dbGoInImg").attr("value", imgUrl);


                        // 스크롤 위치 조정
                        var containerWidth = colorListContainer.width();
                        var selectedDiv = $(this);
                        var selectedDivOffset = selectedDiv.offset().left;
                        var scrollOffset = selectedDivOffset - (containerWidth / 2) + (selectedDiv.width() / 2);
                        colorListContainer.scrollLeft(scrollOffset);
                    });

                    if (colorList.width() > colorListContainer.width()) {
                        colorListContainer.css("overflow-x", "scroll");
                    }
                });



                let previousDiv = null;
                var selectedDiv = null;

                function doClick(currentDiv) {
                    // 이전에 강조된 div가 있다면 border 스타일을 제거
                    if (previousDiv !== null) {
                        previousDiv.classList.remove('border-highlight');
                    }

                    // 현재 div에 border 스타일을 추가
                    currentDiv.classList.add('border-highlight');

                    // 현재 div를 이전 div로 설정
                    previousDiv = currentDiv;


                     if (selectedDiv !== null) {
                            // 이전에 선택된 div의 checkbox를 해제합니다.
                            var previousCheckbox = selectedDiv.querySelector('input[type="checkbox"]');
                            previousCheckbox.checked = false;
                        }

                        // 현재 선택된 div를 저장합니다.
                        selectedDiv = currentDiv;

                        // 현재 선택된 .colorItem div 요소를 가져옵니다.
                        var colorItem = currentDiv.querySelector('.colorItem');

                        // 해당 .colorItem div 안의 checkbox 요소를 가져옵니다.
                        var checkbox = colorItem.querySelector('input[type="checkbox"]');

                        // checkbox 상태를 반전시킵니다.
                        checkbox.checked = !checkbox.checked;
                }


                let previousDiv2 = null;
                var selectedDiv2 = null;

                function doClick2(currentDiv) {
                    // 이전에 강조된 div가 있다면 border 스타일을 제거
                    if (previousDiv2 !== null) {
                        previousDiv2.classList.remove('border-highlight');
                    }

                    // 현재 div에 border 스타일을 추가
                    currentDiv.classList.add('border-highlight');

                    // 현재 div를 이전 div로 설정
                    previousDiv2 = currentDiv;


                     if (selectedDiv2 !== null) {
                            // 이전에 선택된 div의 checkbox를 해제합니다.
                            var previousCheckbox = selectedDiv2.querySelector('input[type="checkbox"]');
                            previousCheckbox.checked = false;
                        }

                        // 현재 선택된 div를 저장합니다.
                        selectedDiv2 = currentDiv;

                        // 현재 선택된 .colorItem div 요소를 가져옵니다.
                        var colorItem2 = currentDiv.querySelector('.colorItem3');

                        // 해당 .colorItem div 안의 checkbox 요소를 가져옵니다.
                        var checkbox2 = colorItem2.querySelector('input[type="checkbox"]');

                        // checkbox 상태를 반전시킵니다.
                        checkbox2.checked = !checkbox2.checked;
                }






                 function selectButton(button) {
                  const buttons = document.querySelectorAll('.button-container button');
                  buttons.forEach(btn => btn.classList.remove('selected'));
                  button.classList.add('selected');

                  if (button.textContent === '외부 색상') {
                    document.getElementById('content1').style.display = 'block';
                    document.getElementById('content2').style.display = 'none';
                } else if (button.textContent === '내부 색상') {
                    document.getElementById('content1').style.display = 'none';
                    document.getElementById('content2').style.display = 'block';
                    }
                }

                function toggleContentDisplay(contentId, display) {
                const content = document.getElementById(contentId);
                const contentElements = content.querySelectorAll('*');

                if (display === 'none') {
                    content.style.display = 'none';
                    contentElements.forEach(element => {
                        element.classList.add('hidden-element');
                    });
                } else {
                    content.style.display = 'block';
                    contentElements.forEach(element => {
                        element.classList.remove('hidden-element');
                    });
                }
            }

//
//            document.addEventListener('DOMContentLoaded', function() {
//                // 첫 번째 input 요소를 선택합니다. 여기서는 name 속성이 "outColorId"인 첫 번째 요소를 선택합니다.
//                const firstInput = document.querySelector('input[name="inColorId"]:first-of-type');
//
//                // 첫 번째 input 요소를 클릭 이벤트를 발생시킵니다.
//                if (firstInput) {
//                    doClick2(firstInput);
//                }
//            });
//
//            document.addEventListener('DOMContentLoaded', function() {
//                // 첫 번째 input 요소를 선택합니다. 여기서는 name 속성이 "outColorId"인 첫 번째 요소를 선택합니다.
//                const firstInput2 = document.querySelector('input[name="outColorId"]:first-of-type');
//
//                // 첫 번째 input 요소를 클릭 이벤트를 발생시킵니다.
//                if (firstInput2) {
//                    doClick(firstInput2);
//                }
//            });
