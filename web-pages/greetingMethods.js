const greeting = document.getElementById("greeting");

async function getGreetingMessage(id){
    let response = await fetch (`http://54.163.141.128:8081/greeting/${id}`);
    if (response.status === 200){
        let message = await response.json();
        greeting.textContent = "";
        greeting.textContent = message.message;
    }
}