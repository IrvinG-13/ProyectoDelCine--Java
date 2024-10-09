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

class Carrito{
    //atributos
    private double precio;
    //private int code;
    private String lista;
    private double descuento;
    private double factura;

    //constructor
    public Carrito(){       
        this.precio = 0.0;
        this.descuento = 0.0;
        //this.lista = lista;
        this.factura = 0.0;
        //this.code = code;
    }
    
    public void menu(int code){

        switch(code){
            case 1:
            precio = 4.50;
            
            break;
                
            case 2:
            precio = 5.00;
            break;

            case 3:
            precio = 6.80;
            break;
            case 4:
            precio = 1.25;
            break;
            case 5:
            precio = 2.00;
            break;
            case 6:
            precio = 3.00;
            break;
            case 7:
            precio = 2.50;
            break;
            case 8:
            precio = 1.75;
            break;
            case 9:
            precio = 1.30;
            break;
            case 10:
            precio= 2.00;
            break;
            case 11:
            precio = 2.75;
            break;
            case 12:
            precio = 1.50;
            break;
            default:
            System.out.println("Codigo Invalido");
            precio = 0;
        }
    }

    public double getFactura(boolean acaramelado){
        factura = factura + precio;

        if(acaramelado){
            factura += 0.50;
        }
        return factura;
        
    }

    public double getDescuentoJubilado(){
        descuento = factura * 0.20 ;
        return descuento;
    }

    public double getTotalFactura(){
        return factura;
    }


}


public class Tienda{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String respuesta;
        Boolean acaramelado;

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

        Carrito carrito = new Carrito();
        Persona persona = new Persona();
        
        System.out.println("Es usted Jubilado? (s/n)");
        String respuestaJubilado = sc.nextLine();
        persona.setJubilado(respuestaJubilado.equalsIgnoreCase("s"));

        do {

            System.out.print("\n Codigo del proucto?");
            int code = sc.nextInt();

            sc.nextLine();

            carrito.menu(code);

            System.out.println("Desea agregar acaramelado?(s/n)");
            String respuestaAcaramelado = sc.nextLine();
            acaramelado = respuestaAcaramelado.equalsIgnoreCase("s");
            
            double totalActual = carrito.getFactura(acaramelado);

            

            System.out.println("Desea Continuar?(s/n)");
            respuesta = sc.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));
        

        System.out.println("El descuento de su compra es :" + carrito.getDescuentoJubilado());
        System.out.println("Su factura final es: $" + carrito.getTotalFactura());

        sc.close();
    }
}