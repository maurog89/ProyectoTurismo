//Funcion para llenar selects
function buscar(key,sel,id,cliente){    
        var http = new XMLHttpRequest();
        http.open("POST","../buscar",true);
        http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        if(id == null)
            http.send("key="+key);
        else
            http.send("key="+key+"&id="+id);
        var json;
        http.onload = function(){
            json = JSON.parse(http.response);
            if(cliente == true){
                for(var i= 0;i < json.length;i++){
                    var opcion = new Option(json[i].razonSocial,json[i].id);
                    sel.add(opcion);
                }
            }else{
                for(var i= 0;i < json.length;i++){
                    var opcion = new Option(json[i].nombre,json[i].id);
                    sel.add(opcion);
                }
            }
            };      
            
}
//Igual a la anterior pero utilizada en servlets
function buscarServlet(key,sel,id,cliente){    
        var http = new XMLHttpRequest();
        http.open("POST","buscar",true);
        http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        if(id == null)
            http.send("key="+key);
        else
            http.send("key="+key+"&id="+id);
        var json;
        http.onload = function(){
            json = JSON.parse(http.response);
            if(cliente == true){
                for(var i= 0;i < json.length;i++){
                    var opcion = new Option(json[i].razonSocial,json[i].id);
                    sel.add(opcion);
                }
            }else{
                for(var i= 0;i < json.length;i++){
                    var opcion = new Option(json[i].nombre,json[i].id);
                    sel.add(opcion);
                }
            }
            };      
            
}

//Funcion para agregar un nodo despues e = referencia i= nodo a agregar
function insertAfter(e,i){ 
        if(e.nextSibling){ 
            e.parentNode.insertBefore(i,e.nextSibling); 
        } else { 
            e.parentNode.appendChild(i); 
        }
    }
