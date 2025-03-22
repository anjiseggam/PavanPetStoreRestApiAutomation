package api.endpoints;
/*
URI--> https://petstore.swagger.io
Create user (Post) : https://petstore.swagger.io/v2/user
Get user (Get) : https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}

    */
public class Routes {
	//working on User Module so user will not in url below line.
	public static String base_url = "https://petstore.swagger.io/v2/";
	
	public static String post_url =    base_url+ "/user/{username}";
// after execution post we get username then use it	, like chaining process in below lines
	public static String get_url =     base_url+ "/user/{username}";
	public static String update_url =  base_url+ "/user/{username}";
	public static String delete_url =  base_url+ "/user/{username}";
	
	
//Store module
		// create store module URL's
	
//Pet module
		// create Pet module URL's	
}
