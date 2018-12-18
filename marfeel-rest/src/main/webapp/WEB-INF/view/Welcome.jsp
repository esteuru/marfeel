<html>
<head>
	<title>REST Server</title>
</head>
<body>
	<h2>Marfeelizable Site Crawler</h2>
	
	<h3>File Upload:</h3>
      Select a file to upload: <br />
      <form action = "UploadServlet" method = "post"
         enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "50" />
         <br />
         <input type = "submit" value = "Upload File" />
     </form>
      
</body>
</html>
