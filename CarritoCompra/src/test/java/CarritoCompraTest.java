import java.util.Scanner;

public class CarritoCompraTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carrito carrito = new Carrito();

        Producto producto1 = new Producto("Camara", 671.21);
        Producto producto2 = new Producto("Reloj", 2121.86);
        Producto producto3 = new Producto("Laptop", 10232.35);
        Producto producto4 = new Producto("Hard Drive",215.10);


        int opcion;

        do {
            System.out.println("\nProductos disponibles:");
            System.out.println("1. Camara - Q671.21");
            System.out.println("2. Reloj - Q2121.86");
            System.out.println("3. Laptop - Q10232.35");
            System.out.println("4. Drive hard - Q215.10");
            System.out.println("5. Mostrar carrito");
            System.out.println("6. Mostrar total");
            System.out.println("7. Eliminar producto del carrito");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            int cantidad;

            switch (opcion) {
                case 1:
                    System.out.print("¿Cuántas camaras deseas agregar? ");
                    cantidad = scanner.nextInt();
                    carrito.agregarProducto(producto1, cantidad);
                    break;
                case 2:
                    System.out.print("¿Cuántos reloj deseas agregar? ");
                    cantidad = scanner.nextInt();
                    carrito.agregarProducto(producto2, cantidad);
                    break;
                case 3:
                    System.out.print("¿Cuántas Laptop deseas agregar? ");
                    cantidad = scanner.nextInt();
                    carrito.agregarProducto(producto3, cantidad);
                    break;
                case 4:
                    System.out.print("¿Cuántos drive hard deseas agregar? ");
                    cantidad = scanner.nextInt();
                    carrito.agregarProducto(producto4, cantidad);
                    break;
                case 5:
                    carrito.mostrarCarrito();
                    break;
                case 6:
                    System.out.println("Total: Q" + carrito.obtenerTotal());
                    break;
                case 7:
                    System.out.print("Selecciona el producto a eliminar (1. Camara, 2. Reloj, 3. Laptop, 4. ): ");
                    int productoEliminar = scanner.nextInt();
                    Producto productoAEliminar = null;

                    switch (productoEliminar) {
                        case 1:
                            productoAEliminar = producto1;
                            break;
                        case 2:
                            productoAEliminar = producto2;
                            break;
                        case 3:
                            productoAEliminar = producto3;
                            break;
                        case 4:
                            productoAEliminar = producto4;
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            continue;
                    }

                    System.out.print("¿Cuántos " + productoAEliminar.getNombre() + " deseas eliminar? ");
                    cantidad = scanner.nextInt();
                    carrito.eliminarProducto(productoAEliminar, cantidad);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
