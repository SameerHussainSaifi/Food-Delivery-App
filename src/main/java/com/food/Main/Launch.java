package com.food.Main;

import java.util.List;
import java.util.Scanner;

import com.food.DAOImp.MenuDaoImp;
import com.food.DAOImp.OrderDaoImp;
import com.food.DAOImp.OrderHistoryDaoImp;
import com.food.DAOImp.OrderItemDaoImp;
import com.food.DAOImp.RestaurantDaoImp;
import com.food.DAOImp.UserDaoImp;
import com.food.Model.Menu;
import com.food.Model.Order;
import com.food.Model.OrderHistory;
import com.food.Model.OrderItem;
import com.food.Model.Restaurant;
import com.food.Model.User;

public class Launch {
	static User user=null;
	static Scanner scan=null;
	static UserDaoImp userDaoImp=null;
	public static void main(String[] args) {
		
		//addTheUser();
	   //getTheUser();
		//updateTheUser();
		//deleteUser();
		
		addRestaurant();
		//getTheRestaurant();
		//updateTheRestaurant();
		//deleteTheRestaurant();
		//getAllTheRestaurants();
		
		 //addTheOrder();
		//getTheOrder();
		//updateTheOrder();
		  //deleteTheOrder();
		//getTheAllOrderByUser();
		
		//addTheMenu();
		//getTheMenu();
		//updateTheMenu() ;
		//deleteTheMenu();
		//getAllTheMenuByRestaurant();
		
		//addTheOrderItem();
		//getTheOrderItem();
		//updateTheOrderItem();
		//deleteTheOrderItem();
		//getTheOrderItemByOrder();
		
		
		//addTheOrderHistory();
		//getTheOrderHistory();
		//updateTheOrderHistory();
		//deleteTheOrderHistory();
		//getTheOrderHistoriesByUser();
	}
	public static void addTheUser() {
		user=new User();
		 scan=new Scanner(System.in);
		System.out.println("enter user name");
		String name=scan.nextLine();
		System.out.println("enter the password");
		String password=scan.nextLine();
		System.out.println("enter the EmailID");
		String email=scan.nextLine();
		System.out.println("enter the address");
		String address=scan.nextLine();
		System.out.println("enter the role");
		String role=scan.nextLine();
		System.out.println("enter the phone no.");
		long phone=scan.nextLong();
		
		user.setUserName(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setAddress(address);
		user.setRole(role);
		user.setPhone(phone);
		
		 userDaoImp=new UserDaoImp();
		userDaoImp.addUser(user);
		
		
	}
	
	public static void getTheUser() {
//		user=new User();
//		
//		scan=new Scanner(System.in);
//		System.out.println("enter the userID to get the details");
//		int UserID=scan.nextInt();
//		user.setUserId(UserID);
//		userDaoImp=new UserDaoImp();
//		userDaoImp.getUser(user);
//		UserDaoImp u=new UserDaoImp();
//		User user=u.getUser(1);
//		System.out.println(user);
		
	}
	
	public static void updateTheUser() {
		
		User user=new User();
        UserDaoImp userDaoImp=new UserDaoImp();
        userDaoImp.updateUser(user);
	}
	
	public static void deleteUser() {
		scan=new Scanner(System.in);
		User user=new User();
		System.out.println("enter the user ID to delete it");
		int id=scan.nextInt();
		user.setUserId(id);
		UserDaoImp userDaoImp=new UserDaoImp();
		userDaoImp.deleteUser(user);
	}

	public static void addRestaurant() {
  Restaurant rst= new Restaurant(101,"Albaik","north-indian",4,"banglore",3.5,true);
  RestaurantDaoImp rdi= new RestaurantDaoImp();
  rdi.addRestaurant(rst);
	}
	
	public static void getTheRestaurant() {
		RestaurantDaoImp rst=new RestaurantDaoImp();
		Restaurant restaurant=rst.getRestaurant(4);
		System.out.println(restaurant);
	}
	
	public static void updateTheRestaurant() {
		Restaurant r=new Restaurant(3,"zamzam","south-indian",10,"pune",4.5,true);
		RestaurantDaoImp rd=new RestaurantDaoImp();
		rd.updateRestaurant(r);
	}
	
	
	public static void deleteTheRestaurant() {
		Restaurant r=new Restaurant();
		RestaurantDaoImp rd=new RestaurantDaoImp();
		rd.deleteRestaurant(4);
	}
	
	
	public static void getAllTheRestaurants() {
		RestaurantDaoImp rd=new RestaurantDaoImp();
		List <Restaurant> restaurants=rd.getAllRestaurant();
		for(Restaurant  o:restaurants) {
			System.out.println(o);
		}
	}
	
	
	public static void addTheOrder() {
		Order order=new Order(61,   1120, "active","Credit Card");
		OrderDaoImp odi=new OrderDaoImp();
		odi.addOrder(order);
	}
	
	public static void getTheOrder() {
		Order order=new Order();
		OrderDaoImp odi=new OrderDaoImp();
		Order res=odi.getOrder(10);
		System.out.println(res);
	}
	
	public static void updateTheOrder() {
		Order order=new Order(20,1023d,"not Active","Debit Card");
		OrderDaoImp odi=new OrderDaoImp();
		odi.updateOrder(order);
		
	}
	
	public static void deleteTheOrder() {
		OrderDaoImp odi=new OrderDaoImp();
		odi.deleteOrder(61);
	}
	
	public static void getTheAllOrderByUser() {
		OrderDaoImp odi=new OrderDaoImp();
		List res =odi.getAllOrderByUser(6);
		System.out.println(res);
	}
	
	public static void addTheMenu() {
		Menu menu=new Menu(402,"Burger","Hot burger ",200, true);
		MenuDaoImp mdi=new MenuDaoImp();
		mdi.addMenu(menu);
	}
	
	public static void getTheMenu() {
	MenuDaoImp mdi=new MenuDaoImp();
	Menu menu=mdi.getMenu(402);
	System.out.println(menu);
	}
	
	public static void updateTheMenu() {
		Menu menu=new Menu(403,"Dosa","taste matters",160,true,401);
		MenuDaoImp mdi=new MenuDaoImp();
		mdi.updateMenu(menu);
	}
	
	public static void deleteTheMenu() {
		MenuDaoImp mdi=new MenuDaoImp();
		mdi.deleteMenu(403);
	}
	
	public static void getAllTheMenuByRestaurant() {
		MenuDaoImp mdi=new MenuDaoImp();
		List res=mdi.getAllMenuByRestaurant(1);
		for(Object o:res) {
			System.out.println(o);
		}
	}
	public static void addTheOrderItem() {
	OrderItem oi=new OrderItem(1001,4,9);
	OrderItemDaoImp oid=new OrderItemDaoImp();	
	
	oid.addOrderItem(oi);
	}
	
	public static void getTheOrderItem() {
		OrderItemDaoImp oid=new OrderItemDaoImp();
		OrderItem res=(OrderItem) oid.getOrderItem(1001);
		System.out.println(res);
	}

	public static void updateTheOrderItem() {
		OrderItem oi=new OrderItem(2002,10,20,1001);
		OrderItemDaoImp oid=new OrderItemDaoImp();
		oid.updateOrderItem(oi);
	}
	
	public static void deleteTheOrderItem() {
		OrderItemDaoImp odi=new OrderItemDaoImp();
		odi.deleteOrderItem(2002);
	}
	
	public static void getTheOrderItemByOrder() {
		OrderItemDaoImp oi=new OrderItemDaoImp();
		List<OrderItem> res=oi.getOrderItemsByOrder(1);
		for(OrderItem o:res) {
			System.out.println(o);
		}
	}
	
	public static void addTheOrderHistory() {
		OrderHistory oh=new OrderHistory(723,382,"canceled");
		OrderHistoryDaoImp ohdi=new OrderHistoryDaoImp();
		ohdi.addOrderHistory(oh);
	}
	
	public static void getTheOrderHistory() {
		OrderHistoryDaoImp ohdi=new OrderHistoryDaoImp();
		OrderHistory res=ohdi.getOrderHistory(723);
		System.out.println(res);
	}
	
	public static void updateTheOrderHistory() {
		OrderHistory oh=new OrderHistory(720,6300,"canceled",721);
		OrderHistoryDaoImp ohdi=new OrderHistoryDaoImp();
		ohdi.updateOrderHistory(oh);
	}
	
	public static void deleteTheOrderHistory() {
		OrderHistoryDaoImp ohdi=new OrderHistoryDaoImp();
		ohdi.deleteOrderHistory(720);
	}
	
	public static void getTheOrderHistoriesByUser() {
		OrderHistoryDaoImp ohdi=new OrderHistoryDaoImp();
		List li=ohdi.getOrderHistoriesByUser(723);
		for(Object  oh:li) {
			System.out.println(oh);
		}
	}
}
