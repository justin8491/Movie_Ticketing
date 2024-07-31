$(document).ready(function() {
    $('#reviewForm').submit(function(event) {
        // 폼 제출 시 추가적인 검증을 여기에 작성할 수 있습니다.
        event.preventDefault(); // 폼의 기본 제출 동작을 막음

        var reviewRating = $('#reviewRating').val();
        if (reviewRating != 0) {
            // AJAX 요청을 통해 서버로 폼 데이터를 전송할 수 있습니다.
            $.ajax({
                type: 'POST',
                url: '/user/movie/createReview', // 리뷰 작성 처리 URL
                data: $('#reviewForm').serialize(),
                success: function(response) {
                    alert('리뷰작성이 완료되었습니다!');
                    location.href = response.location; // 페이지 리다이렉트
                },
                error: function(xhr, status, error) {
                    console.error('AJAX Error: ' + error);
                }
            });
        } else {
            alert('평점을 선택해 주세요.');
        }
    });

    // 리뷰 작성 폼 별점 선택
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

    // 리뷰 수정 폼 별점 선택

    const starsUpdate = document.querySelectorAll('.starUpdate');
    const ratingInputUpdate = document.getElementById('reviewRatingUpdate');

    starsUpdate.forEach(star => {
        star.addEventListener('click', function() {
            //console.log('Star clicked:', this); // 추가된 로그
            const rating = this.getAttribute('data-value');

            // 모든 별 초기화
            starsUpdate.forEach(s => s.classList.remove('selectedUpdate'));

            // 클릭한 별과 이전 별들에 'selected' 클래스 추가
            for (let i = 0; i < rating; i++) {
                starsUpdate[i].classList.add('selectedUpdate');
            }

            // 입력 필드에 선택된 별점 값 설정
            ratingInputUpdate.value = rating;
        });
    });




    // 리뷰 수정 기능 추가
    window.showEditForm = function(reviewId) {
        $('#edit-form-' + reviewId).show(); // 해당 리뷰의 수정 폼 표시
        $('#review-' + reviewId + ' .review-content').hide(); // 기존 리뷰 내용 숨김
    };

    window.hideEditForm = function(reviewId) {
        $('#edit-form-' + reviewId).hide(); // 해당 리뷰의 수정 폼 숨김
        $('#review-' + reviewId + ' .review-content').show(); // 기존 리뷰 내용 표시
    };

    window.updateReview = function(reviewId) {
        var editedContent = $('#edit-content-' + reviewId).val();
        var reviewRatingUpdate = $('#reviewRatingUpdate').val();

        if (reviewRatingUpdate != 0) {
            $.ajax({
                type: 'POST',
                url: '/user/movie/updateReview', // 리뷰 수정 처리 URL
                data: {
                    rev_no: reviewId,
                    rev_content: editedContent,
                    rev_rating: reviewRatingUpdate // 수정된 부분
                },
                success: function(response) {
                    alert('리뷰 수정이 완료되었습니다!');
                    // DOM 업데이트
                    $('#review-content-' + reviewId).text(editedContent); // 수정된 내용 반영
                    $('#review-rating-' + reviewId).text(reviewRatingUpdate); // 수정된 평점 반영

                // 필요 시 추가적인 UI 업데이트
                // 예: 수정한 리뷰가 있는 영역을 강조
                $('#review-item-' + reviewId).addClass('updated'); // 'updated' 클래스 추가 (스타일링 가능)

                hideEditForm(reviewId);
                },
                error: function(xhr, status, error) {
                    console.error('AJAX Error: ' + error);
                }
            });
        } else {
            alert('평점을 선택해 주세요.');
        }
    };

    window.deleteReview = function(reviewId, mo_no) {
            var editedContent = $('#edit-content-' + reviewId).val();
            var reviewRatingUpdate = $('#reviewRatingUpdate').val();

            if (true) {
                $.ajax({
                    type: 'POST',
                    url: '/user/movie/deleteReview', // 리뷰 수정 처리 URL
                    data: {
                        rev_no: reviewId,
                        mo_no: mo_no
                    },
                    success: function(response) {
                        alert('리뷰 삭제가 완료되었습니다!');
                        location.href = response.location;
                        // DOM 업데이트
                        //$('#review-content-' + reviewId).text(editedContent); // 수정된 내용 반영
                        //$('#review-rating-' + reviewId).text(reviewRatingUpdate); // 수정된 평점 반영



                    },
                    error: function(xhr, status, error) {
                        console.error('AJAX Error: ' + error);
                    }
                });
            }
//            else {
//                alert('평점을 선택해 주세요.');
//            }
        };

let isRequestInProgress = false; // 요청 진행 상태 변수

$('.fa-heart').one('click', function() {
    if (isRequestInProgress) return; // 요청이 진행 중이면 무시

    var mem_id = $('#mem_id').val();
    var mo_no = $('#mo_no').val();

    isRequestInProgress = true; // 요청 시작
    console.log('heart click');
    $.ajax({
        type: 'POST',
        url: '/user/movie/updateMovieLike',
        data: {
            mem_id: mem_id,
            mo_no: mo_no,
        },
        success: function(response) {
            alert("좋아요 요청 처리 완료");

            // ml_status에 따라 하트 아이콘 변경
            if (response.ml_status === 1) {
                $('.fa-heart').removeClass('fa-regular').addClass('fa-solid').css('color', '#ff0000');
            } else {
                $('.fa-heart').removeClass('fa-solid').addClass('fa-regular').css('color', '');
            }
            location.href = response.location;
        },
        error: function(xhr, status, error) {
            console.error('AJAX Error: ' + error);
            location.href = "/user/movie/detailMovie?mo_no="+mo_no;
        },
        complete: function() {
            isRequestInProgress = false; // 요청 완료
        }
    });
});




});
