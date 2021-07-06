document.getElementById('submitAddUser').onclick = validateAddUser;

function validateAddUser() {
    var check = Number(0);
    check = checkUsername(check);
    check = checkPassword(check);
    check = checkFullname(check);
    console.log(check)
}

const checkUsername = (check) => {
    if (document.getElementsByName('username')[0].value.trim().length == 0) {
        onAlert(0);
        return check = check + 1;
    } else {
        close(0)
        return check;
    }
}

const checkPassword = (check) => {
    if (document.getElementsByName('password')[0].value.trim().length == 0) {
        onAlert(1);
        return check = check + 1;
    } else {
        close(1)
        return check
    }
}

const checkFullname = (check) => {
    if (document.getElementsByName('fullname')[0].value.trim().length == 0) {
        onAlert(2);
        return check = check + 1;
    } else {
        close(2)
        return check;
    }
}

