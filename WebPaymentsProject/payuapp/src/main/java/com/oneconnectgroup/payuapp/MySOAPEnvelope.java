package com.oneconnectgroup.payuapp;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.SoapFault12;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

/**
 * Created by aubreymalabie on 1/31/17.
 */

public class MySOAPEnvelope extends SoapSerializationEnvelope {
    public MySOAPEnvelope(int version) {
        super(version);
    }

    private static final String ROOT_LABEL = "root";
    public static final String TAG = MySOAPEnvelope.class.getSimpleName();
    @Override
    public void parseBody(XmlPullParser parser) throws IOException, XmlPullParserException {
        Log.d(TAG, "parseBody: ########################### version: " + this.version);
        bodyIn = null;
        parser.nextTag();
        if (parser.getEventType() == XmlPullParser.START_TAG && parser.getNamespace().equals(env)
                && parser.getName().equals("Fault")) {
            SoapFault fault;
            if (this.version < SoapEnvelope.VER12) {
                fault = new SoapFault(this.version);
            } else {
                fault = new SoapFault12(this.version);
            }
            fault.parse(parser);
            bodyIn = fault;
        } else {
            while (parser.getEventType() == XmlPullParser.START_TAG) {
                String rootAttr = parser.getAttributeValue(enc, ROOT_LABEL);

                Object o = read(parser, null, -1, parser.getNamespace(), parser.getName(),
                        PropertyInfo.OBJECT_TYPE);
                if ("1".equals(rootAttr) || bodyIn == null) {
                    bodyIn = o;
                }
                parser.nextTag();
            }
        }
    }

    @Override
    public void write(XmlSerializer writer) throws IOException {
        writer.setPrefix("i", xsi);
        writer.setPrefix("d", xsd);
        writer.setPrefix("c", enc);
        writer.setPrefix("SOAP-ENV", env);
        writer.startTag(env, "Envelope");
        writer.startTag(env, "Header");
        writeHeader(writer);
        writer.endTag(env, "Header");
        writer.startTag(env, "Body");
        writeBody(writer);
        writer.endTag(env, "Body");
        writer.endTag(env, "Envelope");
    }
}
