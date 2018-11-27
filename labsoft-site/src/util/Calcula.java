package util;

public class Calcula {

public static double franquiaCasco ( double cotacao, String tipoFranquia ) {    
			   
	if (tipoFranquia == "Obrigatoria"){
		return cotacao*0.08;
	}
	else if (tipoFranquia == "Majorada"){
		return cotacao*0.1;
	}
	else {
		return cotacao*0.06;
		 }
}  
 
		   
public static double franquiaVidro ( double valorVidro) {    
	return valorVidro*0.15;
}
public static double franquiaLanterna ( double valorLanterna) {    
	return valorLanterna*0.15;
} 

public static double premioCasco ( double contratacao, String tipoFranquia, int idade ) {    
			   
	if( idade >= 18  && idade <= 25){
		
		if (tipoFranquia == "Obrigatoria"){
			return contratacao*0.04 ;
		}
		else if (tipoFranquia == "Majorada"){
		   return contratacao*0.025 ;
		}
		else {
		   return contratacao*0.07;
			 }			
	}
	else{
		if (tipoFranquia == "Obrigatoria"){
			return contratacao*0.03;
		}
		else if (tipoFranquia == "Majorada"){
			return contratacao*0.02;
		}
		else {
			return contratacao*0.05;
			 }
		}  
}
	
public static double premioVidro ( double valorVidro) {    
	return valorVidro*0.005;
}
public static double premioLanterna ( double valorLanterna) {    
	return valorLanterna*0.005;
} 


public static double premioDanosMateriais ( double valorCobertura) {    
	return valorCobertura*0.0025;
}
public static double premioDanosCorporais ( double valorCobertura) {    
	return valorCobertura*0.0025;
} 



public static double calculaIOF ( double valor) {    
	return valor*0.0738;
} 
	
public static double premioTotal ( double contratacao, String tipoFranquia, int idade, double valorVidro, double valorLanterna , double valorCobertura) {    
	double valor;
	
	valor = premioCasco(contratacao,tipoFranquia,idade) + 0.005*(valorLanterna + valorVidro) + premioDanosCorporais (valorCobertura) + premioDanosCorporais (valorCobertura);
	
	return valor + calculaIOF(valor) ;
} 



}
