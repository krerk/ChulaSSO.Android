package th.ac.chula.sso;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Helper Class for ChulaSSO API
 * https://account.it.chula.ac.th/
 *
 * This example is provided by Krerk Piromsopa, Ph. D.
 * May 3, 2019 - Initial version
 *
 * @author <a href="mailto:krerk.p@chula.ac.th">Krerk Piromsopa,Ph. D.</a>
 */
public class ChulaSSOHelper {

    private static final String DeeAppId = "YOUR APP ID";
    private static final String DeeAppSecret = "YOUR APP API";


    public static String serviceValidation(String ticket) {

        try {
            URL url=new URL("https://account.it.chula.ac.th/serviceValidation");

            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("DeeAppId", DeeAppId);
            conn.setRequestProperty("DeeAppSecret", DeeAppSecret);
            conn.setRequestProperty("DeeTicket", ticket);
            conn.setUseCaches(false);
            conn.setDoInput(true);

            InputStream is = conn.getInputStream();
            String encoding = conn.getContentEncoding() == null ? "UTF-8"
                    : conn.getContentEncoding();
            String jsonResponse = IOUtils.toString(is, encoding);
            return jsonResponse;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
