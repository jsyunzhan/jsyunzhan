$(function(){

    $("#loginBtn").on('click',function () {
        login();
    });
    $(document).keydown(function(event){
        if(event.keyCode == 13){
            login();
        }
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
                    $("#userError").text(serverResponse.reason);
                    $("#userError").addClass("red_1");
                }
            },
            error: function (xmlHttpReq, textStatus, errorThrow) {

            }
        });
    }
});