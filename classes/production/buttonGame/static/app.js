function connect() {
    var socket = new SockJS('/stompSocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("Connect!!");
        console.log('Connected: ' + frame);

        stompClient.subscribe('/topic/greetings', function (greeting) {
            console.log("Greet!!");
            console.log(greeting);
        });

        stompClient.subscribe('/user/queue/search', function(data){
            console.log("/user/queue/search");
            alert(data.body);
        });
    });
}
connect();

function send(){
    stompClient.send("/app/hello", {}, {"name":"kuku"});
}

