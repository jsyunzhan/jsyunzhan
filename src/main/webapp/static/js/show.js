$(function () {
   // alert("1")

    // $.ajax({
    //     url: theUri, type: theHttpMethod, dataType: "json", timeout: 360000, cache: false,
    //     data: theObject,
    //     success: function (serverResponse) {
    //         if (theInvokeAfter != null && theInvokeAfter != undefined) {
    //             theInvokeAfter(serverResponse);
    //         }
    //     },
    //     error: function (xmlHttpReq, textStatus, errorThrow) {
    //         showErrorMessage(CLIENT_COMMON_I18N.msg_server_error + ':' + xmlHttpReq.status);
    //     }
    // });

    $.ajax({
        url:"/user/getuser",type:"GET",dataType:"json",
        success:function (r) {
            console.log(r)
        }
    })
});