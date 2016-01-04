function buscar(key,id){
    if(key !== null){
        var httpEstado = new XMLHttpRequest();
        httpEstado.open("POST","../buscar",true);
        httpEstado.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        httpEstado.send("key="+key+"id="+id);
        var json;
        httpEstado.onload = function(){
            return JSON.parse(httpEstado.response);            
            };
    }               
}




