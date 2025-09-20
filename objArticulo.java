package practicaColas;

import java.util.Scanner;

public class objArticulo {
    private int id;
    private String nom;
    private String categ;
    private String existe;
    private Double precioU;
    private int estado;
    Scanner sc = new Scanner(System.in);

    public objArticulo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
    if (nom == null || !nom.matches("^[a-zA-Z]+$")) {
        System.out.println("Caracter Invalido.");
        System.out.println("Ingrese un valor valido: ");
        String nuevo=sc.next();
        setNom(nuevo);
        return;
    }
    this.nom = nom;
    }


    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        if (categ == null || !categ.matches("^[a-zA-Z]+$")) {
        System.out.println("Caracter Invalido.");
        System.out.println("Ingrese un valor valido: ");
        String nuevo = sc.next();
        setCateg(nuevo);
        return;
    }
        this.categ = categ;
    }

    public String getExiste() {
        return existe;
    }

    public void setExiste(String existe) {
        if (existe == null || !existe.matches("^[a-zA-Z0-9]+$")) {
        System.out.println("Caracter Invalido.");
        System.out.println("Ingrese un valor valido: ");
        String nuevo =sc.next();
        setExiste(nuevo);
        return;
    }
        this.existe = existe;
    }

    public Double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(Double precioU) {
        this.precioU = precioU;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
