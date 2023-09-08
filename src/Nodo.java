import java.util.ArrayList;

public class Nodo
{
    private String tipo;
    private String nombre;
    private String valor;
    private int num_siguientes;
    private ArrayList <Nodo> siguientes;

    public Nodo(String tipo, String nombre, String valor) {
        this.tipo=tipo;
        this.nombre=nombre;
        this.valor=valor;
        this.siguientes = new ArrayList<Nodo>();
        this.num_siguientes=0;
    }

    public ArrayList<Nodo> getSiguientes() {
        return this.siguientes;
    }
    public void IncertarSiguientes(Nodo siguiente) {
        this.siguientes.add(siguiente);
    }

    public String getNombre(){return this.nombre;}
    public String getTipo(){return this.tipo;}
    public String getValor(){return this.valor;}
    public int getNum_siguientes(){
        this.num_siguientes = this.siguientes.size();
        return this.num_siguientes;
    }

    public void ListarSiguientes(){
        for (Nodo nodo : siguientes) {
            nodo.Imprimir();
        }
    }

    private void Imprimir() {
        String cadena = "Nombre: "+this.getNombre()+" Tipo: "+this.getTipo();
        if(this.getTipo().equalsIgnoreCase("atributo")){
            cadena = cadena + " Valor: " + this.getValor();
        }
        System.out.println(cadena);
    }

    public boolean EsSiguiente(Nodo nodo) {
    //devuelve si el nodo con el que llama a la funcion es un nodo siguiente del nodo que recibe
    //la funcion

        boolean existe = false;
        if(nodo.siguientes.size()>0){
            for (Nodo n : nodo.siguientes) {
                if(this == n){existe=true;}
            }
        }
        return existe;
    }

    public void MostrarRelaciones() {

        System.out.println("\n______________________________________________________________________________________\n");
        String tipo = this.tipo;
        switch(tipo){
            case "clase":
                for (Nodo nodo : siguientes) {
                    if(nodo.tipo.equalsIgnoreCase("clase")){
                        System.out.println(this.nombre+" Es Un "+nodo.getNombre());
                    }else  if(nodo.tipo.equalsIgnoreCase("atributo")){
                        System.out.println(this.nombre+" "+nodo.getNombre()+" "+nodo.getValor());
                    }else  if(nodo.tipo.equalsIgnoreCase("instancia")){
                        System.out.println("Error, hay una relacion no valida");
                    }
                }
                break;

            case "instancia":
                for (Nodo nodo : siguientes) {
                    if(nodo.tipo.equalsIgnoreCase("clase")){
                        System.out.println(this.nombre+" Es Una Instancia de "+nodo.getNombre());
                    }else  if(nodo.tipo.equalsIgnoreCase("atributo")){
                        System.out.println(this.nombre+" "+nodo.getNombre()+" "+nodo.getValor());
                    }else  if(nodo.tipo.equalsIgnoreCase("instancia")){
                        System.out.println("Error, hay una relacion no valida");
                    }
                }
                break;
            case "atributo":
                    System.out.println(this.nombre + " Es Un Atributo, Valor: "+this.valor);
                break;
            default: break;
        }
        System.out.println("\n______________________________________________________________________________________\n");
    }

}
