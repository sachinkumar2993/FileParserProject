package com.example.parse.data.service;

import com.example.parse.data.entity.Order;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsonParser implements Parser {

  private ResourceLoader resourceLoader = new FileSystemResourceLoader();

  @Override
  public void parseFile(String fileName) {
    try (JsonReader reader = new JsonReader(
        new InputStreamReader(resourceLoader.getResource(ResourceLoader.CLASSPATH_URL_PREFIX + fileName).getInputStream()));) {
      reader.beginArray();
      List<Order> orderList = new ArrayList<>();
      while (reader.hasNext()) {
        try {
          Order order = new Gson().fromJson(reader, Order.class);
          orderList.add(order);
          System.out.println(order);
        } catch (JsonIOException | JsonSyntaxException | NumberFormatException e) {
          //          System.out.println(e.getMessage());
        }
      }
      reader.endArray();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
