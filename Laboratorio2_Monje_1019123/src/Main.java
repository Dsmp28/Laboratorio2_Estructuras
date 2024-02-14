import java.util.Scanner;

// Interfaz funcional para representar funciones de transformación de datos
interface DataTransformer {
    String transform(Empleado empleado);
}

// Clase para manejar las transformaciones de datos
class DataProcessor {
    // Método para aplicar una transformación de datos
    String processData(DataTransformer transformer, Empleado empleado) {
        return transformer.transform(empleado);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una instancia de DataProcessor
        DataProcessor processor = new DataProcessor();

        boolean continuar = true;

        while(continuar) {
            //Crear el empleado actual
            Empleado empleadoActual = Empleado.ValidarNuevoEmpleado();

            //Crear las instancias de las distintas bonificaciones

            DataTransformer tiempoCompleto = empleado -> {
                double salarioConBonificacion = empleado.getSalario() * 1.10;
                empleado.setSalario(salarioConBonificacion);
                return empleado.toString();
            };

            DataTransformer tiempoParcial = Empleado::toString;

            DataTransformer temporal = empleado -> {
                double salarioConBonificacion = empleado.getSalario() * 1.05;
                empleado.setSalario(salarioConBonificacion);
                return empleado.toString();
            };

            switch (empleadoActual.getPuesto()) {
                case '1':
                    System.out.println(processor.processData(tiempoCompleto, empleadoActual));
                    break;
                case '2':
                    System.out.println(processor.processData(tiempoParcial, empleadoActual));
                    break;
                case '3':
                    System.out.println(processor.processData(temporal, empleadoActual));
                    break;
            }

            System.out.println("Desea agregar otro empleado? (s/n)");
            String respuesta = scanner.nextLine();

            if(respuesta.equalsIgnoreCase("n")){
                System.out.println("Feliz dia!");
                continuar = false;
            }else if (respuesta.equalsIgnoreCase("s")){
                System.out.println("Escriba los datos del nuevo usuario");
                System.out.println();
            }else {
                System.out.println("Respuesta no valida, finalizando programa");
                continuar = false;
            }
        }

    }
}
