/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.lab5.DocumentManagementSystem;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author mike
 */
public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        try {
            try (FileInputStream file = new FileInputStream(path); ObjectInputStream in = new ObjectInputStream(file)) {
                return (Catalog) in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
        }
        return null;
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        String location = doc.getLocation();
        try {
            try {
                URI uri = new URI(location);
                desktop.browse(uri);
            } catch (URISyntaxException e) {
                File file = new File(location);
                desktop.open(file);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
