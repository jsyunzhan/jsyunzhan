$(function(){

    $.ajax({
        url: '/security/resources/'+roleId,
        type: 'GET',
        dataType: "json",
        timeout: 360000,
        cache: false,
        success: function (resouces) {
            console.log(resouces)
        }
    });

})