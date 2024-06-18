package com.frontline.webapi.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.frontline.webapi.GlobalConfig;
import com.frontline.webapi.output.EditUserRequest;
import com.frontline.webapi.output.EditUserResponse;
import com.frontline.webapi.output.PageUserViewModel;
import com.frontline.webapi.output.Role;
import com.frontline.webapi.output.ServerRole;
import com.frontline.webapi.output.User;

@Service
public class UserService {
	
	
	@Autowired
	private GlobalConfig globalConfig;
	
	
	
	private RestTemplate restTemplate;


	public UserService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	
	public List <User> getAllUser(String accessToken){
		
		String apiUrl = globalConfig.getApiUrl();
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer " + accessToken);
		header.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<>(header);
		//Give The URL 
		String url= apiUrl+"users/all";
		
		ResponseEntity<User[]> UserList=restTemplate.exchange(url,HttpMethod.GET,entity,User[].class);
		User[] UserListArray =UserList.getBody();
		
		return  Arrays.asList(UserListArray);
					
	}
	

public List <User> getUserDetails(String accessToken , String userid){
	String apiUrl = globalConfig.getApiUrl();
	HttpHeaders header = new HttpHeaders();
	header.add("Authorization", "Bearer " + accessToken);
	header.setContentType(MediaType.APPLICATION_JSON);
	
  String url = apiUrl+"users/getUserDetails";    
  
  URI uri = UriComponentsBuilder.fromUriString(url)
		  .queryParam(userid)
		  .build()
		  .toUri();
			   
			   ResponseEntity<User> response = restTemplate.exchange(
					   uri,
					   HttpMethod.GET,
					   new HttpEntity<>(header),			   
					   User.class);     
			   
			   User userDetails =response.getBody();
			   
			   List<String> useridList = new ArrayList<>(); 
			   
			   useridList.add(userid);
			   
//			   try {
//				//performMultipleUserEdits(useridList ,accessToken);
//			} catch (JsonProcessingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			   
			   
			   
		//	   if (response.getStatusCode() == HttpStatus.OK) {  
				   return Arrays.asList(userDetails);
				 //  return response.getBody();            
//              } 
//			   else {                 
//            	  // Handle other non-success status codes if needed     
//            	  // For example, return null or throw an exception          
//            	  return null;             }       
//			   } catch (Exception e) {          
//				   // Handle exceptions, such as RestClientException or HttpMessageNotReadableException      
//				   e.printStackTrace();           
//				   return null;         
//              }
		  
	
	
	
}
	
	
	 @ExceptionHandler(Exception.class)
	public ResponseEntity <EditUserResponse>   editUser(String accessToken ,  EditUserRequest editUserRequest) {
		 String apiUrl = globalConfig.getApiUrl();
		System.out.println("bearer server =" +accessToken);
		HttpHeaders headers1 = new HttpHeaders();
		headers1.setContentType(MediaType.APPLICATION_JSON);
		headers1.add("Authorization", "Bearer " + accessToken);
		HttpEntity<EditUserRequest> entity = new HttpEntity<>(editUserRequest, headers1 );
		//Give The URL 
		String url=apiUrl+"users/createOrUpdate";
		System.out.println("edit user header");
		System.out.println(headers1);
		System.out.println("entity --------");
		System.out.println(entity);
		
		try {
		ResponseEntity<EditUserResponse> edituser =restTemplate.exchange(url,HttpMethod.POST,entity,EditUserResponse.class);
		System.out.println("edit user response");
		System.out.println(edituser);
		System.out.println(edituser.getBody());
		return ResponseEntity.ok(edituser.getBody());
		} catch(HttpClientErrorException.BadRequest ex) {
			return ResponseEntity.badRequest().body(null);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		//EditUserResponse editUserArray =edituser.getBody();
		
//		System.out.println("edit error capture");
//		System.out.println(editUserArray);
//		
//		return Arrays.asList(editUserArray);
	}
	 
	 

	 
	 
	 public PageUserViewModel  getUserList(Map<String, List<String>> queryParms , String accessToken){
		 
		 String apiUrl = globalConfig.getApiUrl();
			HttpHeaders header = new HttpHeaders();
			header.add("Authorization", "Bearer " + accessToken);
			header.setContentType(MediaType.APPLICATION_JSON);
			
		  String url = apiUrl+"users/list";  
		  
		  JsonNode EditUserPayload = null;
		  
		  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		  
		  // Add query parameters
		  String userID ="" ;
		  String  Displayname = "";
		  String Email ="";
		  
		  for(Map.Entry<String, List<String>> entry : queryParms.entrySet()) {
			  
			  String paramName = entry.getKey();
			  List<String> paramValues = entry.getValue();
			  
			  for(String paramValue : paramValues) {
				  System.out.println("key = "+paramName+"value = "+paramValue);
				  if(paramName == "userid") {
					  builder.queryParam(paramName, paramValue);	
					  userID =paramValue;
				  }else if(paramName == "searchFilter") {
					  builder.queryParam(paramName, paramValue);
				  }else if(paramName == "displayname"){
					  Displayname = paramValue;
				  }else if(paramName == "email"){
					  Email = paramValue;
				  }else {
					  
				  }
				  			  
			  }
		  }
		  		  
		  URI uri = builder.build().toUri();
		  
		  System.out.println("Ford buildup url");
		System.out.println(uri);
		
	String	test = "https://frontlineworker.com/fordtest/users/list?userid=&displayname=&licenseTier=null&sort=realName,asc&email=&page=0&size=100&searchFilter=usa";
	System.out.println(test);
					   
					   ResponseEntity<PageUserViewModel> response = restTemplate.exchange(
							   uri,
							   HttpMethod.GET,
							   new HttpEntity<>(header),			   
							   PageUserViewModel.class);     
					   
					   PageUserViewModel userListDetails =response.getBody();
					   
	
					  
					  ObjectMapper objectMapper = new ObjectMapper();
						
					   String userDetailsInfo;
					try {
						userDetailsInfo = objectMapper.writeValueAsString(userListDetails);
						 JsonNode jsonNode = objectMapper.readTree(userDetailsInfo);
						 
						 JsonNode UserListNode = jsonNode.get("content");
						 
						 System.out.println(UserListNode);
						 
						 ObjectNode payload = objectMapper.createObjectNode();
						 
						 for (JsonNode roleNode : UserListNode) {
							 
							 if( !userID.isEmpty() && userID.equals(roleNode.get("userId").asText())) {
							 
							 ObjectNode userNode = payload.putObject("user");
							 
							 userNode.set("id", roleNode.get("id"));
						//check userID filter validity 	 
							 if( !userID.isEmpty() && userID.equals(roleNode.get("userId").asText())) {
						        userNode.put("realName", Displayname);
						        userNode.put("email", Email);
						      //  userNode.set("email", roleNode.get("email"));
						       // userNode.set("realName", roleNode.get("realName"));
							 }else {
								 userNode.set("realName", roleNode.get("realName"));
								 userNode.set("email", roleNode.get("email"));
							 }
						        userNode.set("userId", roleNode.get("userId"));
						       
						        userNode.set("domainTag", roleNode.get("domainTag"));
						        userNode.set("phoneNumber", roleNode.get("phoneNumber"));
						        userNode.set("preferredLocale", roleNode.get("preferredLocale"));
						        userNode.set("licensed", roleNode.get("licensed"));
						        userNode.set("twoFactorEnabled", roleNode.get("twoFactorEnabled"));
						        userNode.set("webEnabled", roleNode.get("webEnabled"));
						        userNode.set("wearableEnabled", roleNode.get("wearableEnabled"));
						        userNode.set("technical", roleNode.get("technical"));
						        userNode.set("createDate", roleNode.get("createDate"));
						        userNode.set("changeDate", roleNode.get("changeDate"));
						        userNode.set("lastLogin", roleNode.get("lastLogin"));
						        userNode.set("changedBy", roleNode.get("changedBy"));
						        userNode.set("apiKey", roleNode.get("apiKey"));
						        userNode.set("wmsUser", roleNode.get("wmsUser"));
						        userNode.set("hasWMSPassword", roleNode.get("hasWMSPassword"));
						        userNode.set("status", roleNode.get("status"));
						        
						        
//						     // Add attributes if needed
						        ObjectNode attributesNode = userNode.putObject("attributes");
						        attributesNode.set("lastLogin", roleNode.get("attributes").get("lastLogin"));
						        attributesNode.set("previousLoginDate", roleNode.get("attributes").get("previousLoginDate"));

						        // Add teams if needed
						        ArrayNode teamsNode = userNode.putArray("teams");
						        for (JsonNode team : roleNode.get("teams")) {
						            ObjectNode teamNode = teamsNode.addObject();
						            teamNode.set("id", team.get("id"));
						            teamNode.set("name", team.get("name"));
						            teamNode.set("userCount", team.get("userCount"));
						            teamNode.set("twoFactorEnabled", team.get("twoFactorEnabled"));
						            teamNode.set("phonebook", team.get("phonebook"));
						            teamNode.set("serverRoles", team.get("serverRoles"));
						            // Add other team properties as needed
						        }
						        
						        
						        // Add server roles if needed
						        ArrayNode serverRolesNodeInfo = userNode.putArray("serverRoles");
						        for (JsonNode serverRole : roleNode.get("serverRoles")) {
						            ObjectNode serverRoleNodeObj = serverRolesNodeInfo.addObject();
						            serverRoleNodeObj.set("id", serverRole.get("id"));
						            serverRoleNodeObj.set("name", serverRole.get("name"));
						            // Add other server role properties as needed
						        }
						        
						     // Add license tiers
						        ArrayNode licenseTiersArray = userNode.putArray("licenseTier");
						        
						        for (JsonNode licenseTier : roleNode.get("licenseTiers")) {
						            ObjectNode licenseTierObj = licenseTiersArray.addObject();
						            licenseTierObj.set("id", licenseTier.get("id"));
						            licenseTierObj.set("licenseTier", licenseTier.get("licenseTier"));
						            licenseTierObj.set("domain", licenseTier.get("domain"));
						            // Add other server role properties as needed
						        }
//						        ObjectNode licenseTier = objectMapper.createObjectNode();
//						        licenseTier.put("id", 3);
//						        
//						        ObjectNode domainNode = licenseTier.putObject("domain");
//						        domainNode.put("id", 2);
//						        domainNode.put("name", "ubimax");
//						        domainNode.put("tag", "ubimax");
//						        
//						        licenseTier.put("licenseTier", "Frontline");
						     //   licenseTiersArray.add(licenseTier);
						        
						        
						    String testPayload =    objectMapper.writeValueAsString(payload);
						    
						    System.out.println("testPayload");
						    System.out.println(testPayload);
							 
							 System.out.println("user data");
							 
							 JsonNode serverRolesNode = roleNode.get("serverRoles");
							 
							// User pm = new User("Prime", "Minister", address);
							    ObjectMapper serverRoleClone = new ObjectMapper();
							    
							    ServerRole[] Role = serverRoleClone
							      .readValue(objectMapper.writeValueAsString(serverRolesNode), ServerRole[].class);
							    
							 String   RoleInfo = objectMapper.writeValueAsString(Role);
							    
							    JsonNode RolejsonNode = objectMapper.readTree(RoleInfo);
							    
							    
							    System.out.println("RolejsonNode");
							    
							    System.out.println(RolejsonNode);
							 
							 
							 
							 
							   boolean autoLoginExists = false;
							   
							   boolean AddautoLogin = false;
							  String UpdateRoleName = "";
							  String UpdateAutoLoginRoleName = " ";
							   
							   System.out.println(serverRolesNode);

							   if (serverRolesNode != null && serverRolesNode.isArray()) {
								  
							       for (JsonNode serverroleNode : serverRolesNode) {
							    	   
							           int roleid = serverroleNode.get("id").asInt();
							           System.out.println(roleid+"is the role id");
							           if (roleid == 18) {
							               autoLoginExists = true;
							               
							             UpdateRoleName =   serverroleNode.get("name").asText();
							               System.out.println(UpdateRoleName);
							               System.out.println("role deleted 17");
							               break;
							           }
							       }
							   }
							   
							   if (autoLoginExists) {
								   
							       System.out.println("Auto Login server role exists.");
							       
							       
							   } else {
								   
					   
								   ObjectNode ServerroleUpdate = objectMapper.createObjectNode();
								   
								  // ServerroleUpdate.put("disabled" ,true);
								   //ServerroleUpdate.put("name" ,"Auto Login");
								   
								   ArrayNode serverRoleList = (ArrayNode) serverRolesNode;
								   
								   
								   
								   
								   try {
									   
									   
									   /*************/
									   
									   if (RolejsonNode != null && RolejsonNode.isArray()) {
										   
										   Set<String> existingNames = new HashSet<>();
										   
										   List<Role> roles = new ArrayList <>();
										   List<String> rolesToCheck = new ArrayList <>();
										   rolesToCheck.add("Administrator");
										   rolesToCheck.add("xAssist");
										   boolean isAdminPresent = false;
										   boolean isXAssistPresent = false;
										   
										   
										   //Check if both "Administrator and xAssist roles are present"
										   
										   for (String roleToCheck : rolesToCheck) {
											   
											   for (JsonNode serverrole : RolejsonNode) {	
												   
												   String fieldname = serverrole.get("name").asText();	
												   
												   if(fieldname.equals(roleToCheck)) {
													   
													   if(roleToCheck.equals("Administrator")) {
														   isAdminPresent = true;
													   } else if(roleToCheck.equals("xAssist")) {
														   isXAssistPresent =true;
													   }
													   
												   }
												   
												   
											   }
										   }
										   
										   
										   if(isAdminPresent && isXAssistPresent ) {
											   
											   
											   for (JsonNode serverrole : RolejsonNode) {					
												   String name = serverrole.get("name").asText();					
												   
												   if(!existingNames.contains(name)) {
													   existingNames.add(name);
													    boolean  disabled = false;
													    
													    if(name.equals("xAssist")) {
													    	disabled = false;
													    }
													    
													     Role  role  = new Role(name , disabled );
														  roles.add(role);
													   
												   }
												   
												   System.out.println("loopServerName Admin"+serverrole.get("name"));
												   
											   }
											   
											   
										   }else {
											   
											   for (JsonNode serverrole : RolejsonNode) {					
												   String name = serverrole.get("name").asText();					
												   
												   if(!existingNames.contains(name)) {
													   existingNames.add(name);
													    boolean  disabled = false;
													    
													    if(name.equals("xAssist")) {
													    	disabled = false;
													    }
													    
													     Role  role  = new Role(name , disabled );
														  roles.add(role);
													   
												   }
												   
												   System.out.println("loopServerName"+serverrole.get("name"));
												   
											   }
											   
											   
										   }
										   
										  
										   
//									//	   if(!UpdateRoleName.isEmpty()) {
//											   
//											   UpdateRoleName ="Auto Login";
//											   Role  Updaterole  = new Role(UpdateRoleName , false );
//											   
//											   roles.add(Updaterole);
//										 //  }
										   
										
										   UpdateRoleName ="xAssist - GDPR";
										   Role  Updaterole  = new Role(UpdateRoleName , false );
										   
										   UpdateAutoLoginRoleName ="Auto Login";
										   
										   roles.add(Updaterole);
										   
										   	Iterator<Role> iterator = roles.iterator();
										   
										   while(iterator.hasNext()) {
											   
											   Role role = iterator.next();
											   
											   if(role.getName().equals("xAssist")) {
												   iterator.remove();
											   }else if(!role.getName().equals("Auto Login")) {
												   
												   AddautoLogin = true;
//												   Role  UpdateAutorole  = new Role(UpdateAutoLoginRoleName , false );
//												   roles.add(UpdateAutorole);
//												   System.out.println(" Auto Login doest exist in 526");
//												   System.out.println(objectMapper.writeValueAsString(roles));
											   }
											   
										   }
										   
										   if(AddautoLogin) {
											   Role  UpdateAutorole  = new Role(UpdateAutoLoginRoleName , false );
											   roles.add(UpdateAutorole);
											   System.out.println(" Auto Login doest exist in 543");
											   System.out.println(objectMapper.writeValueAsString(roles));
											   
										   }
										  
										   
										   
										   ObjectMapper serv = new ObjectMapper();
										   
										   JsonNode updatedServerRole = serv.valueToTree(roles);
													   
										   JsonNode licenseTiers = roleNode.get("licenseTiers");
										   
										    EditUserPayload = objectMapper.createObjectNode();
												 
										   
										   ((ObjectNode) EditUserPayload).set("user", roleNode);
										   ((ObjectNode) EditUserPayload).set("roles", updatedServerRole);
										   ((ObjectNode) EditUserPayload).set("licenseTiers", licenseTiers);
										   ((ObjectNode) EditUserPayload).put("password", " ");
										   ((ObjectNode) EditUserPayload).put("domainTag", "ubimax");
										   
										   
										   
										   System.out.println("EditUserPayload");
											  System.out.println(EditUserPayload);
										   
										 //  ArrayNode ServerRolesArray = (ArrayNode) roleNode.get("serverRoles");
										   
										 //  ServerRolesArray.add(ServerroleUpdate);
										    
										    System.out.println("Check serverRolesNode loop");
										    
									   }
									   
									   
									   
									   
									   /*************/
									   
									   
									   
									   
									   
									   
								//	   ArrayNode serverRoleArray = (ArrayNode) roleNode.get(0).path("serverRoles");
									   
								//	   String   Serv = objectMapper.writeValueAsString(serverRoleArray);
									   
									   
									   System.out.println("Check string");
								//	   System.out.println(Serv);
									   
								   }catch (Exception e) {
									   
									   e.printStackTrace();
								   }
								   
								  
								   
//								   ((ObjectNode)roleNode).putArray("serverRoles").add(arrayNode);
//								   
//								   String modifyarray = roleNode.toString();
//								   
//								   System.out.println("here is modifyied server role");
//								   
//								   System.out.println(modifyarray);
//  
//								   User userinfo = objectMapper.treeToValue(roleNode, User.class);
								   
								 //  EditUserPayload
								   System.out.println("multi header");
								   System.out.println(header);
								   
								   
								   String editURL = apiUrl+"users/createOrUpdate"; 
								   
								   System.out.println("URL");
								   System.out.println(editURL);
								   
								   EditUserRequest	   editUserPayload = objectMapper.treeToValue(EditUserPayload , EditUserRequest.class);
								   
								   HttpEntity<EditUserRequest> entity = new HttpEntity<>( editUserPayload,header );
								   ResponseEntity<EditUserResponse> edituser =restTemplate.exchange(editURL,HttpMethod.POST,entity,EditUserResponse.class);
//		
								   System.out.println("multiEditTest");
								   System.out.println(edituser.getBody());
								  
								   
							       System.out.println("Auto Login server role does not exist.");
							   }
							 
							 
							 
							 
						//	System.out.println(roleNode);
							
							
					          // String roleName = roleNode.get("name").asText();
						 }
					    	   				    	  					           
					       }
						 
						 
						 writeToExcel(UserListNode);
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   					   
					  

		 
		 return userListDetails;
		 
	 }
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
//	 
	 private static void  writeToExcel(JsonNode userData) {
//		 		
//			
			Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("UserData");
//			
//			// Create bold font style for header cells
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
//			
//			//Apply bold font style to header cells
			CellStyle headerCellStyle =workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
//			
//			
//			//Date format
		//Create cell style
			CreationHelper createHelper = workbook.getCreationHelper();
			CellStyle dateCellStyle = workbook.createCellStyle();
			dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("MMMM dd ,yyyy hh:mm:ss AM/PM" ));
			
			JsonNode firstObject = userData.get(0);
			Iterator<String> fieldNames =firstObject.fieldNames();
			int rowNum =0;
			
			Row headerRow = sheet.createRow(rowNum++);			
			int columnNum =0;
			while(fieldNames.hasNext()) {
			String fieldName =fieldNames.next();
				System.out.println(fieldName);
				Cell headerCell =headerRow.createCell(columnNum++);
			headerCell.setCellValue(fieldName);		
				headerCell.setCellStyle(headerCellStyle);
			}
		//	processJsonNode(userData,sheet,headerRow,headerCellStyle, rowNum , null);
			int ColLength = columnNum;
			
			for(JsonNode userNode : userData) {
				
				
				System.out.println(userNode);
				
				Row dataRow = sheet.createRow(rowNum++);	
				int dataCellNum = 0;
				Iterator<String> dataFieldNames = userNode.fieldNames();
			
				
				
				while(dataFieldNames.hasNext()) {
					String fieldName =dataFieldNames.next();
					JsonNode fieldValue =userNode.get(fieldName);
					Cell dataCell = dataRow.createCell(dataCellNum++);	
					
					if(fieldValue.isTextual()) {
						dataCell.setCellValue(fieldValue.asText());
					} else if(fieldValue.isNumber()) {
						dataCell.setCellValue(fieldValue.asDouble());
					}else if(fieldValue.isArray()) {
						String arrayValue = fieldValue.toString();
						dataCell.setCellValue(arrayValue);
					}else if(fieldValue.isObject()) {
						String objectValue = fieldValue.toString();
						dataCell.setCellValue(objectValue);
					}else if(fieldValue.isBoolean()) {
					dataCell.setCellValue(fieldValue.asBoolean());
					}else if(fieldValue.isNull()) {
						dataCell.setCellValue("");
					}
					
					if(fieldName.equals("createDate")) {					
						
						Date createDate = new Date(fieldValue.asLong());
						dataCell.setCellValue(createDate);
						dataCell.setCellStyle(dateCellStyle);
					}else if(fieldName.equals("changeDate")) {
						Date changeDate = new Date(fieldValue.asLong());
						dataCell.setCellValue(changeDate);
						dataCell.setCellStyle(dateCellStyle);
					}else if(fieldName.equals("lastLogin")) {
						Date lastLogin = new Date(fieldValue.asLong());
						dataCell.setCellValue(lastLogin);
						dataCell.setCellStyle(dateCellStyle);
					}
				}
											
			}
			
			
			//return workbook;
			

			
			//Apply Filter to header
			
			sheet.setAutoFilter(CellRangeAddress.valueOf( "A1:" +getColumnLetter(headerRow.getLastCellNum()-1) + "1"));
			//sheet.setAutoFilter(CellRangeAddress.valueOf("A1:Y1"));
			//write data rows
				   			   

			
			for(int i=0; i < ColLength; i++ ) {
				
				sheet.autoSizeColumn(i);
			}
			
			// save the workbook to a file
			
			try(FileOutputStream outputStream = new FileOutputStream("Userdata.xlsx")){
				workbook.write(outputStream);
			}catch(IOException e) {
				e.printStackTrace();
			}


			
		}
	 
	 
	 public static void setDataCellValue(Cell cell ,JsonNode fieldValue) {
		 
		 if(fieldValue.isTextual()) {
			 cell.setCellValue(fieldValue.asText());
			} else if(fieldValue.isNumber()) {
				cell.setCellValue(fieldValue.asDouble());
			}else if(fieldValue.isArray()) {
				String arrayValue = fieldValue.toString();
				cell.setCellValue(arrayValue);
			}else if(fieldValue.isBoolean()) {
				cell.setCellValue(fieldValue.asBoolean());
			}else if(fieldValue.isNull()) {
				cell.setCellValue("");
			}
		 
	 }
	 
	 
	 public static void processJsonNode(JsonNode jsonNode, Sheet sheet, Row headerRow ,CellStyle headerCellStyle, int rowNum , String parentFieldName) {
		 
		 
		 for(JsonNode ObjectNode : jsonNode) {
				
			 
			Iterator<String> dataFieldNames = ObjectNode.fieldNames();
				int headerCellNum = headerRow.getLastCellNum();
				
				System.out.println(dataFieldNames);
				
				while(dataFieldNames.hasNext()) {
				
					String fieldName =dataFieldNames.next();
					JsonNode fieldValue =ObjectNode.get(fieldName);
					
	
					
					if(fieldValue.isObject()) {
						
						String nestedParentFieldName =(parentFieldName != null) ? parentFieldName +"."+  fieldName : fieldName;
						
						processJsonNode(fieldValue,sheet,headerRow,headerCellStyle, rowNum , nestedParentFieldName);
						
					}else {
						String fullFieldName =(parentFieldName != null) ? parentFieldName +"."+  fieldName : fieldName;
						//int headerCellNum = headerRow.getLastCellNum();
						Cell headerCell = headerRow.createCell(headerCellNum);
						headerCell.setCellValue(fullFieldName);
						headerCell.setCellStyle(headerCellStyle);
						Row dataRow = sheet.getRow(rowNum);
						if(dataRow == null) {
							dataRow = sheet.createRow(rowNum);
						}
						
						Cell dataCell = dataRow.createCell(headerCellNum);
						
						setDataCellValue(dataCell ,fieldValue );
						
						headerCellNum++;
						
						System.out.println("attributes."+ fieldName);
						//Recursively process the nested JSON object
						
					} 
					
					
				}
			
		 }
		 
	 }
	 
		
 
	private static String getColumnLetter(int columnNumber) {
		StringBuilder columnLetter = new StringBuilder();
		while(columnNumber >= 0) {
			int remainder  = columnNumber % 26;
			columnLetter.insert(0, (char) ('A' + remainder));
			columnNumber = (columnNumber /26) -1;
		}
		return columnLetter.toString();
	}
	
	
	
	
 public EditUserResponse  multipleEditUser(Map<String, List<String>> queryParms , String accessToken){
		 
		 String apiUrl = globalConfig.getApiUrl();
			HttpHeaders header = new HttpHeaders();
			header.add("Authorization", "Bearer " + accessToken);
			header.setContentType(MediaType.APPLICATION_JSON);
			
		  String url = apiUrl+"users/list";  
		  
		  JsonNode EditUserPayload = null;
		  
		  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		  
		  // Add query parameters
		  
		  for(Map.Entry<String, List<String>> entry : queryParms.entrySet()) {
			  
			  String paramName = entry.getKey();
			  List<String> paramValues = entry.getValue();
			  
			  for(String paramValue : paramValues) {
				  builder.queryParam(paramName, paramValue);				  
			  }
		  }
		  		  
		  URI uri = builder.build().toUri();
		  
		  System.out.println("Ford buildup url");
		System.out.println(uri);
		
	String	test = "https://frontlineworker.com/fordtest/users/list?userid=&displayname=&licenseTier=null&sort=realName,asc&email=&page=0&size=100&searchFilter=usa";
	System.out.println(test);
					   
					   ResponseEntity<PageUserViewModel> response = restTemplate.exchange(
							   uri,
							   HttpMethod.GET,
							   new HttpEntity<>(header),			   
							   PageUserViewModel.class);     
					   
					   PageUserViewModel userListDetails =response.getBody();
					   
					  
					  ObjectMapper objectMapper = new ObjectMapper();
						
					   String userDetailsInfo;
					try {
						userDetailsInfo = objectMapper.writeValueAsString(userListDetails);
						 JsonNode jsonNode = objectMapper.readTree(userDetailsInfo);
						 
						 JsonNode UserListNode = jsonNode.get("content");
						 
						 System.out.println(UserListNode);
						 
						 for (JsonNode roleNode : UserListNode) {
							 
							 System.out.println("user data");
							 
							 JsonNode serverRolesNode = roleNode.get("serverRoles");
							 
							    ObjectMapper serverRoleClone = new ObjectMapper();
							    
							    ServerRole[] Role = serverRoleClone
							      .readValue(objectMapper.writeValueAsString(serverRolesNode), ServerRole[].class);
							    
							 String   RoleInfo = objectMapper.writeValueAsString(Role);
							    
							    JsonNode RolejsonNode = objectMapper.readTree(RoleInfo);
							    
							    
							    System.out.println("RolejsonNode");
							    
							    System.out.println(RolejsonNode);
							 
							 
							 
							 
							   boolean autoLoginExists = false;
							  String UpdateRoleName = "";
							  String UpdateAutoLoginRoleName = "";
							   
							   System.out.println(serverRolesNode);

							   if (serverRolesNode != null && serverRolesNode.isArray()) {
								  
							       for (JsonNode serverroleNode : serverRolesNode) {
							    	   
							           int roleid = serverroleNode.get("id").asInt();
							           System.out.println(roleid+"is the role id");
							           if (roleid == 17) {
							               autoLoginExists = true;
							               
							             UpdateRoleName =   serverroleNode.get("name").asText();
							               
							               break;
							           }
							       }
							   }
							   
							   if (autoLoginExists) {
								   
							       System.out.println("Auto Login server role exists.");
							       

									   									   
									   
									   try {
										   
										   
										   /*************/
										   
										   if (RolejsonNode != null && RolejsonNode.isArray()) {
											   
											   Set<String> existingNames = new HashSet<>();
											   
											   List<Role> roles = new ArrayList <>();
											   List<String> rolesToCheck = new ArrayList <>();
											   rolesToCheck.add("Administrator");
											   rolesToCheck.add("xAssist");
											   boolean isAdminPresent = false;
											   boolean isXAssistPresent = false;
											   
											   
											   //Check if both "Administrator and xAssist roles are present"
											   
											   for (String roleToCheck : rolesToCheck) {
												   
												   for (JsonNode serverrole : RolejsonNode) {	
													   
													   String fieldname = serverrole.get("name").asText();	
													   
													   if(fieldname.equals(roleToCheck)) {
														   
														   if(roleToCheck.equals("Administrator")) {
															   isAdminPresent = true;
														   } else if(roleToCheck.equals("xAssist")) {
															   isXAssistPresent =true;
														   }
														   
													   }
													   
													   
												   }
											   }
											   
											   
											   if(isAdminPresent && isXAssistPresent ) {
												   
												   
												   for (JsonNode serverrole : RolejsonNode) {					
													   String name = serverrole.get("name").asText();					
													   
													   if(!existingNames.contains(name)) {
														   existingNames.add(name);
														    boolean  disabled = false;
														    
														    if(name.equals("xAssist")) {
														    	disabled = false;
														    }
														    
														     Role  role  = new Role(name , disabled );
															  roles.add(role);
														   
													   }
													   
													   System.out.println("loopServerName Admin"+serverrole.get("name"));
													   
												   }
												   
												   
											   }else {
												   
												   for (JsonNode serverrole : RolejsonNode) {					
													   String name = serverrole.get("name").asText();					
													   
													   if(!existingNames.contains(name)) {
														   existingNames.add(name);
														    boolean  disabled = false;
														    
														    if(name.equals("xAssist")) {
														    	disabled = false;
														    }
														    
														     Role  role  = new Role(name , disabled );
															  roles.add(role);
														   
													   }
													   
													   System.out.println("loopServerName"+serverrole.get("name"));
													   
												   }
												   
												   
											   }
											   
		   
											   ObjectMapper serv = new ObjectMapper();
											   
											   JsonNode updatedServerRole = serv.valueToTree(roles);
														   
											   JsonNode licenseTiers = roleNode.get("licenseTiers");
											   
											    EditUserPayload = objectMapper.createObjectNode();
													 
											   
											   ((ObjectNode) EditUserPayload).set("user", roleNode);
											   ((ObjectNode) EditUserPayload).set("roles", updatedServerRole);
											   ((ObjectNode) EditUserPayload).set("licenseTiers", licenseTiers);
											   ((ObjectNode) EditUserPayload).put("password", " ");
											   ((ObjectNode) EditUserPayload).put("domainTag", "ubimax");
											   
											   
											   
											   System.out.println("EditUserPayload");
												  System.out.println(EditUserPayload);
											   
											
											    
											    System.out.println("Check serverRolesNode loop");
											    
										   }
										   
										   

										   
									   }catch (Exception e) {
										   
										   e.printStackTrace();
									   }
									   
									  
									  
									 //  EditUserPayload
									   System.out.println("multi header");
									   System.out.println(header);
									   
									   
									   String editURL = apiUrl+"users/createOrUpdate"; 
									   
									  
									   
									   EditUserRequest	   editUserPayload = objectMapper.treeToValue(EditUserPayload , EditUserRequest.class);
									   
									   HttpEntity<EditUserRequest> entity = new HttpEntity<>( editUserPayload,header );
									   ResponseEntity<EditUserResponse> edituser =restTemplate.exchange(editURL,HttpMethod.POST,entity,EditUserResponse.class);
//			
									   System.out.println("multiEditTest");
									   System.out.println(edituser.getBody());
							       
									   return edituser.getBody();
							       
							   } else {
								   
					   
								   ObjectNode ServerroleUpdate = objectMapper.createObjectNode();
								   
								  // ServerroleUpdate.put("disabled" ,true);
								   //ServerroleUpdate.put("name" ,"Auto Login");
								   
								   ArrayNode serverRoleList = (ArrayNode) serverRolesNode;
								   
								   
								   
								   
								   try {
									   
									   
									   /*************/
									   
									   if (RolejsonNode != null && RolejsonNode.isArray()) {
										   
										   Set<String> existingNames = new HashSet<>();
										   
										   List<Role> roles = new ArrayList <>();
										   List<String> rolesToCheck = new ArrayList <>();
										   rolesToCheck.add("Administrator");
										   rolesToCheck.add("xAssist");
										   boolean isAdminPresent = false;
										   boolean isXAssistPresent = false;
										   
										   
										   //Check if both "Administrator and xAssist roles are present"
										   
										   for (String roleToCheck : rolesToCheck) {
											   
											   for (JsonNode serverrole : RolejsonNode) {	
												   
												   String fieldname = serverrole.get("name").asText();	
												   
												   if(fieldname.equals(roleToCheck)) {
													   
													   if(roleToCheck.equals("Administrator")) {
														   isAdminPresent = true;
													   } else if(roleToCheck.equals("xAssist")) {
														   isXAssistPresent =true;
													   }
													   
												   }
												   
												   
											   }
										   }
										   
										   
										   if(isAdminPresent && isXAssistPresent ) {
											   
											   
											   for (JsonNode serverrole : RolejsonNode) {					
												   String name = serverrole.get("name").asText();					
												   
												   if(!existingNames.contains(name)) {
													   existingNames.add(name);
													    boolean  disabled = false;
													    
													    if(name.equals("xAssist")) {
													    	disabled = false;
													    }
													    
													     Role  role  = new Role(name , disabled );
														  roles.add(role);
													   
												   }
												   
												   System.out.println("loopServerName Admin"+serverrole.get("name"));
												   
											   }
											   
											   
										   }else {
											   
											   for (JsonNode serverrole : RolejsonNode) {					
												   String name = serverrole.get("name").asText();					
												   
												   if(!existingNames.contains(name)) {
													   existingNames.add(name);
													    boolean  disabled = false;
													    
													    if(name.equals("xAssist")) {
													    	disabled = false;
													    }
													    
													     Role  role  = new Role(name , disabled );
														  roles.add(role);
													   
												   }
												   
												   System.out.println("loopServerName"+serverrole.get("name"));
												   
											   }
											   
											   
										   }
										   
										  
										   
//									//	   if(!UpdateRoleName.isEmpty()) {
//											   
//											   UpdateRoleName ="Auto Login";
//											   Role  Updaterole  = new Role(UpdateRoleName , false );
//											   
//											   roles.add(Updaterole);
//										 //  }
										   
										
										   UpdateRoleName ="xAssist - GDPR";
										   Role  Updaterole  = new Role(UpdateRoleName , false );
										   UpdateAutoLoginRoleName ="Auto Login";
										   roles.add(Updaterole);
										   
										   	Iterator<Role> iterator = roles.iterator();
										   
										   while(iterator.hasNext()) {
											   
											   Role role = iterator.next();
											   
											   if(role.getName().equals("xAssist")) {
												   iterator.remove();
											   }else if(!role.getName().equals("Auto Login")) {
												   
												   Role  UpdateAutorole  = new Role(UpdateAutoLoginRoleName , false );
												   roles.add(UpdateAutorole);
												  System.out.println("Auto Login doesnt exit in line 1230");
											   }
										   }
										  
										   
										   
										   ObjectMapper serv = new ObjectMapper();
										   
										   JsonNode updatedServerRole = serv.valueToTree(roles);
													   
										   JsonNode licenseTiers = roleNode.get("licenseTiers");
										   
										    EditUserPayload = objectMapper.createObjectNode();
												 
										   
										   ((ObjectNode) EditUserPayload).set("user", roleNode);
										   ((ObjectNode) EditUserPayload).set("roles", updatedServerRole);
										   ((ObjectNode) EditUserPayload).set("licenseTiers", licenseTiers);
										   ((ObjectNode) EditUserPayload).put("password", " ");
										   ((ObjectNode) EditUserPayload).put("domainTag", "ubimax");
										   
										   
										   
										   System.out.println("EditUserPayload");
											  System.out.println(EditUserPayload);
										  		
										    
									   }
									   
									   
								   }catch (Exception e) {
									   
									   e.printStackTrace();
								   }
								  
								 //  EditUserPayload
								   System.out.println("multi header");
								   System.out.println(header);
								   
								   
								   String editURL = apiUrl+"users/createOrUpdate"; 
				   
								   EditUserRequest	   editUserPayload = objectMapper.treeToValue(EditUserPayload , EditUserRequest.class);
								   
								   HttpEntity<EditUserRequest> entity = new HttpEntity<>( editUserPayload,header );
								   ResponseEntity<EditUserResponse> edituser =restTemplate.exchange(editURL,HttpMethod.POST,entity,EditUserResponse.class);
//		
								   System.out.println("multiEditTest");
								   System.out.println(edituser.getBody());
								   System.out.println("Auto Login server role does not exist.");
								   return edituser.getBody();
							      
							   }
							 
							 
					    	   				    	  					           
					       }
						 
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   					   
					  

		 
		 return null;
		 
	 }

	
	

}
