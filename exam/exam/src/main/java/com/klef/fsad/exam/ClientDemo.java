package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import jakarta.websocket.Session;

public class ClientDemo 
{
 public static void main(String[] args) 
 {
  SessionFactory sf = new Configuration().configure().buildSessionFactory();
  Session session = sf.openSession();
  Transaction tx = session.beginTransaction();

  Supplier s = new Supplier();
  s.setName("ABC");
  s.setDescription("Electronics");
  s.setDate("2026-03-12");
  s.setStatus("Active");

  session.save(s);

  Supplier s1 = session.get(Supplier.class,1);
  s1.setName("Updated");
  s1.setStatus("Inactive");

  session.update(s1);

  tx.commit();
  session.close();
 }
}