# linkar-rest-api-java
LINKAR REST API with JAVA
In this example,  a way of consuming the Linkar REST API services from JAVA can be seen.
This is a console application that performs a READ operation against the API and displays the result of the query on the screen.
The HttpURLConnection class is used for the query, the official documentation <a href = "https://docs.oracle.com/javase/7/docs/api/java/net/HttpURLConnection.html "target =" blank "> here </a> can be consulted for more information.
This code is used for both XML and JSON calls, you just need to comment and uncomment the block that interests you.
The variation between both formats is as follows:

- XML:
	conn.setRequestProperty("Content-Type", "text/xml");
	String input = "<LkCommand>...</LkCommand>";
	
- JSON:
	conn.setRequestProperty("Content-Type", "application/json");
	String input = "{ ... }";
