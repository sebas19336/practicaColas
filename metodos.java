package practicaColas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class metodos {

    
    private  Queue<objArticulo> articulos = new LinkedList<>();
    private  Queue<objArticulo> Turnos = new LinkedList<>();
    private  Queue<objArticulo> atendidos = new LinkedList<>();
    private Scanner sc = new Scanner(System.in);
    private  double TotDia=0.0;
    private int cont=0;
    public void prin(){
        int opt;
        boolean band=true;
        while (band) {
        System.out.println();
        System.out.println("Bienvenido");
        System.out.println("1.Registro de clientes");
        System.out.println("2.Atencion al cliente");
        System.out.println("3.Estado turno");
        System.out.println("4.Inventario");
        System.out.println("5.Salir");
        opt =ValidarEntero(sc);
        sc.nextLine();
        if (opt < 1 || opt > 5) {
            System.out.println("Ingrese un valor valido.");
        }
        switch (opt) {
            case 1:
                HU00001();
                break;
            case 2:
                HU00002();
                break;
            case 3:
                HU00003();
                break;
            case 4:
                HU00004();
                break;
            default:
                System.out.println("No hace nada -Porque? - no se");
                break;
        }
        }

    }
     public int ValidarEntero(Scanner sc) {
        int numero = 0;
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingrese un numero de 1 al 5 ");
            sc.next();
        }
        numero = sc.nextInt();
        return numero;
    }
    public void HU00001(){
        boolean band = true;
        int opt;
        while (band) {
            System.out.println();
            System.out.println("Menu\nRegistro de Clientes");
            System.out.println("1.Tomar turno");
            System.out.println("2.Llamar turno");
            System.out.println("3.Volver");
            opt = ValidarEntero(sc);
            sc.nextLine();
            if (opt < 1 || opt >3) {
                System.out.println("Ingrese un valor valido.");
            }
            switch (opt) {
                case 1:
                    Turnos.add(tomarTurno());
                    break;
                case 2:
                    MostrarTurno(Turnos);
                    break;
                case 3:
                    prin();
                    break;
                default:
                    break;
            }
        }
    }
    public objArticulo tomarTurno(){
        objArticulo o = new objArticulo();
        System.out.println();
        System.out.println("Ingrese el nombre: ");
        o.setNom(sc.next());
        System.out.println("Ingrese la cedula: ");
        o.setId(sc.nextInt());
        System.out.println("Turno agregado existosamente.");
        return o;
    }
   public void MostrarTurno(Queue<objArticulo> c){
    System.out.println();
    if (c.isEmpty()) {
        System.out.println("No hay turnos pendientes.");
        return;
    }

    objArticulo cliente = c.remove();

    System.out.println("Turno de");
    System.out.println("Nombre cliente: " + cliente.getNom());
    System.out.println("ID: " + cliente.getId());

    atendidos.add(cliente);
    }

    public void HU00002(){
        boolean band=true;
        int opt;
        Double venta=0.0;
        while (band) {
            System.out.println();
            System.out.println("Menu\nAtencion al Cliente");
            System.out.println("1.Ingresar Compra");
            System.out.println("2.Total Venta");
            System.out.println("3.Salir");
            opt = ValidarEntero(sc);
            sc.nextLine();
            if (opt<1 || opt>3) {
                System.out.println("ingrese un valor valido.");
            }
            switch (opt) {
                case 1:
                    venta = IngresarCompra(articulos);
                    TotDia += venta;
                    break;
                case 2:
                    TotalVent(venta);
                    break;
                case 3:
                    prin();
                    break;
                default:
                    break;
            }
        }
    }
    public double  IngresarCompra(Queue<objArticulo> articulos){
        Double PrecioU=0.0;
        Double Total=0.0;
        int opt;
        int cant;
        int id;
        boolean band= true;
        System.out.println();
        System.out.println("ARTICULOS");
        System.out.println();
        for (objArticulo i : articulos) {
            System.out.println("|Categoria articulo "+i.getId()+": "+i.getCateg());
            System.out.println("|Nombre articulo "+i.getId()+": "+i.getNom());
            System.out.println("|Precio articulo "+i.getId()+": "+i.getPrecioU());
            System.out.println("|Estado articulo "+i.getId()+": "+i.getEstado()+" (0.activo y 1.inactivo)");
            System.out.println("----------------------------");
        }
        do {
            System.out.println("Ingrese el id del producto que desea agregar: ");
            id = sc.nextInt();
            for (objArticulo i : articulos) {
                if (id==i.getId()) {
                    PrecioU=i.getPrecioU();
                }
            }
            
            System.out.println("Ingrese la cantidad de articulos que desea agregar: ");
            cant = sc.nextInt();

            System.out.println("Desea agregar otro producto?: ");
            System.out.println("1.Si o 2.No");
            opt = sc.nextInt();
            if (opt==2) {
                band=false;
            }
            Total +=cant*PrecioU;
        } while (band);
        System.out.println("Producto agregado existosamente.");
        return Total;
    }
    public void TotalVent(Double m){
        System.out.println();
        System.out.println("Total de la venta: "+m);
    }
    public void HU00003(){
        boolean band = true;
        int opt;
        while (band) {
            System.out.println();
            System.out.println("Menu\nTurnos");
            System.out.println("1.Pendientes");
            System.out.println("2.Atendidos");
            System.out.println("3.Venta total del dia");
            System.out.println("4.Salir");
            opt = ValidarEntero(sc);
            sc.nextLine();
            if (opt < 1 || opt > 4) {
                System.out.println("Ingrese un valor valido.");
            }
            switch (opt) {
                case 1:
                    Pendientes(Turnos);
                    break;
                case 2:
                    Atendidos();
                    break;
                case 3:
                    TotDia();
                    break;
                default:
                    prin();
                    break;
            }
        }
    }
    public void Pendientes(Queue<objArticulo> m){
        System.out.println("Clientes en cola");
        for (objArticulo o : m) {
            System.out.println("Nombre: "+o.getNom());
            System.out.println("ID: "+o.getId());
        }
    }
    public void Atendidos() {
    System.out.println("Clientes atendidos:");
    if (atendidos.isEmpty()) {
        System.out.println("No hay clientes atendidos todavía.");
    } else {
        for (objArticulo o : atendidos) {
            System.out.println("Nombre: " + o.getNom());
            System.out.println("ID: " + o.getId());
        }
    }
    }
    public void TotDia(){
        System.out.println("Total de ventas del dia: "+ TotDia);
    }
    public void HU00004(){
        boolean band = true;
        int opt;
        while (band) {
            System.out.println();
            System.out.println("Inventario");
            System.out.println("1.Ingresar articulo");
            System.out.println("2.Eliminar articulo");
            System.out.println("3.Salir");
            opt = ValidarEntero(sc);
            sc.nextLine();
            if (opt<1 || opt>3) {
                System.out.println("Ingrese un valor valido.");
            }
            switch (opt) {
                case 1:
                    articulos.add(Articulo());
                    break;
                case 2:
                    System.out.println("Ingrese el id del articulo a eliminar: ");
                    int pto = sc.nextInt();
                    for (objArticulo o : articulos) {
                        if (o.getId()==pto) {
                            articulos.remove(o);
                            System.out.println("Articulo eliminado.");
                        }
                    }
                    break;
                case 3:
                    prin();
                    break;
                default:
                    break;
            }
        }
    }
    public objArticulo Articulo(){
        objArticulo o = new objArticulo();
        System.out.println("Ingrese el id del articulo: ");
        o.setId(sc.nextInt());
        System.out.println("Ingrese el nombre del articulo "+(o.getId())+":");
        o.setNom(sc.next());
        System.out.println("Ingrese la categoria del articulo "+(o.getId())+":");
        o.setCateg(sc.next());
        System.out.println("Ingrese las existencias del articulo "+(o.getId())+":");
        o.setExiste(sc.next());
        System.out.println("Ingrese el precio por unidad del articulo "+(o.getId())+":");
        o.setPrecioU(sc.nextDouble());
        System.out.println("Ingrese el estado del articulo "+(o.getId())+":");
        System.out.println("0.activo o 1.inactivo");
        o.setEstado(sc.nextInt());
        System.out.println();
        return o;
    }
}
