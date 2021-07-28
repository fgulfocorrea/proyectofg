package com.fgulfodev.projectnexos.utilidades;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UtilidadesGenerales {
    
    public UtilidadesGenerales(){
		
	}
	
	public <T> List<T> obtenerListaDatosJSon(String json, Type tipo) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<T> list = gson.fromJson(json, tipo);
		return list;
    }
    
    public <T> T obtenerObjetoDatoJSon(String json, Type tipo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

		//List<T> list = gson.fromJson(json, tipo);
		return gson.fromJson(json, tipo);
	}
}
