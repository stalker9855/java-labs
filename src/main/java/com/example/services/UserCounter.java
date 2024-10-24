package com.example.services;

import jakarta.ejb.Lock;
import jakarta.ejb.LockType;
import jakarta.ejb.Singleton;

@Singleton
public class UserCounter {
  private int activeUsers = 0;

  @Lock(LockType.WRITE)
  public void increment() {
    activeUsers++;
  }

  @Lock(LockType.WRITE)
  public void decrement() {
    if (activeUsers > 0) {
      activeUsers--;
    }
  }

  @Lock(LockType.WRITE)
  public int getActiveUsers() {
    return activeUsers;
  }
}
