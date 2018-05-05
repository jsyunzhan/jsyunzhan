$(function(){

    placeholder(".username",".prompt");
    placeholder(".password",".prompt");



    $("#loginBtn").on('click',function () {

        login();
    })

    function login() {
        var data = $('#loginForm').serializeObject();
        $.ajax({
            url: '/security/login',
            type: 'POST', dataType: "json", timeout: 360000,
            data: data,
            success: function (serverResponse) {

                if (serverResponse.success) {
                    window.location.href = "/security/home";
                } else {
                    alert(serverResponse.reason);
                }
            },
            error: function (xmlHttpReq, textStatus, errorThrow) {

            }
        });
    }
});

})