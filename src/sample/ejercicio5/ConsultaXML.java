package sample.ejercicio5;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vladimirsaldivar
 * @project HipotenusaXXX 2018
 * ...:::vsaldivarm@gmail.com:::...
 **/
public class ConsultaXML {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder documentBuilder;
        Document doc = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
            doc = documentBuilder.parse("employees.xml");

            XPathFactory xPathFactory = XPathFactory.newInstance();

            javax.xml.xpath.XPath xPath = xPathFactory.newXPath();
            String name = getEmployeeNameByID(doc, xPath, 4);
            System.out.println("Employee name whit ID4: " + name);

            List<String> names = getEmployeeNameWithAge(doc, xPath, 30);
            System.out.println("Employees whit 'age<30' are: " + Arrays.toString(names.toArray()));


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }


    }

    private static String getEmployeeNameByID(Document doc, javax.xml.xpath.XPath xPath, int id) {
        String name = null;
        try {
            XPathExpression expr = xPath.compile("/Employees/Employee[@id='" + id + "']/name/text()");
            name = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return name;
    }

    private static List<String> getEmployeeNameWithAge(Document doc, javax.xml.xpath.XPath xpath, int age) {
        List<String> list = new ArrayList<>();
        try {
            XPathExpression expr = xpath.compile("/Employees/Employee[age>" + age + "]/name/text()");
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                list.add(nodes.item(i).getNodeValue());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }
}
