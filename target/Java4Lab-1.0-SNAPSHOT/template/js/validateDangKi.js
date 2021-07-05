document.getElementById("submitDK").onclick = validateDangKi;
var check = false;
function validateDangKi(){
    var username = document.getElementsByName("username")[0].value;
    var password = document.getElementsByName("password")[0].value;
    if(username.trim().length == 0){
        onAlert(0);
    } else {
       close(0);
    }
    if(password.trim().length == 0){
        onAlert(1);
    } else {
        close(1);
    }
    checkSoThich();
    if(check == true){
        document.getElementById("dangkisubmit").click();
    }
}

function onAlert(index){
    document.getElementsByClassName("errorDki")[index].style.display = 'unset';
    document.getElementsByClassName("fa-exclamation-circle")[index].style.display = 'unset';
    document.getElementsByClassName("fa-check-circle")[index].style.display = 'none';
    document.getElementsByTagName("input")[index].style.border = '1px solid red';
    check = false;
}
function close(index){
    document.getElementsByClassName("errorDki")[index].style.display = 'none';
    document.getElementsByClassName("fa-exclamation-circle")[index].style.display = 'none';
    document.getElementsByClassName("fa-check-circle")[index].style.display = 'unset';
    document.getElementsByTagName("input")[index].style.border = '1px solid green'
    check = true;
}

function checkSoThich(){
    var soThich1 = document.getElementsByName("soThich")[0].checked;
    var soThich2 = document.getElementsByName("soThich")[1].checked;
    var soThich3 = document.getElementsByName("soThich")[2].checked;
    var soThich4 = document.getElementsByName("soThich")[3].checked;
    if(soThich1 == false && soThich2 == false && soThich3 == false && soThich4 == false){
        document.getElementById("errorSoThich").style.display = 'unset';
        check = false;
    } else {
        document.getElementById("errorSoThich").style.display = 'none';
        check = true;
    }
}
