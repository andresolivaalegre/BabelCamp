
    arrayx = []

function mostrar_array(){
    document.getElementById("array").value = arrayx
}

function aleatorio(){
    var i = Math.floor(Math.random()*(arrayx.length))
    document.getElementById("num_al").value = arrayx[i]
    console.log(i)
}

function insertar_num(){
    let referencia = document.getElementById("num")
    let valor = referencia.value
    arrayx.push(valor)
    mostrar_array()
}

