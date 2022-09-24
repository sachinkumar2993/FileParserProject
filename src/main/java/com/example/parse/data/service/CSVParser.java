package com.example.parse.data.service;

import com.example.parse.data.entity.Order;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CSVParser implements Parser {

  private static String COMMA = ",";

  private ResourceLoader resourceLoader = new FileSystemResourceLoader();

  @Override
  public void parseFile(String fileName) {
    try {
      Resource resource =resourceLoader.getResource(ResourceLoader.CLASSPATH_URL_PREFIX + fileName);
      BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
      br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
      br.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  private Function<String, Order> mapToItem = line -> {
    String[] columns = line.split(COMMA);// a CSV has comma separated lines
    Order item = null;
    try {
      item = new Order();
      item.setOrderId(Long.valueOf(columns[0]));
      item.setAmount(Double.valueOf(columns[1]));
      item.setCurrency(columns[2]);
      item.setComment(columns[3]);
      System.out.println(item);
    } catch (NumberFormatException e) {
      System.out.println("Please check the data for orderId "+columns[0]);
    }
    return item;
  };
}
