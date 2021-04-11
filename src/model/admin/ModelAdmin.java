package model.admin;

public class ModelAdmin {
	
	private static boolean AdminState;
	
	
	public static void setAdminTrue () {
		AdminState = true;
	}
	
	public static void setAdminFalse () {
		AdminState = false;
	}
	
	public static boolean getAdminState () {
		return AdminState;
	}

}
