/*
* David Tadeo Robles Lara
* Pratica con hilos 1
* 17/10/2022
*Desarrollar un programa en Java que a través de la línea de comandos reciba
*una lista de n números enteros y calcule el número factorial correspondiente
*a cada uno de los números en la lista.
*
* */
import java.math.BigInteger;

class HelloRunner implements Runnable {
    //se inicializan variables
    int numero;
    //como el valor factorial puede ser muy alto en algunos casos se utiliza
    //BigInteger
    BigInteger fact= BigInteger.valueOf(1);
    public HelloRunner(String x) {
        //con el valor recibido en el constructor se le da valor a la variable
        this.numero = Integer.parseInt(x);
    }


    @Override
    public void run() {

        for (int j = 1; j <=numero ; j++) {
            this.fact = this.fact.multiply(BigInteger.valueOf(j));
        }

        String nombre = Thread.currentThread().getName();
        System.out.format("%s el numero %d tiene un valor de  %d\n", nombre,numero,this.fact);


    }

    public static void main(String args[]) throws InterruptedException {
        //se envia al constructor el valor actual de la lista
        for (String s:args) {
            Thread t = new Thread( new HelloRunner(s) );
            t.start();
        }

    }
}