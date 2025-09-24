class Rettangolo {

    //attributi
    private double lunghezza;
    private double altezza;

    //costruttore
    public Rettangolo(double lunghezza, double altezza){

        this.lunghezza = lunghezza;
        this.altezza = altezza;
    }

    //metodi
    public double area() {
        return lunghezza * altezza;
    }

    public double perimetro() {
        return (lunghezza + altezza) * 2;
    }
}

class Quadrato extends Rettangolo {

    public Quadrato(double lato){
        super(lato, lato);
    }
}
