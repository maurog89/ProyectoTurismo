/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function elegirOpcion(sel,opcion){
            var index = 0;
            for(var i = 0;i<sel.length;i++){
                if(sel[i].value == opcion){
                    index = i;
                    break;
                }
            }
            sel[index].selected = true;
        };
        
elegirOpcion(document.getElementById("estadoAlojamiento"),algo);