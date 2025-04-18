package hash;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.ArrayList;

public class XMLHandler {
    public static void saveToXML(ArrayList<user> users, String filename) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("users");
            doc.appendChild(rootElement);

            for (user user : users) {
                Element userElement = doc.createElement("user");

                Element username = doc.createElement("username");
                username.appendChild(doc.createTextNode(user.getName()));

                userElement.appendChild(username);
                rootElement.appendChild(userElement); // không lưu mật khẩu
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<user> loadFromXML(String filename) {
        ArrayList<user> users = new ArrayList<>();
        try {
            File file = new File(filename);
            if (!file.exists()) return users;

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);

            NodeList nodeList = doc.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element userElement = (Element) nodeList.item(i);
                String username = userElement.getElementsByTagName("username").item(0).getTextContent();
                users.add(new user(username, "")); // không có password
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
