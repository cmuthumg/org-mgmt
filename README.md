# org-mgmt
Organization service having two below controller,
	AuthenticationEndPoints
	OrginazationEndPoints
	
AuthenticationEndPoints :	
	For Spring security, the jwt token generate available here and in security configuration ignore the security validation for this API.
	
	Url : http://localhost:9090/auth/signin
	Method: POST
	Description: API is validating USER and Password and generate the jwtToken
	Request :
		<loginDTO>
		  <username>admin</username>
		  <password>password</password>
		</loginDTO>
	
	Response
		<JwtResponseDTO>
			<jwtToken>eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY1NTYwNDczMSwiZXhwIjoxNjU1NjQwNzMxfQ.Ox23P0n8DVqgmDHX21RvkkG2BaxotVzV8eySCpsJaKueXsOW97wxAGnTp2x4rI1yQ6ADeP6wvbmZPiidJanksw</jwtToken>
		</JwtResponseDTO>
	
OrginazationEndPoints
	In this controller, system having all organization related REST API. To access these API should need jwtToken which one generated in above signin API.
	
	Url : http://localhost:9090/service/organization/4
	Method: Get
	Description: Get Organization based on Id
	Authorization: For all Roles
	Request :
		<No Body>
	
	Response
		<organizationDTO>
			<orgId>4</orgId>
			<name>test</name>
			<contactNo/>
			<emailId>test@gmail.com</emailId>
			<address>test address</address>
			<employeesDTO>
				<employeesDTO>
					<empId>6</empId>
					<empName>empName test1</empName>
					<empContactNo>empContactNo test1</empContactNo>
					<empEmailId>empEmailId test1</empEmailId>
					<empAddress>empAddress test1</empAddress>
					<orgId>4</orgId>
					<salary>100000</salary>
				</employeesDTO>
			</employeesDTO>
			<assetsDTO>
				<assetsDTO>
					<assetId>5</assetId>
					<assetName>assetName test</assetName>
					<totalAsset>100000.0</totalAsset>
					<orgId>4</orgId>
				</assetsDTO>
			</assetsDTO>
		</organizationDTO>
	
	Url : http://localhost:9090/service/organizations
	Method: Get
	Description: Get Organizations List
	Authorization: For all Roles
	
	Request :
		<No Body>
	
	Response
		<List>
			<item>
				<orgId>4</orgId>
				<name>test</name>
				<contactNo/>
				<emailId>test@gmail.com</emailId>
				<address>test address</address>
				<employeesDTO>
					<employeesDTO>
						<empId>6</empId>
						<empName>empName test1</empName>
						<empContactNo>empContactNo test1</empContactNo>
						<empEmailId>empEmailId test1</empEmailId>
						<empAddress>empAddress test1</empAddress>
						<orgId>4</orgId>
						<salary>100000</salary>
					</employeesDTO>
				</employeesDTO>
				<assetsDTO>
					<assetsDTO>
						<assetId>5</assetId>
						<assetName>assetName test</assetName>
						<totalAsset>100000.0</totalAsset>
						<orgId>4</orgId>
					</assetsDTO>
				</assetsDTO>
			</item>
		</List>
		
	Url : http://localhost:9090/service/organization/save
	Method: POST
	Description: Creating new Organization including employees and assets
	Authorization: For only ADMIN and MANEGER Roles
	
	Request :
		<No Body>
	
	Response
		<List>
			<item>
				<orgId>4</orgId>
				<name>test</name>
				<contactNo/>
				<emailId>test@gmail.com</emailId>
				<address>test address</address>
				<employeesDTO>
					<employeesDTO>
						<empId>6</empId>
						<empName>empName test1</empName>
						<empContactNo>empContactNo test1</empContactNo>
						<empEmailId>empEmailId test1</empEmailId>
						<empAddress>empAddress test1</empAddress>
						<orgId>4</orgId>
						<salary>100000</salary>
					</employeesDTO>
				</employeesDTO>
				<assetsDTO>
					<assetsDTO>
						<assetId>5</assetId>
						<assetName>assetName test</assetName>
						<totalAsset>100000.0</totalAsset>
						<orgId>4</orgId>
					</assetsDTO>
				</assetsDTO>
			</item>
		</List>
		
	Url : http://localhost:9090/service/organization/1
	Method: Delete
	Description: Delete Organization based OrgId
	Authorization: For only ADMIN and MANEGER Roles
	
	Request :
		<No Body>
	
	Response
		Organizations deleted with id: 1
		
	
