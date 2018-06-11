/**
 * Created by li on 2016/4/4.
 */

//var urlType = {
//    query:"query",
//    add:"add",
//    update:"update",
//    deletes:"delete"
//}

 function urlType(query,add,update,deletes){
     this.query = query;
     this.add = add;
     this.update = update;
     this.deletes = deletes;
 }

var url = new urlType("query","add","update","delete");

//{
//    "body": {
//    "header": {
//        "code": "0",
//            "message": "success"
//    },
//    "rows": [
//        {
//            "ACCOUNT": "li",
//            "GENDER": 0,
//            "ID": 1,
//            "MOBILE_PHONE": "18819450554",
//            "NAME": "liii",
//            "PASSWORD": "123456",
//            "STATUS": 0
//        }
//    ]
//}
//}

/**
 * $("#actionForm").serializeJson();
 * 将指定的表单数据转换成json对象
 * 如果传入otherObj,为追加参数
 */
(function ($) {
    $.fn.serializeJson = function (otherObj,filter) {
        var serializeObj = {};
        var array = this.serializeArray();
        var str = this.serialize();
        $(array).each(function () {
            if (serializeObj[this.name] && this.name!=filter ) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                if(this.name!=filter ) {
                    serializeObj[this.name] = this.value;
                }
            }
        });
        if(otherObj!=undefined){
            for(var p in otherObj){
                if(typeof otherObj[p]!="function"){
                    serializeObj[p] = otherObj[p];
                }
            }
        }

        return serializeObj;
    };
})(jQuery);


/**
 * $("#actionForm").serializeJsonString();
 * 将指定的表单数据转换成json字符串
 * 如果传入otherObj,为追加参数
 */
(function ($) {
    $.fn.serializeJsonString = function (otherobj,filter) {
        return JSON.stringify($(this).serializeJson(otherobj,filter));
    };
})(jQuery);

(function ($) {
    $.fn.objToJsonString = function (obj) {
        return JSON.stringify(obj);
    }
})(jQuery);

/**
 * 请求参数到服务器
 *
 */
(function ($) {

    $.myPostObj = function (obj, callback, notice) {

        if(obj.url!=undefined && obj.path!=undefined && obj.params!=undefined){
            return $.myPost(obj.url,obj.path,obj.params,callback,notice);
        }else{
            console.log("The Obj is not contains url or path or params !!!!");
            return;
        }

    };

    $.myPost = function (url, path, params, callback, notice) {

        console.log(url);
        //console.log(path==undefined +"    "+params==undefined);

        if (notice == undefined && url.indexOf("query")==-1) {
            notice = true;
        }else{
            notice = false;
        }

        if(path.indexOf("path")!=0){
            path="path="+path;
        }

        $.ajax({
            url: url,
            type: params['type'] || "POST",
            dataType: 'text', //params['dataType'] || 'text',
            data: path + '&params=' + params + "&_t=" + new Date(),
            success: function (data) {

                console.log("---success---->" + data);

                if (data == null) {
                    return;
                }

                try {

                    var json = $.parseJSON(data);
                    //if (data.header == undefined) {
                    if (json.header == undefined && json.body == undefined)
                        return null;
                    callback(json, data.header);
                    if (notice) {
                        showModalMessage(json.body.header.message);
                        //$("#messageDialog .modal-body").empty().append(json.body.header.message);
                        //$("#messageDialog").modal('show');
                    }
                } catch (e) {
                    console.log(data);
                    console.log("---catchException---->" + e.message);
                }


            },
            error: function (data) {
                console.log("---error---->" + data);
                if (notice) {
                    showModalMessage(data);
                    //$("#messageDialog .modal-body").empty().append(data);
                    //$("#messageDialog").modal('show');
                }

            }
        });
    };
})(jQuery);

/**
 * 禁止输出日志
 */
function stopConsole(){

    console.log = function (message) {};

}

/**
 * 控制是否输出日志,在调试的时候可以输出日志,在正式发布的时候将值改为false,
 * 不准输出,因为console语句在IE8及以下会报错,影响用户体验
 */
var CONSOLE_FLAG = true;

if(CONSOLE_FLAG==false){
    console.log = function(message){};
}


function fixUrl(type){
    return "/service/"+type;
}


/**
 * 拼接url
 * @param url 类型,有query,add,update,delete
 * @param path 访问的地址
 * @param params 参数
 * @returns {string}
 */
function fixTotalUrl(url,path,params){

    return url+"?path="+path+"&params="+params;

}

function fixTotalUrlByObj(obj){

    return obj.url+"?path="+obj.path+"&params="+obj.params;

}

/**
 * 数据是否加载成功
 * @param data
 * @returns {boolean}
 */
function isAjaxSuccess(data){

    try{
        if(data.body.header.code ==0){
            return true;
        }else{
            return false;
        }
    }catch (e){
        return false;
    }

}

/**
 * 获得服务器返回的消息
 * @param data
 * @returns {Document.message|string|string|string|string|string|*}
 */
function  getAjaxMessage(data){

    try{
        return data.body.header.message;
    }catch(e){
        return e.message;
    }
}

/**
 * 获得具体的数据
 * @param data
 * @returns {*}
 */
function getAjaxRow(data){
    try{
        return data.body.rows;
    }catch(e){
        return "";
    }

}

/**
 * 将文本内容赋值到模态框,并显示到网页上
 * @param data
 */
function showModalMessage(data){
    if(data!=undefined && data!=null){
        $("#messageDialog .modal-body").empty().append(data);
    }
    $("#messageDialog").modal('show');
}

/**
 * 展示datagrid数据
 * @param urlObj
 * @param table
 * @param obj
 */
function fillDataGird(urlObj,table,obj,callback){
            table.datagrid({
                url:fixTotalUrl(urlObj.url,urlObj.path,urlObj.params),
                columns : obj.columns,
                fitColumns : obj.fitColumns,
                singleSelect : true,
                pagination : true,
                pageSize : 10,
                pageList : [10],
                loadFilter: function(data){
                    if(isAjaxSuccess(data)){
                        var result = {
                            total:1000,
                            rows:data.body.rows
                        }
                        if(callback!=undefined){
                            callback(data);
                        }
                        return result;
                    }else{
                        return;
                    }
                },
                onSelect:obj.onSelect,
                onUnselect:obj.onUnselect,
            });

}

Date.prototype.format = function (fmt) { //author: meizz

    if(fmt==undefined){
        fmt = "yyyy-MM-dd HH:mm:ss";
    }

    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "H+" : this.getHours(),//小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
