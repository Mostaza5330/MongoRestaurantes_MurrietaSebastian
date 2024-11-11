package com.mycompany.restaurantes;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.Arrays;

/**
 *
 * @author Sebastian Murrieta Verduzco - 233463
 */
public class BaseDeDatos {

    private final MongoClient client;
    private final MongoCollection<Document> collection;

    public BaseDeDatos() {
        this.client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = client.getDatabase("restauranteBD");
        this.collection = database.getCollection("restaurantes");
    }

    public void insertarRestaurantes() {
        Document restaurante1 = new Document("nombre", "PizzaPalace")
                .append("categorias", Arrays.asList("Pizza", "Italiana"))
                .append("rating", 4.5);
        Document restaurante2 = new Document("nombre", "SushiDelight")
                .append("categorias", Arrays.asList("Sushi", "Japonesa"))
                .append("rating", 5.0);
        Document restaurante3 = new Document("nombre", "TacoHouse")
                .append("categorias", Arrays.asList("Mexicana", "Rápida"))
                .append("rating", 3.9);

        collection.insertMany(Arrays.asList(restaurante1, restaurante2, restaurante3));
        System.out.println("Documentos insertados correctamente.");
    }

    public void consultarRestaurantesConMasDe4Estrellas() {
        FindIterable<Document> resultados = collection.find(Filters.gt("rating", 4));
        System.out.println("Restaurantes con más de 4 estrellas:");
        for (Document doc : resultados) {
            System.out.println(doc.toJson());
        }
    }

    public void consultarRestaurantesPorCategoria(String categoria) {
        FindIterable<Document> resultados = collection.find(Filters.in("categorias", categoria));
        System.out.println("Restaurantes que incluyen la categoría " + categoria + ":");
        for (Document doc : resultados) {
            System.out.println(doc.toJson());
        }
    }

    public void consultarRestaurantesPorNombre(String nombre) {
        FindIterable<Document> resultados = collection.find(Filters.regex("nombre", ".*" + nombre + ".*", "i"));
        System.out.println("Restaurantes que incluyen '" + nombre + "' en su nombre:");
        for (Document doc : resultados) {
            System.out.println(doc.toJson());
        }
    }

    public void agregarCategoria(String nombreRestaurante, String nuevaCategoria) {
        collection.updateOne(Filters.eq("nombre", nombreRestaurante),
                Updates.addToSet("categorias", nuevaCategoria));
        System.out.println("Categoría agregada al restaurante: " + nombreRestaurante);
    }

    public void eliminarRestaurantePorId(String idRestaurante) {
        collection.deleteOne(Filters.eq("_id", new ObjectId(idRestaurante)));
        System.out.println("Restaurante con ID " + idRestaurante + " eliminado.");
    }

    public void eliminarRestaurantesConMenosDe3Estrellas() {
        collection.deleteMany(Filters.lte("rating", 3));
        System.out.println("Restaurantes con 3 estrellas o menos eliminados.");
    }
}
