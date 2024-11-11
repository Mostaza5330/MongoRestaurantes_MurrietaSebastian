package com.mycompany.restaurantes;

/**
 *
 * @author Sebastian Murrieta Verduzco - 233463
 */
public class Prueba {

    public static void main(String[] args) {
        BaseDeDatos baseDeDatos = new BaseDeDatos();

        baseDeDatos.insertarRestaurantes();
        baseDeDatos.consultarRestaurantesConMasDe4Estrellas();
        baseDeDatos.consultarRestaurantesPorCategoria("Pizza");
        baseDeDatos.consultarRestaurantesPorNombre("sushi");
        baseDeDatos.agregarCategoria("Sushilito", "Fusion");
        baseDeDatos.eliminarRestaurantePorId("idRestaurante");
        baseDeDatos.eliminarRestaurantesConMenosDe3Estrellas();
    }
}
