document.getElementById('submitAddUser').onclick = validateAddUser;

function validateAddUser() {
    var check = Number(0);
    check = checkUsername(check);
    check = checkPassword(check);
    check = checkFullname(check);
    check = checkEmailUser(check);
    console.log(check)
    if(check == 0){
        document.getElementById('adduser').click();
    }
}

const checkUsername = (check) => {
    if (document.getElementsByName('usernameBai3')[0].value.trim().length == 0) {
        onAlert(0);
        return check = check + 1;
    } else {
        close(0)
        check = checkUsernameUnicode(check);
        return check;
    }
}

const checkPassword = (check) => {
    if (document.getElementsByName('passwordBai3')[0].value.trim().length == 0) {
        onAlert(1);
        return check = check + 1;
    } else {
        close(1)
        return check
    }
}

const checkFullname = (check) => {
    if (document.getElementsByName('fullnameBai3')[0].value.trim().length == 0) {
        onAlert(2);
        return check = check + 1;
    } else {
        close(2)
        return check;
    }
}

const checkEmailUser = (check) => {
    if (/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(document.getElementsByName('emailBai3')[0].value)) {
        close(3)
        return check;
    } else {
        onAlert(3);
        return check = check + 1;
    }
}

const checkUsernameUnicode = (check) => {
    if(/^[a-z\d_]{5,20}$/i.test(document.getElementsByName('usernameBai3')[0].value)){
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

