package com.spring.ai.firstProject;

import com.spring.ai.firstProject.service.Chatservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Vector;

@SpringBootTest
class ApplicationTests {

    @Autowired
    Chatservice chatservice;

	@Test
    void saveDataTOVectorDatabase() {
        System.out.println("saveDataTOVectorDatabase");
        this.chatservice.saveToVectorDb( );
        System.out.println("Data saved successfully");
//        Vector<Document> documents = new Vector<>();
    }

}
