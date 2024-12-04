<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test Async and WebSocket</title>
    <script>
        let socket;

        function connectWebSocket() {
            socket = new WebSocket("ws://localhost:8080/java/ws");

            socket.onmessage = function(event) {
                const resultsDiv = document.getElementById("results");
                const resultElement = document.createElement("div");
                resultElement.className = "result";
                resultElement.textContent = event.data;
                resultsDiv.appendChild(resultElement);
                resultsDiv.scrollTop = resultsDiv.scrollHeight;
            };

            socket.onopen = function() {
                console.log("WebSocket connection established.");
            };

            socket.onclose = function() {
                console.log("WebSocket connection closed.");
            };

            socket.onerror = function(error) {
                console.error("WebSocket error:", error);
            };
        }

        async function callAsyncTasks() {
            await fetch('/java/mvc/tasks/async');
        }

        async function callScheduledTask() {
            await fetch('/java/mvc/tasks/scheduled');
        }

        window.onload = connectWebSocket;
    </script>
</head>
<body>
    <h1>Test Async and WebSocket</h1>
    <button onclick="callAsyncTasks()">Run Async Tasks</button>
    <button onclick="callScheduledTask()">Run Scheduled Tasks</button>
    
    <div id="results">
        <h3>Task Results:</h3>
    </div>
</body>
</html>
