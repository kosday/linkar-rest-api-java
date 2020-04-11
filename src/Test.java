import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.OutputStream;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			URL url = new URL("http://yourdomain.com:11201/api/read");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			
			//JSON
			//conn.setRequestProperty("Content-Type", "application/json");
			//String input = "{ \"APIKey\" : \"my_apikey\", \"Data\" : { \"CALCULATED\" : \"False\", \"DICTIONARIES\" : \"False\", \"CONVERSION\" : \"False\", \"FORMAT_SPEC\" : \"False\", \"ORIGINAL_RECORDS\" : \"False\" ,\"CUSTOM_VARS\" : \"\" ,\"OUTPUT_FORMAT\" : \"MV\" ,\"FILE_NAME\" : \"LK.CUSTOMERS\" ,\"RECORD_IDS\" : [ { \"ID\" : \"2\" }, { \"ID\" : \"3\" } ] ,\"RECORD_DICTCLAUSE\" : \"\"} }";
			
			//XML
			conn.setRequestProperty("Content-Type", "text/xml");
			String input = "<LkCommand><APIKey>my_apikey</APIKey><Data><CALCULATED>False</CALCULATED><DICTIONARIES>False</DICTIONARIES><CONVERSION>False</CONVERSION><FORMAT_SPEC>False</FORMAT_SPEC><ORIGINAL_RECORDS>False</ORIGINAL_RECORDS><CUSTOM_VARS></CUSTOM_VARS><OUTPUT_FORMAT>MV</OUTPUT_FORMAT><FILE_NAME>LK.CUSTOMERS</FILE_NAME><RECORD_IDS><ID>2</ID><ID>3</ID></RECORD_IDS><RECORD_DICTCLAUSE></RECORD_DICTCLAUSE></Data></LkCommand>";
			
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			if (conn.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST)
			{
				throw new RuntimeException("Failed: HTTP error code: " + conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String output;
			System.out.println("Output from Server ... \n");
			while ((output = br.readLine()) != null ) {
				System.out.println(output);				
			}
		}
		catch(MalformedURLException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
