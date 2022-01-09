const greeting = document.getElementById("greeting");

async function getGreetingMessage(id){
    let response = await fetch (`http://184.73.72.191:8081/greeting/${id}`);
    if (response.status === 200){
        let message = await response.json();
        greeting.textContent = "";
        greeting.textContent = message.message;
    }
}