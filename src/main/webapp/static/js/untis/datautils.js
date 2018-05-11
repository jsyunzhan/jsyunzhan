
//计算分页page
function getPage(param) {
    var rows = param.rows;
    var page = param.page;
    param.page = (page-1)*rows;
    return param;
}

//角色验证是否重复

function checkRoleName(data) {
    var flag = false;
    $.ajax({
        url: "/system/rolemanpage/checkrolename" , type: "POST", dataType:"json",data:data,async: false,
        success: function (r) {
            flag = r;
        }
    });
    return flag;
}