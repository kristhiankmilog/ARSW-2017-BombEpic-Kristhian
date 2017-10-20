var nickname;
var stompClient = null;
var flag = 0;
var gana1;
var gana2;
var sala;

function players() {
   
        
        var f=new Date();
        cad=f.getHours()+":"+f.getMinutes()+":"+f.getSeconds();
        identificador=nickname+cad;
        $.ajax({
            url: "salas/"+sala+"/players",
            type: 'PUT',
            data: JSON.stringify({nombre: nickname,alias:nickname+cad}),
            contentType: "application/json"
        }).then(
                function () {
                    sessionStorage.setItem('identificador', identificador);
                    stompClient.subscribe('/topic/Jugar.'+sessionStorage.getItem('sala'), function (data) {
                        document.location.href = "game.html";
                        
                    });
                }
        ,
                function (err) {
                    alert("err:" + err.responseText);
                    
                }

        );

    
}


function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    //setConnected(false);
    console.log("Disconnected");
}

function connect() {
    var socket = new SockJS('/stompendpoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/mostrarJugadores', function (data) {
            gana = JSON.parse(data.body);
            alert(String(gana));
            play = gana[0];
            $("#player").empty();
            for (i = 0; i < play.length; i++) {
                $("#player").append(play[i].nombre + "<br>");
            }
            
        });


    });
}





$(document).ready(
        function () {
            console.info('loading script!...');
            connect();
            nickname = sessionStorage.getItem('nickname');
            $("#welcome").append("<b>Welcome " + sessionStorage.getItem('nickname') + "</b><br><br>");
            
            
            $.get("/salas/salaDisponible", function (data) {
                sala=data;
                sessionStorage.setItem('sala', sala);
                
                $.get("/salas/"+data+"/jugadores", function (data3) {
                        $("#player").empty();
                        for (i = 0; i < data3.length; i++) {
                            $("#player").append(data3[i].nombre + "<br>");
                        }
                        });
                }
            );
        }
);


