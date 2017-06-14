package co.simplon.laposte.FooBarQix;

public class App 
{
    public static void main( String[] args )
    {
    	String res;
    	String enLettre;
        for(int i=1;i<=100;i++) {
        	res="";
        	enLettre=""+i;  //passer i en String
        	if(i%3==0) {
        		res+="Foo";
        	}
        	if(enLettre.indexOf('3')>-1) {
        		res+="Foo";
        	}
        	if(i%5==0) {
        		res+="Bar";
        	}
        	if(enLettre.indexOf('5')>-1) {
        		res+="Bar";
        	}
        	if(i%7==0) {
        		res+="Qix";
        	}
        	if(enLettre.indexOf('7')>-1) {
        		res+="Qix";
        	}
        	if(res=="") {
        		res=""+i;
        	}
        	System.out.println(i +" => "+ res );
        }
    }
}
