/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var signIn =( function (){
 
    var nickname;
    
    return {
         save:function() {
                nickname = document.getElementById('nickname').value;
                if (nickname==="" || nickname.length>9) {
                    alert("Insert Valid Nickname");
                }

                else {
                    sessionStorage.setItem('nickname', document.getElementById('nickname').value);
                    document.location.href = "Room.html";
                }
          
        },
        
        init: function () {
            console.info('loading script!...');
        
            }
        
        
    };

    
    
}) ();

