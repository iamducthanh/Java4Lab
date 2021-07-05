document.getElementById("submitDKLab3").onclick = validateDangKi;
var check = false;

function validateDangKi() {
    var check = 0;
    var username = document.getElementsByName("username")[0].value;
    var password = document.getElementsByName("password")[0].value;
    if (username.trim().length == 0) {
        onAlert(0);
        check = check + 1;
    } else {
        close(0);
    }
    if (password.trim().length == 0) {
        check = check + 1;
        onAlert(1);
    } else if (!checkNgaySinh()) {
        check = check + 1;
        document.getElementsByClassName("errorNgaySinh")[0].style.display = "unset";
        close(1);
    } else {
        document.getElementsByClassName("errorNgaySinh")[0].style.display = "none";
        close(1);
    }
    if (!checkSoThich()) {
        check = check + 1;
    }

    if (check === 0) {
        document.getElementById("dangkisubmit").click();
    }
}

function onAlert(index) {
    document.getElementsByClassName("errorDki")[index].style.display = 'unset';
    document.getElementsByClassName("fa-exclamation-circle")[index].style.display = 'unset';
    document.getElementsByClassName("fa-check-circle")[index].style.display = 'none';
    document.getElementsByTagName("input")[index].style.border = '1px solid red';
}

function close(index) {
    document.getElementsByClassName("errorDki")[index].style.display = 'none';
    document.getElementsByClassName("fa-exclamation-circle")[index].style.display = 'none';
    document.getElementsByClassName("fa-check-circle")[index].style.display = 'unset';
    document.getElementsByTagName("input")[index].style.border = '1px solid green'
}

const checkSoThich = function () {
    var soThich1 = document.getElementsByName("soThich")[0].checked;
    var soThich2 = document.getElementsByName("soThich")[1].checked;
    var soThich3 = document.getElementsByName("soThich")[2].checked;
    var soThich4 = document.getElementsByName("soThich")[3].checked;
    if (soThich1 == false && soThich2 == false && soThich3 == false && soThich4 == false) {
        document.getElementById("errorSoThich").style.display = 'unset';
        return false;
    } else {
        document.getElementById("errorSoThich").style.display = 'none';
        return true;
    }
}

const checkNgaySinh = function () {
    var today = new Date();
    var birthDate = new Date(document.getElementsByName("password")[0].value);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    if (age >= 18) {
        return true;
    } else {
        return false;
    }
}
