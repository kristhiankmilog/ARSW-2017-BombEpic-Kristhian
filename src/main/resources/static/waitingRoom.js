var waitingRoom =(function(){
    var nickname;
    var stompClient = null;
    var flag = 0;
    var gana1;
    var gana2;
    var sala;
    
    return{       
         players:function() {
                if (flag === 0) {
                    flag = 1;        
                    var f=new Date();
                    cad=f.getHours()+":"+f.getMinutes()+":"+f.getSeconds();
                    identificador=nickname+cad;
                    $.ajax({
                        url: "salas/"+sala+"/players",
                        type: 'PUT',
                        data: JSON.stringify({nombre: nickname,nick:nickname+cad}),
                        contentType: "application/json"
                    }).then(
                            function () {
                                sessionStorage.setItem('identificador', identificador);

                            }
                    ,
                            function (err) {
                                alert("err:" + err.responseText);
                                flag = 0;
                            }

                    );
                }

            },
            
         disconnect :   function() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
            //setConnected(false);
            console.log("Disconnected");
            },
            
          connect:function() {
                var socket = new SockJS('/stompendpoint');
                stompClient = Stomp.over(socket);
                stompClient.connect({}, function (frame) {
                    console.log('Connected: ' + frame);
                    stompClient.subscribe('/topic/mostrarJugadores/'+sala, function (data) {
                        gana = JSON.parse(data.body);
                        if (flag===0){
                            if (gana[0].length===4){
                                location.reload();
                        }
                        }
                        play = gana[0];

                        $("#player").empty();
                        for (i = 0; i < play.length; i++) {
                            $("#player").append(play[i].nombre + "<br>");
                        }

                    });
                    stompClient.subscribe('/topic/Play.'+sala, function (data) {
                                    document.location.href = "game.html";
                    });


                });
            },
            
            init:function () {
                    console.info('loading script!...');
                    this.connect();
                    nickname = sessionStorage.getItem('nickname');
                    $("#welcome").append("<b>Welcome " + sessionStorage.getItem('nickname') + "</b><br><br>");
                    
                                 
                        
                    sala=sessionStorage.getItem('salaid');
                    $.get("/salas/"+sala+"/jugadores", function (data3) {
                            $("#player").empty();
                            for (i = 0; i < data3.length; i++) {
                                $("#player").append(data3[i].nombre + "<br>");
                            }
                    });
                    
                    
                }
        
        
        
        
    }
    

})();

