package com.example.ver01.taptenance20;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.Serializable;
import java.util.ArrayList;


public class WS extends AsyncTask<String,Void,String>  {







    private static String NAMESPACE = "http://caputi.com/"; //localhost:8080/nomecartella/nomedelfile?WSDL (tomcat aperto)
    //Webservice URL - WSDL File location
    private static String URL = "http://127.0.0.1:8080/ws_Login/ws_login?WSDL";
    //SOAP Action URI again Namespace + Web method name
    private static String SOAP_ACTION = "http://caputi.com/login"; //namespace + /nomeWebService

    public static String METODO_LOGIN = "login"; //Nome del metodo nel web service
    public static String METODO_REGISTRATI = "registrati";
    public static String METODO_VISUALIZZA = "visualizza"; //Nome del metodo nel web service
    public static String METODO_MODIFICA = "modifica";


    protected String doInBackground(String... params) {

        ArrayList<String> risposta = new ArrayList<String>();
        if (params[0].equals(METODO_LOGIN)) {
            SoapObject request = new SoapObject(NAMESPACE, params[0]);

            request.addProperty("nomeparametro1", params[4]);
            request.addProperty("nomeparametro2", params[5]);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.setOutputSoapObject(request);

            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

            try {
                // Invoke web service
                androidHttpTransport.call(SOAP_ACTION, envelope);
                // Get the response
                SoapObject response = (SoapObject) envelope.bodyIn;
                // Assign it to resTxt variable static variable
                return response.getProperty(0).toString();

            } catch (Exception e) {
                //Print error
                e.printStackTrace();
                //Assign error message to resTxt
                // resTxt = "Error occured";
            }
            //Return resTxt to calling object
            return risposta.get(0).toString();


        } else if (params[0].equals(METODO_REGISTRATI)) {
            SoapObject request = new SoapObject(NAMESPACE, params[0]);

            request.addProperty("nomeparametro1", params[2]);
            request.addProperty("nomeparametro2", params[3]);
            request.addProperty("nomeparametro1", params[5]);


            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.setOutputSoapObject(request);

            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

            try {
                // Invoke web service
                androidHttpTransport.call(SOAP_ACTION, envelope);
                // Get the response
                SoapObject response = (SoapObject) envelope.bodyIn;
                // Assign it to resTxt variable static variable
                return response.getProperty(0).toString();

            } catch (Exception e) {
                //Print error
                e.printStackTrace();
                //Assign error message to resTxt
                // resTxt = "Error occured";
            }
            //Return resTxt to calling object
            return risposta.get(0).toString();
        } else if (params[0].equals(METODO_MODIFICA)) {
                    SoapObject request = new SoapObject(NAMESPACE, params[0]);

                    request.addProperty("nomeparametro1", params[3]);
                    request.addProperty("nomeparametro2", params[4]);
                    request.addProperty("nomeparametro1", params[5]);
                    request.addProperty("nomeparametro2", params[6]);


                    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

                    envelope.setOutputSoapObject(request);

                    HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

                    try {
                        // Invoke web service
                        androidHttpTransport.call(SOAP_ACTION, envelope);
                        // Get the response
                        SoapObject response = (SoapObject) envelope.bodyIn;
                        // Assign it to resTxt variable static variable
                        return response.getProperty(0).toString();

                    } catch (Exception e) {
                        //Print error
                        e.printStackTrace();
                        //Assign error message to resTxt
                        // resTxt = "Error occured";
                    }
                    //Return resTxt to calling object
                    return risposta.get(0).toString();

                }


                return null;
            }




    protected  void onPostExecute(String esito) {
        if (esito.equals("true")) {

            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);


        }


    }


}


