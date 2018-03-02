/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import javafx.scene.control.TreeItem;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Anjay
 */
public class ParserLoad extends DefaultHandler{
        TreeItem<String> node = new TreeItem<>();  
        
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

                TreeItem<String> item = new TreeItem<>(qName);
                this.node.getChildren().add(item);
                this.node = item;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
                this.node = this.node.getParent();
        }

        @Override
        public void characters(char ch[], int start, int length) throws SAXException {
          String s = String.valueOf(ch, start, length).trim();
          if (!s.isEmpty()) {
             this.node.getChildren().add(new TreeItem<>(s));
          }                                       
        } 
}

