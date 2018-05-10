$(function(){

    $.ajax({
        url: '/security/resources/'+roleId,
        type: 'GET',
        dataType: "json",
        timeout: 360000,
        cache: false,
        success: function (resouces) {
            var _html = "";
            var  num = 0;
            for(var i=0;i<resouces.length;i++){
                if(!resouces[i].parentId){
                    _html += '<div class="modular">';
                    _html += '<div class="title_first" data-target="#modular_child'+num+'" data-toggle="collapse" id="'+resouces[i].id+'">';
                    _html += '<div class="icon_title"><img src="'+resouces[i].imageUrl+'"></div>'+resouces[i].resourceName;
                    _html += '<div class="arrow white_right"><img src="../../static/images/white_right.png"></div>';
                    _html += '<div class="arrow white_down none"><img src="../../static/images/white_down.png"></div></div>';
                    _html += '<ul id="modular_child'+num+'" class="collapse">';
                    num++;
                }else{
                    if(resouces[i+1]&&resouces[i+1].parentId) {
                        _html += '<li><a href="'+resouces[i].resourceUrl+'">'+resouces[i].resourceName+'</a></li>';
                    }else{
                        _html += '<li><a href="'+resouces[i].resourceUrl+'">'+resouces[i].resourceName+'</a></li></ul></div>';
                    }
                }
            }
            $(".sidebar").append(_html);
            modular_click();
        }
    });

    function modular_click(){
        $(".title_first").click(function () {
            if(IEVersion() == 8){
                var con = $(this).attr("aria-expanded");
                if(con == "true"){
                    $(this).find(".white_down").addClass("none");
                    $(this).find(".white_down").removeClass("inlineBlock");
                    $(this).find(".white_right").addClass("inlineBlock");
                    $(this).find(".white_right").removeClass("none");
                }else {
                    $(this).find(".white_down").removeClass("none");
                    $(this).find(".white_down").addClass("inlineBlock");
                    $(this).find(".white_right").removeClass("inlineBlock");
                    $(this).find(".white_right").addClass("none");
                }
            }else{
                var con = $(this).attr("aria-expanded");
                if(con == "true"){
                    $(this).find(".arrow").removeClass("rotate90");
                    $(this).find(".arrow").addClass("rotate0");
                }else{
                    $(this).find(".arrow").removeClass("rotate0");
                    $(this).find(".arrow").addClass("rotate90");
                }
            }
        })
    }

    $("iframe").attr("height",$(window).height()-80);
    $(".sidebar").css("max-height",$(window).height()-80);

    function personal(){
        $(".personal").mouseover(function(){
            $(".personal_ul").show();
            $(".personal").mouseout(function (){
                $(".personal_ul").hide();
            })
        });
        $(".personal_ul li").click(function () {
            $(".personal_ul").hide();
        })
    }
    personal();

})