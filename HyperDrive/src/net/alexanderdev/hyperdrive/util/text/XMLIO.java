/***************************************************************
 *   _   _                         ____        _               *
 *  | | | |                       |  _ \      |_|              *
 *  | |_| |_   _  ___   ___   ____| | | | ____ _ _   _  ___    *
 *  |  _  | | | |/ _ \ / _ \ / ___| | | |/ ___| | \ / |/ _ \   *
 *  | | | | |_| | |_| |  ___| |   | |_| | |   | |\ V /|  ___|  *
 *  |_| |_|\__  |  __/ \___||_|   |____/|_|   |_| \_/  \___|   *
 *   ___   ___| | |  _______________________________________   *
 *  |___| |____/|_| |___________JAVA_GAME_LIBRARY___________|  *
 *                                                             *
 *                                                             *
 *  COPYRIGHT © 2015, Christian Bryce Alexander                *
 ***************************************************************/

package net.alexanderdev.hyperdrive.util.text;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * @author Christian Bryce Alexander
 * @since Aug 17, 2015, 5:30:38 PM
 */
public class XMLIO {
	public static Document read(String path, boolean relative) throws Exception {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		Document xml;

		if (relative) {
			xml = builder.parse(XMLIO.class.getResourceAsStream(path));
		} else {
			xml = builder.parse(new File(path));
		}

		xml.normalize();

		return xml;
	}

	public static Document create() throws ParserConfigurationException {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		Document xml = builder.newDocument();

		return xml;
	}

	public static void write(Document doc, String loc) throws Exception {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();

		DOMSource source = new DOMSource(doc);

		StreamResult result = new StreamResult(new File(loc));

		transformer.transform(source, result);
	}
}