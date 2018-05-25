
$(function(){

    console.log(path);

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
            url: path +'/security/login',
            type: 'POST', dataType: "json",
            data: data,
            success: function (serverResponse) {
                console.log(serverResponse);
                console.log("3");
                if (serverResponse.success) {
                    console.log("1");
                    location.href = path + "/security/home";
                } else {
                    console.log("2");
                    $("#userError").text(serverResponse.reason);
                    $("#userError").addClass("red_1");
                }
            },
            error: function (xmlHttpReq, textStatus, errorThrow) {

            }
        });
    }
});