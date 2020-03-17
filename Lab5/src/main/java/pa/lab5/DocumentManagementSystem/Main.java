/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.lab5.DocumentManagementSystem;

import java.io.IOException;

/**
 *
 * @author mike
 */
public class Main {

    public static void main(String args[]) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog
                = new Catalog("Java Resources", "/home/mike/NetBeansProjects/PA/catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        try {
            CatalogUtil.save(catalog);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("/home/mike/NetBeansProjects/PA/catalog.ser");
            if (catalog != null) {
                Document doc = catalog.findById("java1");
                CatalogUtil.view(doc);
            }
        } catch (InvalidCatalogException e) {
            System.err.println(e);
        }
    }
}
