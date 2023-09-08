import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListaNodos
{
    ArrayList<Nodo> lista_nodos;

    public ListaNodos(){
         this.lista_nodos = new ArrayList<Nodo>();
         this.lista_nodos.add(new Nodo("clase", "todo", ""));
    }
    
    public void Instancia(){
        String nombre;
        try {
            nombre = JOptionPane.showInputDialog(null,"Ingrese Un Nombre Para la Instancia");
        } catch (Exception e) {
            nombre="";
        }

        if(!nombre.equalsIgnoreCase("")){
            boolean existe = this.ExisteNodoCI(nombre);
            if(!existe){
                lista_nodos.add(new Nodo("instancia",nombre,""));
                System.out.println("Instancia: "+nombre+" Agregada con exito");
            }else{ System.out.println("Nodo: "+nombre+" Ya existe, no Puede Repetir Nombres de Nodos");}
        }else{
            System.out.println("El nombre no puede ser vacio");
        }
    }

    public void Clase(){
        String nombre;
        try {
            nombre = JOptionPane.showInputDialog(null,"Ingrese Un Nombre Para la Clase");
        } catch (Exception e) {
            nombre="";
        }

        if(!nombre.equalsIgnoreCase("")){
            boolean existe = this.ExisteNodoCI(nombre);
            if(!existe){
                lista_nodos.add(new Nodo("clase",nombre,""));
                System.out.println("Clase: "+nombre+" Agregada con exito");
            }else{ System.out.println("Nodo: "+nombre+" Ya existe, no Puede Repetir Nombres de Nodos");}
        }else{
            System.out.println("El nombre no puede ser vacio");
        }
    }

    public void Atributo(){
        String nombre;
        String valor;
        try {
            nombre = JOptionPane.showInputDialog(null,"Ingrese Un Nombre Para el Atributo");
        } catch (Exception e) {
            nombre="";
        }

        try {
            valor = JOptionPane.showInputDialog(null,"Ingrese Un Valor Para el Atributo");
        } catch (Exception e) {
            valor="";
        }

        if(!nombre.equalsIgnoreCase("")){
           if(!valor.equalsIgnoreCase("")){
                lista_nodos.add(new Nodo("atributo",nombre,valor));
                System.out.println("Atributo : "+nombre+" Valor: "+valor+" Agregado con exito");
           }else{
                System.out.println("El valor no puede ser vacio");
           }
        }else{
            System.out.println("El nombre no puede ser vacio");
        }
    }

    public void ListarNodos(){
        System.out.println("\n___________________________________________________________________________________\n");
        System.out.println("Clases");
        for(int i=0; i<this.lista_nodos.size(); i++){
           if(this.lista_nodos.get(i).getTipo().equalsIgnoreCase("clase")){
                System.out.println("Nombre: "+this.lista_nodos.get(i).getNombre());
           }
        }

        System.out.println("\n___________________________________________________________________________________\n");

        System.out.println("Instancias");
        for(int i=0; i<this.lista_nodos.size(); i++){
            if(this.lista_nodos.get(i).getTipo().equalsIgnoreCase("instancia")){
                System.out.println("Nombre: "+this.lista_nodos.get(i).getNombre());
            }
        }

        System.out.println("\n___________________________________________________________________________________\n");

        System.out.println("Atributos");
        for(int i=0; i<this.lista_nodos.size(); i++){
            if(this.lista_nodos.get(i).getTipo().equalsIgnoreCase("atributo")){
                System.out.println("Nombre: "+this.lista_nodos.get(i).getNombre()+" Valor: "+this.lista_nodos.get(i).getValor());
            }
        }

        System.out.println("\n___________________________________________________________________________________\n");
    }

    public void AgregarNodos() {

        String [] menu = {"Clase",
                        "Instancia",
                        "Atributo",
                        "Volver"
                    };
        try {
            String opcion = (String) JOptionPane.showInputDialog(null,"************APP ACTIVACIÓN**************", null, JOptionPane.DEFAULT_OPTION, null, menu, menu[0]);
            while(!opcion.equalsIgnoreCase("Volver")){

                switch(opcion){

                    case "Clase": this.Clase(); break;

                    case "Instancia": Instancia(); break;

                    case "Atributo": Atributo(); break;

                    default:System.out.println("Volver"); break;
                }
                opcion = (String) JOptionPane.showInputDialog(null,"************APP ACTIVACIÓN**************", null, JOptionPane.DEFAULT_OPTION, null, menu, menu[0]);
            }

        } catch (Exception e) {
            System.out.println("Entrada no valida");
        }
    }

    private boolean ExisteNodoCI(String nombre) {
        boolean existe = false;
        for (Nodo nodo : lista_nodos) {
            if((nodo.getNombre().equalsIgnoreCase(nombre))&&(!nodo.getTipo().equalsIgnoreCase("atributo"))){existe=true;}
        }
        return existe;
    }
    
    public void AgregarRelacion() {
        String [] menu = {"Clase",
                        "Instancia",
                        "Atributo",
                        "Volver"
                    };
        
        Nodo nodo1=null;
        Nodo nodo2=null;
                    
        try {
            String tipo1 = (String) JOptionPane.showInputDialog(null,"Nodo1: Escoger Tipo", null, JOptionPane.DEFAULT_OPTION, null, menu, menu[0]);
            switch(tipo1){

                case "Clase": nodo1 = BuscarNodoTipo("clase"); break;

                case "Instancia": nodo1 = BuscarNodoTipo("instancia"); break;

                case "Atributo":  nodo1 = BuscarNodoTipo("atributo");break;

                default:
                        System.out.println("Nodo no existe");
                        nodo1 = null;
                    break;
            }

        } catch (Exception e) {
            System.out.println("Entrada no valida");
        }

        if(nodo1!=null){
            try {
                String tipo2 = (String) JOptionPane.showInputDialog(null,"Nodo2: Escoger Tipo", null, JOptionPane.DEFAULT_OPTION, null, menu, menu[0]);
                switch(tipo2){
    
                    case "Clase": nodo2 = BuscarNodoTipo("clase"); break;
    
                    case "Instancia": nodo2 = BuscarNodoTipo("instancia"); break;

                    case "Atributo": nodo2 =BuscarNodoTipo("atributo"); break;
    
                    default:
                        System.out.println("Nodo2 no valido");
                        nodo2=null;
                    break;
                }
    
            } catch (Exception e) {
                System.out.println("Entrada no valida");
            }

            if(nodo2!=null){

                this.Relacionar(nodo1,nodo2);

            }else{System.out.println("Nodo2 no es valido");}

        }else{System.out.println("Nodo1 no existe");}
    }

    private void Relacionar(Nodo nodo1, Nodo nodo2) {
        int pos1=0;
        int pos2=0;
        for (int i = 0; i<this.lista_nodos.size(); i++) {
            if(this.lista_nodos.get(i) == nodo1){pos1=i;}
            if(this.lista_nodos.get(i) == nodo2){pos2=i;}
        }
       if((this.lista_nodos.get(pos1).getTipo().equalsIgnoreCase("clase"))&&(this.lista_nodos.get(pos2).getTipo().equalsIgnoreCase("clase"))){
            if(!this.lista_nodos.get(pos1).getNombre().equalsIgnoreCase("todo")){
                if(!lista_nodos.get(pos2).EsSiguiente(lista_nodos.get(pos1))){
                    this.lista_nodos.get(pos1).IncertarSiguientes(this.lista_nodos.get(pos2));
                    System.out.println(this.lista_nodos.get(pos1).getNombre()+" Es Un "+this.lista_nodos.get(pos2).getNombre());
                }else{System.out.println("Nodo 1 ya está relacionado con Nodo 2");}
            }else{System.out.println("El nodo todo no puede heredar");}
       }
       else if((this.lista_nodos.get(pos1).getTipo().equalsIgnoreCase("instancia"))&&(this.lista_nodos.get(pos2).getTipo().equalsIgnoreCase("clase"))){
            if(!this.lista_nodos.get(pos2).getNombre().equalsIgnoreCase("todo")){
                if(!lista_nodos.get(pos2).EsSiguiente(lista_nodos.get(pos1))){
                    this.lista_nodos.get(pos1).IncertarSiguientes(this.lista_nodos.get(pos2));
                    System.out.println(this.lista_nodos.get(pos1).getNombre()+" Es Una Instancia De: "+this.lista_nodos.get(pos2).getNombre());
                }else{System.out.println("Nodo 1 ya está relacionado con Nodo 2");}
            }else{System.out.println("El nodo todo no puede tener instancias");}
        }
        else if((!this.lista_nodos.get(pos1).getTipo().equalsIgnoreCase("atributo"))&&(this.lista_nodos.get(pos2).getTipo().equalsIgnoreCase("atributo"))){
            if(!lista_nodos.get(pos2).EsSiguiente(lista_nodos.get(pos1))){
                this.lista_nodos.get(pos1).IncertarSiguientes(this.lista_nodos.get(pos2));
                System.out.println(this.lista_nodos.get(pos1).getNombre()+"  "+this.lista_nodos.get(pos2).getNombre()+" "+this.lista_nodos.get(pos2).getValor());
            }else{System.out.println("Nodo 1 ya está relacionado con Nodo 2");}
        }else{System.out.println("Relacion no valida");}
    }

    private Nodo BuscarNodoTipo(String tipo) {
        Nodo nodo=null;
        int tamano =0;
        for (Nodo n1: lista_nodos) {
            if(n1.getTipo().equalsIgnoreCase(tipo)){tamano=tamano+1;}
        }
        if(tamano>0){

            String [] nombres = new String [tamano];
            int contador = 0;
            for(int i = 0; i<this.lista_nodos.size(); i++){
                if(this.lista_nodos.get(i).getTipo().equalsIgnoreCase(tipo)){
                    nombres[contador]=lista_nodos.get(i).getNombre();
                    contador++;
                }
            }
    
            String nombre="";
            switch(tipo){
    
                case"clase":
    
                        try {
                            nombre = (String) JOptionPane.showInputDialog(null,"Escoger Nombre del nodo", null, JOptionPane.DEFAULT_OPTION, null, nombres, nombres[0]);
                        } catch (Exception e) {
                            System.out.println("Opcion no valida");
                        }
                        
                        if(!nombre.equalsIgnoreCase("")){nodo = BuscarNodoCI(nombre);}
    
                    break;
    
                case"instancia":
    
                        try {
                            nombre = (String) JOptionPane.showInputDialog(null,"Escoger Nombre del nodo", null, JOptionPane.DEFAULT_OPTION, null, nombres, nombres[0]);
                        } catch (Exception e) {
                            System.out.println("Opcion no valida");
                        }
                        if(!nombre.equalsIgnoreCase("")){nodo = BuscarNodoCI(nombre);}
    
                    break;
                
                case"atributo":

                        try {
                            nombre = (String) JOptionPane.showInputDialog(null,"Escoger Nombre del nodo", null, JOptionPane.DEFAULT_OPTION, null, nombres, nombres[0]);
                        } catch (Exception e) {
                            System.out.println("Opcion no valida");
                        }

                        if(!nombre.equalsIgnoreCase("")){nodo = this.BuscarNodoAtr(nombre);}
                        
                    break;
    
            }
        }else{System.out.println("No hay nodos de tipo: "+tipo);}

        return nodo;
    }

    private Nodo BuscarNodoAtr(String nombre) {
        Nodo nodo = null;
        int tamano =0;
        for (Nodo n1: lista_nodos) {
            if(n1.getTipo().equalsIgnoreCase("atributo")){
                if(n1.getNombre().equalsIgnoreCase(nombre)){tamano=tamano+1;}
            }
        }
        
        if(tamano>0){

            String [] valores = new String [tamano];

            int contador = 0;
            for(int i = 0; i<this.lista_nodos.size(); i++){
                if(this.lista_nodos.get(i).getTipo().equalsIgnoreCase("atributo")){
                    if(this.lista_nodos.get(i).getNombre().equalsIgnoreCase(nombre)){
                        valores[contador] = lista_nodos.get(i).getValor();
                        contador++;
                    }
                }
            }

            String valor="";
            try {
                valor= (String) JOptionPane.showInputDialog(null,"Escoger Nombre del nodo", null, JOptionPane.DEFAULT_OPTION, null, valores, valores[0]);
            } catch (Exception e) {
                System.out.println("Valor no valido");
                valor="";
            }

            if(!valor.equalsIgnoreCase("")){
                for(Nodo n: this.lista_nodos){
                    if(n.getTipo().equalsIgnoreCase("atributo")){
                        if(n.getNombre().equalsIgnoreCase(nombre)){
                            if(n.getValor().equalsIgnoreCase(valor)){
                                nodo = n;
                            }
                        }
                    }
                }
            }
     

        }
        return nodo;
    }

    private Nodo BuscarNodoCI(String nombre) {
        Nodo nodo=null;
        for (Nodo n1 : lista_nodos) {
            if(n1.getNombre().equalsIgnoreCase(nombre)){
                if(!n1.getTipo().equalsIgnoreCase("atributo")){
                    nodo=n1;
                }
            }
        }
        return nodo;
    }

    public void ListarNodo() {
        String [] lista = new String [this.lista_nodos.size()];
        int contador = 0;
        for (Nodo nodo: this.lista_nodos) {
            lista [contador] = nodo.getNombre();
            contador++;
        }

        String nombre_nodo = "";
        try {
            nombre_nodo = (String) JOptionPane.showInputDialog(null,"Elegir Nodo", null, JOptionPane.DEFAULT_OPTION, null, lista, lista[0]);
        } catch (Exception e) {
           System.out.println("Entrada no Valida");
        }

        if(!nombre_nodo.equals("")){
            for(Nodo nodo : this.lista_nodos){
                if(nombre_nodo.equalsIgnoreCase(nodo.getNombre())){nodo.MostrarRelaciones();}
            }
        }
    }

    public void EncontrarActivacion() {

        int cantidad = 0;
        
        try {
            cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese La Cantidad de Nodos: "+
                                            "\n Numero de nodos a los cuales desea encontrar la activacion"));
        } catch (Exception e) {
           System.out.println("Entrada no valida");
        }
        if(cantidad>1){
            Nodo [] nodos = new Nodo [cantidad];
            String [] nombres = new String [this.lista_nodos.size()];

            for (int i = 0; i<this.lista_nodos.size(); i++) {
                nombres[i] = this.lista_nodos.get(i).getNombre();
            }

            for(int i=0; i<cantidad; i++){

                String nombre = "";
                try {
                    nombre = (String) JOptionPane.showInputDialog(null,"Escoger Nombre del nodo "+(i+1), null, JOptionPane.DEFAULT_OPTION, null, nombres, nombres[0]);
                } catch (Exception e) {System.out.println("Nombre no valido");}

                if(!nombre.equals("")){
                    nodos[i] = this.BuscarNodo(nombre);
                }
            }

            ArrayList <Nodo> c_activacion = new ArrayList<Nodo>();
            for (Nodo nodo1 : nodos) {
                for (Nodo nodo2 : this.lista_nodos) {
                    if(nodo1.EsSiguiente(nodo2)){c_activacion.add(nodo2);}
                }
            }

            ArrayList <Nodo> lista = new ArrayList<Nodo>();
            for (Nodo nodo : this.lista_nodos) {
                lista.add(nodo);
            }

            for(int j = 0; j<c_activacion.size(); j++){
                for(int i =0; i<lista.size(); i++){
                    if(lista.get(i) == c_activacion.get(j)){lista.remove(i);}
                }
            }
            
            Nodo nuevo_nodo = ObtenerSiguientes(c_activacion, lista);
            
            while(nuevo_nodo!=null){

                if(nuevo_nodo!=null){
                    c_activacion.add(nuevo_nodo);
                    lista.remove(nuevo_nodo);
                }

                nuevo_nodo = ObtenerSiguientes(c_activacion, lista);
            }
            

           Nodo activacion = null;

           for (Nodo nodo1 : c_activacion) {
                int contador = 0;
                for (Nodo nodo2: nodos) {
                    if(nodo2.EsSiguiente(nodo1)){
                        contador++;
                    }
                }
                if(contador==cantidad){activacion=nodo1;}
           }

           if(activacion==null){

                c_activacion = ValidarRelActivacion(c_activacion);

                boolean es_activacion = ValidarRelaciones(c_activacion, nodos);

                if(es_activacion){

                    System.out.println("\n__________________________________________________________________________\n");

                    System.out.println("\n_______________***CONJUNTO DE ACTIVACION***_____________\n");

                    c_activacion = this.EliminarRepetidos(c_activacion);
                    for (Nodo nodo : c_activacion) {
                        System.out.println(nodo.getNombre());
                    }
                    System.out.println("________________***DE LOS NODOS:***______________");

                    for (Nodo nodo : nodos) {
                        System.out.println(nodo.getNombre());
                    }
                    System.out.println("\n__________________________________________________________________________\n");
                
                }else{
                    System.out.println("\n__________________________________________________________________________\n");
                    System.out.println("No existe un conjunto de activacion entre los nodos: ");

                    for (Nodo nodo : nodos) {
                        System.out.println(nodo.getNombre());
                    }
                    System.out.println("\n__________________________________________________________________________\n");
                }

            
            }else{
                System.out.println("\n__________________________________________________________________________\n");
                System.out.println("Nodo "+activacion.getNombre()+" Es activacion de los nodos: ");

                for (Nodo nodo : nodos) {
                    System.out.println(nodo.getNombre());
                }
                System.out.println("\n__________________________________________________________________________\n");
            }

        }else{System.out.println("Numero de nodos no valido");}

    }

    private ArrayList <Nodo> ValidarRelActivacion(ArrayList<Nodo> c_activacion) {

        ArrayList <Nodo> conjunto_z = new ArrayList<Nodo>();
       if(c_activacion.size()>0){
            conjunto_z.add(c_activacion.get(c_activacion.size()-1));
            c_activacion.remove(c_activacion.size()-1);

            while(c_activacion.size()>0){
                Nodo nodo1 = c_activacion.get(c_activacion.size()-1);
                boolean add = false;
                for (int i =0; i<conjunto_z.size(); i++) {
                    Nodo nodo2 = conjunto_z.get(i);
                    if(nodo2.EsSiguiente(nodo1)||nodo1.EsSiguiente(nodo2)){
                        add= true;
                    }
                }
                if(add){conjunto_z.add(nodo1);}
                c_activacion.remove(c_activacion.size()-1);
            }
       }
        return EliminarRepetidos(conjunto_z);
    }

    private boolean ValidarRelaciones(ArrayList<Nodo> c_activacion, Nodo[] nodos) {
        boolean es_activacion = false;

        ArrayList <Nodo> nds = new ArrayList<Nodo>();
        for (Nodo nodo : nodos) {
            nds.add(nodo);
        }

        for (Nodo nodo1 : c_activacion){
            for (Nodo nodo2 : nodos) {
                if(nodo2.EsSiguiente(nodo1)){
                    nds.remove(nodo2);
                }
            }
        }

        if(nds.size()==0){es_activacion=true;}

        return es_activacion;
    }

    private Nodo ObtenerSiguientes(ArrayList<Nodo> c_activacion, ArrayList<Nodo> lista) {
        Nodo nodo = null;

        for (Nodo nodo1 : lista) {
            for (Nodo nodo2 : c_activacion) {
                if(nodo2.EsSiguiente(nodo1)){
                    nodo = nodo1;
                }  
            }
        }
        if(nodo!=null){
            for (Nodo nodo1 : c_activacion) {
                if(nodo == nodo1){nodo=null;}
            }
        }

        return nodo;
    }

    private ArrayList<Nodo> EliminarRepetidos(ArrayList<Nodo> c_candidatos) {
        ArrayList<Nodo> c_candidatos_sin_repetidos = new ArrayList<Nodo>();
        for (Nodo nodo : c_candidatos) {
            boolean repetido = false;
            for (Nodo nodo2 : c_candidatos_sin_repetidos) {
                if(nodo==nodo2){repetido= true;}
            }
            if(!repetido){
                c_candidatos_sin_repetidos.add(nodo);
            }
        }
        return c_candidatos_sin_repetidos;
    }

    private Nodo BuscarNodo(String nombre) {
        Nodo nodo = null;
        for (Nodo n1 : this.lista_nodos) {
            if(nombre.equalsIgnoreCase(n1.getNombre())){nodo = n1;}
        }
        return nodo;
    }
}

