document.getElementById("dangkiLab2Bai3").onclick = validateLab2Bai3;

function validateLab2Bai3(){
    var check = Number(0);
    check = checkUsernameLab2(check);
    check = checkPasswordLab2(check);
    check = checkSoThich(check);
    console.log(check);
    if(check == 0){
        document.getElementById("dangkisubmit").click();
    }
}

function onAlert(index){
    document.getElementsByClassName("errorDki")[index].style.display = 'unset';
    document.getElementsByClassName("fa-exclamation-circle")[index].style.display = 'unset';
    document.getElementsByClassName("fa-check-circle")[index].style.display = 'none';
    document.getElementsByTagName("input")[index].style.border = '1px solid red';
}
function close(index){
    document.getElementsByClassName("errorDki")[index].style.display = 'none';
    document.getElementsByClassName("fa-exclamation-circle")[index].style.display = 'none';
    document.getElementsByClassName("fa-check-circle")[index].style.display = 'unset';
    document.getElementsByTagName("input")[index].style.border = '1px solid green'
}

const checkUsernameLab2 = (check) => {
    if (document.getElementsByName('username')[0].value.trim().length == 0) {
        onAlert(0);
        return check = check + 1;
    } else {
        close(0)
        check = checkUsernameUnicodeLab2(check);
        return check;
    }
}

const checkPasswordLab2 = (check) => {
    if (document.getElementsByName('password')[0].value.trim().length == 0) {
        onAlert(1);
        return check = check + 1;
    } else {
        close(1)
        return check
    }
}

const checkSoThich = (check) => {
    var soThich1 = document.getElementsByName("soThich")[0].checked;
    var soThich2 = document.getElementsByName("soThich")[1].checked;
    var soThich3 = document.getElementsByName("soThich")[2].checked;
    var soThich4 = document.getElementsByName("soThich")[3].checked;
    if(soThich1 == false && soThich2 == false && soThich3 == false && soThich4 == false){
        document.getElementById("errorSoThich").style.display = 'unset';
        return check + 1;
    } else {
        document.getElementById("errorSoThich").style.display = 'none';
        return check;
    }
}

const checkUsernameUnicodeLab2 = (check) => {
    if(/^[a-z\d_]{5,20}$/i.test(document.getElementsByName('username')[0].value)){
        document.getElementsByClassName("errorDkiName")[0].style.display = 'none';
        document.getElementsByClassName("fa-exclamation-circle")[0].style.display = 'none';
        document.getElementsByClassName("fa-check-circle")[0].style.display = 'unset';
        document.getElementsByTagName("input")[0].style.border = '1px solid green'
        return check;
    } else {
        document.getElementsByClassName("errorDkiName")[0].style.display = 'unset';
        document.getElementsByClassName("fa-exclamation-circle")[0].style.display = 'unset';
        document.getElementsByClassName("fa-check-circle")[0].style.display = 'none';
        document.getElementsByTagName("input")[0].style.border = '1px solid red';
        return check = check + 1;
    }
}
