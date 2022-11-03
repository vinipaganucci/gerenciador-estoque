

function adicionar() {
    window.location.href = "form.html";
}

function cadastrar() {
    let produto = document.getElementById("usuario-produto").value;
    let qtd = document.getElementById("usuario-qtd").value;
    let valor = document.getElementById("usuario-valor").value;
    let table = document.getElementById("tbody");
    let tr = document.createElement("tr");
    table.appendChild(tr);
    console.log(produto)  
    console.log(qtd)  
    console.log(valor)  
    
}