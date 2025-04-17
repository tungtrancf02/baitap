package hash;

import java.io.FileWriter;
import java.util.ArrayList;

public class UserExporter {
    public static void exportToHTML(ArrayList<String> users, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("<html><head><title>Danh sách người dùng</title></head><body>");
            writer.write("<h2>Danh sách người dùng:</h2><ul>");
            for (String user : users) {
                writer.write("<li>" + user + "</li>");
            }
            writer.write("</ul></body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}