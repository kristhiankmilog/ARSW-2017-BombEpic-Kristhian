




var app =(function(){

    var stompClient = null;
    myplayer = null;
    myposx = null;
    myposy = null;
    var ctx = null;
    var mymem = null;
    var shift = 0;
    var currentFrame = 0;
    var totalFrames = 2;
    var imgs = null;
    var ky = null;
    

    var nicknameA;
    var nicknameB;
    var nicknameC;
    var nicknameD;
    var cont = 0;
    var salaid= sessionStorage.getItem('sala');
    
    
     
    
    
return {
    
    ///**
// * 
// *  Flecha izquierda 	37 	
//    Flecha arriba 	38 	
//    Flecha derecha 	39 	
//    Flecha abajo 	40 	
// */
         
      cargarInfo:function(){
        
        alert("esta es la sala #: "+salaid);
        
        $.get("/salas/"+salaid+"/jugadores", function (data) {
            $("#plays").empty();
            for (i = 0; i < data.length; i++) {
                $("#plays").append(data[i].nombre + "<br>");
                    
            }
            });
      },
      
//3 es un obstaculo
////0 un espacio en blanco
////2 pared rompible
////letras en mayusculas son jugadores
    cargarSala:function () {
        var salaid= sessionStorage.getItem('sala');
        var tablero=null;
        canvas = document.getElementById('cnv');
        ctx = canvas.getContext('2d');
        
        
        
         
         
        $.get("salas/tablero", function (data) {
             tablero=data;
             alert(tablero);
             
             function bloque(width, height, color, x, y, type) {
                canvas = document.getElementById('cnv');
                ctx = canvas.getContext('2d');
                var image = new Image();
                
                if(type==""){
                    ctx.fillStyle = "green";
                    ctx.fillRect(x, y, width, height);
                }else{
                    image.src = color;
                    image.onload = function () {
                        ctx.drawImage(image, x, y, width, height);
                    };
                }
            };
            //1 = pasto
            //2 = muro
            //3 =barrera metal
            for (i = 0; i < tablero.length; i++) {
                for (j = 0; j < tablero.length; j++) { 
                     if (tablero[i][j] === "1") {
                         var myObstacle = new bloque(20, 20, "", j * 20, i * 20,"");
                     } else if (tablero[i][j] === "3") {
                         var myObstacle = new bloque(20, 20, "images/BomberWalls/1.jpg", j * 20, i * 20,"image");
                     } else if (tablero[i][j] === "2") {
                         var myObstacle = new bloque(20, 20, "images/BomberBricks/1.jpg", j * 20, i * 20,"image");
                     } else if (tablero[i][j] === "A") {
                        var myObstacle = new bloque(20, 20, "", j * 20, i * 20,"");
                        var myObstacle = new bloque(20, 20, "images/Bombermans/Player1/11.gif", j * 20, i * 20, "image");
                        

                     } else if (tablero[i][j] === "B") {
                         var myObstacle = new bloque(20, 20, "", j * 20, i * 20,"");
                         var myObstacle = new bloque(20, 20, "images/Bombermans/Player2/11.gif", j * 20, i * 20, "image");
                         
                     } else if (tablero[i][j] === "C") {
                         var myObstacle = new bloque(20, 20, "", j * 20, i * 20,"");
                         var myObstacle = new bloque(20, 20, "images/Bombermans/Player3/11.gif", j * 20, i * 20, "image");
                         
                    } else if (tablero[i][j] === "D") {
                         var myObstacle = new bloque(20, 20, "", j * 20, i * 20,"");
                         var myObstacle = new bloque(20, 20, "images/Bombermans/Player4/11.gif", j * 20, i * 20, "image");
                         
                    }
                };
            };
        });
        
        
              
     },
     
     connect:function () {
                var socket = new SockJS('/stompendpoint');
                stompClient = Stomp.over(socket);
                stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                //funtion
                function bloque(width, height, color, x, y, type) {
                    canvas = document.getElementById('cnv');
                    ctx = canvas.getContext('2d');
                    var image = new Image();

                    if(type==""){
                        ctx.fillStyle = "green";
                        ctx.fillRect(x, y, width, height);
                    }else{
                        image.src = color;
                        image.onload = function () {
                            ctx.drawImage(image, x, y, width, height);
                        };
                    }
                };
                
                    
                //subscriptions            
                stompClient.subscribe('/topic/actualizarJuego.' + sessionStorage.getItem('sala'), function (data) {
                    var table = JSON.parse(data.body);
                    
                    for (i = 0; i < table.length; i++) {
                        for (j = 0; j < table.length; j++) { 
                             if (table[i][j] === "1") {
                                 var myObstacle = new bloque(20, 20, "", j * 20, i * 20,"");
                             } else if (table[i][j] === "3") {
                                 var myObstacle = new bloque(20, 20, "images/BomberWalls/1.jpg", j * 20, i * 20,"image");
                             } else if (table[i][j] === "2") {
                                 var myObstacle = new bloque(20, 20, "images/BomberBricks/1.jpg", j * 20, i * 20,"image");
                             } else if (table[i][j] === "A" ) {
                                if(myplayer === "A"){
                                    myposx = i;
                                    myposy = j;   
                                }
                                var myObstacle = new bloque(20, 20, "", j * 20, i * 20,"");
                                var myObstacle = new bloque(20, 20, "images/Bombermans/Player1/11.gif", j * 20, i * 20, "image");


                             } else if (table[i][j] === "B" ) {
                                if(myplayer === "B"){
                                    myposx = i;
                                    myposy = j;   
                                }
                                
                                var myObstacle = new bloque(20, 20, "", j * 20, i * 20,"");
                                var myObstacle = new bloque(20, 20, "images/Bombermans/Player2/11.gif", j * 20, i * 20, "image");

                             } else if (table[i][j] === "C") {
                                if(myplayer === "C"){
                                    myposx = i;
                                    myposy = j;   
                                }
                                 var myObstacle = new bloque(20, 20, "", j * 20, i * 20,"");
                                 var myObstacle = new bloque(20, 20, "images/Bombermans/Player3/11.gif", j * 20, i * 20, "image");

                            } else if (table[i][j] === "D") {
                                if(myplayer === "B"){
                                    myposx = i;
                                    myposy = j;   
                                }
                                 var myObstacle = new bloque(20, 20, "", j * 20, i * 20,"");
                                 var myObstacle = new bloque(20, 20, "images/Bombermans/Player4/11.gif", j * 20, i * 20, "image");

                            }
                        };
                    };

                });
                stompClient.subscribe("/topic/winner."+salaid, function (eventbody) {
                    
                
                });

            });
           },
           
           
        
           
  

//        
//         isUpperCase:function(str) {
//                return str === str.toUpperCase();
//            },
//            
//            
        
//             
//        disconnect:function() {
//            if (stompClient != null) {
//                  stompClient.disconnect();
//              }
//              //setConnected(false);
//              console.log("Disconnected");
//          },
//          
   

        
        
        
          init: function () {
                console.info('loading script!...');
                alert('Que comience el Juego!!!!!');
                this.connect();
                this.cargarSala();
                //this.cargarInfo();
                
                

                window.addEventListener('keydown', function (e) {
                    function moverPersonaje(key){
                        if (36 < key && key < 41) {
                                ky = key;
                                
                                stompClient.send("/app/mover." + sessionStorage.getItem('sala'), {}, JSON.stringify({x: myposx, y: myposy, key: ky}));
                                
                        }
                    };
                    
                    var key = e.keyCode;
                    
                    var nickname = sessionStorage.getItem('identificador');
                    moverPersonaje(key);
                    console.log(key);

                
                });
                window.addEventListener('keyup', function (e) {
                    key = false;
                });
                
                
                
                $.get("/salas/" + sessionStorage.getItem('sala') + "/" + sessionStorage.getItem('identificador'), function (data) {
                    myplayer = data;
                    alert(myplayer);
                    
                    if (data === data.toUpperCase()) {
                        
                        if (data === 'A') {
                            myposx = 1;
                            myposy = 1;
                        } else if (data === 'B') {
                            myposx = 19;
                            myposy = 1;
                        } else if (data === 'D') {
                            myposx = 19;
                            myposy = 19;
                        } else if (data === 'C') {
                            myposx = 1;
                            myposy = 19;
                        }
                    }
                });
             
          }      
    };


})();

