/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author matiascanodesarrollos
 */
public class JSON {

    public static String generarJSON(ArrayList ls) {
        String json = "";
        if (ls != null) {
            Iterator iterator = ls.iterator();
            if (iterator.hasNext()) {
                json = "[";
            }
            while (iterator.hasNext()) {
                json += iterator.next();
                if (iterator.hasNext()) {
                    json += ",";
                } else {
                    json += "]";
                }
            }
        }
        return json;
    }
}
