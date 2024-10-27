
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrito {
    private List<Producto> productos;
    private Map<Producto, Integer> cantidadProductos;

    public Carrito() {
        productos = new ArrayList<>();
        cantidadProductos = new HashMap<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            productos.add(producto);
        }
        cantidadProductos.put(producto, cantidadProductos.getOrDefault(producto, 0) + cantidad);
        System.out.println(cantidad + " " + producto.getNombre() + " han sido agregados al carrito.");
    }

    public void eliminarProducto(Producto producto, int cantidad) {
        if (cantidadProductos.containsKey(producto) && cantidadProductos.get(producto) >= cantidad) {
            for (int i = 0; i < cantidad; i++) {
                productos.remove(producto);
            }
            cantidadProductos.put(producto, cantidadProductos.get(producto) - cantidad);
            System.out.println(cantidad + " " + producto.getNombre() + " han sido eliminados del carrito.");
            // Eliminar el producto del mapa si la cantidad es 0
            if (cantidadProductos.get(producto) == 0) {
                cantidadProductos.remove(producto);
            }
        } else {
            System.out.println("No hay suficientes " + producto.getNombre() + " en el carrito.");
        }
    }

    public void mostrarCarrito() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Productos en el carrito:");
            for (Producto producto : cantidadProductos.keySet()) {
                System.out.println(producto + " - Cantidad: " + cantidadProductos.get(producto));
            }
        }
    }

    public double obtenerTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
