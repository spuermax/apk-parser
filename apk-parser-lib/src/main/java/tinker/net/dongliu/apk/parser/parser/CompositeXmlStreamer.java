package tinker.net.dongliu.apk.parser.parser;

import tinker.net.dongliu.apk.parser.struct.xml.Attribute;
import tinker.net.dongliu.apk.parser.struct.xml.XmlCData;
import tinker.net.dongliu.apk.parser.struct.xml.XmlNamespaceEndTag;
import tinker.net.dongliu.apk.parser.struct.xml.XmlNamespaceStartTag;
import tinker.net.dongliu.apk.parser.struct.xml.XmlNodeEndTag;
import tinker.net.dongliu.apk.parser.struct.xml.XmlNodeStartTag;

/**
 * @author dongliu
 */
public class CompositeXmlStreamer implements XmlStreamer {

    public XmlStreamer[] xmlStreamers;

    public CompositeXmlStreamer(XmlStreamer... xmlStreamers) {
        this.xmlStreamers = xmlStreamers;
    }

    @Override
    public void onStartTag(XmlNodeStartTag xmlNodeStartTag) {
        for (XmlStreamer xmlStreamer : xmlStreamers) {
            xmlStreamer.onStartTag(xmlNodeStartTag);
        }
    }

    @Override
    public void onAttribute(Attribute attribute) {
        for (XmlStreamer xmlStreamer : xmlStreamers) {
            xmlStreamer.onAttribute(attribute);
        }
    }

    @Override
    public void onEndTag(XmlNodeEndTag xmlNodeEndTag) {
        for (XmlStreamer xmlStreamer : xmlStreamers) {
            xmlStreamer.onEndTag(xmlNodeEndTag);
        }
    }

    @Override
    public void onCData(XmlCData xmlCData) {
        for (XmlStreamer xmlStreamer : xmlStreamers) {
            xmlStreamer.onCData(xmlCData);
        }
    }

    @Override
    public void onNamespaceStart(XmlNamespaceStartTag tag) {
        for (XmlStreamer xmlStreamer : xmlStreamers) {
            xmlStreamer.onNamespaceStart(tag);
        }
    }

    @Override
    public void onNamespaceEnd(XmlNamespaceEndTag tag) {
        for (XmlStreamer xmlStreamer : xmlStreamers) {
            xmlStreamer.onNamespaceEnd(tag);
        }
    }
}
