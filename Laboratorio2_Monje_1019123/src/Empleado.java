import java.util.Scanner;

public class Empleado {
    //Constructor empleado
    private final String nombre;
    private final Character puesto;
    private double salario;

    public Empleado(String nombre, Character puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Character getPuesto() {
        return puesto;
    }

    //Metodo de menu de usuario
    public static Empleado ValidarNuevoEmpleado() {
        Scanner scanner = new Scanner(System.in);
        String nombreAct;
        char puestoAct = '0';
        double salarioAct = 0;

        System.out.println("Escriba el nombre del empleado");
        nombreAct = scanner.nextLine();

        boolean continuar = true;
        while(continuar){
            System.out.println("Seleccione su categoria laboral (presione la tecla correspondiente sin el punto)");
            System.out.println("1. Tiempo completo");
            System.out.println("2. Tiempo parcial");
            System.out.println("3. Temporal");
            puestoAct = scanner.nextLine().charAt(0);
            if(puestoAct == '1' || puestoAct == '2' || puestoAct == '3'){
                continuar = false;
            }else{
                System.out.println("Opcion no valida");
            }
        }

        continuar = true;
        while(continuar){
            try {
                System.out.println("Escriba el salario del empleado");
                salarioAct = Double.parseDouble(scanner.nextLine());
                if(salarioAct > 0){
                    continuar = false;
                }else{
                    System.out.println("Salario no valido");
                }
            } catch (Exception e) {
                System.out.println("Salario no valido");
            }
        }

        return new Empleado(nombreAct, puestoAct, salarioAct);
    }

    @Override
    public String toString() {
        String puestoString = switch (puesto) {
            case '1' -> "Tiempo completo";
            case '2' -> "Tiempo parcial";
            case '3' -> "Temporal";
            default -> "";
        };
        return puestoString + "|" + nombre + "| $" + salario;
    }
}
