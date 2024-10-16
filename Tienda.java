import java.util.Scanner;

class Persona{
    //atributos
    private boolean jubilado;

    //Getters
    public boolean getJubilado(){
        return jubilado;
    }

    public void setJubilado(boolean jubilado) {
        this.jubilado = jubilado;
    }
}


class Carrito {
    private double totalPopcorn;
    private double totalHotdog;
    private double totalRefresco;
    private double totalAgua;
    private double totalChocolate;

    private double factura; 
    private double descuento; 

    // Constructor
    public Carrito() {
        this.totalPopcorn = 0.0;
        this.totalHotdog = 0.0;
        this.totalRefresco = 0.0;
        this.totalAgua = 0.0;
        this.totalChocolate = 0.0;
        this.factura = 0.0;
        this.descuento = 0.0;
    }

    // metodos
    //condicional de los codigos que el usuario escogera
    public void menu(int code) {
        switch (code) {
            case 1:
                totalPopcorn += 2.00;
                totalRefresco += 2.50;
                factura += 4.50;  
                break;
            case 2:
                totalHotdog += 2.50;
                totalRefresco += 2.50;
                factura += 5.00;
                break;
            case 3:
                totalPopcorn += 2.80;
                totalRefresco += 4.00;
                factura += 6.80;
                break;
            case 4:
                totalPopcorn += 1.25;
                factura += 1.25;
                break;
            case 5:
                totalPopcorn += 2.00;
                factura += 2.00;
                break;
            case 6:
                totalPopcorn += 3.00;
                factura += 3.00;
                break;
            case 7:
                totalHotdog += 2.50;
                factura += 2.50;
                break;
            case 8:
                totalChocolate += 1.75;
                factura += 1.75;
                break;
            case 9:
                totalRefresco += 1.30;
                factura += 1.30;
                break;
            case 10:
                totalRefresco += 2.00;
                factura += 2.00;
                break;
            case 11:
                totalRefresco += 2.75;
                factura += 2.75;
                break;
            case 12:
                totalAgua += 1.50;
                factura += 1.50;
                break;
            default:
                System.out.println("Codigo Invalido");
        }
    }

    // Método para calcular la factura con acaremlado
    public double getFactura(boolean acaramelado) {
        if (acaramelado) {
            totalPopcorn += 0.50;
            factura += 0.50;  
        }
        return factura;
    }

    // Calcular descuento si es jubilado
    public double getDescuentoJubilado() {
        descuento = factura * 0.20;  // 20% de descuento
        return descuento;
    }

    // Método para calcular el porcentaje de cada producto
    public String calcularPorcentaje() {
        if (factura == 0) {
            return "No se han hecho compras";
        }

        double porcentajePopcorn = (totalPopcorn / factura) * 100;
        double porcentajeHotdog = (totalHotdog / factura) * 100;
        double porcentajeRefresco = (totalRefresco / factura) * 100;
        double porcentajeAgua = (totalAgua / factura) * 100;
        double porcentajeChocolate = (totalChocolate / factura) * 100;

        return String.format("Popcorn: %.2f%%\nHotdog: %.2f%%\nRefresco: %.2f%%\nAgua: %.2f%%\nChocolate: %.2f%%\n",
                porcentajePopcorn, porcentajeHotdog, porcentajeRefresco, porcentajeAgua, porcentajeChocolate);
    }

    // Método para obtener el total de la factura
    public double getTotalFactura() {
        return factura;
    }
}


//Clase principal
public class Tienda{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String respuesta;
        Boolean acaramelado = false;
        Boolean agrandar = false;
        Boolean agrandarRefresco = false;

        //Pantalla del menu
        System.out.println("\n--Cafeteria del Cine Universitario--");
        System.out.println("1.Combo1(Popcorn Mediano, Refresco Grande) ($4.50)");
        System.out.println("2.Combo2(Hotdog, Refresco Grande) ($5.00)");
        System.out.println("3.Combo3(Popcorn Grande, 2 Refrescos Medianos) ($6.80)");
        System.out.println("4.Popcorn Chico ($1.25)");
        System.out.println("5.Popcorn Mediano ($2.00)");
        System.out.println("6.Popcorn Grande ($3.00)");
        System.out.println("Si se desea acaramelado pagar ($0.50) adicional, igual en los combos");
        System.out.println("7.Hotdog ($2.50)");
        System.out.println("8.Chocolate ($1.75)");
        System.out.println("9.Refrescos Pequeño ($1.30)");
        System.out.println("10.Refrescos Mediano ($2.00)");
        System.out.println("11.Refrescos Grande ($2.75)");
        System.out.println("12.Agua ($1.50)");

        //Creacion de Objetos
        Carrito carrito = new Carrito();
        Persona persona = new Persona();

        //Preguntas al Usuario 
        System.out.println("Es usted Jubilado? (s/n)");
        String respuestaJubilado = sc.nextLine();
        persona.setJubilado(respuestaJubilado.equalsIgnoreCase("s"));

        //Ciclo Do While y preguntas del acaramelado y agrandar productos
        do {
            System.out.print("\nCodigo del producto? ");
            int code = sc.nextInt();
            sc.nextLine(); 
        
            if (code >= 1 && code <= 12) {
                carrito.menu(code);
        
                // codigo para popcorn o combo
                if (code == 1 || code == 3 || code == 4 || code == 5 || code == 6) {
                    // Preguntar si se desea acaramelado
                    System.out.println("¿Desea agregar acaramelado? (s/n)");
                    acaramelado = sc.nextLine().equalsIgnoreCase("s");
                }
        
                 //codigo para popcorn
                if (code == 4 || code == 5 || code == 6) {
                    System.out.println("¿Desea agrandar el producto? (s/n)");
                    agrandar = sc.nextLine().equalsIgnoreCase("s"); 
        
                    if (agrandar) {
                        System.out.println("Agrandar mediano o grande? 5 = Mediano, 6 = Grande");
                        int respuestaAgrandarPopcorn = sc.nextInt();
                        sc.nextLine(); 
                        if (respuestaAgrandarPopcorn >= 5 && respuestaAgrandarPopcorn <= 6) {
                            carrito.menu(respuestaAgrandarPopcorn); // agrandar
                        } else {
                            System.out.println("Codigo Invalido");
                        }
                    }
                }
        
                //codigo  para refrescos
                if (code >= 9 && code <= 10) {
                    System.out.println("¿Desea agrandar el refresco? (s/n)");
                    agrandarRefresco = sc.nextLine().equalsIgnoreCase("s");
        
                    if (agrandarRefresco) {
                        System.out.println("Agrandar refresco mediano o grande? 10 = Mediano, 11 = Grande");
                        int respuestaAgrandarRefresco = sc.nextInt();
                        sc.nextLine(); 

                        if (respuestaAgrandarRefresco >= 10 && respuestaAgrandarRefresco <= 11) {
                            carrito.menu(respuestaAgrandarRefresco); // agrandar refresco
                        } else {
                            System.out.println("Codigo Invalido");
                        }
                    }
                }
        
                double totalActual = carrito.getFactura(acaramelado);
                System.out.println("Total Actual: $" + totalActual);
            } else{
                System.out.println("codigo invalido");
            }
        
            System.out.println("¿Desea continuar? (s/n)");
            respuesta = sc.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));
        
        //Condicional si la persona es jubilada y pantalla de los calculos finales
        if (persona.getJubilado()) {
            double descuento = carrito.getDescuentoJubilado();
            System.out.println("Descuento de Jubilado: $" + descuento);
            System.out.println("Su factura final con descuento es: $" + (carrito.getTotalFactura() - descuento));
        } else {
            System.out.println("Su factura final es: $" + carrito.getTotalFactura());
        }

        System.out.println(carrito.calcularPorcentaje());

        sc.close();
    }
}