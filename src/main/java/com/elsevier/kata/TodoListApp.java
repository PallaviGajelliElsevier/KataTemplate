package com.elsevier.kata;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TodoListApp {
  private List<TodoItem> items;

  public TodoListApp() {
    this.items = new ArrayList<>();
  }

  public void addItem(String name) {
    for (TodoItem item : items) {
      if (item.getName().equalsIgnoreCase(name)) {
        System.out.println("Item already exists!");
        return;
      }
    }
    items.add(new TodoItem(name));
  }

  public void removeItem(String name) {
    for (int i = 0; i < items.size(); i++) {
      if (items.get(i).getName().equalsIgnoreCase(name)) {
        items.remove(i);
        System.out.println("Item removed successfully.");
        return;
      }
    }
    System.out.println("Item not found!");
  }

  public void viewItems() {
    System.out.println("Current items on the list:");
    for (TodoItem item : items) {
      System.out.println("- " + item.getName() + " (Added: " + item.getDateAdded() + ", Last Modified: " + item.getLastModified() + ")");
    }
  }

  public void markAsCompleted(String name) {
    for (TodoItem item : items) {
      if (item.getName().equalsIgnoreCase(name)) {
        item.setCompleted(true);
        System.out.println("Item marked as completed.");
        return;
      }
    }
    System.out.println("Item not found!");
  }

  public void viewCompletedItems() {
    System.out.println("Completed items:");
    for (TodoItem item : items) {
      if (item.isCompleted()) {
        System.out.println("- " + item.getName() + " (Added: " + item.getDateAdded() + ", Last Modified: " + item.getLastModified() + ")");
      }
    }
  }

  public void markAsUncompleted(String name) {
    for (TodoItem item : items) {
      if (item.getName().equalsIgnoreCase(name)) {
        item.setCompleted(false);
        System.out.println("Item marked as uncompleted.");
        return;
      }
    }
    System.out.println("Item not found!");
  }

  public void sortItemsByName() {
    items.sort(Comparator.comparing(TodoItem::getName));
  }

  public void sortItemsByDateAdded() {
    items.sort(Comparator.comparing(TodoItem::getDateAdded));
  }

  public void sortItemsByLastModified() {
    items.sort(Comparator.comparing(TodoItem::getLastModified));
  }

  public void sortItemsDescending() {
    Collections.reverse(items);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TodoListApp todoList = new TodoListApp();

    while (true) {
      System.out.println("\nChoose an option:");
      System.out.println("1. Add new item");
      System.out.println("2. Remove item");
      System.out.println("3. View items");
      System.out.println("4. Mark item as completed");
      System.out.println("5. View completed items");
      System.out.println("6. Mark item as uncompleted");
      System.out.println("0. Exit");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> {
          System.out.print("Enter item name: ");
          String newItem = scanner.nextLine();
          todoList.addItem(newItem);
        }
        case 2 -> {
          System.out.print("Enter item name to remove: ");
          String itemToRemove = scanner.nextLine();
          todoList.removeItem(itemToRemove);
        }
        case 3 -> todoList.viewItems();
        case 4 -> {
          System.out.print("Enter item name to mark as completed: ");
          String itemToComplete = scanner.nextLine();
          todoList.markAsCompleted(itemToComplete);
        }
        case 5 -> todoList.viewCompletedItems();
        case 6 -> {
          System.out.print("Enter item name to mark as uncompleted: ");
          String itemToUncomplete = scanner.nextLine();
          todoList.markAsUncompleted(itemToUncomplete);
        }
        case 0 -> {
          System.out.println("Exiting...");
          System.exit(0);
        }
        default -> System.out.println("Invalid choice. Please try again.");
      }
    }
  }
}



