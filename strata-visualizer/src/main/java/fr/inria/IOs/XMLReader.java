package fr.inria.IOs;


import fr.inria.DataStructure.CallTree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by nharrand on 09/03/17.
 */
public class XMLReader {
    public CallTree read() {
        return null;
    }

    public CallTree readFromFile(File f) {
        CallTree res = null;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(f);
            //doc.getDocumentElement().normalize();
            Element eElement = doc.getDocumentElement();
            Node n = eElement.getElementsByTagName("tree").item(0);
            NodeList nList = doc.getElementsByTagName("tree");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
}
