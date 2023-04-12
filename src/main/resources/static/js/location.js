
// 현재 위치 찾기

$(document).ready(function (){
    $('#location').on('click',function(){
        if (navigator.geolocation) {
            // 위치 정보를 얻는데 성공한 경우
            navigator.geolocation.getCurrentPosition(function(position) {
                const latitude = position.coords.latitude;
                const longitude = position.coords.longitude;
                console.log(`현재 위치: 위도 ${latitude}, 경도 ${longitude}`);
            }, function(error) {
                // 위치 정보를 얻는데 실패한 경우
                console.error(error);
            });
        } else {
            // 위치 정보를 지원하지 않는 경우
            console.error('Geolocation is not supported.');
        }
    });
});

