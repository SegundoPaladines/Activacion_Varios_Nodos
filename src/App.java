import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
       ListaNodos nodos=new ListaNodos();

       String [] menu_principal = {"Agregar Nodos",
                            "Listar Todos Los Nodos",
                            "Listar Nodo",
                            "Encontrar Activacion",
                            "Agregar Relacion",
                            "Salir"
                        };
       try {

            String opcion1 = (String) JOptionPane.showInputDialog(null,"************APP ACTIVACIÓN**************", null, JOptionPane.DEFAULT_OPTION, null, menu_principal, menu_principal[0]);

            while(!opcion1.equalsIgnoreCase("Salir")){

                switch(opcion1){

                    case "Agregar Nodos": nodos.AgregarNodos(); break;

                    case "Listar Todos Los Nodos": nodos.ListarNodos(); break;

                    case "Listar Nodo": nodos.ListarNodo(); break;
                    
                    case "Encontrar Activacion" : nodos.EncontrarActivacion(); break;

                    case "Agregar Relacion": nodos.AgregarRelacion(); break;

                    default:System.out.println("Fin Programa"); break;
                }

                opcion1 = (String) JOptionPane.showInputDialog(null,"************APP ACTIVACIÓN**************", null, JOptionPane.DEFAULT_OPTION, null, menu_principal, menu_principal[0]);
            }
            
        } catch (Exception e) {System.out.println("Entrada no valida");}

        System.out.println("\n Fin Programa \n");
    }
}
