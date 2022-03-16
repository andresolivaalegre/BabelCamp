    resultado = 1


    function suma(){
        let n1 = document.getElementById("num1").value
        let n2 = document.getElementById("num2").value
        resultado = parseFloat(n1)+parseFloat(n2)
        document.getElementById("n").value = resultado
    }

    function resta(){
        let n1 = document.getElementById("num1").value
        let n2 = document.getElementById("num2").value
        let resultado = n1-n2
        document.getElementById("n").value = resultado
    }

    function multiplicacion(){
        let n1 = document.getElementById("num1").value
        let n2 = document.getElementById("num2").value
        let resultado = n1*n2
        document.getElementById("n").value = resultado
    }

    function division(){
        let n1 = document.getElementById("num1").value
        let n2 = document.getElementById("num2").value
        let resultado = n1/n2
        document.getElementById("n").value = resultado
    }
    
    
    
