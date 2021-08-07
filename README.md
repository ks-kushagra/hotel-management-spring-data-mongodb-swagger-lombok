# hotel-management-spring-data-mongodb-swagger-lombok
This is a Hotel Management Project . In this project, we can add Hotels and Customers. Since , every hotels have some rooms so a customer can book a room or withdraw from a 
room and can check availability of room on the basis of some criteria like Location.


#Fields that are added 

  a)hotel
  
      1.addHotel : Hotels can be added directly to DB 
      
      2.searchByName: search hotels by Name
      
      3.searchByLocation : search hotels by Lovation
      
      4.searchByAvailability : search hotels by availability of rooms
      
      
  b)Customer
  
      1.addCustomer :Customers can be added directly to DB
      
      2.searchByName : search customer by Name
      
      3.deleteCustomer : Delete a existing customer
      
   
   c)Room
   
      1.addRoom : Rooms can be added directly to DB
      
      2.bookRoom : Rooms can be booked , numberOfRooms field of corresponding hotel automatically updated , Status of Room gets modified (i.e. from VACANT to BOOKED)
      
      3.withdrawRoom : Rooms can be vacant again , and related fields gets modified (still in working)
      
      4.getRoomsByHotelName : give a list of all rooms present in any particular hotel.
      
      
      
 #How to run project
 
      1.extract zip and open project using any IDE
      
      2.Start MongoDB Server
      
      3.run HotelManagementApplication.java file
      
      4.Open browser and go to : http://localhost:8080/swagger-ui.html
      
      5.Now, you can perform all operations listed above
