/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var signIn =( function (){
 
    var nickname;
    var salaid;
    
    return {
         save:function() {
                nickname = document.getElementById('nickname').value;
                salaid = document.getElementById('salaid').value;
                if (nickname==="" || nickname.length>9) {
                    alert("Insert Valid Nickname");
                }
                if(salaid==="" || salaid<0){
                    alert("Insert Valid Room");
                }
                else {
                    sessionStorage.setItem('nickname', document.getElementById('nickname').value);
                    sessionStorage.setItem('salaid', document.getElementById('salaid').value);
                    document.location.href = "Room.html";
                }
          
        },
        
        init: function () {
            console.info('loading script!...');
        
            }
        
        
    };

    
    
}) ();

