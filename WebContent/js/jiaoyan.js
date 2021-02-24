var username_flag = false;
var password_flag = false;
var resetpassword_flag = false;

function showTip(spanID,msg){
    var spanId =document.getElementById(spanID);
    spanId.innerHTML = msg;
}
function checkUserName(obj){
    var username = obj.value;
    var span =document.getElementById("span_username");
    if(username.length <6){
        span.innerHTML = "<h1>不能太短</h1>";
        username_flag = false;
    }else{
        span.innerHTML = "<p>恭喜你成功使用该名字</p>";
        username_flag = true;
    }
}
function checkpassword(obj){
    var password = obj.value;
    var span = document.getElementById("span_password");
    if(password.length<5){
        span.innerHTML = "<h2>密码太短</h2>"
        password_flag = false;
    }else{
        span.innerHTML = "<p>恭喜你可以使用</p>";
        password_flag = true;
    }
}
function checkresetpassword(obj){
    var resetpassword = obj.value;
    
    
    var password = document.getElementById("password").value;
    var span = document.getElementById("reset_password");
    if(resetpassword == password){
        span .innerHTML = "<p>密码验证通过</p>";
        resetpassword_flag = true;
    }else{
        span.innerHTML = "<h3>两次密码不一致</h3>";
        resetpassword_flag = false;
    }
}
function checkflag(){
    return resetpassword_flag&&password_flag&&username_flag;
}