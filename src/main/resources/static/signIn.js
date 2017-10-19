/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var nickname;

function save() {
    nickname = document.getElementById('nickname').value;

    if (nickname==="" || nickname.length>9) {
        alert("Ingrese Un Username Válido");
    }
    
    else {
        sessionStorage.setItem('nickname', document.getElementById('nickname').value);
        document.location.href = "Room.html";
    }

}

$(document).ready(
        function () {
            console.info('loading script!...');
        }
);






