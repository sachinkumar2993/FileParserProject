package com.example.parse.data.service;

import org.springframework.stereotype.Service;

@Service
public interface Parser {

  /**
   * This method used to parse json and csv file to console output
   * @param fileName
   */
  void parseFile(String fileName);
}
