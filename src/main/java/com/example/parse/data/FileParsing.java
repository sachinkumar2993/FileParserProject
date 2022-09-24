package com.example.parse.data;

import com.example.parse.data.service.CSVParser;
import com.example.parse.data.service.JsonParser;
import com.example.parse.data.service.Parser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileParsing implements CommandLineRunner {


  private Parser csvParser = new CSVParser();
  private Parser jsonParser = new JsonParser();

  @Override
  public void run(String... args) throws Exception {
    if(null== args) {
      System.out.println("Please provide valid csv and json file name in same order in cli argument");
      return;
    }
    List<String> fileNameList = Arrays.stream(args).collect(Collectors.toList());
    if(CollectionUtils.isEmpty(fileNameList) || fileNameList.size() < 2) {
      System.out.println("Please provide valid csv and json file name in same order in cli argument");
      return;
    }

    System.out.println("CSV DATA====================");
    csvParser.parseFile(fileNameList.get(0));
    System.out.println("JSON DATA====================");
    jsonParser.parseFile(fileNameList.get(1));
  }
}
