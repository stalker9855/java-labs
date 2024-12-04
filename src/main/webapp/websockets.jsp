<!DOCTYPE html>
<html lang="en">
<head>
    <title>WebSocket Chat</title>
    <script>
        let websocket;

        function connect() {
            websocket = new WebSocket("ws://localhost:8080/java/chat");

            websocket.onopen = function () {
                console.log("WebSocket connected");
            };

            websocket.onmessage = function (event) {
                const messages = document.getElementById("messages");
                const message = document.createElement("p");
                message.textContent = event.data;
                messages.appendChild(message);
            };

            websocket.onclose = function () {
                console.log("WebSocket closed");
            };
        }

        function sendMessage(event) {
            event.preventDefault();
            const messageInput = document.getElementById("messageInput");
            websocket.send(messageInput.value);
            messageInput.value = "";
        }

        window.onload = connect;
    </script>
</head>
<body>
    <h1>WebSocket Chat</h1>
    <form onsubmit="sendMessage(event)">
        <input type="text" id="messageInput" placeholder="Type your message" required>
        <button type="submit">Send</button>
    </form>
    <div id="messages"></div>
</body>
</html>
