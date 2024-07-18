/**
 * 
 */
 
//submit button id
const btn = document.getElementById("btn");

//input tag class
const ch = document.getElementsByClassName("ch");

//each infos' id
const memberId = document.getElementById("member_id");
const pw = document.getElementById("member_pw");
const memberName = document.getElementById("member_name");
const phone = document.getElementById("member_phone");
const email = document.getElementById("member_email");

//form tag id
const frm = document.getElementById("frm");

//password validation div's id
const passwordError = document.getElementById("password-error");


btn.addEventListener("click", function() {
    passwordError.innerHTML="";

    //password validation
    if(pw.value=="") {
        passwordError.innerHTML="pw is required";
        pw.focus();
        return
    } else if(pw.value.length < 4) {
        passwordError.innerHTML="pw must be over 4 characters";
        pw.focus();
        return
    }

    //id validation
    if(id.value=="" || pw.value=="" ||
        memberName.value=="" || phone.value=="" ||
        email.value==""
    ) {
        alert("missing information");
    } else {
        alert("good to go");
        frm.submit();

    }
})