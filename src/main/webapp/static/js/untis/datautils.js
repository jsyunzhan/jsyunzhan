
//过去分页page
function getPage(param) {
    var rows = param.rows;
    var page = param.page;
    param.page = (page-1)*rows;
    return param;
}