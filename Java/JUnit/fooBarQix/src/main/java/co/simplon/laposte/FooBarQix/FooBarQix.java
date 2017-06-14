package co.simplon.laposte.FooBarQix;

import org.junit.Ignore;

public class FooBarQix {
	
	public String calculerCorrespondance(int entier) {
    	String res;
    	String enLettre;
//        for(int entier=1; entier<=100; entier++) {
        	res="";
        	enLettre=""+entier;  //passer entier en String
        	if(entier%3==0) {
        		res+="Foo";
        	}
        	if(enLettre.indexOf('3')>-1) {
        		res+="Foo";
        	}
        	if(entier%5==0) {
        		res+="Bar";
        	}
        	if(enLettre.indexOf('5')>-1) {
        		res+="Bar";
        	}
        	if(entier%7==0) {
        		res+="Qix";
        	}
        	if(enLettre.indexOf('7')>-1) {
        		res+="Qix";
        	}
        	if(res=="") {
        		res=enLettre;
        	}
//          }
       	return res;
	}

	public String sommiel(int entier) {
		return ""+(entier*(entier+1))/2;
	}

	public String fibonacci(int entier) {
		int resultat=0;
		int mem=1;
		for (int i=1; i<=entier; i++) {
			resultat = resultat + mem;
			mem = resultat;
		}
		return String.valueOf(resultat);
	}

}

