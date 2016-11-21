import static org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


/**
 * Created by Nick on 07/11/16.
 */
public class ValidatorTest {
    private Solve solve;
    private static String FilePath = "./unitTestInputData.xml";

    @BeforeTest
    public void setUp() throws Exception {
        solve = new Solve();
    }

    public static Object[][] readFromXML(String tagName) throws Exception {
        File inputFile = new File(FilePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodes = document.getElementsByTagName(tagName);
        Object[][] result = new Double[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attrs = nodes.item(i).getAttributes();
            result[i] = new Double[]{
                    Double.parseDouble(attrs.getNamedItem("side_a").getNodeValue()),
                    Double.parseDouble(attrs.getNamedItem("side_b").getNodeValue()),
                    Double.parseDouble(attrs.getNamedItem("side_c").getNodeValue()),
            };
        }
        return result;
    }

    @DataProvider(name = "positiveForIsosceles")
    public Object[][] getIsoscelesNumber() throws Exception {
        return readFromXML("positiveForIsosceles");
    }

    @DataProvider(name = "positiveForEquilateral")
    public Object[][] getEquilateralNumber() throws Exception {
        return readFromXML("positiveForEquilateral");
    }

    @DataProvider(name = "positiveForSimple")
    public Object[][] getSimpleNumber() throws Exception {
        return readFromXML("positiveForSimple");
    }

    @DataProvider(name = "positiveForCheckZero")
    public Object[][] getZeroNumbers() throws Exception {
        return readFromXML("positiveForCheckZero");
    }

    @DataProvider(name = "invalidData")
    public Object[][] negativeValues() throws Exception {
        File inputFile = new File(FilePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodes = document.getElementsByTagName("negativeValues");
        Object[][] result = new Double[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attrs = nodes.item(i).getAttributes();
            double a = 0;
            double b = 0;
            double c = 0;
            if (attrs.getNamedItem("side_a").getNodeValue().equals("MaX")) {
                a = Double.MAX_VALUE;
            } else if (attrs.getNamedItem("side_a").getNodeValue().equals("MiN")) {
                a = Double.MIN_VALUE;
            } else {
                a = Double.parseDouble(attrs.getNamedItem("side_a").getNodeValue());
            }
            if (attrs.getNamedItem("side_b").getNodeValue().equals("MaX")) {
                b = Double.MAX_VALUE;
            } else if (attrs.getNamedItem("side_b").getNodeValue().equals("MiN")) {
                b = Double.MIN_VALUE;
            } else {
                b = Double.parseDouble(attrs.getNamedItem("side_b").getNodeValue());
            }
            if (attrs.getNamedItem("side_c").getNodeValue().equals("MaX")) {
                c = Double.MAX_VALUE;
            } else if (attrs.getNamedItem("side_c").getNodeValue().equals("MiN")) {
                c = Double.MIN_VALUE;
            } else {
                c = Double.parseDouble(attrs.getNamedItem("side_c").getNodeValue());
            }
            result[i] = new Double[]{a, b, c,};
        }
        return result;
    }

    @Test(dataProvider = "positiveForEquilateral")
    public void testEquilateral(double a, double b, double c) throws Exception {
        assertEquals(solve.solveTriangular(a, b, c), "Equilateral triangle.");
    }

    @Test(dataProvider = "positiveForIsosceles")
    public void testIsosceles(double a, double b, double c) throws Exception {
        assertEquals(solve.solveTriangular(a, b, c), "Isosceles triangle.");
    }

    @Test(dataProvider = "positiveForSimple")
    public void testSimple(double a, double b, double c) throws Exception {
        assertEquals(solve.solveTriangular(a, b, c), "Simple triangular.");
    }

    @Test(dataProvider = "invalidData")
    public void testSideTriangle(double a, double b, double c) throws Exception {
        assertEquals(solve.solveTriangular(a, b, c), "Not a triangular.");
    }

    @Test(dataProvider = "invalidData", expectedExceptions = Exception.class)
    public void testCheckInvalidData(double a, double b, double c) throws Exception {
        Validator validator = new Validator();
        validator.checkInvalidData(a, b, c);
    }

    @Test(dataProvider = "positiveForCheckZero")
    public void testCheckZero(double a, double b, double c) {
        Validator validator = new Validator();
        assertFalse(validator.checkZero(a, b, c));

    }
}