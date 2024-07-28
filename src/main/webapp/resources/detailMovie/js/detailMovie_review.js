$(document).ready(function() {
        $('#reviewForm').submit(function(event) {
            // 폼 제출 시 추가적인 검증을 여기에 작성할 수 있습니다.
            event.preventDefault(); // 폼의 기본 제출 동작을 막음
            // 필요한 추가 작업을 수행한 후 폼을 제출할 수 있습니다.
            var reviewForm = $('#reviewForm').serialize();
//            console.dir("reviewForm : ");
//            console.dir(reviewForm);
            // 예를 들어, 아이디 중복 확인 결과에 따라 폼 제출을 막을 수 있습니다.
            var mem_id = $('#mem_id').val();
            var reviewRating = $('#reviewRating').val();
            if (reviewRating != 0) {
                // AJAX 요청을 통해 서버로 폼 데이터를 전송할 수 있습니다.
                // 예시 코드:
                $.ajax({
                    type: 'POST',
                    url: '/user/movie/createReview', // 회원가입 처리 URL
                    data: $('#reviewForm').serialize(),
                    success: function(response) {
                        alert('리뷰작성이 완료되었습니다!');
//                        console.log("response : ", response);
                        // 필요 시 페이지를 리다이렉트하거나 다른 작업을 수행할 수 있습니다.
                        location.href = response.location;
                    },
                    error: function(xhr, status, error) {
                        console.error('AJAX Error: ' + error);
                    }
                });
            } else {
                alert('평점을 선택해 주세요.');
            }
        });

        const stars = document.querySelectorAll('.star');
            const ratingInput = document.getElementById('reviewRating');

            stars.forEach(star => {
                star.addEventListener('click', function() {
                    const rating = this.getAttribute('data-value');

                    // 모든 별 초기화
                    stars.forEach(s => s.classList.remove('selected'));

                    // 클릭한 별과 이전 별들에 'selected' 클래스 추가
                    for (let i = 0; i < rating; i++) {
                        stars[i].classList.add('selected');
                    }

                    // 입력 필드에 선택된 별점 값 설정
                    ratingInput.value = rating;
                });
            });


    });