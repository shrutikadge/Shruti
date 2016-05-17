package com.mikadosolutions.training.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import java.util.List;

import com.mikadosolutions.training.springmvc.bean.Room;

@Repository
public class RoomMasterDAO extends BaseDAO
{
	
	/*private RowMapper<Room>  roomMapper = new RowMapper<Room>() {

		@Override
		public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
			Room room = new Room();
			room.setRoomNumber(rs.getInt("roomno"));
			room.setRoomType(rs.getString("typename"));
			room.setRoomStatus(rs.getString("roomstatus"));
			return room;
		}
		
	};
	
	public Collection<Room> getAvailableRooms()
	{ 
		return jdbcTemplate.query("select roomno,typename,roomstatus from roommaster,roomtypemaster where roomstatus='A' and roommaster.typeid = roomtypemaster.typeid", roomMapper);
	}
	
	public Collection getOccupiedRooms()
	{ 
		return jdbcTemplate.query("select roomno,typename,roomstatus from roommaster,roomtypemaster where roomstatus='O' and roommaster.typeid = roomtypemaster.typeid", roomMapper);
	}
	
	public boolean updateRoom(Room room, String status){
		int cnt = jdbcTemplate.update("update roommaster set roomstatus=? where roomno=?", new Object[]{status, room.getRoomNumber()});
		return cnt > 0;
	}
	
	public boolean allocateRoom(Room room){
		return updateRoom(room, "O");
	}
	public boolean deallocateRoom(Room room){
		return updateRoom(room, "A");
	}*/


	public Collection<Room> getAvailableRooms()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Room> rooms = null;
		try
		{
			tx = session.beginTransaction();
			rooms = session.createQuery("FROM Room R where R.roomStatus = 'A' ").list();
			//System.out.println(rooms);
			rooms.toString();// doing this so that it fetches data
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx != null)
				tx.rollback();
			System.out.println(tx);
		}
		finally
		{
			session.close();
		}
		return rooms;
	}
	
	public Collection<Room> getOccupiedRooms()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Room> rooms = null;
		try
		{
			tx = session.beginTransaction();
			rooms = session.createQuery("FROM Room R where R.roomStatus = 'O' ").list();
			rooms.toString();// doing this so that it fetches data
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx != null)
				tx.rollback();
			System.out.println(tx);
		}
		finally
		{
			session.close();
		}
		return rooms;
	}

	public void allocateRoom(Room room )
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			System.out.println("!!!!!!!!!!!!!!!!!! "+room.getRoomNumber());
			Room actualRoom = (Room)session.get(Room.class,room.getRoomNumber());
			actualRoom.setRoomStatus("O");
			session.update(actualRoom);
			tx.commit();

		}
		catch(HibernateException e)
		{
			if(tx != null)
				tx.rollback();
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
	}
	public void deallocateRoom(Room room )
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			System.out.println("!!!!!!!!!!!!!!!!!! "+room.getRoomNumber());
			Room actualRoom = (Room)session.get(Room.class,room.getRoomNumber());
			actualRoom.setRoomStatus("A");
			session.update(actualRoom);
			tx.commit();

		}
		catch(HibernateException e)
		{
			if(tx != null)
				tx.rollback();
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
	}
}